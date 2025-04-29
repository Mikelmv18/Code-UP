package com.platform.code_up.services;

import com.platform.code_up.dtos.SubscriptionDto;
import com.platform.code_up.entities.Subscription;
import com.platform.code_up.entities.User;
import com.platform.code_up.repositories.SubscriptionRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SubscriptionService {

    private final SubscriptionRepository subscriptionRepository;

    public SubscriptionService(SubscriptionRepository subscriptionRepository) {
        this.subscriptionRepository = subscriptionRepository;
    }

    public Subscription createSubscription(SubscriptionDto subscriptionDto) {
        Subscription subscription = new Subscription();

        User user = new User();
        user.setId(subscriptionDto.getUserId());

        subscription.setStartTime(subscriptionDto.getStartTime());
        subscription.setEndTime(subscriptionDto.getEndTime());
        subscription.setPaymentStatus(subscriptionDto.getPaymentStatus());
        subscription.setUser(user);

        return subscriptionRepository.save(subscription);
    }

    public List<Subscription> listAllSubscriptions() {
        List<Subscription> subscriptions = new ArrayList<>();
        subscriptionRepository.findAll().forEach(subscriptions::add);
        return subscriptions;
    }

    public Subscription getById(Integer id) {
        return subscriptionRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Subscription not found"));
    }

    public SubscriptionDto updateSubscription(Integer id, SubscriptionDto subscriptionDto) {
        Subscription subscription = subscriptionRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Subscription not found"));

        User user = new User();
        user.setId(subscriptionDto.getUserId());

        subscription.setStartTime(subscriptionDto.getStartTime());
        subscription.setEndTime(subscriptionDto.getEndTime());
        subscription.setPaymentStatus(subscriptionDto.getPaymentStatus());
        subscription.setUser(user);

        subscriptionRepository.save(subscription);

        return new SubscriptionDto(
                subscription.getStartTime(),
                subscription.getEndTime(),
                subscription.getPaymentStatus(),
                subscription.getUser().getId()
        );
    }

    public void deleteSubscription(Integer id) {
        Subscription subscription = subscriptionRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Subscription not found"));

        subscriptionRepository.delete(subscription);
    }
}
