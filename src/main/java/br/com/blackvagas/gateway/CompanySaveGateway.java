package br.com.blackvagas.gateway;

import java.util.List;

import br.com.blackvagas.usecase.entity.Company;

public interface CompanySaveGateway {

	public Company saveCompany(Company company);

	public List<Company> listAll();

}
