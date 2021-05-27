package kodlamaio.hrms.business.utilities.helper;

import kodlamaio.hrms.core.utilities.results.ErrorResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.entities.concretes.Employer;

public class EmployerCheckHelper {

	public static Result Required(Employer employer) {
		if (employer.getFirst_name().isEmpty() || employer.getLast_name().isEmpty() || employer.getPassword().isEmpty()
				|| employer.getCompany_name().isEmpty() || employer.getCompany_website().isEmpty()
				|| employer.getPhone().isEmpty() || employer.getRepeat_password().isEmpty()) {

			return new ErrorResult("Tüm alanları doldurun.");
		}
		return new SuccessResult();
	}

	public static Result CheckPassword(Employer employer) {
		if (!employer.getRepeat_password().equals(employer.getPassword())) {
			return new ErrorResult("Şifreler uyuşmamaktadır");
		}
		return new SuccessResult();
	}
	
}
