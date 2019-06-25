package kr.whenever.crocodile.service.impl;

import java.io.IOException;
import java.util.List;

import kr.whenever.crocodile.domain.GCMInfo;
import kr.whenever.crocodile.domain.GCMMessage;
import kr.whenever.crocodile.domain.Matching;
import kr.whenever.crocodile.domain.MatchingSearch;
import kr.whenever.crocodile.domain.common.contract.ContractStatus;
import kr.whenever.crocodile.domain.common.matching.MatchingStatus;
import kr.whenever.crocodile.repo.ContractRepository;
import kr.whenever.crocodile.repo.GCMInfoRepository;
import kr.whenever.crocodile.repo.MatchingRepository;
import kr.whenever.crocodile.service.MatchingService;
import kr.whenever.crocodile.util.GCMUtil;
import kr.whenever.crocodile.util.JSONUtil;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MatchingServiceImpl implements MatchingService {
	
	@Autowired
	private MatchingRepository matchingRepository;
	
	@Autowired
	private ContractRepository contractRepository;
	
	@Autowired
	private GCMInfoRepository gcmInfoRepository;
	
	@Override
	public int registerMatching(Matching matching) throws IOException {
		// Business Logic
		// 매칭이 등록되는 시점에 초기 상태 값은 WAITING
		// TODO 학부모가 악어에게 신청한 부분이므로 악어에게 푸시메시지 추가.
		matching.setStatus(MatchingStatus.WAITING.getCode());
		matching.setTimeInfo();
		int matchId = this.matchingRepository.registerMatching(matching);
		this.messageForCroc(matchId, MatchingStatus.WAITING.getCode());
		return matchId;
	}

	@Override
	public Matching retrieveMatching(int matchId) {
		return this.matchingRepository.retrieveMatching(matchId);
	}

	@Override
	public List<Matching> retrieveMatchingList() {
		return this.matchingRepository.retrieveMatchingList();
	}
	
	@Override
	public MatchingSearch retrieveMatchingListBySearch(MatchingSearch search) {
		return this.matchingRepository.retrieveMatchingListBySearch(search);
	}

	@Override
	public int modifyMatching(Matching matching) {
		return this.matchingRepository.modifyMatching(matching);
	}
	
	@Override
	public void modifyMatchingStatus(int matchId, int status, int contractId) throws IOException {
		// Business Logic
		// 1.악어가 수락하면 Contract와 관련된 다른 Matching은 취소 상태가 되어야 한다.
		// 1-1. 악어가 수락시. MatchingStatus.ACCEPT
		// 1-2. 악어 취소 -> 매칭이 완료되었을 경우. MatchingStatus.CANCEL
		// 2. 악어가 거절했을 때. MatchingStatus.REJECT
		// 3. 결제 완료 되었을 때. MatchingStatus.PAYMENT_COMPLETE
		// 4. 서비스 완료 되었을 때. MatchingStatus.SERVICE_COMPLETE , ContractStatus.SERVICE_COMPLETE
		// 5. CMS에서 매칭을 강제로 취소시킬떄. MatchingStatus.CANCEL
		
		// 1
		if (MatchingStatus.ACCEPT.getCode() == status) {
			// TODO PUSH 메세지. 학부모에게 - TEST
			this.acceptMatching(matchId, status, contractId);
			this.messageForParent(matchId, status);
		}
		// 2 
		else if (MatchingStatus.REJECT.getCode() == status) {
			// TODO PUSH 메세지. 학부모에게. - TEST
			this.matchingRepository.modifyMatchingStatus(matchId, status);
			this.messageForParent(matchId, status);
		}
		// 3
		else if (MatchingStatus.PAYMENT_COMPLETE.getCode() == status) {
			// TODO PUSH 메세지. 학부모에게. - TEST
			this.matchingRepository.modifyMatchingStatus(matchId, status);
			this.messageForParent(matchId, status);
		}
		// 4
		else if (MatchingStatus.SERVICE_COMPLETE.getCode() == status) {
			// TODO PUSH 메세지. 학부모에게. - TEST
			this.matchingRepository.modifyMatchingStatus(matchId, status);
			this.contractRepository.modifyContractStatus(contractId, ContractStatus.SERVICE_COMPLETE.getCode());
			this.messageForParent(matchId, status);
		}
		// 5
		else if (MatchingStatus.CANCEL.getCode() == status) {
			this.matchingRepository.modifyMatchingStatus(matchId, status);
			//this.messageForParent(matchId, status);
		}
	}

	private void acceptMatching(int matchId, int status, int contractId) {
		this.cancelMatchingStatusByContractId(contractId);
		this.matchingRepository.modifyMatchingStatus(matchId, status);
		this.contractRepository.modifyContractStatus(contractId, ContractStatus.MATCHING_COMPLETE.getCode());
	}
	

	@Override
	public int removeMatching(int matchId) {
		return this.matchingRepository.removeMatching(matchId);
	}
	
	@Override
	public int cancelMatchingStatusByContractId(int contractId) {
		return this.matchingRepository.modifyMatchingStatusByContractId(contractId, MatchingStatus.CANCEL.getCode());
	}
	

	private void messageForCroc(int matchId, int status) throws IOException {
		Matching retrieveMatching = this.matchingRepository.retrieveMatching(matchId);
		String parentName = retrieveMatching.getContract().getParentMember().getMemberInfo().getName();
		GCMMessage gcmMessage = new GCMMessage(matchId, status);
		gcmMessage.createCrocMessage(parentName);
		GCMInfo gcmInfo = this.gcmInfoRepository.retrieveGCMInfoByMemberId(retrieveMatching.getCrocMember().getMemberId());
		if (gcmInfo != null) GCMUtil.sendMessage("째깍악어", JSONUtil.toJson(gcmMessage), gcmInfo.getGcmId());
	}
	
	private void messageForParent(int matchId, int status) throws IOException {
		Matching retrieveMatching = this.matchingRepository.retrieveMatching(matchId);
		String crocName = retrieveMatching.getCrocMember().getCrocMemberInfo().getName();
		GCMMessage gcmMessage = new GCMMessage(matchId, status);
		gcmMessage.createParentMessage(crocName);
		GCMInfo gcmInfo = this.gcmInfoRepository.retrieveGCMInfoByMemberId(retrieveMatching.getContract().getParentMember().getMemberId());
		if (gcmInfo != null) GCMUtil.sendMessage("째깍악어", JSONUtil.toJson(gcmMessage), gcmInfo.getGcmId());
	}

}
