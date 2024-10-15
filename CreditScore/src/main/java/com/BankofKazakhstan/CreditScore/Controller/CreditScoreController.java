package com.BankofKazakhstan.CreditScore.Controller;

import com.BankofKazakhstan.CreditScore.Entity.CreditScoreEntity;
import com.BankofKazakhstan.CreditScore.Services.CreditScoreServ;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/CreditScoreEntitys")
public class CreditScoreController {

    @Autowired
    private CreditScoreServ CreditScoreServ;

    @GetMapping
    public ResponseEntity<List<CreditScoreEntity>> getAllCreditScoreEntities() {
        List<CreditScoreEntity> CreditScoreEntitys = CreditScoreServ.getAllCreditScoreEntities();
        return new ResponseEntity<>(CreditScoreEntitys, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CreditScoreEntity> getCreditScoreEntityById(@PathVariable Long id) {
        Optional<CreditScoreEntity> CreditScoreEntity = CreditScoreServ.getCreditScoreEntityById(id);
        return CreditScoreEntity.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping
    public ResponseEntity<CreditScoreEntity> createCreditScoreEntity(@RequestBody CreditScoreEntity CreditScoreEntity) {
        CreditScoreEntity createdCreditScoreEntity = CreditScoreServ.createCreditScoreEntity(CreditScoreEntity);
        return new ResponseEntity<>(createdCreditScoreEntity, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CreditScoreEntity> updateCreditScoreEntity(@PathVariable Long id, @RequestBody CreditScoreEntity updatedCreditScoreEntity) {
        CreditScoreEntity CreditScoreEntity = CreditScoreServ.updateCreditScoreEntity(id, updatedCreditScoreEntity);
        return CreditScoreEntity != null ? new ResponseEntity<>(CreditScoreEntity, HttpStatus.OK) :
                new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCreditScoreEntity(@PathVariable Long id) {
        CreditScoreServ.deleteCreditScoreEntity(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
