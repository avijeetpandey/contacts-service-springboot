package io.avijeet.contactsservice.service;

import io.avijeet.contactsservice.exception.NoContactException;
import io.avijeet.contactsservice.pojo.Contact;
import io.avijeet.contactsservice.repository.ContactRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

@Service
public class ContactServiceImpl implements ContactService {
    @Autowired
    private ContactRepository contactRepository;

    private int findIndexById(String id) throws NoContactException {
        return IntStream.range(0, contactRepository.getContacts().size())
                .filter(index -> contactRepository.getContacts().get(index).getId().equals(id))
                .findFirst()
                .orElseThrow(NoContactException::new);
    }

    @Override
    public Contact getContactById(String id) throws NoContactException {
        return contactRepository.getContact(findIndexById(id));
    }

    @Override
    public void saveContact(Contact contact) {
        contactRepository.saveContact(contact);
    }

    @Override
    public Contact updateContact(Contact contact, int index) {
        contactRepository.updateContact(contact, index);
        return contactRepository.getContact(index);
    }

    @Override
    public int findContactIndexById(String id) throws NoContactException {
       return findIndexById(id);
    }

    @Override
    public void deleteContact(String id) throws NoContactException {
        contactRepository.deleteContact(findIndexById(id));
    }

    @Override
    public List<Contact> getAllContacts() {
        return contactRepository.getContacts();
    }
}
