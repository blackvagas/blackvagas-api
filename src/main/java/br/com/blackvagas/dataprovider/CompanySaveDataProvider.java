package br.com.blackvagas.dataprovider;

import static br.com.blackvagas.dataprovider.mapper.CompanyDataProviderMapper.from;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Component;

import br.com.blackvagas.Exception.TechnicalException;
import br.com.blackvagas.dataprovider.repository.CompanyRepository;
import br.com.blackvagas.dataprovider.repository.entity.CompanyEntity;
import br.com.blackvagas.gateway.CompanySaveGateway;
import br.com.blackvagas.usecase.entity.Company;
import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class CompanySaveDataProvider implements CompanySaveGateway {

	private CompanyRepository repository;

	@Autowired
	public CompanySaveDataProvider(CompanyRepository repository) {
		this.repository = repository;
	}

	@Override
	public Company saveCompany(Company company) {
		try {

			CompanyEntity entity = from(company);
			CompanyEntity entitySaved = repository.save(entity);
			return from(entitySaved);

		} catch (DataAccessException e) {
			log.error(e.getMessage(), e);
			throw new TechnicalException("Erro ao conectar ao banco de dados");
		}
	}

}
