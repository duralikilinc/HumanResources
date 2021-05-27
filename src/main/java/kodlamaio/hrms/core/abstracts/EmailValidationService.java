package kodlamaio.hrms.core.abstracts;

import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.User;

public interface EmailValidationService {

	
	Result isActive(User user);
}
