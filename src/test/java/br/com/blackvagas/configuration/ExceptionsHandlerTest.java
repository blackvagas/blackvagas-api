package br.com.blackvagas.configuration;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static org.springframework.http.HttpStatus.SERVICE_UNAVAILABLE;

import org.junit.Test;
import org.springframework.http.ResponseEntity;
import org.springframework.mock.web.MockHttpServletRequest;

import br.com.blackvagas.Exception.TechnicalException;
import br.com.blackvagas.configuration.ExceptionsHandler;
import br.com.blackvagas.configuration.StandardError;

public class ExceptionsHandlerTest {

	ExceptionsHandler handler = new ExceptionsHandler();

	@Test
	public void testingServiceUnavailableHandler() {
		// given
		MockHttpServletRequest request = new MockHttpServletRequest();
		request.addParameter("id", "1");

		// when
		ResponseEntity<StandardError> requestReturn = handler.serviceUnavailable(new TechnicalException("any error"),
				request);

		// then
		assertThat(requestReturn.getStatusCode(), is(SERVICE_UNAVAILABLE));
		assertEquals(requestReturn.getBody().getError(), "Service Unavailable");

	}

}
