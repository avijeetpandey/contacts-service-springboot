package io.avijeet.contactsservice.repository;

import io.avijeet.contactsservice.pojo.Contact;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Repository
public class ContactRepository {
    private List<Contact> contacts = List.of(
            new Contact("123", "Jon snow", "41312121212"),
            new Contact("456", "Hound snow", "4131212232323")
    );

    public List<Contact> getContacts() {
        return contacts;
    }

    public Contact getContact(int index) {
        return contacts.get(index);
    }

    public void saveContact(Contact contact) {
        contacts.add(contact);
    }

    public void updateContact(Contact contact, int index) {
        contacts.set(index, contact);
    }

    public void deleteContact(int index) {
        contacts.remove(index);
    }
}
