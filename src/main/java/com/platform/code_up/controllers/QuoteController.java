package com.platform.code_up.controllers;

import com.platform.code_up.entities.Quote;
import com.platform.code_up.services.QuoteService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/quotes")
public class QuoteController {
    private final QuoteService service;

    public QuoteController(QuoteService service) {
        this.service = service;
    }

    @GetMapping
    public List<Quote> getAll() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public Quote getOne(@PathVariable Integer id) {
        return service.findById(id);
    }

    @PostMapping
    public Quote create(@RequestBody Quote q) {
        return service.create(q);
    }

    @PutMapping("/{id}")
    public Quote update(
            @PathVariable Integer id,
            @RequestBody Quote q
    ) {
        return service.update(id, q);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        service.delete(id);
    }
}
