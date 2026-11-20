package com.bridgelabz.addressbookapp.service;

import com.bridgelabz.addressbookapp.dto.AddressBookDTO;
import com.bridgelabz.addressbookapp.model.AddressBookData;
import java.util.List;
import org.springframework.stereotype.Service;

/**
 * Creates contact objects for the controller without storing them yet.
 */
@Service
public class AddressBookService implements IAddressBookService {

    @Override
    public List<AddressBookData> getAllContacts() {
        return List.of(getContactById(1));
    }

    @Override
    public AddressBookData getContactById(int contactId) {
        return new AddressBookData(contactId, "Lisa", "9876543210", "Chennai");
    }

    @Override
    public AddressBookData createContact(AddressBookDTO request) {
        return new AddressBookData(1, request);
    }

    @Override
    public AddressBookData updateContact(int contactId, AddressBookDTO request) {
        return new AddressBookData(contactId, request);
    }

    @Override
    public void deleteContact(int contactId) {
        // There is no contact list to delete from until UC 3.
    }
}