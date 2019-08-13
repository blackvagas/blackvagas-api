package br.com.blackvagas.dataprovider;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Component;

import br.com.blackvagas.Exception.TechnicalException;
import br.com.blackvagas.dataprovider.mapper.VacancyDataProviderMapper;
import br.com.blackvagas.dataprovider.repository.VacancyRepository;
import br.com.blackvagas.dataprovider.repository.entity.VacancyEntity;
import br.com.blackvagas.gateway.VacancySaveGateway;
import br.com.blackvagas.usecase.entity.Vacancy;
import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class VacancySaveDataProvider implements VacancySaveGateway {

	private VacancyRepository repository;
	private VacancyDataProviderMapper mapper;

	@Autowired
	public VacancySaveDataProvider(VacancyRepository repository, VacancyDataProviderMapper mapper) {
		this.repository = repository;
		this.mapper = mapper;
	}

	@Override
	public Vacancy saveVacancy(Vacancy vacancy) {
		try {
			VacancyEntity entity = mapper.from(vacancy);
			VacancyEntity entitySaved = repository.save(entity);
			return mapper.from(entitySaved);
		} catch (DataAccessException e) {
			log.error(e.getMessage(), e);
			throw new TechnicalException("Erro ao conectar ao banco de dados");
		}
	}

}
