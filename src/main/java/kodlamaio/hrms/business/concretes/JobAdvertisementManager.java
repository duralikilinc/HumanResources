package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.CityService;
import kodlamaio.hrms.business.abstracts.EmployerService;
import kodlamaio.hrms.business.abstracts.JobAdvertisementService;
import kodlamaio.hrms.business.abstracts.JobPositionService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.EmployerDao;
import kodlamaio.hrms.dataAccess.abstracts.JobAdvertisementDao;
import kodlamaio.hrms.dataAccess.abstracts.JobPositionDao;
import kodlamaio.hrms.entities.concretes.JobAdvertisement;
import kodlamaio.hrms.entities.dtos.JobAdversimentDto;
import lombok.AllArgsConstructor;

import org.springframework.data.domain.Sort;

@Service
@AllArgsConstructor
public class JobAdvertisementManager implements JobAdvertisementService {

	private JobAdvertisementDao jobAdvertisementDao;
	private JobPositionService jobPositionService;
	private EmployerService employerService;
	private CityService cityService;

	@Override
	public DataResult<List<JobAdvertisement>> getByEmployer(int employer_id) {

		return new SuccessDataResult<List<JobAdvertisement>>(
				this.jobAdvertisementDao.getByisAktiveTrueAndEmployer_Id(employer_id), "Data listed.");
	}

	@Override
	public DataResult<List<JobAdvertisement>> getAll() {

		return new SuccessDataResult<List<JobAdvertisement>>(this.jobAdvertisementDao.findAll(), "Data listed.");
	}

	@Override
	public DataResult<List<JobAdvertisement>> getAllActive() {

		return new SuccessDataResult<List<JobAdvertisement>>(this.jobAdvertisementDao.findAllByisAktiveTrue(),
				"Data Listed");
	}

	@Override
	public DataResult<List<JobAdvertisement>> getByIsActiveAndSortedByLastDate() {

		Sort sort = Sort.by(Sort.Direction.DESC, "lastDate");
		return new SuccessDataResult<List<JobAdvertisement>>(this.jobAdvertisementDao.findAllByisAktiveTrue(sort),
				"Tarihe göre aktif ilanlar sıralandı");
	}

	@Override
	public DataResult<List<JobAdvertisement>> getBySortedByLastDate() {

		Sort sort = Sort.by(Sort.Direction.DESC, "lastDate");
		return new SuccessDataResult<List<JobAdvertisement>>(this.jobAdvertisementDao.findAll(sort),
				"Tarihe göre  ilanlar sıralandı");
	}

	@Override
	public Result add(JobAdvertisement jobAdvertisement) {
		this.jobAdvertisementDao.save(jobAdvertisement);

		return new SuccessResult("İş İlanı eklenmiştir");
	}

}
