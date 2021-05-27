package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.UserService;
import kodlamaio.hrms.core.utilities.results.ErrorResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.UserDao;
import kodlamaio.hrms.entities.concretes.User;


@Service
public class UserManager implements UserService {

	private UserDao userDao;

	
	@Autowired
	public UserManager(UserDao userDao) {
		super();
		this.userDao = userDao;
	}


	@Override
	public List<User> getAll() {
		
		return this.userDao.findAll();
	}


	@Override
	public Result isCheckMail(String mail) {
	 User result=this.userDao.findByEmail(mail);
		if (result!=null) {
			return new ErrorResult("Bu mail adresi sistemde kayıtlıdır.");
		}
		return  new SuccessResult();
	}


	
}
