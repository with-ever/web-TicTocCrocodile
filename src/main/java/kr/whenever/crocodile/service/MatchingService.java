package kr.whenever.crocodile.service;

import java.io.IOException;
import java.util.List;

import kr.whenever.crocodile.domain.Matching;
import kr.whenever.crocodile.domain.MatchingSearch;

public interface MatchingService {
	
	int registerMatching(Matching matching) throws IOException;

	Matching retrieveMatching(int matchId);
	
	List<Matching> retrieveMatchingList();
	
	MatchingSearch retrieveMatchingListBySearch(MatchingSearch search);
	
	int modifyMatching(Matching matching);
	
	int removeMatching(int matchId);

	int cancelMatchingStatusByContractId(int contractId);

	void modifyMatchingStatus(int matchId, int status, int contractId) throws IOException;
	
}
