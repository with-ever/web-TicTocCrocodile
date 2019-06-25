package kr.whenever.crocodile.repo;

import java.util.List;

import kr.whenever.crocodile.domain.CrocAvailableTime;
import kr.whenever.crocodile.repo.mapper.CrocAvailableTimeMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class CrocAvailableTimeRepository {

	@Autowired
	private CrocAvailableTimeMapper crocAvailableTimeMapper;

	public int registerCrocAvailableTime(CrocAvailableTime crocAvailableService) {
		return this.crocAvailableTimeMapper.insertCrocAvailableTime(crocAvailableService);
	}

	public List<CrocAvailableTime> retrieveCrocAvailableTimeList(int memberId) {
		return this.crocAvailableTimeMapper.selectCrocAvailableTimeList(memberId);
	}

	public int removeCrocAvailableTime(int memberId, int timeId) {
		return this.crocAvailableTimeMapper.deleteCrocAvailableTime(memberId, timeId);
	}

	public int removeAllCrocAvailableTime(int memberId) {
		return this.crocAvailableTimeMapper.deleteAllCrocAvailableTime(memberId);
	}
}
