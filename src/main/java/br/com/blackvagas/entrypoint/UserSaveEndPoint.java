package br.com.blackvagas.entrypoint;

import static br.com.blackvagas.entrypoint.mapper.UserEntryPointMapper.from;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.blackvagas.entrypoint.model.UserModel;
import br.com.blackvagas.usecase.UserSaveUseCase;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/api/v1")
public class UserSaveEndPoint {

	private UserSaveUseCase useCase;

	@Autowired
	public UserSaveEndPoint(UserSaveUseCase useCase) {
		this.useCase = useCase;
	}

	@ApiOperation(value = "Save a User")
	@ApiResponses(value = { @ApiResponse(code = 201, message = "Sucess") })
	@PostMapping(path = "/user", consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Void> saveEndPoint(@RequestBody UserModel model) {

		useCase.saveUser(from(model));

		return ResponseEntity.status(HttpStatus.CREATED).build();
	}

}
