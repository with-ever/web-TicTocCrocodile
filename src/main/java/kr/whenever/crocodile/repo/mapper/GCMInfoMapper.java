package kr.whenever.crocodile.repo.mapper;

import java.util.List;

import kr.whenever.crocodile.domain.GCMInfo;

public interface GCMInfoMapper {
	
	int insertGCMInfo(GCMInfo GCMInfo);
	
	GCMInfo selectGCMInfo(int idx);
	
	GCMInfo selectGCMInfoByMemberId(int memberId);
	
	GCMInfo selectGCMInfoByDeviceId(String deviceId);
	
	int deleteGCMInfo(int idx);

	List<GCMInfo> selectGCMInfoByMemberIds(List<Integer> memberIds);

	int updateGCMInfo(GCMInfo gcmInfo);

	int deleteGCMInfoByMemberId(int memberId);

}
