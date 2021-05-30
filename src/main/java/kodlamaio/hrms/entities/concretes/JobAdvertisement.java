package kodlamaio.hrms.entities.concretes;

import java.math.BigDecimal;
import java.time.LocalDate;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "job_advertisemens")
@Data
@AllArgsConstructor
@NoArgsConstructor
//@JsonIgnoreProperties(ignoreUnknown = true, value ={"hibernateLazyInitializer","handler","employer"})
public class JobAdvertisement {

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

//	@Column(name = "job_positions_id")
//	private int job_positions_id;

	@ManyToOne()
	@JoinColumn(name = "job_position_id")
	private JobPosition jobPosition;

//	@Column(name = "employer_id")
//	private int employer_id;

	@ManyToOne()
	@JoinColumn(name = "employer_id")
	private Employer employer;

//	@Column(name = "city_id")
//	private int city_id;

	@ManyToOne
	@JoinColumn(name = "city_id")
	private City city;

	@Column(name = "min_salary", nullable = true)
	private BigDecimal min_salary;

	@Column(name = "max_salary", nullable = true)
	private BigDecimal max_salary;

	@Column(name = "personel_number")
	private int personel_number;

	@Column(name = "last_date")
	private LocalDate lastDate;

	@Column(name = "is_aktive")
	private boolean isAktive;

}
