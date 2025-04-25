package com.platform.code_up.controllers;

import com.platform.code_up.entities.Subscription;
import com.platform.code_up.services.SubscriptionService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/subscriptions")
public class SubscriptionController {
    private final SubscriptionService service;

    public SubscriptionController(SubscriptionService service) {
        this.service = service;
    }

    @GetMapping
    public List<Subscription> getAll() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public Subscription getOne(@PathVariable Integer id) {
        return service.findById(id);
    }

    @PostMapping
    public Subscription create(@RequestBody Subscription s) {
        return service.create(s);
    }

    @PutMapping("/{id}")
    public Subscription update(
            @PathVariable Integer id,
            @RequestBody Subscription s
    ) {
        return service.update(id, s);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        service.delete(id);
    }
}
