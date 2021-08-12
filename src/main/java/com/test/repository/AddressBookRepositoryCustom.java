package com.test.repository;

import java.util.List;

import com.test.entity.AddressEntity;

public interface AddressBookRepositoryCustom {

	public List<AddressEntity> findAllByAny(String field);
}
