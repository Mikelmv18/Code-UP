package com.platform.code_up.services;

import com.platform.code_up.dtos.QuoteDto;
import com.platform.code_up.entities.Quote;
import com.platform.code_up.repositories.QuoteRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class QuoteService {

    private final QuoteRepository quoteRepository;

    public QuoteService(QuoteRepository quoteRepository) {
        this.quoteRepository = quoteRepository;
    }

    public Quote createQuote(QuoteDto quoteDto) {
        Quote quote = new Quote();
        quote.setQuote(quoteDto.getQuote());
        quote.setDate(quoteDto.getDate());
        // ❗ User is ignored here because we don't have UserRepository
        return quoteRepository.save(quote);
    }

    public List<Quote> listAllQuotes() {
        List<Quote> quotes = new ArrayList<>();
        quoteRepository.findAll().forEach(quotes::add);
        return quotes;
    }

    public Quote getById(Integer id) {
        return quoteRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Quote not found"));
    }

    public QuoteDto updateQuote(Integer id, QuoteDto quoteDto) {
        Quote quote = quoteRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Quote not found"));

        quote.setQuote(quoteDto.getQuote());
        quote.setDate(quoteDto.getDate());
        // ❗ Again user update is ignored here

        quoteRepository.save(quote);

        return new QuoteDto(
                quote.getQuote(),
                quote.getDate(),
                null // No userId because no UserRepository
        );
    }

    public void deleteQuote(Integer id) {
        if (!quoteRepository.existsById(id)) {
            throw new RuntimeException("Quote not found");
        }
        quoteRepository.deleteById(id);
    }
}
