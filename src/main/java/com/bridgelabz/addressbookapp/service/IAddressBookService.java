package com.bridgelabz.addressbookapp.service;

import com.bridgelabz.addressbookapp.dto.AddressBookDTO;
import com.bridgelabz.addressbookapp.model.AddressBookData;
import java.util.List;

/**
 * Defines the contact operations that the controller can call.
 */
public interface IAddressBookService {

    List<AddressBookData> getAllContacts();

    AddressBookData getContactById(int contactId);

    AddressBookData createContact(AddressBookDTO request);

    AddressBookData updateContact(int contactId, AddressBookDTO request);

    void deleteContact(int contactId);
}