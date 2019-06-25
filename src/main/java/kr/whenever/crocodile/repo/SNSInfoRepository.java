package kr.whenever.crocodile.repo;

import kr.whenever.crocodile.domain.SNSInfo;
import kr.whenever.crocodile.repo.mapper.SNSInfoMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class SNSInfoRepository {
	
	@Autowired
	private SNSInfoMapper snsInfoMapper;
	
	public int registerSNSInfo(SNSInfo snsInfo) {
		this.snsInfoMapper.insertSNSInfo(snsInfo);
		return snsInfo.getIdx();
	}

	public SNSInfo retrieveSNSInfo(int index) {
		return this.snsInfoMapper.selectSNSInfo(index);
	}
	
	public SNSInfo retrieveSNSInfoBySnsId(String snsId, int snsType) {
		return this.snsInfoMapper.selectSNSInfoBySnsId(snsId, snsType);
	}
	
	public SNSInfo retrieveSNSInfoMemberId(int memberId) {
		return this.snsInfoMapper.selectSNSInfoByMemberId(memberId);
	}
	
	public int removeSNSInfo(int index) {
		return this.snsInfoMapper.deleteSNSInfo(index);
	}

}
