package kr.whenever.crocodile.repo;

import java.util.List;

import kr.whenever.crocodile.domain.CrocAvailableService;
import kr.whenever.crocodile.repo.mapper.CrocAvailableServiceMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class CrocAvailableServiceRepository {

	@Autowired
	private CrocAvailableServiceMapper crocAvailableServiceMapper;

	public int registerCrocAvailableService(CrocAvailableService crocAvailableService) {
		return this.crocAvailableServiceMapper.insertCrocAvailableService(crocAvailableService);
	}

	public CrocAvailableService retrieveCrocAvailableService(int memberId, int serviceId) {
		return this.crocAvailableServiceMapper.selectCrocAvailableService(memberId, serviceId);
	}

	public List<CrocAvailableService> retrieveCrocAvailableServiceList(int memberId) {
		return this.crocAvailableServiceMapper.selectCrocAvailableServiceList(memberId);
	}

	public int removeCrocAvailableService(int memberId, int serviceId) {
		return this.crocAvailableServiceMapper.deleteCrocAvailableService(memberId, serviceId);
	}

	public int removeAllCrocAvailableService(int memberId) {
		return this.crocAvailableServiceMapper.deleteAllCrocAvailableService(memberId);
	}
}
