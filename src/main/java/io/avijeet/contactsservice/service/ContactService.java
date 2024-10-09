package io.avijeet.contactsservice.service;
import io.avijeet.contactsservice.exception.NoContactException;
import io.avijeet.contactsservice.pojo.Contact;
import java.util.List;

public interface ContactService {
    Contact getContactById(String id) throws NoContactException;
    void saveContact(Contact contact);
    Contact updateContact(Contact contact, int index) throws NoContactException;
    int findContactIndexById(String id) throws NoContactException;
    void deleteContact(String id) throws NoContactException;
    List<Contact> getAllContacts();
}
