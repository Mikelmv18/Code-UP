package com.platform.code_up.repositories;

import com.platform.code_up.entities.Subscription;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SubscriptionRepository
        extends JpaRepository<Subscription, Integer> {
}
