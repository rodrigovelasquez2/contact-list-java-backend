package com.rodvels.crud.api.controller;

import com.rodvels.crud.api.dto.ContactDTO;
import com.rodvels.crud.api.entity.Contact;
import com.rodvels.crud.api.service.ContactService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@CrossOrigin
@RequestMapping("api/contacts")
@RestController
@RequiredArgsConstructor
public class ContactController {

    private final ContactService contactService;

    @GetMapping
    Iterable<Contact> list(){
        return contactService.findAll();
    }

    @GetMapping("{id}")
    public Contact getContacts(@PathVariable Integer id) {
        return contactService.findById(id);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public Contact create(@RequestBody ContactDTO contactDTO) {
        return contactService.create(contactDTO);
    }

    @PutMapping({"{id}"})
    public Contact update(@PathVariable Integer id , @RequestBody ContactDTO contactDTO) {
        return contactService.update(id,contactDTO);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("{id}")
    public void delete(@PathVariable Integer id) {
        contactService.delete(id);
    }
}
