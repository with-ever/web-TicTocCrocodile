package kr.whenever.crocodile.repo;

import java.util.List;

import kr.whenever.crocodile.domain.CrocAvailableRegion;
import kr.whenever.crocodile.repo.mapper.CrocAvailableRegionMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class CrocAvailableRegionRepository {

	@Autowired
	private CrocAvailableRegionMapper crocAvailableRegionMapper;

	public int registerCrocAvailableRegion(CrocAvailableRegion CrocAvailableRegion) {
		return this.crocAvailableRegionMapper.insertCrocAvailableRegion(CrocAvailableRegion);
	}

	public CrocAvailableRegion retrieveCrocAvailableRegion(int memberId, int regionId) {
		return this.crocAvailableRegionMapper.selectCrocAvailableRegion(memberId, regionId);
	}

	public List<CrocAvailableRegion> retrieveCrocAvailableRegionList(int memberId) {
		return this.crocAvailableRegionMapper.selectCrocAvailableRegionList(memberId);
	}

	public int removeCrocAvailableRegion(int memberId, int regionId) {
		return this.crocAvailableRegionMapper.deleteCrocAvailableRegion(memberId, regionId);
	}

	public int removeAllCrocAvailableRegion(int memberId) {
		return this.crocAvailableRegionMapper.deleteAllCrocAvailableRegion(memberId);
	}
}
