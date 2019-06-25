package kr.whenever.crocodile.repo.mapper;

import org.apache.ibatis.annotations.Param;

import kr.whenever.crocodile.domain.SNSInfo;

public interface SNSInfoMapper {
	
	int insertSNSInfo(SNSInfo snsInfo);
	
	SNSInfo selectSNSInfo(int idx);
	
	SNSInfo selectSNSInfoBySnsId(@Param("snsId")String snsId, @Param("snsType")int snsType);
	
	int deleteSNSInfo(int idx);

	SNSInfo selectSNSInfoByMemberId(int memberId);

}
