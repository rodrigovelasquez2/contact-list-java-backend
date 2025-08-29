package com.rodvels.crud.api.controller;

import com.rodvels.crud.api.entity.Contact;
import com.rodvels.crud.api.repository.ContactRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@CrossOrigin
@RequestMapping("api/contacts")
@RestController
@RequiredArgsConstructor
public class ContactController {

    private final ContactRepository contactRepository;

    @GetMapping
    Iterable<Contact> list(){
        return contactRepository.findAll();
    }

    @GetMapping("{id}")
    public ResponseEntity<Contact> getContacts(@PathVariable Integer id) {
        return contactRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(null);
    }

    @PostMapping
    public ResponseEntity<Contact> create(@RequestBody Contact contact) {
        contact.setCreated_At(LocalDateTime.now());
        return ResponseEntity.ok(contactRepository.save(contact));
    }

    @PutMapping({"{id}"})
    public ResponseEntity<Contact> update(@PathVariable Integer id ,
                                          @RequestBody Contact contact) {
        return contactRepository.findById(id)
                .map(existingContact -> {
                    existingContact.setName(contact.getName());
                    existingContact.setEmail(contact.getEmail());
                    existingContact.setCreated_At(LocalDateTime.now());
                    Contact updated = contactRepository.save(existingContact);
                    return ResponseEntity.ok(updated);
                })
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> delete(@PathVariable Integer id) {
        if(!contactRepository.existsById(id)){
            return ResponseEntity.notFound().build();
        }
            contactRepository.deleteById(id);
          return ResponseEntity.ok("Delete Contact");
    }
}
