package io.avijeet.contactsservice.web;

import io.avijeet.contactsservice.pojo.Contact;
import io.avijeet.contactsservice.service.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class ContactController {
    @Autowired
    private ContactService contactService;

    @GetMapping("/contact/{id}")
    public ResponseEntity<Contact> getContact(@PathVariable String id) {
       Contact contact = contactService.getContactById(id);
       return new ResponseEntity<>(contact, HttpStatus.OK);
    }

    @PostMapping("/contact")
    public ResponseEntity<String> createContact(@RequestBody Contact contact) {
        contactService.saveContact(contact);
        return new ResponseEntity<>(contact.getId(), HttpStatus.CREATED);
    }

    @PutMapping("/contact")
    public ResponseEntity<Contact> updateContact(@RequestBody Contact contact) {
        int index = contactService.findContactIndexById(contact.getId());
        Contact updatedContact = contactService.updateContact(contact, index);
        return new ResponseEntity<>(updatedContact, HttpStatus.OK);
    }

    @DeleteMapping("/contact/{id}")
    public ResponseEntity<HttpStatus> deleteContact(@PathVariable String id) {
        contactService.deleteContact(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
