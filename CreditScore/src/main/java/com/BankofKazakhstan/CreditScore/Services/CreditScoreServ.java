package com.BankofKazakhstan.CreditScore.Services;

import com.BankofKazakhstan.CreditScore.Entity.CreditScoreEntity;
import com.BankofKazakhstan.CreditScore.Repository.CreditScoreRep;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class CreditScoreServ {

    @Autowired
    private CreditScoreRep creditScoreEntityRepository;

    public List<CreditScoreEntity> getAllCreditScoreEntities() {
        return creditScoreEntityRepository.findAll();
    }

    public Optional<CreditScoreEntity> getCreditScoreEntityById(Long id) {
        return creditScoreEntityRepository.findById(id);
    }

    public CreditScoreEntity createCreditScoreEntity(CreditScoreEntity CreditScoreEntity) {
        return creditScoreEntityRepository.save(CreditScoreEntity);
    }

    public CreditScoreEntity updateCreditScoreEntity(Long id, CreditScoreEntity updatedCreditScoreEntity) {
        Optional<CreditScoreEntity> existingCreditScoreEntityOptional = creditScoreEntityRepository.findById(id);
        if (existingCreditScoreEntityOptional.isPresent()) {
            CreditScoreEntity existingCreditScoreEntity = existingCreditScoreEntityOptional.get();
            existingCreditScoreEntity.setName(updatedCreditScoreEntity.getName());
            existingCreditScoreEntity.setAge(updatedCreditScoreEntity.getAge());
            existingCreditScoreEntity.setPhone(updatedCreditScoreEntity.getPhone());
            existingCreditScoreEntity.setCreditscore(updatedCreditScoreEntity.getCreditscore());
            existingCreditScoreEntity.setCurrentcredits(updatedCreditScoreEntity.getCurrentcredits());
            return creditScoreEntityRepository.save(existingCreditScoreEntity);
        }
        return null;
    }

    public void deleteCreditScoreEntity(Long id) {
        creditScoreEntityRepository.deleteById(id);
    }
}