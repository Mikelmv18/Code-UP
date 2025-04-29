package com.platform.code_up.controllers;

import com.platform.code_up.dtos.SubscriptionDto;
import com.platform.code_up.entities.Subscription;
import com.platform.code_up.services.SubscriptionService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/subscriptions")
@CrossOrigin(origins = "http://localhost:8081")
public class SubscriptionController {

    private final SubscriptionService service;

    public SubscriptionController(SubscriptionService service) {
        this.service = service;
    }

    @PostMapping("/create")
    public ResponseEntity<?> createSubscription(@RequestBody SubscriptionDto subscriptionDto) {
        Subscription subscription = service.createSubscription(subscriptionDto);
        return ResponseEntity.ok(subscription);
    }

    @GetMapping("/")
    public ResponseEntity<List<Subscription>> getAllSubscriptions() {
        List<Subscription> subscriptions = service.listAllSubscriptions();
        return ResponseEntity.ok(subscriptions);
    }


    @GetMapping("/{id}")
    public ResponseEntity<Subscription> getById(@PathVariable Integer id) {
        Subscription subscription = service.getById(id);
        return ResponseEntity.ok(subscription);
    }

    @PutMapping("/{id}")
    public ResponseEntity<SubscriptionDto> updateSubscription(@PathVariable Integer id, @RequestBody SubscriptionDto subscriptionDto) {
        SubscriptionDto updated = service.updateSubscription(id, subscriptionDto);
        return ResponseEntity.ok(updated);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteSubscription(@PathVariable Integer id) {
        service.deleteSubscription(id);
        return ResponseEntity.ok("Subscription deleted");
    }
}
