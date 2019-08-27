package br.com.blackvagas.dataprovider;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.timeout;
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
import br.com.blackvagas.dataprovider.mapper.VacancyDataProviderMapper;
import br.com.blackvagas.dataprovider.repository.VacancyRepository;
import br.com.blackvagas.dataprovider.repository.entity.VacancyEntity;
import br.com.blackvagas.factory.VacancyFactory;
import br.com.blackvagas.usecase.entity.Vacancy;

@RunWith(MockitoJUnitRunner.class)
public class VacancySaveDataProviderTest {

	@Mock
	private VacancyRepository repository;
	
	@Captor
	private ArgumentCaptor<VacancyEntity> captor;
	
	private VacancySaveDataProvider provider;
	
	@Before
	public void setup() {
		provider = new VacancySaveDataProvider(repository);
	}
		
	    
	@Test
	public void testSaveAVacancy() {
		//given
		VacancyEntity entity = VacancyFactory.validEntity();
		Vacancy core = VacancyDataProviderMapper.from(entity);
		
		when(repository.save(Mockito.any(VacancyEntity.class))).thenReturn(entity);
		
		//when
		Vacancy entitySaved = provider.saveVacancy(core);
		
		//then
		verify(repository, timeout(1)).save(captor.capture());
		assertThat(entitySaved.getCompany().getId()).isEqualTo(captor.getValue().getCompany().getId());
		assertThat(entitySaved.getId()).isNotNull();
	}
	
	@Test(expected = TechnicalException.class)
	public void comunicateDatabaseException() {
		// given
		Vacancy core = VacancyFactory.validCore();

		when(repository.save(Mockito.any(VacancyEntity.class)))
				.thenThrow(new TechnicalException("Erro ao conectar no banco de dados"));

		// when
		provider.saveVacancy(core);

	}
	
}
