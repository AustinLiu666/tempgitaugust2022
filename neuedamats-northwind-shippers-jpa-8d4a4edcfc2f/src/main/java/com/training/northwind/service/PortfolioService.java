package com.training.northwind.service;


import com.training.northwind.entities.FinancialPortfolio;
import com.training.northwind.repository.PortfolioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PortfolioService {
    @Autowired
    PortfolioRepository portfolioRepository;

    public List<FinancialPortfolio> findAll() {
        return portfolioRepository.findAll();
    }

    public FinancialPortfolio findById(long id) {
        return portfolioRepository.findById(id).get();
    }

    public List<FinancialPortfolio> findPortfolioByUsername(String userName) {
        return portfolioRepository.findFinancialPortfolioByUsername(userName);
    }

    public FinancialPortfolio save(FinancialPortfolio financialPortfolio) {
        return portfolioRepository.save(financialPortfolio);
    }

    public FinancialPortfolio update(FinancialPortfolio financialPortfolio) {
        portfolioRepository.findById(financialPortfolio.getId()).get();

        return portfolioRepository.save(financialPortfolio);
    }

    public void delete(long id) {
        portfolioRepository.deleteById(id);
    }
}
