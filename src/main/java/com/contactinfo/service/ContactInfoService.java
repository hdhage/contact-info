package com.contactinfo.service;

import com.contactinfo.exception.RecordNotFoundException;
import com.contactinfo.model.ContactInfo;
import com.contactinfo.repository.ContactRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ContactInfoService {

    @Autowired
    ContactRepository repository;

    public List<ContactInfo> getAll() {
        List<ContactInfo> contactInfoList = repository.findAll();

        if(contactInfoList.size() > 0) {
            return contactInfoList;
        } else {
            return new ArrayList<ContactInfo>();
        }
    }

    public ContactInfo getContactById(Long id) throws RecordNotFoundException {
        Optional<ContactInfo> contactInfo = repository.findById(id);

        if(contactInfo.isPresent()) {
            return contactInfo.get();
        } else {
            throw new RecordNotFoundException("No contact record exist for given id : "+id);
        }
    }

    public ContactInfo createContact(ContactInfo entity) {
        ContactInfo newContact = new ContactInfo();
        newContact.setFirstName(entity.getFirstName());
        newContact.setLastName(entity.getLastName());
        newContact.setEmail(entity.getEmail());
        newContact.setPhoneNumber(entity.getPhoneNumber());
        newContact.setStatus(entity.getStatus());

        newContact = repository.save(newContact);
        return newContact;
    }

    public ContactInfo updateContact(Long id, ContactInfo entity) throws RecordNotFoundException {
        Optional<ContactInfo> contactInfo = repository.findById(id);

        if(contactInfo.isPresent()) {
            ContactInfo newContact = contactInfo.get();
            newContact.setFirstName(entity.getFirstName());
            newContact.setLastName(entity.getLastName());
            newContact.setEmail(entity.getEmail());
            newContact.setPhoneNumber(entity.getPhoneNumber());
            newContact.setStatus(entity.getStatus());

            newContact = repository.save(newContact);
            return newContact;
        } else {
            throw new RecordNotFoundException("No contact record exist for given id : "+id);
        }
    }

    public void deleteContactById(Long id) throws RecordNotFoundException {
        Optional<ContactInfo> contactInfo = repository.findById(id);

        if(contactInfo.isPresent()) {
            ContactInfo contact = contactInfo.get();
            contact.setStatus("INACTIVE");
            repository.save(contact);
        } else {
            throw new RecordNotFoundException("No contact record exist for given id : "+id);
        }

    }
}
