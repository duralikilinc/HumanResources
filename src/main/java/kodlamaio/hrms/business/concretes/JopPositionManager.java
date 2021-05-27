package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.JobPositionService;

import kodlamaio.hrms.business.utilities.business.BusinessRules;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.ErrorResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.JobPositionDao;

import kodlamaio.hrms.entities.concretes.JobPosition;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class JopPositionManager implements JobPositionService {

	private JobPositionDao jobPositionDao;

	@Override
	public DataResult<List<JobPosition>> getAll() {

		return new SuccessDataResult<List<JobPosition>>(this.jobPositionDao.findAll(), "Job Position Listed.");
	}

	@Override
	public Result add(JobPosition jobPosition) {
		var result = BusinessRules.Run(isCheckPosition(jobPosition.getName()));
		if (result != null) {
			return new ErrorResult(result.getMessage());
		}

		this.jobPositionDao.save(jobPosition);

		return new SuccessResult("İş Pozisyonu eklendi");
	}

	@Override
	public Result isCheckPosition(String name) {
		var result = this.jobPositionDao.findByName(name);
		if (result != null) {
			return new ErrorResult("Bu İş Pozisyonundan sistemde kayıtlıdır.");
		}
		return new SuccessResult();
	}
}
