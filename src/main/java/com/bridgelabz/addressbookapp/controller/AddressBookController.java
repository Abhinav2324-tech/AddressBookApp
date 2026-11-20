package com.bridgelabz.addressbookapp.controller;

import com.bridgelabz.addressbookapp.dto.AddressBookDTO;
import com.bridgelabz.addressbookapp.dto.ResponseDTO;
import com.bridgelabz.addressbookapp.model.AddressBookData;
import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * Returns structured JSON responses using the contact model and DTOs.
 */
@RestController
@RequestMapping("/addressbook")
public class AddressBookController {

    @GetMapping({"", "/"})
    public ResponseEntity<ResponseDTO> getAllContacts() {
        AddressBookData sample = new AddressBookData(1, "Lisa", "9876543210", "Chennai");
        return response("Get contacts successful", List.of(sample));
    }

    @GetMapping("/get/{contactId}")
    public ResponseEntity<ResponseDTO> getContactById(
            @PathVariable("contactId") int contactId) {
        AddressBookData sample = new AddressBookData(contactId, "Lisa", "9876543210", "Chennai");
        return response("Get contact by ID successful", sample);
    }

    @PostMapping("/create")
    public ResponseEntity<ResponseDTO> createContact(@RequestBody AddressBookDTO request) {
        AddressBookData contact = new AddressBookData(1, request);
        return response("Create request received", contact);
    }

    @PutMapping("/update/{contactId}")
    public ResponseEntity<ResponseDTO> updateContact(
            @PathVariable("contactId") int contactId,
            @RequestBody AddressBookDTO request) {
        AddressBookData contact = new AddressBookData(contactId, request);
        return response("Update request received", contact);
    }

    @DeleteMapping("/delete/{contactId}")
    public ResponseEntity<ResponseDTO> deleteContact(
            @PathVariable("contactId") int contactId) {
        return response("Delete request received", contactId);
    }

    private ResponseEntity<ResponseDTO> response(String message, Object data) {
        return ResponseEntity.ok(new ResponseDTO(message, data));
    }
}