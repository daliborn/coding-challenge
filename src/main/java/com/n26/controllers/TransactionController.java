package com.n26.controllers;

import com.n26.domain.Transaction;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController (value = "/transactions")
public class TransactionController {

    //Returns: Empty body with one of the following:
    //
    //201 – in case of success
    //204 – if the transaction is older than 60 seconds
    //400 – if the JSON is invalid
    //422 – if any of the fields are not parsable or the transaction date is in the future
    @PostMapping
    @ResponseBody
    public ResponseEntity greeting(@Valid @RequestBody Transaction transaction) {
        return new ResponseEntity(HttpStatus.CREATED);
    }

    @DeleteMapping
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void delete() {

    }
}
