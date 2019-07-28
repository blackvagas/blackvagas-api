package br.com.blackvagas.dataprovider.mapper;

import br.com.blackvagas.dataprovider.repository.entity.UserEntity;
import br.com.blackvagas.usecase.entity.User;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class UserDataProviderMapper {

	public static User from(UserEntity entity) {
		return User.builder().id(entity.getId()).build();
	}
	
	public static UserEntity from(User core) {
		return UserEntity.builder().id(core.getId()).build();
	}
	
}
