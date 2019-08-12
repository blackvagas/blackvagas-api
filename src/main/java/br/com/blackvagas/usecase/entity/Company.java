package br.com.blackvagas.usecase.entity;

import java.util.List;

import br.com.blackvagas.dataprovider.repository.entity.VacancyEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Company {

	private Long id;

	private String name;

	private String email;

	private String adress;

	private List<VacancyEntity> vacancys;

}
