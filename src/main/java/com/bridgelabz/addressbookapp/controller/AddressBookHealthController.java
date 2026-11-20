package com.bridgelabz.addressbookapp.controller;

import java.util.Map;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Provides an endpoint to verify that the Address Book app is running.
 */
@RestController
public class AddressBookHealthController {

    @GetMapping("/addressbook/health")
    public Map<String, String> health() {
        return Map.of("status", "UP");
    }
}