package kodlamaio.hrms.business.utilities.helper;

import kodlamaio.hrms.core.utilities.results.ErrorResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.entities.concretes.JobSeeker;

public class JobSeekerCheckHelper {

	public static Result  Required(JobSeeker jobSeeker) {
		if (jobSeeker.getFirst_name().isEmpty() || jobSeeker.getLast_name().isEmpty() || jobSeeker.getTcNo().isEmpty()
				|| jobSeeker.getPassword().isEmpty() || jobSeeker.getEmail().isEmpty()
				|| jobSeeker.getBirth_year() < 1900) {

			return new ErrorResult("Tüm alanları doldurun.");
		}
		return new SuccessResult();
	}

	public static Result CheckPassword(JobSeeker jobSeeker) {
		if (!jobSeeker.getRepeat_password().equals(jobSeeker.getPassword())) {
			return new ErrorResult("Şifreler uyuşmamaktadır");
		}
		return new SuccessResult();
	}	
	
}
