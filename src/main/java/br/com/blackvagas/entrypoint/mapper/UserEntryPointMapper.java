package br.com.blackvagas.entrypoint.mapper;

import br.com.blackvagas.entrypoint.model.UserModel;
import br.com.blackvagas.usecase.entity.User;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class UserEntryPointMapper {

	public static User from(UserModel model) {
		return User.builder().id(model.getId()).build();
	}
	
}
