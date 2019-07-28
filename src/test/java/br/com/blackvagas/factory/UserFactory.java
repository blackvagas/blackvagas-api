package br.com.blackvagas.factory;

import static io.github.benas.randombeans.api.EnhancedRandom.random;

import br.com.blackvagas.dataprovider.repository.entity.UserEntity;
import br.com.blackvagas.entrypoint.model.UserModel;
import br.com.blackvagas.usecase.entity.User;

public class UserFactory {

	public static UserEntity validEntity() {
		return random(UserEntity.class);
	}

	public static User validUser() {
		return random(User.class);
	}

	public static UserModel validModel() {
		return random(UserModel.class);
	}

}
