package br.com.blackvagas.factory;

import static io.github.benas.randombeans.api.EnhancedRandom.random;

import br.com.blackvagas.dataprovider.repository.entity.VacancyEntity;
import br.com.blackvagas.usecase.entity.Vacancy;

public class VacancyFactory {

	public static VacancyEntity validEntity() {
		return random(VacancyEntity.class);
	}

	public static Vacancy validCore() {
		return random(Vacancy.class);
	}

}
