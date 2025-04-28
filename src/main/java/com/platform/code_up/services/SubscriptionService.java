package com.platform.code_up.services;

import com.platform.code_up.entities.Subscription;
import com.platform.code_up.repositories.SubscriptionRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SubscriptionService {
    private final SubscriptionRepository repo;

    public SubscriptionService(SubscriptionRepository repo) {
        this.repo = repo;
    }

    public List<Subscription> findAll() {
        return repo.findAll();
    }

    public Subscription findById(Integer id) {
        return repo.findById(id)
                .orElseThrow(() -> new RuntimeException("Subscription not found"));
    }

    public Subscription create(Subscription subscription) {
        return repo.save(subscription);
    }

    public Subscription update(Integer id, Subscription subscription) {
        subscription.setId(id);
        return repo.save(subscription);
    }

    public void delete(Integer id) {
        repo.deleteById(id);
    }
}
