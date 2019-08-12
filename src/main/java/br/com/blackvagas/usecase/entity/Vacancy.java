package br.com.blackvagas.usecase.entity;

import java.time.LocalDateTime;

import br.com.blackvagas.dataprovider.repository.entity.CompanyEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Vacancy {

	private Long id;

	private String description;

	private Integer numberCandidats;

	private LocalDateTime dateLimit;

	private LocalDateTime datePublication;

	private CompanyEntity company;

}
