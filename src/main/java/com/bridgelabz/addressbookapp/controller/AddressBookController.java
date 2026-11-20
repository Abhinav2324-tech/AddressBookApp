package com.bridgelabz.addressbookapp.controller;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * Demonstrates the five Address Book REST routes without storing contacts.
 */
@RestController
@RequestMapping("/addressbook")
public class AddressBookController {

    @GetMapping({"", "/"})
    public ResponseEntity<Map<String, Object>> getAllContacts() {
        return response("Get contacts successful", List.of());
    }

    @GetMapping("/get/{contactId}")
    public ResponseEntity<Map<String, Object>> getContactById(
            @PathVariable("contactId") int contactId) {
        return response("Get contact by ID successful",
                Map.of("contactId", contactId));
    }

    @PostMapping("/create")
    public ResponseEntity<Map<String, Object>> createContact(
            @RequestBody Map<String, String> contact) {
        return response("Create request received", contact);
    }

    @PutMapping("/update/{contactId}")
    public ResponseEntity<Map<String, Object>> updateContact(
            @PathVariable("contactId") int contactId,
            @RequestBody Map<String, String> contact) {
        Map<String, Object> data = new LinkedHashMap<>(contact);
        data.put("contactId", contactId);
        return response("Update request received", data);
    }

    @DeleteMapping("/delete/{contactId}")
    public ResponseEntity<Map<String, Object>> deleteContact(
            @PathVariable("contactId") int contactId) {
        return response("Delete request received",
                Map.of("contactId", contactId));
    }

    private ResponseEntity<Map<String, Object>> response(String message, Object data) {
        return ResponseEntity.ok(Map.of("message", message, "data", data));
    }
}