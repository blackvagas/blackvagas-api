package br.com.blackvagas.usecase;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.blackvagas.gateway.CompanySaveGateway;
import br.com.blackvagas.usecase.entity.Company;

@Component
public class CompanySaveUseCase {

	private CompanySaveGateway saveGateway;

	@Autowired
	public CompanySaveUseCase(CompanySaveGateway saveGateway) {
		this.saveGateway = saveGateway;
	}

	public Company saveCompany(Company company) {
		return saveGateway.saveCompany(company);
	}

	public List<Company> findAllCompany() {
		return saveGateway.listAll();
	}

}
