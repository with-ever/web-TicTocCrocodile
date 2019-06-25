package kr.whenever.crocodile.repo;

import java.util.List;

import kr.whenever.crocodile.domain.Matching;
import kr.whenever.crocodile.domain.MatchingSearch;
import kr.whenever.crocodile.repo.mapper.MatchingMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class MatchingRepository {
	
	@Autowired
	private MatchingMapper matchingMapper;

	public int registerMatching(Matching matching) {
		this.matchingMapper.insertMatching(matching);
		return matching.getMatchId();
	}
	
	public Matching retrieveMatching(int matchId) {
		return this.matchingMapper.selectMatching(matchId);
	}
	
	public List<Matching> retrieveMatchingList() {
		return this.matchingMapper.selectMatchingList();
	}
	
	public MatchingSearch retrieveMatchingListBySearch(MatchingSearch search) {
		List<Matching> matchings = this.matchingMapper.selectMatchingListBySearch(search);
		search.setResults(matchings);
		
		if (matchings.size() != 0) {
			int totalCount = this.matchingMapper.selectMatchingListTotalCount(search);
			search.setTotalCount(totalCount);
		}
		return search;
	}
	
	public int modifyMatching(Matching matching) {
		return this.matchingMapper.updateMatching(matching); 
	}
	
	public int modifyMatchingStatus(int matchId, int status) {
		return this.matchingMapper.updateMatchingStatus(matchId, status); 
	}

	public int removeMatching(int matchId) {
		return this.matchingMapper.deleteMatching(matchId);
	}

	public int modifyMatchingStatusByContractId(int contractId,
			int status) {
		return this.matchingMapper.updateMatchingStatusByContractId(contractId, status);
	}


}
