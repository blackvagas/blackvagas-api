package br.com.blackvagas.dataprovider.repository.entity;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "`TB_VACANCY`")
public class VacancyEntity extends AuditModel {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "vacancy_id")
	private Long id;

	@Column(name = "description", nullable = false)
	private String description;

	@Column(name = "number_candidats", nullable = false)
	private Integer numberCandidats;

	@Column(name = "date_limit", columnDefinition = "TIMESTAMP")
	private LocalDateTime dateLimit;

	@Column(name = "date_publication", columnDefinition = "TIMESTAMP")
	private LocalDateTime datePublication;

	@ManyToOne
	@JoinColumn(name = "company_id", nullable = false)
	private CompanyEntity company;

}
