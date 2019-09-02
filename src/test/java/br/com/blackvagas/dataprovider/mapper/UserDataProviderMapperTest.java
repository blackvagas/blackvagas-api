package br.com.blackvagas.dataprovider.mapper;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;

import br.com.blackvagas.dataprovider.repository.entity.UserEntity;
import br.com.blackvagas.factory.UserFactory;
import br.com.blackvagas.usecase.entity.User;

public class UserDataProviderMapperTest {

	@Test
	public void testConverterEntityToCore() {
		// given
		UserEntity entity = UserFactory.validEntity();

		// when
		User core = UserDataProviderMapper.from(entity);

		// then
		assertThat(core.getId()).isEqualTo(entity.getId());

	}

	@Test
	public void testConverterCoreToEntity() {
		// given
		User core = UserFactory.validUser();

		// when
		UserEntity entity = UserDataProviderMapper.from(core);

		// then
		assertThat(core.getId()).isEqualTo(entity.getId());

	}

}
