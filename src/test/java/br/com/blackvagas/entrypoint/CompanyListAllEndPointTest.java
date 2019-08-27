package br.com.blackvagas.entrypoint;

import static br.com.blackvagas.entrypoint.mapper.CompanyEntryPointMapper.from;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import br.com.blackvagas.entrypoint.model.CompanyModel;
import br.com.blackvagas.factory.CompanyFactory;
import br.com.blackvagas.usecase.CompanyListAllUseCase;
import br.com.blackvagas.usecase.entity.Company;

@RunWith(MockitoJUnitRunner.class)
public class CompanyListAllEndPointTest {

	@Mock
	private CompanyListAllUseCase useCase;
	
	private CompanyListAllEndPoint endPoint;
	
	@Before
	public void setup() {
		endPoint = new CompanyListAllEndPoint(useCase);
	}
	
	@Test
	public void testFindAllEndPoint() {
		//given
		Company core = CompanyFactory.buildFakeCore();
		List<Company> listCore = Arrays.asList(core);
		
		when(useCase.findAllCompany()).thenReturn(listCore);
		
		//when
		ResponseEntity<List<CompanyModel>> returnEndPoint = endPoint.findAllEndPoint();

		//then
		assertThat(returnEndPoint.getStatusCode()).isEqualTo(HttpStatus.OK);
		assertThat(returnEndPoint.getBody().contains(from(core))).isTrue();
		
	}
	
}
