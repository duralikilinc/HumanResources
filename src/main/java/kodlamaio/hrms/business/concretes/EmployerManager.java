package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.EmployerService;
import kodlamaio.hrms.business.abstracts.UserService;
import kodlamaio.hrms.business.utilities.business.BusinessRules;
import kodlamaio.hrms.business.utilities.helper.EmployerCheckHelper;
import kodlamaio.hrms.core.abstracts.EmailValidationService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.ErrorResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.EmployerDao;
import kodlamaio.hrms.entities.concretes.Employer;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class EmployerManager implements EmployerService {

	private EmployerDao employerDao;
	private UserService userService;
	private EmailValidationService emailValidationService;

	@Override
	public DataResult<List<Employer>> getAll() {

		return new SuccessDataResult<List<Employer>>(this.employerDao.findAll(), "Employers listed");
	}

	@Override
	public Result add(Employer employer) {

		var result = BusinessRules.Run(EmployerCheckHelper.Required(employer),
				EmployerCheckHelper.CheckPassword(employer), CheckDomainMail(employer),
				userService.isCheckMail(employer.getEmail()));
		if (result != null) {
			return new ErrorResult(result.getMessage());
		}

		if (this.emailValidationService.isActive(employer).isSuccess()) {
			this.employerDao.save(employer);

			return new SuccessResult("İş Veren Kullanıcı eklendi. Kaydın tamamlanması için doğrulama kodu gönderildi.Yöneticiler için onay kaydı oluşturuldu. ");
		} else {
			return new ErrorResult("Doğrulama kodu gönderiminde hata. Kayıt gerçekleşmedi!");
		}

	}

	public Result CheckDomainMail(Employer employer) {

		if (!employer.getEmail().contains("@" + employer.getEmail().substring(employer.getEmail().indexOf("@") + 1))) {
			return new ErrorResult("Aynı domaine sahip mail adresi kullanılmalıdır");
		}
		return new SuccessResult();
	}

}
