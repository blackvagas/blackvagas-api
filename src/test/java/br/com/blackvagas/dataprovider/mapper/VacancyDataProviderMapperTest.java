package br.com.blackvagas.dataprovider.mapper;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;

import br.com.blackvagas.dataprovider.repository.entity.VacancyEntity;
import br.com.blackvagas.factory.VacancyFactory;
import br.com.blackvagas.usecase.entity.Vacancy;

public class VacancyDataProviderMapperTest {

	@Test
	public void testConvertEntityToCore() {
		//given
		VacancyEntity entity = VacancyFactory.validEntity();
		
		//when
		Vacancy core = VacancyDataProviderMapper.from(entity);
		
		//then
		assertThat(core.getCompany()).isEqualTo(entity.getCompany());
		assertThat(core.getDateLimit()).isEqualTo(entity.getDateLimit());
		assertThat(core.getId()).isEqualTo(entity.getId());
		assertThat(core.getDatePublication()).isEqualTo(entity.getDatePublication());
		assertThat(core.getDescription()).isEqualTo(entity.getDescription());
		assertThat(core.getNumberCandidats()).isEqualTo(entity.getNumberCandidats());
	}
	
	@Test
	public void testConvertCoreToEntity() {
		//given
		Vacancy core = VacancyFactory.validCore();
		
		//when
		VacancyEntity entity = VacancyDataProviderMapper.from(core);
		
		//then
		assertThat(core.getCompany()).isEqualTo(entity.getCompany());
		assertThat(core.getDateLimit()).isEqualTo(entity.getDateLimit());
		assertThat(core.getId()).isEqualTo(entity.getId());
		assertThat(core.getDatePublication()).isEqualTo(entity.getDatePublication());
		assertThat(core.getDescription()).isEqualTo(entity.getDescription());
		assertThat(core.getNumberCandidats()).isEqualTo(entity.getNumberCandidats());
	}
	
}
