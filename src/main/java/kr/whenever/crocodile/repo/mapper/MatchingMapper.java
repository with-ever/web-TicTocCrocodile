package kr.whenever.crocodile.repo.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import kr.whenever.crocodile.domain.Matching;
import kr.whenever.crocodile.domain.MatchingSearch;


public interface MatchingMapper {

	int insertMatching(Matching matching);

	Matching selectMatching(int matchId);

	List<Matching> selectMatchingList();

	List<Matching> selectMatchingListBySearch(MatchingSearch search);
	
	int selectMatchingListTotalCount(MatchingSearch search);
	
	int updateMatching(Matching matching);
	
	int updateMatchingStatus(@Param("matchId") int matchId, @Param("status") int status);

	int deleteMatching(int matchId);

	int updateMatchingStatusByContractId(@Param("contractId") int contractId, @Param("status") int status);
	
}
