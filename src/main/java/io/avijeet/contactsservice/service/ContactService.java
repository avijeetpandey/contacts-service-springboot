package io.avijeet.contactsservice.service;

import io.avijeet.contactsservice.pojo.Contact;

public interface ContactService {
    Contact getContactById(String id);
}
