package com.bridgelabz.addressbookapp.model;

import com.bridgelabz.addressbookapp.dto.AddressBookDTO;

/**
 * Represents a contact with an ID, name, phone number, and city.
 */
public class AddressBookData {
    private final int contactId;
    private final String name;
    private final String phone;
    private final String city;

    public AddressBookData(int contactId, String name, String phone, String city) {
        this.contactId = contactId;
        this.name = name;
        this.phone = phone;
        this.city = city;
    }

    public AddressBookData(int contactId, AddressBookDTO request) {
        this(contactId, request.name, request.phone, request.city);
    }

    public int getContactId() {
        return contactId;
    }

    public String getName() {
        return name;
    }

    public String getPhone() {
        return phone;
    }

    public String getCity() {
        return city;
    }
}