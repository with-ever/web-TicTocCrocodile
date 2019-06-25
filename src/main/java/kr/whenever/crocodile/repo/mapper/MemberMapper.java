package kr.whenever.crocodile.repo.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import kr.whenever.crocodile.domain.Member;
import kr.whenever.crocodile.domain.MemberSearch;


public interface MemberMapper {

	int insertMember(Member member);

	Member selectMember(String id);
	
	Member selectMemberByMemberId(int memberId);
	
	List<Member> selectMemberList();

	List<Member> selectMemberListBySearch(MemberSearch search);

	int selectMemberListTotalCount(MemberSearch search);

	int updateMember(Member member);

	int deleteMember(String id);
	
	int checkId(String id);

	boolean selectMemberByIdWithPassword(@Param("id") String id, @Param("password") String encodePassword);
	
	int updateMemberPassword(@Param("id") String id, @Param("password") String encodePassword);

	int selectLastMemberId();

}
