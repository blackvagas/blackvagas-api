package br.com.blackvagas.entrypoint;

import static br.com.blackvagas.entrypoint.mapper.CompanyEntryPointMapper.from;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.blackvagas.entrypoint.model.CompanyModel;
import br.com.blackvagas.usecase.CompanySaveUseCase;
import br.com.blackvagas.usecase.entity.Company;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/api/v1")
@Api(value = "Company", tags = { "Company" })
public class CompanySaveEndPoint {

	private CompanySaveUseCase useCase;

	@Autowired
	public CompanySaveEndPoint(CompanySaveUseCase useCase) {
		this.useCase = useCase;
	}

	@ApiOperation(value = "Save a Company", tags = { "Company" })
	@ApiResponses(value = { @ApiResponse(code = 201, message = "Sucess") })
	@PostMapping(path = "/company", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<CompanyModel> saveEndPoint(@RequestBody CompanyModel model) {

		Company core = from(model);
		Company coreSaved = useCase.saveCompany(core);
		CompanyModel modelReturn = from(coreSaved);

		return new ResponseEntity<CompanyModel>(modelReturn, HttpStatus.CREATED);
	}

}
