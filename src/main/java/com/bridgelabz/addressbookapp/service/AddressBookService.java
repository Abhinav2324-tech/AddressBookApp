package com.bridgelabz.addressbookapp.service;

import com.bridgelabz.addressbookapp.dto.AddressBookDTO;
import com.bridgelabz.addressbookapp.model.AddressBookData;
import java.util.ArrayList;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

/**
 * Stores contacts in memory while the application is running.
 */
@Service
public class AddressBookService implements IAddressBookService {

    private final List<AddressBookData> contacts = new ArrayList<>();
    private int nextContactId = 1;

    @Override
    public synchronized List<AddressBookData> getAllContacts() {
        return List.copyOf(contacts);
    }

    @Override
    public synchronized AddressBookData getContactById(int contactId) {
        return contacts.get(findContactIndex(contactId));
    }

    @Override
    public synchronized AddressBookData createContact(AddressBookDTO request) {
        AddressBookData contact = new AddressBookData(nextContactId++, request);
        contacts.add(contact);
        return contact;
    }

    @Override
    public synchronized AddressBookData updateContact(int contactId, AddressBookDTO request) {
        int index = findContactIndex(contactId);
        AddressBookData updatedContact = new AddressBookData(contactId, request);
        contacts.set(index, updatedContact);
        return updatedContact;
    }

    @Override
    public synchronized void deleteContact(int contactId) {
        contacts.remove(findContactIndex(contactId));
    }

    private int findContactIndex(int contactId) {
        for (int i = 0; i < contacts.size(); i++) {
            if (contacts.get(i).getContactId() == contactId) {
                return i;
            }
        }

        throw new ResponseStatusException(
                HttpStatus.NOT_FOUND, "Contact not found with ID " + contactId);
    }
}