package com.mxi.maintsuite.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class PropertyUtil {

	private static final String PROPERTY_FILE = "/app.properties";
	
	@Getter @Setter
	private Properties 	properties;
	
	public PropertyUtil(){
		init();
	}
	
	private void init(){
		properties = new Properties();
		try {
			InputStream in =  this.getClass().getResourceAsStream(PROPERTY_FILE);
			properties.load(in);
		} catch (IOException e) {
			log.error("Error trying to get properties");
		}
	}
	
}
