package kr.whenever.crocodile.repo.mapper;

import kr.whenever.crocodile.domain.MemberInfo;

public interface MemberInfoMapper {
	
	int insertMemberInfo(MemberInfo memberInfo);

	MemberInfo selectMemberInfo(int memberId);

	int updateMemberInfo(MemberInfo memberInfo);

	int deleteMemberInfo(int memberId);

}
