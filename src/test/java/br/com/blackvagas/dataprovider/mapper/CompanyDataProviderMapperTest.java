package br.com.blackvagas.dataprovider.mapper;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

import br.com.blackvagas.dataprovider.repository.entity.CompanyEntity;
import br.com.blackvagas.factory.CompanyFactory;
import br.com.blackvagas.usecase.entity.Company;

public class CompanyDataProviderMapperTest {

	@Test
	public void testConverterEntityToCore() {
		//given
		CompanyEntity entity = CompanyFactory.buildFakeEntity();
		
		//when
		Company core = CompanyDataProviderMapper.from(entity);
		
		//then
		assertThat(core.getAdress()).isEqualTo(entity.getAdress());
		assertThat(core.getEmail()).isEqualTo(entity.getEmail());
		assertThat(core.getId()).isEqualTo(entity.getId());
		assertThat(core.getName()).isEqualTo(entity.getName());

	}
	
	@Test
	public void testConverterACoreToEntity() {
		//given
		Company core = CompanyFactory.buildFakeCore();
		
		//when
		CompanyEntity entity = CompanyDataProviderMapper.from(core);
		
		//then
		assertThat(core.getAdress()).isEqualTo(entity.getAdress());
		assertThat(core.getEmail()).isEqualTo(entity.getEmail());
		assertThat(core.getId()).isEqualTo(entity.getId());
		assertThat(core.getName()).isEqualTo(entity.getName());

	}
	
	@Test
	public void testConvertListEntityToListCore() {
		//given
		CompanyEntity entity = CompanyFactory.buildFakeEntity();
		List<CompanyEntity> listEntity = Arrays.asList(entity);
		Company core = CompanyDataProviderMapper.from(entity);

		
		
		//when
		List<Company> listCore = CompanyDataProviderMapper.from(listEntity);
		
		//then
		assertThat(listCore).isNotEmpty();
		assertThat(listCore.contains(core)).isTrue();
	}
	
}
