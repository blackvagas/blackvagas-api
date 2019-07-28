package br.com.blackvagas.entrypoint;

import static br.com.blackvagas.entrypoint.mapper.UserEntryPointMapper.from;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.fasterxml.jackson.databind.ObjectMapper;

import br.com.blackvagas.configuration.ConfigurationEndPointIntegrationTest;
import br.com.blackvagas.configuration.ExceptionsHandler;
import br.com.blackvagas.entrypoint.UserSaveEndPoint;
import br.com.blackvagas.entrypoint.model.UserModel;
import br.com.blackvagas.factory.UserFactory;
import br.com.blackvagas.usecase.UserSaveUseCase;
import br.com.blackvagas.usecase.entity.User;

public class UserSaveEndPointIntegrationTest extends ConfigurationEndPointIntegrationTest {

	private MockMvc mockMvc;

	@Mock
	private UserSaveUseCase useCase;

	@InjectMocks
	UserSaveEndPoint endPoint;

	@Before
	public void setup() {
		this.mockMvc = MockMvcBuilders.standaloneSetup(endPoint).setControllerAdvice(new ExceptionsHandler()).build();
	}

	@Test
	public void verifyCallUseCase() throws Exception {
		// given
		UserModel user = UserFactory.validModel();
		String json = new ObjectMapper().writeValueAsString(user);

		when(useCase.saveUser(Mockito.any(User.class))).thenReturn(from(user));

		// when
		ResultActions requestReturn = this.mockMvc.perform(
				MockMvcRequestBuilders.post("/api/v1/user").contentType(MediaType.APPLICATION_JSON).content(json));

		// then
		requestReturn.andExpect(MockMvcResultMatchers.status().isCreated());

	}

}
