package br.com.blackvagas.gateway;

import br.com.blackvagas.usecase.entity.Vacancy;

public interface VacancySaveGateway {

	public Vacancy saveVacancy(Vacancy vacancy);

}
