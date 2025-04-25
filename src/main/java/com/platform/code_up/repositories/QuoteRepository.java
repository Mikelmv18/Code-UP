package com.platform.code_up.repositories;

import com.platform.code_up.entities.Quote;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuoteRepository
        extends JpaRepository<Quote, Integer> {
}
