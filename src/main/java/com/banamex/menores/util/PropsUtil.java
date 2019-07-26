package com.banamex.menores.util;

import java.io.FileInputStream;
import java.util.Properties;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class PropsUtil {

	private static final Logger LOGGER = LoggerFactory
			.getLogger(PropsUtil.class);

	private static Properties props;

	private PropsUtil() {

	}

	static {
		try {
			TransactionState.Current().initialize();
			props = new Properties();
			props.load(new FileInputStream(
					"/opt/middleware/BOC/properties/menores.properties"));
			LOGGER.info("Se cargan las propiedades menores.properties");
		} catch (Exception e) {
			LOGGER.error(e.getMessage(), e);
		}
	}

	public static Properties getProperties() {
		return props;
	}
}
