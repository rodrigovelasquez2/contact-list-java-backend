package com.rodvels.crud.api.service;

import com.rodvels.crud.api.dto.ContactDTO;
import com.rodvels.crud.api.entity.Contact;
import com.rodvels.crud.api.exception.ResourceNotFoundException;
import com.rodvels.crud.api.repository.ContactRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;


@RequiredArgsConstructor
@Service
public class ContactService {
    private final ContactRepository contactRepository;
    private final ModelMapper modelMapper;

    public Iterable<Contact> findAll() {
        return contactRepository.findAll();
    }

    public Contact findById(Integer id) {
        return contactRepository.findById(id).orElseThrow(ResourceNotFoundException::new);
    }

    public Contact create(ContactDTO contactDTO) {
        Contact contact =  modelMapper.map(contactDTO, Contact.class);
        contact.setCreated_At(LocalDateTime.now());
        return contactRepository.save(contact);
    }
    public Contact update(Integer  id, ContactDTO contactDTO) {
        return contactRepository.findById(id).map(contactExist ->{
            modelMapper.map(contactDTO, contactExist);
            return  contactRepository.save(contactExist);
        }).orElse(null);
    }
    public void delete(Integer id) {
        if(!contactRepository.existsById(id)){
            throw new IllegalArgumentException("Contact not found");
        }
        contactRepository.deleteById(id);
    }
}
