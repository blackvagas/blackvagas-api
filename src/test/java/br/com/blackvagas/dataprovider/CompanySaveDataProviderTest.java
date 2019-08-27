package br.com.blackvagas.dataprovider;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import br.com.blackvagas.Exception.TechnicalException;
import br.com.blackvagas.dataprovider.mapper.CompanyDataProviderMapper;
import br.com.blackvagas.dataprovider.repository.CompanyRepository;
import br.com.blackvagas.dataprovider.repository.entity.CompanyEntity;
import br.com.blackvagas.factory.CompanyFactory;
import br.com.blackvagas.usecase.entity.Company;

@RunWith(MockitoJUnitRunner.class)
public class CompanySaveDataProviderTest {

	@Mock
	private CompanyRepository repository;
	
	@Captor
	private ArgumentCaptor<CompanyEntity> entityCaptor;
	
	private CompanySaveDataProvider dataProvider;
	
	
	@Before
	public void setup() {
		dataProvider = new CompanySaveDataProvider(repository);
	}
	
	@Test
	public void testSaveCompany() {
		//given
		Company core = CompanyFactory.buildFakeCore();
		CompanyEntity entity = CompanyDataProviderMapper.from(core);
		
		when(repository.save(Mockito.any(CompanyEntity.class))).thenReturn(entity);
		
		//when
		Company savedCompany = dataProvider.saveCompany(core);
		
		//then
		verify(repository, times(1)).save(entityCaptor.capture());
		assertThat(savedCompany.getId()).isNotNull();
		assertThat(savedCompany.getEmail()).isEqualTo(entityCaptor.getValue().getEmail());
	
	}
	
	
	@Test(expected = TechnicalException.class)
	public void comunicateDatabaseException() {
		// given
		Company entity = CompanyFactory.buildFakeCore();
		
		when(repository.save(Mockito.any(CompanyEntity.class)))
				.thenThrow(new TechnicalException("Erro ao conectar no banco de dados"));

		// when
		dataProvider.saveCompany(entity);

	}
}
