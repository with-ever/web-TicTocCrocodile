package kr.whenever.crocodile.service.impl;

import java.util.List;

import kr.whenever.crocodile.domain.CrocAvailableRegion;
import kr.whenever.crocodile.domain.CrocAvailableService;
import kr.whenever.crocodile.domain.CrocAvailableTime;
import kr.whenever.crocodile.domain.CrocMemberInfo;
import kr.whenever.crocodile.domain.Member;
import kr.whenever.crocodile.domain.MemberInfo;
import kr.whenever.crocodile.domain.MemberSearch;
import kr.whenever.crocodile.domain.SNSInfo;
import kr.whenever.crocodile.domain.common.member.MemberType;
import kr.whenever.crocodile.domain.common.sns.SNSType;
import kr.whenever.crocodile.repo.BabyInfoRepository;
import kr.whenever.crocodile.repo.CrocAvailableRegionRepository;
import kr.whenever.crocodile.repo.CrocAvailableServiceRepository;
import kr.whenever.crocodile.repo.CrocAvailableTimeRepository;
import kr.whenever.crocodile.repo.CrocMemberInfoRepository;
import kr.whenever.crocodile.repo.MemberInfoRepository;
import kr.whenever.crocodile.repo.MemberRepository;
import kr.whenever.crocodile.repo.SNSInfoRepository;
import kr.whenever.crocodile.service.MemberService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.encoding.ShaPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class MemberServiceImpl implements MemberService {
	
	@Autowired
	private MemberRepository memberRepository;
	
	@Autowired
	private MemberInfoRepository memberInfoRepository;
	
	@Autowired
	private CrocMemberInfoRepository crocMemberInfoRepository;
	
	@Autowired
	private CrocAvailableRegionRepository crocAvailableRegionRepository;
	
	@Autowired
	private CrocAvailableServiceRepository crocAvailableServiceRepository;
	
	@Autowired
	private CrocAvailableTimeRepository crocAvailableTimeRepository;
	
	@Autowired
	private BabyInfoRepository babyInfoRepository;
	
	@Autowired
	private SNSInfoRepository snsInfoRepository;
	
	@Autowired
    private ShaPasswordEncoder shaPasswordEncoder;
	
	@Override
	public int registerMember(Member member) {
		
		// TODO password 암호화 유틸로 빼기.
		String encodePassword = shaPasswordEncoder.encodePassword(member.getPassword(), member.getId());
		member.setPassword(encodePassword);
		member.setTimeInfo();
		int memberId = this.memberRepository.registerMember(member);
		
		// SNS 정보 등록.
		if (member.getSnsInfo() != null && !member.getSnsInfo().getSnsId().equals(null)) {
			SNSInfo snsInfo = member.getSnsInfo();
			snsInfo.setMemberId(memberId);
			snsInfoRepository.registerSNSInfo(snsInfo);
		}
		
		if (Integer.toString(member.getType()).equals(MemberType.PARENTS.getCode())) {
			member.getMemberInfo().setMemberId(memberId);
			this.memberInfoRepository.registerMemberInfo(member.getMemberInfo());
		} else if (Integer.toString(member.getType()).equals(MemberType.CROCODILE.getCode())) {
			// TODO crocinfo
			member.getCrocMemberInfo().setMemberId(memberId);
			this.crocMemberInfoRepository.registerCrocMemberInfo(member.getCrocMemberInfo());
			List<CrocAvailableRegion> crocAvailableRegions = member.getCrocMemberInfo().getCrocAvailableRegions();
			
			if (crocAvailableRegions != null && crocAvailableRegions.size() > 0) {
				
				for (CrocAvailableRegion crocAvailableRegion : crocAvailableRegions) {
					crocAvailableRegion.setMemberId(memberId);
					this.crocAvailableRegionRepository.registerCrocAvailableRegion(crocAvailableRegion);
				}
			}
			
			List<CrocAvailableService> crocAvailableServices = member.getCrocMemberInfo().getCrocAvailableServices();
			
			if (crocAvailableServices != null && crocAvailableServices.size() > 0) {
				for (CrocAvailableService crocAvailableService : crocAvailableServices) {
					crocAvailableService.setMemberId(memberId);
					this.crocAvailableServiceRepository.registerCrocAvailableService(crocAvailableService);
				}
			}
			List<CrocAvailableTime> crocAvailableTimes = member.getCrocMemberInfo().getCrocAvailableTimes();
			
			if (crocAvailableTimes != null && crocAvailableTimes.size() > 0) {
				for (CrocAvailableTime crocAvailableTime : crocAvailableTimes) {
					crocAvailableTime.setMemberId(memberId);
					this.crocAvailableTimeRepository.registerCrocAvailableTime(crocAvailableTime);
				}
			}
		}
 		return memberId;
	}

	@Override
	public Member retrieveMember(String id) {
		
		Member member = this.memberRepository.retrieveMember(id);
		if (Integer.toString(member.getType()).equals(MemberType.PARENTS.getCode())) {
			MemberInfo memberInfo = this.memberInfoRepository.retrieveMemberInfo(member.getMemberId());
			memberInfo.setBabyInfo(this.babyInfoRepository.retrieveBabyInfoList(member.getMemberId()));
			member.setMemberInfo(memberInfo);
		} else if (Integer.toString(member.getType()).equals(MemberType.CROCODILE.getCode())) {
			// TODO crocinfo
			CrocMemberInfo crocMemberInfo = this.crocMemberInfoRepository.retrieveCrocMemberInfo(member.getMemberId());
			crocMemberInfo.setCrocAvailableRegions(this.crocAvailableRegionRepository.retrieveCrocAvailableRegionList(member.getMemberId()));
			crocMemberInfo.setCrocAvailableServices(this.crocAvailableServiceRepository.retrieveCrocAvailableServiceList(member.getMemberId()));
			crocMemberInfo.setCrocAvailableTimes(this.crocAvailableTimeRepository.retrieveCrocAvailableTimeList(member.getMemberId()));
			member.setCrocMemberInfo(crocMemberInfo);
		}
		
		SNSInfo snsInfo = this.snsInfoRepository.retrieveSNSInfoMemberId(member.getMemberId());
		member.setSnsInfo(snsInfo);
		
		return member;
	}

	@Override
	public List<Member> retrieveMemberList() {
		List<Member> memberList =  this.memberRepository.retrieveMemberList();
		for(Member member : memberList) {
			if (Integer.toString(member.getType()).equals(MemberType.PARENTS.getCode())) {
				MemberInfo memberInfo = this.memberInfoRepository.retrieveMemberInfo(member.getMemberId());
				memberInfo.setBabyInfo(this.babyInfoRepository.retrieveBabyInfoList(member.getMemberId()));
				member.setMemberInfo(memberInfo);
			} else if (Integer.toString(member.getType()).equals(MemberType.CROCODILE.getCode())) {
				// TODO crocinfo
				CrocMemberInfo crocMemberInfo = this.crocMemberInfoRepository.retrieveCrocMemberInfo(member.getMemberId());
				crocMemberInfo.setCrocAvailableRegions(this.crocAvailableRegionRepository.retrieveCrocAvailableRegionList(member.getMemberId()));
				crocMemberInfo.setCrocAvailableServices(this.crocAvailableServiceRepository.retrieveCrocAvailableServiceList(member.getMemberId()));
				crocMemberInfo.setCrocAvailableTimes(this.crocAvailableTimeRepository.retrieveCrocAvailableTimeList(member.getMemberId()));
				member.setCrocMemberInfo(crocMemberInfo);
			}
		}
		return memberList;
	}

	@Override
	public MemberSearch retrieveMemberListBySearch(MemberSearch search) {
		return this.memberRepository.retrieveUserListBySearch(search);
	}

	@Override
	public int modifyMember(Member member) {
		Member previousMember = this.retrieveMember(member.getId());
		previousMember.setUpdatedMember(member);
		if (Integer.toString(previousMember.getType()).equals(MemberType.PARENTS.getCode())) {
			previousMember.getMemberInfo().setUpdatedMemberInfo(member.getMemberInfo());
			this.memberInfoRepository.modifyMemberInfo(previousMember.getMemberInfo());
		} else if (Integer.toString(previousMember.getType()).equals(MemberType.CROCODILE.getCode())) {
			// TODO crocinfo
			previousMember.getCrocMemberInfo().setUpdatedCrocMemberInfo(member.getCrocMemberInfo());
			this.crocMemberInfoRepository.modifyCrocMemberInfo(previousMember.getCrocMemberInfo());
			
			List<CrocAvailableRegion> crocAvailableRegions = member.getCrocMemberInfo().getCrocAvailableRegions();
			if (crocAvailableRegions != null && crocAvailableRegions.size() > 0) {
				this.crocAvailableRegionRepository.removeAllCrocAvailableRegion(previousMember.getMemberId());
				for (CrocAvailableRegion crocAvailableRegion : crocAvailableRegions) {
					crocAvailableRegion.setMemberId(previousMember.getMemberId());
					this.crocAvailableRegionRepository.registerCrocAvailableRegion(crocAvailableRegion);
				}
			}
			
			List<CrocAvailableService> crocAvailableServices = member.getCrocMemberInfo().getCrocAvailableServices();
			if (crocAvailableServices != null && crocAvailableServices.size() > 0) {
				this.crocAvailableServiceRepository.removeAllCrocAvailableService(previousMember.getMemberId());
				for (CrocAvailableService crocAvailableService : crocAvailableServices) {
					crocAvailableService.setMemberId(previousMember.getMemberId());
					this.crocAvailableServiceRepository.registerCrocAvailableService(crocAvailableService);
				}
			}
			List<CrocAvailableTime> crocAvailableTimes = member.getCrocMemberInfo().getCrocAvailableTimes();
			if (crocAvailableTimes != null && crocAvailableTimes.size() > 0) {
				this.crocAvailableTimeRepository.removeAllCrocAvailableTime(previousMember.getMemberId());
				for (CrocAvailableTime crocAvailableTime : crocAvailableTimes) {
					crocAvailableTime.setMemberId(previousMember.getMemberId());
					this.crocAvailableTimeRepository.registerCrocAvailableTime(crocAvailableTime);
				}
			}
		}
		return this.memberRepository.modifyMember(previousMember);
	}

	@Override
	public int removeMember(String id) {
		Member member = this.memberRepository.retrieveMember(id);
		if (member == null) {
			return 0;
		}
		if (Integer.toString(member.getType()).equals(MemberType.PARENTS.getCode())) {
			this.memberInfoRepository.removeMemberInfo(member.getMemberId());
		} else if (Integer.toString(member.getType()).equals(MemberType.CROCODILE.getCode())) {
			this.crocMemberInfoRepository.removeCrocMemberInfo(member.getMemberId());
		}
		return this.memberRepository.removeMember(id);
	}

	@Override
	public int checkId(String id) {
		return this.memberRepository.checkId(id);
	}
	
	@Override
	public Member verifyMemberInfo(String id, String password) {
		String encodePassword = shaPasswordEncoder.encodePassword(password, id);
		boolean isMembered = this.memberRepository.verifyMemberInfo(id, encodePassword);
		if (!isMembered) return null;
		return this.memberRepository.retrieveMember(id);
	}
	
	@Override
	public int modifyMemberPassword(String id, String password, String newPassword) {
		String encodePassword = shaPasswordEncoder.encodePassword(password, id);
		String newEncodePassword = shaPasswordEncoder.encodePassword(newPassword, id);
		boolean isMembered = this.memberRepository.verifyMemberInfo(id, encodePassword);
		if (!isMembered) return 0;
		return this.memberRepository.modifyMemberPassword(id, newEncodePassword);
	}
	
	@Override
	public Member verifyKaKaoMemberInfo(String kakaoId) {
		SNSInfo snsInfo = this.snsInfoRepository.retrieveSNSInfoBySnsId(kakaoId, SNSType.KAKAO.getCode());
		if (snsInfo == null) return null;
		Member member = this.memberRepository.retrieveMemberByMemberId(snsInfo.getMemberId());
		member.setSnsInfo(snsInfo);
		return member;
	}
	
	@Override
	public int retrieveLastMemberId() {
		return this.memberRepository.retrieveLastMemberId();
	}
}
