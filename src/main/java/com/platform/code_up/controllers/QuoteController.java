package com.platform.code_up.controllers;

import com.platform.code_up.dtos.QuoteDto;
import com.platform.code_up.entities.Quote;
import com.platform.code_up.services.QuoteService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/quotes")
@CrossOrigin(origins = "http://localhost:8081")
public class QuoteController {

    private final QuoteService service;

    public QuoteController(QuoteService service) {
        this.service = service;
    }

    @PostMapping("/create")
    public ResponseEntity<?> createQuote(@RequestBody QuoteDto quoteDto) {
        Quote quote = service.createQuote(quoteDto);
        return ResponseEntity.ok(quote);
    }

    @GetMapping("/")
    public ResponseEntity<List<Quote>> getAllQuotes() {
        List<Quote> quotes = service.listAllQuotes();
        return ResponseEntity.ok(quotes);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Quote> getQuoteById(@PathVariable Integer id) {
        Quote quote = service.getById(id);
        return ResponseEntity.ok(quote);
    }

    @PutMapping("/{id}")
    public ResponseEntity<QuoteDto> updateQuote(@PathVariable Integer id, @RequestBody QuoteDto quoteDto) {
        QuoteDto updated = service.updateQuote(id, quoteDto);
        return ResponseEntity.ok(updated);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteQuote(@PathVariable Integer id) {
        service.deleteQuote(id);
        return ResponseEntity.ok("Quote deleted");
    }
}
