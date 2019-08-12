package br.com.blackvagas.dataprovider.repository.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import br.com.blackvagas.configuration.AuditModel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Builder
@Data
@EqualsAndHashCode(callSuper = false)
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "`TB_COMPANY`")
public class CompanyEntity extends AuditModel {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "company_id")
	private Long id;

	@Column(name = "name", nullable = false)
	private String name;

	@Column(name = "email", nullable = false)
	private String email;

	@Column
	private String adress;

	@OneToMany(mappedBy = "company")
	private List<VacancyEntity> vacancys;

}
