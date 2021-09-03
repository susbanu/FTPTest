package com.test;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.env.Environment;

import com.test.config.FTPSettings;
import com.test.entity.AddressEntity;
import com.test.exception.ApplicationException;
import com.test.processor.DataProcessor;

@SpringBootApplication
public class FtpTestApplication implements ApplicationRunner {

	private final Logger LOGGER = LoggerFactory.getLogger(FtpTestApplication.class);
	
	// Read property from environment variable
	@Autowired
	private Environment environment;
	
	// Bind the properties
	@Autowired
	private FTPSettings ftpSettings;
	
	@Autowired
	private DataProcessor dataProcessor;
	
	// Read property from application.properites and arguments value
	@Value("${person.name}")
    private String name;
	
	public static void main(String[] args) {
		SpringApplication.run(FtpTestApplication.class, args);
	}

	@Override
	public void run(ApplicationArguments args) throws Exception {
		LOGGER.info("ApplicationRunnerImpl Called");
		
		// java -jar FTPTest-0.0.1-SNAPSHOT.jar --myarg=123
		args.getOptionNames().forEach(arg -> LOGGER.info("Arguments Key: "+arg+" Arguments Value:"+ args.getOptionValues(arg)));
		
		LOGGER.info("Read Environment value: {}", environment.getProperty("APPDATA"));
		
		LOGGER.info("FTP Connection config:- Host: {}, Port: {}", ftpSettings.getHost(), ftpSettings.getPort());
		
		LOGGER.info("Read property from custom application.prop : {}", name);
		
		try {
			
			List<AddressEntity> addresses = dataProcessor.searchAddressByAny("Sushant");
			addresses.forEach(address -> LOGGER.info(address.getFirstName()+" - "+address.getLastName()));
			
		} catch (ApplicationException ex) {
			LOGGER.error("Error: {0}", ex);
			System.exit(1);
		} catch (Exception ex) {
			throw ex;
		}
	}
}
