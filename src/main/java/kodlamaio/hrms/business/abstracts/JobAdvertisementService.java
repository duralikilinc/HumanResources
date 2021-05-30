package kodlamaio.hrms.business.abstracts;

import java.util.List;



import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.JobAdvertisement;
import kodlamaio.hrms.entities.dtos.JobAdversimentDto;

public interface JobAdvertisementService {

	DataResult<List<JobAdvertisement>> getAll();

	DataResult<List<JobAdvertisement>> getAllActive();	
	
	DataResult<List<JobAdvertisement>> getByEmployer(int employer_id);
	
	DataResult<List<JobAdvertisement>> getByIsActiveAndSortedByLastDate();

	DataResult<List<JobAdvertisement>> getBySortedByLastDate();
	
	Result add(JobAdvertisement jobAdvertisement);
	
	
}
