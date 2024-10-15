package com.BankofKazakhstan.CreditScore.Repository;

import com.BankofKazakhstan.CreditScore.Entity.CreditScoreEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CreditScoreRep extends JpaRepository<CreditScoreEntity, Long> {
}