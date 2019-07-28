package br.com.blackvagas.usecase;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.blackvagas.gateway.UserSaveGateway;
import br.com.blackvagas.usecase.entity.User;

@Component
public class UserSaveUseCase {

	private UserSaveGateway saveGateway;
	
	@Autowired
	public UserSaveUseCase(UserSaveGateway saveGateway) {
		this.saveGateway = saveGateway;
	}
	
	public User saveUser(User user) {
		return saveGateway.saveUser(user);
	}
	
}
