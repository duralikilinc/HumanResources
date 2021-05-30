package kodlamaio.hrms.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.domain.Sort;
import kodlamaio.hrms.entities.concretes.JobAdvertisement;

public interface JobAdvertisementDao extends JpaRepository<JobAdvertisement, Integer> {

	List<JobAdvertisement> getByisAktiveTrueAndEmployer_Id(int employerId);

	List<JobAdvertisement> findAllByisAktiveTrue();

	List<JobAdvertisement> findAllByisAktiveTrue(Sort sort);
	
	@Query("Update JobAdvertisement Set isActive =: isActive where id =: jobAdvertisementId")
	void updateActivationStatus(boolean isActive, int jobAdvertisementId);
	
	
	
}
