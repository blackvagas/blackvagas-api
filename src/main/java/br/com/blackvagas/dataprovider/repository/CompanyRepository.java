package br.com.blackvagas.dataprovider.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.blackvagas.dataprovider.repository.entity.CompanyEntity;

public interface CompanyRepository extends JpaRepository<CompanyEntity, Long> {

}
