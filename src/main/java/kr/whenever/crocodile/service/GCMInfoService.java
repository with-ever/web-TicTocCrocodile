package kr.whenever.crocodile.service;

import kr.whenever.crocodile.domain.GCMInfo;

public interface GCMInfoService {
	
	int registerGCMInfo(GCMInfo gcmInfo);
	
	GCMInfo retrieveGCMInfo(int index);
	
	GCMInfo retrieveGCMInfoByMemberId(int memberId);
	
	int removeGCMInfo(int index);

	int removeGCMInfoByMemberId(int memberId);
	
}
