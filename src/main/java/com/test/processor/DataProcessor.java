package com.test.processor;

import java.util.List;

import com.test.entity.AddressEntity;

public interface DataProcessor {

	public List<AddressEntity> searchAddressByAny(String searchField);
	
	public void uploadFileToFTPServer();
}
