package br.com.blackvagas.dataprovider.mapper;

import org.springframework.stereotype.Component;

import br.com.blackvagas.dataprovider.repository.entity.VacancyEntity;
import br.com.blackvagas.usecase.entity.Vacancy;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;

@Component
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class VacancyDataProviderMapper {

	public static Vacancy from(VacancyEntity entity) {
		return Vacancy.builder()
				.id(entity.getId())
				.company(entity.getCompany())
				.dateLimit(entity.getDateLimit())
				.datePublication(entity.getDatePublication())
				.description(entity.getDescription())
				.numberCandidats(entity.getNumberCandidats())
				.build();
	}
	
	public static VacancyEntity from(Vacancy core) {
		return VacancyEntity.builder()
				.id(core.getId())
				.company(core.getCompany())
				.dateLimit(core.getDateLimit())
				.datePublication(core.getDatePublication())
				.description(core.getDescription())
				.numberCandidats(core.getNumberCandidats())
				.build();
	}
	
}
