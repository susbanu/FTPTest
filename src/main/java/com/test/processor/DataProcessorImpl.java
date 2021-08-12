package com.test.processor;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.test.entity.AddressEntity;
import com.test.repository.AddressBookRepository;

@Component
public class DataProcessorImpl implements DataProcessor {

	@Autowired
	private AddressBookRepository addressBookRepository;

	@Override
	public List<AddressEntity> searchAddressByAny(String searchField) {
		return addressBookRepository.findAllByAny(searchField);
	}

	@Override
	public void uploadFileToFTPServer() {
		// UploadFile to FTP Server
		// Read FTP configuration from 'FTPSettings' class
		
		// https://spring.io/blog/2020/03/18/spring-tips-remote-file-system-integrations-ftp-with-spring-integration
	}
}
