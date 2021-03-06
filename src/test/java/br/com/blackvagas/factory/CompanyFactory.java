package br.com.blackvagas.factory;

import static io.github.benas.randombeans.api.EnhancedRandom.random;

import br.com.blackvagas.dataprovider.repository.entity.CompanyEntity;
import br.com.blackvagas.entrypoint.model.CompanyModel;
import br.com.blackvagas.usecase.entity.Company;

public class CompanyFactory {

	public static CompanyEntity buildFakeEntity() {
		return random(CompanyEntity.class);
	}

	public static Company buildFakeCore() {
		return random(Company.class);
	}

	public static CompanyModel buildFakeModel() {
		return random(CompanyModel.class);
	}
}
