package kodlamaio.hrms.business.concretes;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.JobAdvertisementService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.JobAdvertisementDao;

import kodlamaio.hrms.entities.concretes.JobAdvertisement;
import kodlamaio.hrms.entities.dtos.JobAdvertisementDto;
import kodlamaio.hrms.entities.dtos.JobAdvertisementRegisterDto;
import lombok.AllArgsConstructor;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.data.domain.Sort;

@Service
@AllArgsConstructor
public class JobAdvertisementManager implements JobAdvertisementService {

	private JobAdvertisementDao jobAdvertisementDao;
	// private org.modelmapper.ModelMapper modelMapper;

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
	public Result add(JobAdvertisementRegisterDto jobAdvertisement) {

		JobAdvertisement advertisement = convertToJobAdvertisementRegisterDto(jobAdvertisement);
		this.jobAdvertisementDao.saveAndFlush(advertisement);

		return new SuccessResult("İş ilanı eklendi");

	}

	@Override
	public DataResult<List<JobAdvertisementDto>> getAllJobAdvertisement() {
		return new SuccessDataResult<List<JobAdvertisementDto>>(
				((List<JobAdvertisement>) this.jobAdvertisementDao.findAll()).stream()
						.map(this::convertToJobAdvertisementDTO).collect(Collectors.toList()),
				"Data listed.");
	}

	@Override
	public DataResult<List<JobAdvertisementDto>> findByLastDateBetween(Date startDate, Date finishDate) {

		return new SuccessDataResult<List<JobAdvertisementDto>>(
				((List<JobAdvertisement>) this.jobAdvertisementDao.findByLastDateBetween(startDate, finishDate))
						.stream().map(this::convertToJobAdvertisementDTO).collect(Collectors.toList()),
				"Tarihe göre listelendi");
	}

	@Override
	public Result changeStatus(boolean isActive, int jobAdvertisementId) {

		var jobAdvertisement = this.jobAdvertisementDao.getById(jobAdvertisementId);
		jobAdvertisement.setAktive(isActive);
		this.jobAdvertisementDao.save(jobAdvertisement);

		return (isActive == true ? new SuccessResult("job advertisement has been activated")
				: new SuccessResult("job advertisement has been deactivated"));
	}

	private JobAdvertisementDto convertToJobAdvertisementDTO(JobAdvertisement advertisement) {

		org.modelmapper.ModelMapper modelMapper = new ModelMapper();
		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.LOOSE);
		JobAdvertisementDto jobAdversimentDto = modelMapper.map(advertisement, JobAdvertisementDto.class);
		return jobAdversimentDto;
	}

	private JobAdvertisement convertToJobAdvertisementRegisterDto(
			JobAdvertisementRegisterDto advertisementRegisterDto) {
		org.modelmapper.ModelMapper modelMapper = new ModelMapper();
		return modelMapper.map(advertisementRegisterDto, JobAdvertisement.class);

	}

}
