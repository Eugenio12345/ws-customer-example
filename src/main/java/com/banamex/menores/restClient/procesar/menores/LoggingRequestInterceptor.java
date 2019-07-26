package com.banamex.menores.restClient.procesar.menores;

import java.io.IOException;
import java.nio.charset.Charset;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpRequest;
import org.springframework.http.client.ClientHttpRequestExecution;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.util.StreamUtils;

public class LoggingRequestInterceptor implements ClientHttpRequestInterceptor {

	private static final Logger LOGGER = LoggerFactory
			.getLogger(LoggingRequestInterceptor.class);

	//@Override
	public ClientHttpResponse intercept(HttpRequest request, byte[] body,
			ClientHttpRequestExecution execution) throws IOException {
		traceRequest(request, body);
		ClientHttpResponse response = execution.execute(request, body);
		traceResponse(response);
		return response;
	}

	private void traceRequest(HttpRequest request, byte[] body)
			throws IOException {
		LOGGER.info("===========================request begin================================================");
		LOGGER.info("URI         : {}" + request.getURI());
		LOGGER.info("Method      : {}" + request.getMethod());
		LOGGER.info("Headers     : {}" + request.getHeaders());
		LOGGER.info("Request body: {}" + new String(body, "UTF-8"));
		LOGGER.info("==========================request end================================================");
	}

	private void traceResponse(ClientHttpResponse response) throws IOException {
		LOGGER.info("============================response begin==========================================");
		LOGGER.info("Status code  : {}" + response.getStatusCode());
		LOGGER.info("Status text  : {}" + response.getStatusText());
		LOGGER.info("Headers      : {}" + response.getHeaders());
		//LOGGER.info("Response body: {}" + inputStringBuilder.toString());
		LOGGER.info("Response body: {}" + StreamUtils.copyToString(response.getBody(), Charset.defaultCharset()));
		LOGGER.info("=======================response end=================================================");
	}

}
