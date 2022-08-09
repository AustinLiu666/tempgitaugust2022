package com.training.northwind.repository;

import com.training.northwind.entities.FinancialPortfolio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PortfolioRepository  extends JpaRepository<FinancialPortfolio, Long> {
    List<FinancialPortfolio> findFinancialPortfolioByUsername(String userName);
}
