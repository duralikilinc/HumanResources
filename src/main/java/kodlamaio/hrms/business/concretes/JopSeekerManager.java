package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.JobSeekerService;
import kodlamaio.hrms.business.abstracts.UserService;
import kodlamaio.hrms.business.utilities.business.BusinessRules;
import kodlamaio.hrms.business.utilities.helper.JobSeekerCheckHelper;
import kodlamaio.hrms.core.abstracts.EmailValidationService;
import kodlamaio.hrms.core.abstracts.MernisValidationService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.ErrorResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.JobSeekerDao;
import kodlamaio.hrms.entities.concretes.JobSeeker;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class JopSeekerManager implements JobSeekerService {

	private JobSeekerDao jobSeekerDao;
	private MernisValidationService mernisValidationService;
	private UserService userService;
	private EmailValidationService emailValidationService;

	@Override
	public DataResult<List<JobSeeker>> getAll() {

		return new SuccessDataResult<List<JobSeeker>>(this.jobSeekerDao.findAll(), "Job Seekers listed.");
	}

	@Override
	public Result add(JobSeeker jobSeeker) {

		var result = BusinessRules.Run(JobSeekerCheckHelper.Required(jobSeeker),
				JobSeekerCheckHelper.CheckPassword(jobSeeker), 
				isCheckTcNo(jobSeeker.getTcNo()),				
				mernisValidationService.validate(jobSeeker),
				userService.isCheckMail(jobSeeker.getEmail()));
		if (result != null) {
			return new ErrorResult(result.getMessage());
		}

		if (this.emailValidationService.isActive(jobSeeker).isSuccess()) {
			this.jobSeekerDao.save(jobSeeker);

			return new SuccessResult(
					"İş Arayan Kullanıcı eklendi. Kaydın tamamlanması için doğrulama kodu gönderildi.");
		} else {
			return new ErrorResult("Doğrulama kodu gönderiminde hata. Kayıt gerçekleşmedi!");
		}

	}

	@Override
	public Result isCheckTcNo(String tcNo) {

		var result = this.jobSeekerDao.findByTcNo(tcNo);
		if (result != null) {
			return new ErrorResult("Bu T.C. No sistemde kayıtlıdır.");
		}
		return new SuccessResult();
	}

}
