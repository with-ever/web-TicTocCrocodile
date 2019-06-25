package kr.whenever.crocodile.repo;

import java.util.List;

import kr.whenever.crocodile.domain.BabyInfo;
import kr.whenever.crocodile.domain.BabyInfoSearch;
import kr.whenever.crocodile.repo.mapper.BabyInfoMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class BabyInfoRepository {
	
	@Autowired
	private BabyInfoMapper babyInfoMapper;

	public int registerBabyInfo(BabyInfo babyInfo) {
		this.babyInfoMapper.insertBabyInfo(babyInfo);
		return babyInfo.getBabyId();
	}
	
	public BabyInfo retrieveBabyInfo(int babyId) {
		return this.babyInfoMapper.selectBabyInfo(babyId);
	}
	
	public List<BabyInfo> retrieveBabyInfoList(int memberId) {
		return this.babyInfoMapper.selectBabyInfoList(memberId);
	}
	
	public BabyInfoSearch retrieveBabyInfoListBySearch(BabyInfoSearch search) {
		List<BabyInfo> babyInfos = this.babyInfoMapper.selectBabyInfoListBySearch(search);
		search.setResults(babyInfos);
		
		if (babyInfos.size() != 0) {
			int totalCount = this.babyInfoMapper.selectBabyInfoListTotalCount(search);
			search.setTotalCount(totalCount);
		}
		return search;
	}
	
	public int modifyBabyInfo(BabyInfo babyInfo) {
		this.babyInfoMapper.updateBabyInfo(babyInfo);
		return babyInfo.getBabyId();
	}
	
	public int removeBabyInfo(int babyId) {
		return this.babyInfoMapper.deleteBabyInfo(babyId);
	}

}
