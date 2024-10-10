package io.avijeet.contactsservice.repository;

import io.avijeet.contactsservice.pojo.Contact;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface ContactRepository extends JpaRepository<Contact, Long> {
    List<Contact> findByName(String name);
}