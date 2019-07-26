package com.banamex.menores.restClient.procesar.menores;

import java.io.File;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.nio.charset.Charset;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSession;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.io.FileUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.BufferingClientHttpRequestFactory;
import org.springframework.http.client.ClientHttpRequestFactory;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import com.banamex.eeafo.content.upload.EeafoContentEngineLogServiceUploadImpl;
import com.banamex.eeafo.content.upload.dto.ContentEngineLogServiceRequestDTO;
import com.banamex.eeafo.content.upload.dto.ContentEngineUploadResponseDTO;
import com.banamex.eeafo.jaas.EeafoContentEngineImpl;
import com.banamex.menores.rest.dto.Cuerpo;
import com.banamex.menores.rest.dto.RespDatosBaseCurpMenor;
import com.banamex.menores.rest.dto.RespDatosDomParticular;
import com.banamex.menores.rest.dto.Respuesta;
import com.banamex.menores.util.PropsUtil;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class ProcesarMenoresRestConnectorImpl implements
		ProcesarMenoresRestConnector {

	private static final Logger LOGGER = LoggerFactory
			.getLogger(ProcesarMenoresRestConnectorImpl.class);

	private static final String MENORES_URL = PropsUtil.getProperties()
			.getProperty("procesar.menores.ws.url");

	private static final String USER_NAME = PropsUtil.getProperties()
			.getProperty("procesar.menores.user");
	private static final String PASSWORD = PropsUtil.getProperties()
			.getProperty("procesar.menores.password");
	private static final String ID_EBUSSINES = PropsUtil.getProperties()
			.getProperty("procesar.menores.idEbusiness");
	private static final String ID_CLIENTE = PropsUtil.getProperties()
			.getProperty("procesar.menores.idCliente");
	private static final String ID_SERVICIO = PropsUtil.getProperties()
			.getProperty("procesar.menores.idServicio");

	private static final String CONTENT_ENGINE_URI = PropsUtil.getProperties()
			.getProperty("contentEngineUri");
	private static final String CONTENT_ENGINE_USER_NAME = PropsUtil.getProperties()
			.getProperty("contentEngineUserName");
	private static final String CONTENT_ENGINE_PASSWORD = PropsUtil.getProperties()
			.getProperty("contentEnginePassword");
	private static final String CONTENT_ENGINE_STANZA = PropsUtil.getProperties()
			.getProperty("contentEngineStanza");
	private static final String LOG_PATH_ECM = PropsUtil.getProperties()
			.getProperty("logPathECM");
	private static final String TEMP_PATH_LOG = PropsUtil.getProperties()
			.getProperty("procesar.services.tempPathLog");
	
	private String userName;
	private String password;

	// @Override
	public Respuesta registraMenor(Cuerpo requestDTO) {
		try {

			// LOGGER.info("this.getUserName(): " + this.getUserName());
			// LOGGER.info("this.getPassword(): " + this.getPassword());

			HttpHeaders headers = new HttpHeaders();
			headers.add("Accept", MediaType.APPLICATION_JSON_VALUE);
			headers.add("idEbusiness", ID_EBUSSINES);
			headers.add("idCliente", ID_CLIENTE);
			headers.add("idServicio", ID_SERVICIO);

			// String usuario = StringToHex.getDecodificada(USER_NAME);
			// String contrasena = StringToHex.getDecodificada(PASSWORD);
			//
			// LOGGER.info("usuario: " + usuario);
			// LOGGER.info("contrasena: " + contrasena);

//			Base64 base64 = new Base64();
//			String usuarioDec = new String(base64.decode(USER_NAME.getBytes()));
//			String passDec = new String(base64.decode(PASSWORD.getBytes()));
//			this.setUserName(usuarioDec);
//			this.setPassword(passDec);

			
			this.setUserName(USER_NAME);
			this.setPassword(PASSWORD);			
			String auth = this.getUserName() + ":" + this.getPassword();
			byte[] encodedAuth = Base64.encodeBase64(auth.getBytes(Charset
					.forName("UTF8")));
			String encod = new String(encodedAuth);
			// LOGGER.info("encodedAuth: " + encod);
			String authHeader = "Basic " + new String(encod);
			headers.add("Authorization", authHeader);

			// el objeto que contiene la informacion de la peticion va aqui
			HttpEntity<?> entity = new HttpEntity<>(requestDTO, headers);

			String urlServicioRest = MENORES_URL
					+ requestDTO.getCurpMenorEdad().toUpperCase();
			LOGGER.info("URL: " + urlServicioRest);
			LOGGER.info("requestDTO: " + requestDTO.toString());

			Gson gson = new GsonBuilder().setPrettyPrinting().create();
			String jsonRequest = gson.toJson(requestDTO);
			LOGGER.info("request json: " + jsonRequest);

			UriComponentsBuilder builder = UriComponentsBuilder
					.fromHttpUrl(urlServicioRest);

			// El utilizar los interceptor se pierte el contenido de body
			// con BufferingClientHttpRequestFactory no se pierde el body
			List<ClientHttpRequestInterceptor> interceptors = new ArrayList<>();
			interceptors.add(new LoggingRequestInterceptor());
			ClientHttpRequestFactory factory = new BufferingClientHttpRequestFactory(
					clientHttpRequestFactory());
			RestTemplate restTemplate = new RestTemplate(factory);
			restTemplate.setInterceptors(interceptors);

			
			// RestTemplate restTemplate = new RestTemplate();
			// restTemplate.setRequestFactory(clientHttpRequestFactory());
			Respuesta output = null;

			ResponseEntity<String> respuesta = restTemplate.exchange(builder
					.build().encode().toUri(), HttpMethod.PUT, entity,
					String.class);

			LOGGER.info("URL: " + builder.build().encode().toUri());

			LOGGER.info("respuesta Menores null: "
					+ ((respuesta == null) ? "true" : "false"));

			LOGGER.info("respuesta Menores empty: "
					+ respuesta.toString().isEmpty());

			LOGGER.info("respuesta Menores texto: " + respuesta.toString());

			LOGGER.info("respuesta Menores hasBody: " + respuesta.hasBody());

			LOGGER.info("respuesta Menores getBody: " + respuesta.getBody());

			LOGGER.info("respuesta Menores length: "
					+ respuesta.getBody().length());

			String respuestaFinal = respuesta.getBody();

			if (respuestaFinal != null && !respuestaFinal.isEmpty()) {
				Gson g = new Gson();
				output = g.fromJson(respuestaFinal, Respuesta.class);
			} else {
				output = new Respuesta();
				output.setEntidadOrigen(requestDTO.getEntidadOrigen());
				output.setTipoDeMovimiento(requestDTO.getTipoMovimiento());
				output.setCurpMenorEdad(requestDTO.getCurpMenorEdad());
				RespDatosBaseCurpMenor respDatosBaseCurpMenor = new RespDatosBaseCurpMenor();
				respDatosBaseCurpMenor.setResultadoOperacion("02");
				respDatosBaseCurpMenor.setDiagnosticoRecepcion("999");
				RespDatosDomParticular respDatosDomParticular = new RespDatosDomParticular();
				respDatosDomParticular.setResultadoOperacion("02");
				respDatosDomParticular.setDiagnosticoRecepcion("999");
				output.setDatosBaseCurpMenor(respDatosBaseCurpMenor);
				output.setDatosDomParticular(respDatosDomParticular);
				LOGGER.info("No hay respuesta del servicio Menores...");
			}

 // INICIO ERD LOG MENORES
			try {
				String fileName;
				String serviceName = "Menores";
				fileName = serviceName + "_" + this.getCurrentDate().toString()
						+ ".txt";
				
				String responseJson = "";
				String requestJson  = jsonRequest;
				if (respuestaFinal != null && !respuestaFinal.isEmpty()) {
					responseJson = respuestaFinal;
				}else{
					responseJson="No hay respuesta del servicio Menores...";
				}
				
				File file = crearArchivo(requestJson, responseJson,
						TEMP_PATH_LOG, fileName);

				String folio = requestDTO.getDatosBaseCurpMenor()
						.getFolioSolicitudMenorEdad();
				LOGGER.info(folio);
				ContentEngineLogServiceRequestDTO LogServiceRequestDTO = new ContentEngineLogServiceRequestDTO();
				LogServiceRequestDTO.setFolio(folio);
				LogServiceRequestDTO.setServiceName(serviceName);
				LogServiceRequestDTO.setSubServiceID("N/A");
				LogServiceRequestDTO.setPath(LOG_PATH_ECM);
				LogServiceRequestDTO.setFileName(fileName);
				LogServiceRequestDTO.setFile(file);
				LogServiceRequestDTO.setMimeType("text/plain; charset=UTF-8");
				LOGGER.info(LogServiceRequestDTO.toString());

				EeafoContentEngineLogServiceUploadImpl eeafoContentEngineLogServiceUpload = new EeafoContentEngineLogServiceUploadImpl();
				EeafoContentEngineImpl eeafoContentEngine = new EeafoContentEngineImpl();
				eeafoContentEngine.setUri(CONTENT_ENGINE_URI);
				eeafoContentEngine.setUserName(CONTENT_ENGINE_USER_NAME);
				eeafoContentEngine.setPassword(CONTENT_ENGINE_PASSWORD);
				eeafoContentEngine.setStanza(CONTENT_ENGINE_STANZA);

				eeafoContentEngineLogServiceUpload
						.setEeafoContentEngine(eeafoContentEngine);

				ContentEngineUploadResponseDTO responseDTO = eeafoContentEngineLogServiceUpload
						.createDocument(LogServiceRequestDTO);
				LOGGER.info(responseDTO.toString());
			} catch (Exception e) {
				LOGGER.error("Error al subir los archivos de log a Filenet. "
						+ e.getMessage(), e);
			}
//  FIN ERD LOG MENORES
			// this.outputTrace(output);

			return output;
		} catch (Exception ex) {
			LOGGER.error("Error en el servicio ProcesarMenoresRestConnector", ex);
			throw new RuntimeException(
					"Se genero un error la registrar un expediente Resolucion",
					ex);
		}
	}

	public String getCurrentDate() throws ParseException {
		String pattern = "yyyyMMddHHmmss";
		DateFormat df = new SimpleDateFormat(pattern);
		Date today = Calendar.getInstance().getTime();
		String fechaActual = df.format(today);
		return fechaActual;
	}

	public File crearArchivo(String request, String response, String path,
			String fileName) throws IOException {
		String Log = "REQUEST \n" + request + "\n" + "RESPONSE\n" + response;
		File file = new File(path + fileName);
		FileUtils.writeStringToFile(file, Log);
		return file;
	}

	private SimpleClientHttpRequestFactory clientHttpRequestFactory() {
		SimpleClientHttpRequestFactory simpleClientHttpRequestFactory = new SimpleClientHttpRequestFactory() {
			@Override
			protected void prepareConnection(HttpURLConnection connection,
					String httpMethod) throws IOException {
				// LOGGER.info("connection instanceof HttpsURLConnection: "
				// + (connection instanceof HttpsURLConnection));
				// LOGGER.info("connection instanceof HttpURLConnection: "
				// + (connection instanceof HttpURLConnection));
				if (connection instanceof HttpsURLConnection) {
					LOGGER.info("Entro connection instanceof HttpsURLConnection: true");
					((HttpsURLConnection) connection)
							.setHostnameVerifier(new HostnameVerifier() {
								// @Override
								public boolean verify(String arg0,
										SSLSession arg1) {
									// TODO Auto-generated method stub
									return true;
								}
							});
					((HttpsURLConnection) connection)
							.setSSLSocketFactory(trustSelfSignedSSL()
									.getSocketFactory());
					((HttpsURLConnection) connection)
							.setAllowUserInteraction(true);
				} else {
					LOGGER.info("NO Entro connection instanceof HttpsURLConnection: false");
				}
				super.prepareConnection(connection, httpMethod);
			}
		};
		simpleClientHttpRequestFactory.setReadTimeout(6 * 60 * 1000);
		simpleClientHttpRequestFactory.setConnectTimeout(6 * 60 * 1000);

		return simpleClientHttpRequestFactory;
	}

	public SSLContext trustSelfSignedSSL() {
		try {
			SSLContext ctx = SSLContext.getInstance("TLS");
			X509TrustManager tm = new X509TrustManager() {

				// @Override
				public void checkClientTrusted(X509Certificate[] arg0,
						String arg1) throws CertificateException {
					// TODO Auto-generated method stub

				}

				// @Override
				public void checkServerTrusted(X509Certificate[] arg0,
						String arg1) throws CertificateException {
					// TODO Auto-generated method stub

				}

				public X509Certificate[] getAcceptedIssuers() {
					return null;
				}

			};
			ctx.init(null, new TrustManager[] { tm }, null);
			SSLContext.setDefault(ctx);
			return ctx;
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return null;
	}

	/**
	 * @return the userName
	 */
	public String getUserName() {
		// return StringToHex.getDecodificada(userName);
		return userName;
	}

	/**
	 * @param userName
	 *            the userName to set
	 */
	public void setUserName(String userName) {
		this.userName = userName;
	}

	/**
	 * @return the password
	 */
	public String getPassword() {
		// return StringToHex.getDecodificada(password);
		return password;
	}

	/**
	 * @param password
	 *            the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}
}
