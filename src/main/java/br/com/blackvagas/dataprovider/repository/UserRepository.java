package br.com.blackvagas.dataprovider.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.blackvagas.dataprovider.repository.entity.UserEntity;

public interface UserRepository extends JpaRepository<UserEntity, Long> {

}
