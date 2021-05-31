package kodlamaio.hrms.entities.dtos;

import java.math.BigDecimal;
import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class JobAdvertisementRegisterDto {
	

	private int jobPositionId;

	private int employerId;

	private int city_id;

	private String description;

	private BigDecimal min_salary;

	private BigDecimal max_salary;

	private int personel_number;

	private Date lastDate;

	private boolean isAktive;
}