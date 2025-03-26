package com.platform.code_up.controllers;

import com.platform.code_up.records.ChangePassword;
import com.platform.code_up.dtos.MailBody;
import com.platform.code_up.entities.ForgotPassword;
import com.platform.code_up.entities.User;
import com.platform.code_up.repositories.ForgotPasswordRepository;
import com.platform.code_up.repositories.UserRepository;
import com.platform.code_up.services.EmailService;
import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.time.Instant;
import java.util.Date;
import java.util.Objects;
import java.util.Random;

@Slf4j
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

        User user = userRepository.findByEmail(email).orElseThrow(() -> new UsernameNotFoundException("Please provide a valid email"));

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

        emailService.sendSimpleMessage(mailBody);
        forgotPasswordRepository.save(fp);

        return ResponseEntity.ok("Email sent for verification");

    }

    private Integer OtpGenerator() {

        Random random = new Random();

        return random.nextInt(100000,999999);
    }

    @PostMapping("verifyOtp/{otp}/{email}")
    public ResponseEntity<String> verifyOtp(@PathVariable Integer otp,
                                            @PathVariable String email) {
        User user = userRepository.findByEmail(email)
                .orElseThrow(() -> new UsernameNotFoundException("Please provide a valid email"));


        ForgotPassword forgotPassword = forgotPasswordRepository.findByOtpandUser(otp,user)
                .orElseThrow(() -> new RuntimeException("Invalid otp for email" + " " + email));

        if(forgotPassword.getExpirationTime().before(Date.from(Instant.now()))) {
            forgotPasswordRepository.deleteById(forgotPassword.getFpid());
            return new ResponseEntity<>("Otp has expired", HttpStatus.EXPECTATION_FAILED);
        }

        return ResponseEntity.ok("Otp verified");
    }

    @PostMapping("changePassword/{email}")
    @Transactional
    public ResponseEntity<String> changePassword(@RequestBody ChangePassword changePassword,
                                                 @PathVariable String email) {

        if(!Objects.equals(changePassword.password(),changePassword.confirmPassword())) {
            return new ResponseEntity<>("Enter the same password and confirm password",HttpStatus.EXPECTATION_FAILED);
        }

        String encodedPassword = passwordEncoder.encode(changePassword.password());
        User user = userRepository.findByEmail(email)
                .orElseThrow(() -> new UsernameNotFoundException("User not valid"));
        user.setPassword(encodedPassword);
        userRepository.save(user);


        return ResponseEntity.ok("Password has been changed");

    }
}
