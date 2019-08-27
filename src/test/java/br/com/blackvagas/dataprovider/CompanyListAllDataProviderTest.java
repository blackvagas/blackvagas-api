package br.com.blackvagas.dataprovider;

import static org.junit.Assert.assertFalse;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import br.com.blackvagas.Exception.TechnicalException;
import br.com.blackvagas.dataprovider.repository.CompanyRepository;
import br.com.blackvagas.dataprovider.repository.entity.CompanyEntity;
import br.com.blackvagas.factory.CompanyFactory;
import br.com.blackvagas.usecase.entity.Company;

@RunWith(MockitoJUnitRunner.class)
public class CompanyListAllDataProviderTest {

	@Mock
	private CompanyRepository repository;
	
	private CompanyListAllDataProvider dataProvider;
	
	@Before
	public void setup() {
		dataProvider = new CompanyListAllDataProvider(repository);
	}
	
	@Test
	public void testFindAllCompanyInList() {
		//given
		List<CompanyEntity> listCore = Arrays.asList(CompanyFactory.buildFakeEntity());
		
		//when
		when(repository.findAll()).thenReturn(listCore);
		
		List<Company> listCompany = dataProvider.listAll();
		
		//then
		assertFalse(listCompany.isEmpty());
	}
	
	
	@Test(expected = TechnicalException.class)
	public void comunicateDatabaseException() {
		// given
		when(repository.findAll())
				.thenThrow(new TechnicalException("Erro ao conectar no banco de dados"));

		// when
		dataProvider.listAll();

	}
}
