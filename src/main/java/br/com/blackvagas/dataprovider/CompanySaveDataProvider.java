package br.com.blackvagas.dataprovider;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Component;

import br.com.blackvagas.Exception.TechnicalException;
import br.com.blackvagas.dataprovider.mapper.CompanyDataProviderMapper;
import br.com.blackvagas.dataprovider.repository.CompanyRepository;
import br.com.blackvagas.dataprovider.repository.entity.CompanyEntity;
import br.com.blackvagas.gateway.CompanySaveGateway;
import br.com.blackvagas.usecase.entity.Company;
import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class CompanySaveDataProvider implements CompanySaveGateway {

	private CompanyRepository repository;
	private CompanyDataProviderMapper mapper;

	@Autowired
	public CompanySaveDataProvider(CompanyRepository repository, CompanyDataProviderMapper mapper) {
		this.repository = repository;
		this.mapper = mapper;
	}

	@Override
	public Company saveCompany(Company company) {
		try {

			CompanyEntity entity = mapper.from(company);
			CompanyEntity entitySaved = repository.save(entity);
			return mapper.from(entitySaved);

		} catch (DataAccessException e) {
			log.error(e.getMessage(), e);
			throw new TechnicalException("Erro ao conectar ao banco de dados");
		}
	}

	@Override
	public List<Company> listAll() {
		try {

			List<CompanyEntity> listCompanyEntity = repository.findAll();
			return mapper.from(listCompanyEntity);

		} catch (DataAccessException e) {
			log.error(e.getMessage(), e);
			throw new TechnicalException("Erro ao conectar ao banco de dados");
		}
	}

}
