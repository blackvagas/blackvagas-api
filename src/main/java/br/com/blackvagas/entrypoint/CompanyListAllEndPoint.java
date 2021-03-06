package br.com.blackvagas.entrypoint;

import static br.com.blackvagas.entrypoint.mapper.CompanyEntryPointMapper.from;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.blackvagas.entrypoint.model.CompanyModel;
import br.com.blackvagas.usecase.CompanyListAllUseCase;
import br.com.blackvagas.usecase.entity.Company;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/api/v1")
@Api(value = "Company", tags = { "Company" })
public class CompanyListAllEndPoint {

	private CompanyListAllUseCase useCase;

	@Autowired
	public CompanyListAllEndPoint(CompanyListAllUseCase useCase) {
		this.useCase = useCase;
	}

	@ApiOperation(value = "List all Company", tags = { "Company" })
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Sucess") })
	@GetMapping(path = "/company", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<CompanyModel>> findAllEndPoint() {

		List<Company> listCore = useCase.findAllCompany();
		List<CompanyModel> listModelReturn = from(listCore);

		return new ResponseEntity<List<CompanyModel>>(listModelReturn, HttpStatus.OK);
	}

}
