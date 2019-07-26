package com.banamex.menores.util;

import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;

public class TransactionState {
	
	private static final Logger logger = LoggerFactory.getLogger(TransactionState.class);
	
	private static ThreadLocal<TransactionState> sessionForCurrentThread = new ThreadLocal<TransactionState>() {
		@Override
		public TransactionState initialValue() {
			return new TransactionState();
		}
	}; 
	
	public static TransactionState Current() {
		return sessionForCurrentThread.get();
	}

	public void initialize() {		
		logger.trace("Antes: {}", this);
    	MDC.put("transactionId", UUID.randomUUID().toString());
    	logger.trace("Despues: {}", this);
	}
}

