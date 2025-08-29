package com.rodvels.crud.api.repository;

import com.rodvels.crud.api.entity.Contact;
import org.springframework.data.repository.CrudRepository;

public interface ContactRepository extends CrudRepository<Contact, Integer> {

}
