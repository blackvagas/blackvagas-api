
package br.com.blackvagas.dataprovider.repository.entity;

import static br.com.blackvagas.factory.UserFactory.validEntity;
import static org.junit.Assert.assertEquals;

import java.util.Optional;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import br.com.blackvagas.configuration.ConfigurationEntityIntegrationTest;
import br.com.blackvagas.dataprovider.repository.UserRepository;
import br.com.blackvagas.dataprovider.repository.entity.UserEntity;

public class UserEntityIntegrationTest extends ConfigurationEntityIntegrationTest {

	@Autowired
	private UserRepository repository;

	@Test
	public void testAllFildMapping() {
		// given
		UserEntity userSave = validEntity();

		// when
		repository.save(userSave);
		Optional<UserEntity> objReturn = repository.findById(userSave.getId());

		// then
		assertEquals(objReturn.get().getId(), userSave.getId());
	}
}
