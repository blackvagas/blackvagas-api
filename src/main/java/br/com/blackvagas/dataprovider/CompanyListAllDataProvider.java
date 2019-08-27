package br.com.blackvagas.dataprovider;

import static br.com.blackvagas.dataprovider.mapper.CompanyDataProviderMapper.from;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Component;

import br.com.blackvagas.Exception.TechnicalException;
import br.com.blackvagas.dataprovider.repository.CompanyRepository;
import br.com.blackvagas.dataprovider.repository.entity.CompanyEntity;
import br.com.blackvagas.gateway.CompanyListAllGateway;
import br.com.blackvagas.usecase.entity.Company;
import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class CompanyListAllDataProvider implements CompanyListAllGateway {

	private CompanyRepository repository;

	@Autowired
	public CompanyListAllDataProvider(CompanyRepository repository) {
		this.repository = repository;
	}

	@Override
	public List<Company> listAll() {
		try {

			List<CompanyEntity> listCompanyEntity = repository.findAll();
			return from(listCompanyEntity);

		} catch (DataAccessException e) {
			log.error(e.getMessage(), e);
			throw new TechnicalException("Erro ao conectar ao banco de dados");
		}
	}

}
