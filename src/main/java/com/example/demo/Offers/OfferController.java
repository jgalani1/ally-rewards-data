package com.example.demo.Offers;

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
@RequestMapping("/offerdata")
public class OfferController {
    @Autowired
    OfferRespository repository;

    @GetMapping("/all")
    public List<OfferData> readAllOffers() {
        return repository.findAll();
    }

    @GetMapping("/{id}")
    public OfferData readOfferById(@PathVariable UUID id) {
        return repository.findById(id).orElse(null);
    }

    @PostMapping("/all")
    public OfferData createOffer(@RequestBody OfferData offer) {
        return repository.save(offer);  
    }

    @PutMapping("/{id}")
    public OfferData updateOffer(@PathVariable UUID id, @RequestBody OfferData offer) {    //Search transaction by its ID in order to update it
        OfferData offerToEdit = repository.findById(id).orElse(null);    //Find transaction by ID in the repository...if not ID matches then its null

        if(offerToEdit == null) {            //If the transaction cannot be found then throw a 404 Not Found error
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Deal Data not Found.");   //nothing else below this line in the If statement will run because you threw an exception
        }
        
        //If you do find the it by Id then get the following information for the variables and be able to set them to new ones 
        offerToEdit.setCard(offer.getCard());
        offerToEdit.setOffer(offer.getOffer());
        offerToEdit.setReward(offer.getReward());
        

        return repository.save(offerToEdit);      //Save the changes made by transactionToEdit 
    }

    @DeleteMapping("/{id}")
    public void deleteOffer(@PathVariable UUID id) {
        if(repository.existsById(id)) {      //Spring's CRUD repository has a built in existsById method to check if something exists
            repository.deleteById(id);          //Also has a built in deleteById method 
        }
    }
}
