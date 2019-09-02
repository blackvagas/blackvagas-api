
package br.com.blackvagas.dataprovider.repository.entity;

import static org.junit.Assert.assertEquals;

import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import br.com.blackvagas.dataprovider.repository.CompanyRepository;
import br.com.blackvagas.factory.CompanyFactory;

@RunWith(SpringRunner.class)
@DataJpaTest
public class VacancyEntityIntegrationTest {

	@Autowired
	private CompanyRepository repository;

	@Test
	public void testAllFildMapping() {
		// given
		CompanyEntity entity = CompanyFactory.buildFakeEntity();
		entity.setVacancys(null);

		// when
		CompanyEntity entitySave = repository.save(entity);
		Optional<CompanyEntity> objReturn = repository.findById(entitySave.getId());

		// then
		assertEquals(objReturn.get().getId(), entitySave.getId());
		assertEquals(objReturn.get().getAdress(), entitySave.getAdress());
		assertEquals(objReturn.get().getName(), entitySave.getName());
		assertEquals(objReturn.get().getEmail(), entitySave.getEmail());
	}
}
