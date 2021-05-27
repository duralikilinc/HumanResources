package kodlamaio.hrms.core.adapters;

import org.springframework.stereotype.Service;

import kodlamaio.hrms.core.abstracts.MernisValidationService;
import kodlamaio.hrms.core.utilities.results.ErrorResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.entities.concretes.JobSeeker;
import tr.gov.nvi.tckimlik.WS.KPSPublicSoap;
import tr.gov.nvi.tckimlik.WS.KPSPublicSoapProxy;

@Service
public class MernisServiceAdapter implements MernisValidationService {

	@Override
	public Result validate(JobSeeker jobSeeker) {

//		KPSPublicSoap soapClient = new KPSPublicSoapProxy();
//
//		boolean result = false;
//
//		try {
//
//			result = soapClient.TCKimlikNoDogrula(Long.parseLong(jobSeeker.getTcNo()), jobSeeker.getFirst_name(),
//					jobSeeker.getLast_name(), jobSeeker.getBirth_year());
//			if (result) {
//				return new SuccessResult();
//			}
//			
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		return new ErrorResult("Kimlik doğrulanamadı");
		
		return new SuccessResult();
	}

}
