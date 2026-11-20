package com.bridgelabz.addressbookapp.controller;

import com.bridgelabz.addressbookapp.dto.AddressBookDTO;
import com.bridgelabz.addressbookapp.dto.ResponseDTO;
import com.bridgelabz.addressbookapp.service.IAddressBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * Handles HTTP requests and delegates contact operations to the service.
 */
@RestController
@RequestMapping("/addressbook")
public class AddressBookController {

    private final IAddressBookService addressBookService;

    @Autowired
    public AddressBookController(IAddressBookService addressBookService) {
        this.addressBookService = addressBookService;
    }

    @GetMapping({"", "/"})
    public ResponseEntity<ResponseDTO> getAllContacts() {
        return response("Get contacts successful", addressBookService.getAllContacts());
    }

    @GetMapping("/get/{contactId}")
    public ResponseEntity<ResponseDTO> getContactById(
            @PathVariable("contactId") int contactId) {
        return response("Get contact by ID successful",
                addressBookService.getContactById(contactId));
    }

    @PostMapping("/create")
    public ResponseEntity<ResponseDTO> createContact(@RequestBody AddressBookDTO request) {
        return response("Create request received", addressBookService.createContact(request));
    }

    @PutMapping("/update/{contactId}")
    public ResponseEntity<ResponseDTO> updateContact(
            @PathVariable("contactId") int contactId,
            @RequestBody AddressBookDTO request) {
        return response("Update request received",
                addressBookService.updateContact(contactId, request));
    }

    @DeleteMapping("/delete/{contactId}")
    public ResponseEntity<ResponseDTO> deleteContact(
            @PathVariable("contactId") int contactId) {
        addressBookService.deleteContact(contactId);
        return response("Delete request received", contactId);
    }

    private ResponseEntity<ResponseDTO> response(String message, Object data) {
        return ResponseEntity.ok(new ResponseDTO(message, data));
    }
}