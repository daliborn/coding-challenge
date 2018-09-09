package com.n26.controllers;

import com.fasterxml.jackson.databind.exc.InvalidFormatException;
import com.n26.domain.Transaction;
import com.n26.service.TransactionService;
import com.n26.util.DurationUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;


@RestController (value = "/transactions")
public class TransactionController {
    Logger log = LoggerFactory.getLogger(TransactionController.class);

    private TransactionService transactionService;

    @Autowired
    public TransactionController(TransactionService transactionService) {
        this.transactionService = transactionService;
    }

    @PostMapping
    @ResponseBody
    public final ResponseEntity greeting(@Valid @RequestBody Transaction transaction, Errors errors) {
        if (errors.hasErrors()){
            return new ResponseEntity(HttpStatus.UNPROCESSABLE_ENTITY);
        }

        if(DurationUtil.isOlderThanSixtySecondsFromNow(transaction.getTimestamp())){
            return new ResponseEntity(HttpStatus.NO_CONTENT);
        }

        transactionService.saveTransaction(transaction);
        return new ResponseEntity(HttpStatus.CREATED);
    }

    @DeleteMapping
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void delete() {
        transactionService.deleteTransactions();
    }

    @ExceptionHandler(InvalidFormatException.class)
    public final ResponseEntity handleUserNotFoundException(InvalidFormatException ex) {
        return new ResponseEntity(HttpStatus.UNPROCESSABLE_ENTITY);
    }
}
