package kr.whenever.crocodile.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import kr.whenever.crocodile.domain.BabyInfo;
import kr.whenever.crocodile.domain.BabyInfoSearch;
import kr.whenever.crocodile.repo.BabyInfoRepository;
import kr.whenever.crocodile.service.BabyInfoService;

@Service
@Transactional
public class BabyInfoServiceImpl implements BabyInfoService {
	
	@Autowired
	private BabyInfoRepository babyInfoRepository;

	@Override
	public int registerBabyInfo(BabyInfo babyInfo) {
		return this.babyInfoRepository.registerBabyInfo(babyInfo);
	}

	@Override
	public BabyInfo retrieveBabyInfo(int babyId) {
		return this.babyInfoRepository.retrieveBabyInfo(babyId);
	}

	@Override
	public List<BabyInfo> retrieveBabyInfoList(int memberId) {
		return this.babyInfoRepository.retrieveBabyInfoList(memberId);
	}

	@Override
	public int modifyBabyInfo(BabyInfo babyInfo) {
		BabyInfo previousBabyInfo = this.retrieveBabyInfo(babyInfo.getBabyId());
		previousBabyInfo.setUpdatedBabyInfo(babyInfo);
		return this.babyInfoRepository.modifyBabyInfo(previousBabyInfo);
	}

	@Override
	public int removeBabyInfo(int babyId) {
		BabyInfo babyInfo = this.babyInfoRepository.retrieveBabyInfo(babyId);
		if (babyInfo == null) return 0;
		return this.babyInfoRepository.removeBabyInfo(babyId);
	}

	@Override
	public BabyInfoSearch retrieveBabyInfoListBySearch(BabyInfoSearch search) {
		return this.babyInfoRepository.retrieveBabyInfoListBySearch(search);
	}

}
