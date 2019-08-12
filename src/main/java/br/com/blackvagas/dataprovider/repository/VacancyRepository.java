package br.com.blackvagas.dataprovider.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.blackvagas.dataprovider.repository.entity.VacancyEntity;

public interface VacancyRepository extends JpaRepository<VacancyEntity, Long> {

}
