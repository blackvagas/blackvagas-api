package br.com.blackvagas.usecase.entity;

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

}
