package kodlamaio.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms.business.abstracts.JobAdvertisementService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.JobAdvertisement;
import kodlamaio.hrms.entities.dtos.JobAdvertisementDto;
import kodlamaio.hrms.entities.dtos.JobAdvertisementRegisterDto;

@RestController
@RequestMapping("/api/jobadvertisements")
public class JobAdvertisementsController {

	@Autowired
	private JobAdvertisementService jobAdvertisementService;

	public JobAdvertisementsController(JobAdvertisementService jobAdvertisementService) {
		super();
		this.jobAdvertisementService = jobAdvertisementService;
	}

	@GetMapping("/getall")
	public DataResult<List<JobAdvertisementDto>> getAll() {

		return this.jobAdvertisementService.getAllJobAdvertisement();
	}

	@GetMapping("/getbyemployers")
	public DataResult<List<JobAdvertisement>> getByEmployer(@RequestParam int employerId) {
		return this.jobAdvertisementService.getByEmployer(employerId);

	}

	@GetMapping("/getisactivedescbydate")
	public DataResult<List<JobAdvertisement>> getByIsActiveAndSortedByLastDate() {
		return this.jobAdvertisementService.getByIsActiveAndSortedByLastDate();
	}

	@GetMapping("/getalldescbydate")
	public DataResult<List<JobAdvertisement>> getBySortedByLastDate() {
		return this.jobAdvertisementService.getBySortedByLastDate();
	}

	@PostMapping("/add")
	public Result add(@RequestBody JobAdvertisementRegisterDto advertisement) {
		
		return this.jobAdvertisementService.add(advertisement);
	}
}
