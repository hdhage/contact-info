package com.contactinfo.controller;

import com.contactinfo.customresponse.ResponseMessage;
import com.contactinfo.exception.RecordNotFoundException;
import com.contactinfo.model.ContactInfo;
import com.contactinfo.service.ContactInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1")
public class ContactInfController {

    @Autowired
    private ContactInfoService contactService;

    @PostMapping("/contactinfo")
    public ResponseEntity<ResponseMessage> createOrUpdate(@RequestBody ContactInfo contactInfo){
        contactService.createContact(contactInfo);
        return ResponseEntity.status(HttpStatus.CREATED).body(getResponseMessage(HttpStatus.CREATED, "Contact added successfully"));
    }

    @GetMapping("/contactinfo")
    public List<ContactInfo> getAllContacts(){
        return contactService.getAll();
    }

    @GetMapping("/contactinfo/{id}")
    public ContactInfo getContactById(@PathVariable Long id) throws RecordNotFoundException {
        return contactService.getContactById(id);
    }

    @PutMapping("/contactinfo/{id}")
    public ResponseEntity<ResponseMessage> updateContact(@PathVariable Long id, @RequestBody ContactInfo contactInfo) throws RecordNotFoundException {
        contactService.updateContact(id, contactInfo);
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(getResponseMessage(HttpStatus.ACCEPTED, "Contact updated successfully"));
    }

    @DeleteMapping("/contactinfo/{id}")
    public ResponseEntity<ResponseMessage> deleteEmployeeById(@PathVariable("id") Long id) throws RecordNotFoundException {
        contactService.deleteContactById(id);
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(getResponseMessage(HttpStatus.ACCEPTED, "Contact deleted successfully"));
    }


    private ResponseMessage getResponseMessage(HttpStatus status, String message){
        ResponseMessage response = new ResponseMessage();
        response.setMessage(message);
        response.setStatus(status);
        return response;
    }
}
