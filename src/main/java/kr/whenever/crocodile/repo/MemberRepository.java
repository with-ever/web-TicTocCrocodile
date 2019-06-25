package kr.whenever.crocodile.repo;

import java.util.List;

import kr.whenever.crocodile.domain.CrocMemberInfo;
import kr.whenever.crocodile.domain.Member;
import kr.whenever.crocodile.domain.MemberInfo;
import kr.whenever.crocodile.domain.MemberSearch;
import kr.whenever.crocodile.domain.common.member.MemberType;
import kr.whenever.crocodile.repo.mapper.BabyInfoMapper;
import kr.whenever.crocodile.repo.mapper.CrocAvailableRegionMapper;
import kr.whenever.crocodile.repo.mapper.CrocAvailableServiceMapper;
import kr.whenever.crocodile.repo.mapper.CrocAvailableTimeMapper;
import kr.whenever.crocodile.repo.mapper.CrocMemberInfoMapper;
import kr.whenever.crocodile.repo.mapper.MemberInfoMapper;
import kr.whenever.crocodile.repo.mapper.MemberMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class MemberRepository {

	@Autowired
	private MemberMapper memberMapper;
	
	@Autowired
	private MemberInfoMapper memberInfoMapper;
	
	@Autowired
	private BabyInfoMapper babyInfoMapper;
	
	@Autowired
	private CrocMemberInfoMapper crocMemberInfoMapper;
	
	@Autowired
	private CrocAvailableRegionMapper crocAvailableRegionMapper;
	
	@Autowired
	private CrocAvailableTimeMapper crocAvailableTimeMapper;
	
	@Autowired
	private CrocAvailableServiceMapper crocAvailableServiceMapper;
	
	
	

	public int registerMember(Member member) {
		this.memberMapper.insertMember(member);
		return member.getMemberId();
	}

	public Member retrieveMember(String id) {
		return this.memberMapper.selectMember(id);
	}
	
	public Member retrieveMemberByMemberId(int memberId) {
		return this.memberMapper.selectMemberByMemberId(memberId);
	}

	public List<Member> retrieveMemberList() {
		return this.memberMapper.selectMemberList();
	}

	public MemberSearch retrieveUserListBySearch(MemberSearch search) {
		List<Member> members = this.memberMapper.selectMemberListBySearch(search);
		
		for(Member member : members) {
			if (Integer.toString(member.getType()).equals(MemberType.PARENTS.getCode())) {
				MemberInfo memberInfo = this.memberInfoMapper.selectMemberInfo(member.getMemberId());
				memberInfo.setBabyInfo(this.babyInfoMapper.selectBabyInfoList(member.getMemberId()));
				member.setMemberInfo(memberInfo);
			} else if (Integer.toString(member.getType()).equals(MemberType.CROCODILE.getCode())) {
				// TODO crocinfo
				CrocMemberInfo crocMemberInfo = this.crocMemberInfoMapper.selectCrocMemberInfo(member.getMemberId());
				crocMemberInfo.setCrocAvailableRegions(this.crocAvailableRegionMapper.selectCrocAvailableRegionList(member.getMemberId()));
				crocMemberInfo.setCrocAvailableServices(this.crocAvailableServiceMapper.selectCrocAvailableServiceList(member.getMemberId()));
				crocMemberInfo.setCrocAvailableTimes(this.crocAvailableTimeMapper.selectCrocAvailableTimeList(member.getMemberId()));
				member.setCrocMemberInfo(crocMemberInfo);
			}
		}
		
		search.setResults(members);
		
		if (members.size() != 0) {
			int totalCount = this.memberMapper.selectMemberListTotalCount(search);
			search.setTotalCount(totalCount);
		}
		return search;
	}
	
	

	public int modifyMember(Member member) {
		this.memberMapper.updateMember(member);
		return member.getMemberId(); 
	}


	public int removeMember(String id) {
		return this.memberMapper.deleteMember(id);
	}
	
	public int checkId(String id) {
		return this.memberMapper.checkId(id);
	}

	public boolean verifyMemberInfo(String id, String encodePassword) {
		return this.memberMapper.selectMemberByIdWithPassword(id, encodePassword);
	}
	
	public int modifyMemberPassword(String id, String encodePassword) {
		return this.memberMapper.updateMemberPassword(id, encodePassword);
	}

	public int retrieveLastMemberId() {
		return this.memberMapper.selectLastMemberId();
	}

	
}
