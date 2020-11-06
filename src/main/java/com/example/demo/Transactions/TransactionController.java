package com.example.demo.Transactions;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping("/transactiondata")
public class TransactionController {

    @Autowired
    TransactionRespository repository;

    // Create and Read routes

    @GetMapping("/all")
    public List<TransactionData> readAllTransactions() {         // Just declared our own TransactionData list and made a function named getAllTransactions
        return repository.findAll();                            // findAll function is an automatically generated query method that Spring provides which returns everything from the data store
    }

    @GetMapping("/{id}")
    public TransactionData readTransactionById(@PathVariable UUID id) {
        return repository.findById(id).orElse(null);
    }

    @PostMapping("/all")
    public TransactionData createTransaction(@RequestBody TransactionData transaction) {   //It is of type TransactionData because you are reuturning TransactionData from this function
        return repository.save(transaction);            //save is another Spring method which stores an object
    }

    // Update route

    @PutMapping("/{id}")
    public TransactionData updateTransaction(@PathVariable UUID id, @RequestBody TransactionData transaction) {    //Search transaction by its ID in order to update it
        TransactionData transactionToEdit = repository.findById(id).orElse(null);    //Find transaction by ID in the repository...if not ID matches then its null

        if(transactionToEdit == null) {            //If the transaction cannot be found then throw a 404 Not Found error
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Message Data not Found.");   //nothing else below this line in the If statement will run because you threw an exception
        }
        
        //If you do find the it by Id then get the following information for the variables and be able to set them to new ones 
        transactionToEdit.setDate(transaction.getDate());
        transactionToEdit.setAmount(transaction.getAmount());
        transactionToEdit.setDescription(transaction.getDescription());
        transactionToEdit.setLocation(transaction.getLocation());

        return repository.save(transactionToEdit);      //Save the changes made by transactionToEdit 
    }

    // Delete route

    @DeleteMapping("/{id}")
    public void deleteTransaction(@PathVariable UUID id) {
        if(repository.existsById(id)) {      //Spring's CRUD repository has a built in existsById method to check if something exists
            repository.deleteById(id);          //Also has a built in deleteById method 
        }
    }




}
