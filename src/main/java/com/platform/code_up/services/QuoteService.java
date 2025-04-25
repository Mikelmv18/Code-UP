package com.platform.code_up.services;

import com.platform.code_up.entities.Quote;
import com.platform.code_up.repositories.QuoteRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuoteService {
    private final QuoteRepository repo;

    public QuoteService(QuoteRepository repo) {
        this.repo = repo;
    }

    public List<Quote> findAll() {
        return repo.findAll();
    }

    public Quote findById(Integer id) {
        return repo.findById(id)
                .orElseThrow(() -> new RuntimeException("Quote not found"));
    }

    public Quote create(Quote quote) {
        return repo.save(quote);
    }

    public Quote update(Integer id, Quote quote) {
        quote.setId(id);
        return repo.save(quote);
    }

    public void delete(Integer id) {
        repo.deleteById(id);
    }
}
