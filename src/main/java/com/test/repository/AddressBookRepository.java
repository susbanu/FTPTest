package com.test.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Component;

import com.test.entity.AddressEntity;

@Component
public interface AddressBookRepository extends MongoRepository<AddressEntity, String>, AddressBookRepositoryCustom {

}
