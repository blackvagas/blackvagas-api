package br.com.blackvagas.entrypoint.mapper;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import br.com.blackvagas.entrypoint.model.CompanyModel;
import br.com.blackvagas.usecase.entity.Company;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;

@Component
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class CompanyEntryPointProviderMapper {

	public Company from(CompanyModel model) {
		return Company.builder()
					  .id(model.getId())
					  .adress(model.getAdress())
					  .email(model.getEmail())
					  .name(model.getName())
					  .build();
	}

	public CompanyModel from(Company core) {
		return CompanyModel.builder()
				  .id(core.getId())
				  .adress(core.getAdress())
				  .email(core.getEmail())
				  .name(core.getName())
				  .build();
	}
	
	public List<CompanyModel> from(List<Company> listCore) {
		return listCore.stream().map(l -> from(l)).collect(Collectors.toList());
	}

}
