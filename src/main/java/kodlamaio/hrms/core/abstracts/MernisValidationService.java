package kodlamaio.hrms.core.abstracts;


import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.JobSeeker;

public interface MernisValidationService {

	Result validate(JobSeeker jobSeeker);
}
