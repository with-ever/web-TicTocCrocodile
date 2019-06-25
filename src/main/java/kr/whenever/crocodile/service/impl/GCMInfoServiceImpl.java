package kr.whenever.crocodile.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import kr.whenever.crocodile.domain.GCMInfo;
import kr.whenever.crocodile.repo.GCMInfoRepository;
import kr.whenever.crocodile.service.GCMInfoService;

@Service
@Transactional
public class GCMInfoServiceImpl implements GCMInfoService {
	
	@Autowired
	private GCMInfoRepository gcmInfoRepository;

	@Override
	public int registerGCMInfo(GCMInfo gcmInfo) {
		GCMInfo isExistedGCMInfo = this.gcmInfoRepository.retrieveGCMInfoByMemberId(gcmInfo.getMemberId());
		if (isExistedGCMInfo == null) return this.gcmInfoRepository.registerGCMInfo(gcmInfo);
		isExistedGCMInfo.setGcmId(gcmInfo.getGcmId());
		isExistedGCMInfo.setDeviceId(gcmInfo.getDeviceId());
		this.gcmInfoRepository.modifyGCMInfo(isExistedGCMInfo);
		return isExistedGCMInfo.getIdx();
	}

	@Override
	public GCMInfo retrieveGCMInfo(int index) {
		return this.gcmInfoRepository.retrieveGCMInfo(index);
	}

	@Override
	public GCMInfo retrieveGCMInfoByMemberId(int memberId) {
		return this.gcmInfoRepository.retrieveGCMInfoByMemberId(memberId);
	}

	@Override
	public int removeGCMInfo(int index) {
		return this.gcmInfoRepository.removeGCMInfo(index);
	}
	
	@Override
	public int removeGCMInfoByMemberId(int memberId) {
		return this.gcmInfoRepository.removeGCMInfoByMemberId(memberId);
	}

}
