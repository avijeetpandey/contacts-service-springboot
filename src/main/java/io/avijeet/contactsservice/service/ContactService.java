package io.avijeet.contactsservice.service;
import io.avijeet.contactsservice.pojo.Contact;
import io.avijeet.contactsservice.repository.ContactRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ContactService {
    @Autowired
    private ContactRepository contactRepository;

    public List<Contact> findAll() {
        return contactRepository.findAll();
    }

    public Optional<Contact> findById(Long id) {
        return contactRepository.findById(id);
    }

    public Contact save(Contact contact) {
        return contactRepository.save(contact);
    }

    public void deleteById(Long id) {
        contactRepository.deleteById(id);
    }

    public List<Contact> findByName(String name) {
        return contactRepository.findByName(name);
    }

    public Contact update(Long id, Contact updatedContact) {
        Optional<Contact> existingContactOptional = contactRepository.findById(id);
        if (existingContactOptional.isPresent()) {
            Contact existingContact = existingContactOptional.get();

            // updating the fields
            existingContact.setName(updatedContact.getName());
            existingContact.setPhoneNumber(updatedContact.getPhoneNumber());

            return contactRepository.save(existingContact);
        } else {
            throw new RuntimeException("Contact not found");
        }
    }
}
