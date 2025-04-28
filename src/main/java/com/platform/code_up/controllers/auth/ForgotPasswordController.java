package com.platform.code_up.controllers.auth;

import com.platform.code_up.dtos.ChangePassword;
import com.platform.code_up.dtos.MailBody;
import com.platform.code_up.entities.ForgotPassword;
import com.platform.code_up.entities.User;
import com.platform.code_up.exceptions.PasswordException;
import com.platform.code_up.repositories.auth.ForgotPasswordRepository;
import com.platform.code_up.repositories.auth.UserRepository;
import com.platform.code_up.services.auth.EmailService;
import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.time.Instant;
import java.util.*;
import java.util.concurrent.TimeoutException;

@Slf4j
@CrossOrigin(origins = "http://localhost:8081")
@RestController
@RequestMapping("/forgotPassword")
public class ForgotPasswordController {

    private final UserRepository userRepository;

    private final EmailService emailService;

    private final ForgotPasswordRepository forgotPasswordRepository;

    private final PasswordEncoder passwordEncoder;

    public ForgotPasswordController(UserRepository userRepository, EmailService emailService, ForgotPasswordRepository forgotPasswordRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.emailService = emailService;
        this.forgotPasswordRepository = forgotPasswordRepository;
        this.passwordEncoder = passwordEncoder;
    }


    @PostMapping("/verifyMail/{email}")
    public ResponseEntity<String> verifyEmail(@PathVariable String email){

        User user = userRepository.findByEmail(email).orElseThrow(() ->
                new UsernameNotFoundException("Please provide a valid email"));

        int otp = OtpGenerator();

        MailBody mailBody = MailBody.builder()
                .to(email)
                .text("This is the OTP for your forgot password request" + " " + otp)
                .subject("OTP for Forgot password request")
                .build();

        ForgotPassword fp = ForgotPassword.builder()
                .otp(otp)
                .expirationTime(new Date(System.currentTimeMillis() + 70 * 1000))
                .user(user)
                .build();

        emailService.sendEmail(mailBody);
        forgotPasswordRepository.save(fp);

        return ResponseEntity.ok("Email sent for verification");

    }

    private Integer OtpGenerator() {

        Random random = new Random();

        return random.nextInt(100000,999999);
    }

    @PostMapping("verifyOtp/{otp}/{email}")
    public ResponseEntity<String> verifyOtp(@PathVariable Integer otp,
                                         @PathVariable String email) throws TimeoutException {

        User user = userRepository.findByEmail(email)
                .orElseThrow(() -> new UsernameNotFoundException("Invalid email"));

        ForgotPassword forgotPassword = forgotPasswordRepository
                .findByOtpandUser(otp, user)
                .orElseThrow(() -> new UsernameNotFoundException("Invalid OTP"));


        if (forgotPassword.getExpirationTime().before(Date.from(Instant.now()))) {
            forgotPasswordRepository.deleteById(forgotPassword.getFpid());
            throw new TimeoutException("OTP is expired");
        }


        return ResponseEntity.ok("Ok");
    }

    @PostMapping("changePassword/{email}")
    @Transactional
    public ResponseEntity<String> changePassword(@RequestBody ChangePassword changePassword,
                                                 @PathVariable String email) throws
            PasswordException {

        if(!Objects.equals(changePassword.password(),changePassword.confirmPassword())) {
            throw new IllegalArgumentException("Passwords do not match");
        }

        if(!changePassword.isStrong(changePassword.password())) {
            throw new PasswordException("Use a strong password which contains at least:\n" +
                    "- 8 characters\n" +
                    "- one uppercase letter\n" +
                    "- two numbers\n" +
                    "- one special character (! @ # $ & *)");
        }

        String encodedPassword = passwordEncoder.encode(changePassword.password());
        User user = userRepository.findByEmail(email)
                .orElseThrow(() -> new UsernameNotFoundException("User not valid"));
        user.setPassword(encodedPassword);
        userRepository.save(user);

        MailBody mailBody = MailBody.builder()
                .to(email)
                .text("Your password has been reset! You can now sign in to your account")
                .subject("Password reset")
                .build();

        emailService.sendEmail(mailBody);

        return ResponseEntity.ok("Password has been changed");

    }
}
