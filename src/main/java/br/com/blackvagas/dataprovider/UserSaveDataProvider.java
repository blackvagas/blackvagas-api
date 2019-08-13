package br.com.blackvagas.dataprovider;

import static br.com.blackvagas.dataprovider.mapper.UserDataProviderMapper.from;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Component;

import br.com.blackvagas.Exception.TechnicalException;
import br.com.blackvagas.dataprovider.repository.UserRepository;
import br.com.blackvagas.dataprovider.repository.entity.UserEntity;
import br.com.blackvagas.gateway.UserSaveGateway;
import br.com.blackvagas.usecase.entity.User;
import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class UserSaveDataProvider implements UserSaveGateway {

	private UserRepository repository;

	@Autowired
	public UserSaveDataProvider(UserRepository repository) {
		this.repository = repository;
	}

	@Override
	public User saveUser(User user) {
		try {

			UserEntity entityReturn = repository.save(from(user));
			return from(entityReturn);

		} catch (DataAccessException e) {
			log.error(e.getMessage(), e);
			throw new TechnicalException("Erro ao conectar ao banco de dados");
		}

	}

}
