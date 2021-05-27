package kodlamaio.hrms.core.adapters;

import org.springframework.stereotype.Service;

import kodlamaio.hrms.core.abstracts.EmailValidationService;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.entities.concretes.User;

@Service
public class EmailValidationAdapter implements EmailValidationService {

	@Override
	public Result isActive(User user) {
		// TODO Auto-generated method stub
		return new SuccessResult(user.getEmail()+" doğrulandı");
	}

}
