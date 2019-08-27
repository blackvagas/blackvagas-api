package br.com.blackvagas.dataprovider.mapper;

import java.util.List;
import java.util.stream.Collectors;

import br.com.blackvagas.dataprovider.repository.entity.CompanyEntity;
import br.com.blackvagas.usecase.entity.Company;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class CompanyDataProviderMapper {

	public static Company from(CompanyEntity entity) {
		return Company.builder().id(entity.getId()).adress(entity.getAdress()).email(entity.getEmail())
				.name(entity.getName()).build();
	}

	public static CompanyEntity from(Company core) {
		return CompanyEntity.builder().id(core.getId()).adress(core.getAdress()).email(core.getEmail())
				.name(core.getName()).build();
	}

	public static List<Company> from(List<CompanyEntity> listEntity) {
		return listEntity.stream().map(CompanyDataProviderMapper::from).collect(Collectors.toList());
	}

}
