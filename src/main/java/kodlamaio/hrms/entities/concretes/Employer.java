package kodlamaio.hrms.entities.concretes;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "employers")
@Entity
@EqualsAndHashCode(callSuper = false)
@PrimaryKeyJoinColumn(name = "employer_id", referencedColumnName = "id")
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler", "jobAdvert" })

public class Employer extends User {

//	@Id
//	@Column(name="id")
//	@GeneratedValue(strategy = GenerationType.IDENTITY)
//	private int id;

	@Column(name = "company_name")
	private String company_name;

	@Column(name = "company_website")
	private String company_website;

	@Column(name = "first_name")
	private String first_name;

	@Column(name = "last_name")
	private String last_name;

	@Column(name = "phone")
	private String phone;

	@Column(name = "system_verify")
	private boolean system_verify;

	@OneToMany(mappedBy = "employer")
	private List<JobAdvertisement> jobAdvert;
}
