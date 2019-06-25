package kr.whenever.crocodile.service;

import java.util.List;

import kr.whenever.crocodile.domain.BabyInfo;
import kr.whenever.crocodile.domain.BabyInfoSearch;

public interface BabyInfoService {
	
	int registerBabyInfo(BabyInfo babyInfo);
	
	BabyInfo retrieveBabyInfo(int babyId);
	
	List<BabyInfo> retrieveBabyInfoList(int memberId);

	BabyInfoSearch retrieveBabyInfoListBySearch(BabyInfoSearch search);
	
	int modifyBabyInfo(BabyInfo babyInfo);
	
	int removeBabyInfo(int babyId);
	
}
