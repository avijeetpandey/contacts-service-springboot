package io.avijeet.contactsservice.service;

import io.avijeet.contactsservice.pojo.Contact;

public interface ContactService {
    Contact getContactById(String id);
    void saveContact(Contact contact);
    Contact updateContact(Contact contact, int index);
    int findContactIndexById(String id);
    void deleteContact(String id);
}
