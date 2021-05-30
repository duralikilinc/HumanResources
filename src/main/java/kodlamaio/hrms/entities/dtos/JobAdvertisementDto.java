package kodlamaio.hrms.entities.dtos;

import java.math.BigDecimal;
import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class JobAdvertisementDto {

	private int id;

	private int jobPositionId;

	private int employerId;

	private String company_name;

	private String company_website;

	private String city_name;

	private String name;

	private BigDecimal min_salary;

	private BigDecimal max_salary;

	private String description;

	private int personel_number;

	private LocalDate lastDate;

	private boolean isAktive;

}
