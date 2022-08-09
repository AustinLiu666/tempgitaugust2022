package com.training.northwind.controller;

import com.training.northwind.entities.FinancialPortfolio;
import com.training.northwind.service.PortfolioService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/v2/financialportfolio")
public class PortfolioController {
    private static final Logger LOG = LoggerFactory.getLogger(PortfolioController.class);
    @Autowired
    private PortfolioService portfolioService;
    @GetMapping
    public List<FinancialPortfolio> findAll() {
        return portfolioService.findAll();
    }

    @GetMapping("{id:[0-9]+}")
    public ResponseEntity<FinancialPortfolio> findById(@PathVariable long id) {
        try {
            return new ResponseEntity<>(portfolioService.findById(id), HttpStatus.OK);
        } catch(NoSuchElementException ex) {
            // return 404
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @GetMapping("{username:[a-zA-Z .]+}")
    public ResponseEntity<List<FinancialPortfolio>> findByFinancialPorfolioUsername(@PathVariable String username) {
        return new ResponseEntity<>(portfolioService.findPortfolioByUsername(username), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<FinancialPortfolio> create(@RequestBody FinancialPortfolio financialPortfolio) {
        LOG.debug("Create financial portfolio: [" + financialPortfolio + "]");
        return new ResponseEntity<>(portfolioService.save(financialPortfolio), HttpStatus.CREATED);
    }
    @PutMapping
    public ResponseEntity<FinancialPortfolio> update(@RequestBody FinancialPortfolio financialPortfolio) {
        try {
            return new ResponseEntity<>(portfolioService.update(financialPortfolio), HttpStatus.OK);
        } catch(NoSuchElementException ex) {
            LOG.debug("update for unknown id: [" + financialPortfolio + "]");
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable long id) {
        try {
            portfolioService.delete(id);
        } catch(EmptyResultDataAccessException ex) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
