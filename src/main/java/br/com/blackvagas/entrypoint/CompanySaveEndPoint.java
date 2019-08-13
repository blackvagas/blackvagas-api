package br.com.blackvagas.entrypoint;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.blackvagas.entrypoint.mapper.CompanyEntryPointProviderMapper;
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
	private CompanyEntryPointProviderMapper mapper;

	@Autowired
	public CompanySaveEndPoint(CompanySaveUseCase useCase, CompanyEntryPointProviderMapper mapper) {
		this.useCase = useCase;
		this.mapper = mapper;
	}

	@ApiOperation(value = "Save a Company", tags = { "Company" })
	@ApiResponses(value = { @ApiResponse(code = 201, message = "Sucess") })
	@PostMapping(path = "/company", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<CompanyModel> saveEndPoint(@RequestBody CompanyModel model) {

		Company core = mapper.from(model);
		Company coreSaved = useCase.saveCompany(core);
		CompanyModel modelReturn = mapper.from(coreSaved);

		return new ResponseEntity<CompanyModel>(modelReturn, HttpStatus.CREATED);
	}

	@ApiOperation(value = "List all Company", tags = { "Company" })
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Sucess") })
	@GetMapping(path = "/company", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<CompanyModel>> findAllEndPoint() {

		List<Company> listCore = useCase.findAllCompany();
		List<CompanyModel> listModelReturn = mapper.from(listCore);

		return new ResponseEntity<List<CompanyModel>>(listModelReturn, HttpStatus.CREATED);
	}

}
