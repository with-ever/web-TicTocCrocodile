package kr.whenever.crocodile.service;

import java.util.List;

import kr.whenever.crocodile.domain.Member;
import kr.whenever.crocodile.domain.MemberSearch;

public interface MemberService {
	
	int registerMember(Member member);
	
	Member retrieveMember(String id);

	List<Member> retrieveMemberList();
	
	MemberSearch retrieveMemberListBySearch(MemberSearch search);
	
	int modifyMember(Member member);
	
	int removeMember(String id);
	
	int checkId(String id);

	Member verifyMemberInfo(String id, String password);
	
	int modifyMemberPassword(String id, String password, String newPassword);

	Member verifyKaKaoMemberInfo(String kakaoId);

	int retrieveLastMemberId();
}
