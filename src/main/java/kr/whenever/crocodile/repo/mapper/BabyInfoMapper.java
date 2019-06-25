package kr.whenever.crocodile.repo.mapper;

import java.util.List;

import kr.whenever.crocodile.domain.BabyInfo;
import kr.whenever.crocodile.domain.BabyInfoSearch;

public interface BabyInfoMapper {

	int insertBabyInfo(BabyInfo BabyInfo);

	BabyInfo selectBabyInfo(int babyId);
	
	List<BabyInfo> selectBabyInfoList(int memberId);
	
	List<BabyInfo> selectBabyInfoListBySearch(BabyInfoSearch search);
	
	int selectBabyInfoListTotalCount(BabyInfoSearch search);
	
	int updateBabyInfo(BabyInfo BabyInfo);

	int deleteBabyInfo(int babyId);
	
}
