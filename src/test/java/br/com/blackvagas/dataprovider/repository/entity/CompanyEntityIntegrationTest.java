
package br.com.blackvagas.dataprovider.repository.entity;

import static org.junit.Assert.assertEquals;

import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import br.com.blackvagas.dataprovider.repository.CompanyRepository;
import br.com.blackvagas.dataprovider.repository.VacancyRepository;
import br.com.blackvagas.factory.CompanyFactory;
import br.com.blackvagas.factory.VacancyFactory;

@RunWith(SpringRunner.class)
@DataJpaTest
public class CompanyEntityIntegrationTest {

	@Autowired
	private CompanyRepository CompanyRepository;

	@Autowired
	private VacancyRepository repository;

	@Test
	public void testAllFildMapping() {
		// given
		CompanyEntity companyEntity = CompanyFactory.buildFakeEntity();
		companyEntity.setVacancys(null);

		VacancyEntity entity = VacancyFactory.validEntity();

		CompanyEntity companyEntitySave = CompanyRepository.save(companyEntity);
		entity.setCompany(companyEntitySave);

		// when
		VacancyEntity entitySave = repository.save(entity);
		Optional<VacancyEntity> objReturn = repository.findById(entitySave.getId());

		// then
		assertEquals(objReturn.get().getId(), entitySave.getId());
		assertEquals(objReturn.get().getDateLimit(), entitySave.getDateLimit());
		assertEquals(objReturn.get().getDatePublication(), entitySave.getDatePublication());
		assertEquals(objReturn.get().getDescription(), entitySave.getDescription());
		assertEquals(objReturn.get().getNumberCandidats(), entitySave.getNumberCandidats());

	}
}
