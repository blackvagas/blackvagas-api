package br.com.blackvagas.usecase;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.blackvagas.gateway.CompanyListAllGateway;
import br.com.blackvagas.usecase.entity.Company;

@Component
public class CompanyListAllUseCase {

	private CompanyListAllGateway listAllGateway;

	@Autowired
	public CompanyListAllUseCase(CompanyListAllGateway listAllGateway) {
		this.listAllGateway = listAllGateway;
	}

	public List<Company> findAllCompany() {
		return listAllGateway.listAll();
	}

}
