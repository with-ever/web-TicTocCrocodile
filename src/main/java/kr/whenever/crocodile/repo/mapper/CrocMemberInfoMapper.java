package kr.whenever.crocodile.repo.mapper;

import kr.whenever.crocodile.domain.CrocMemberInfo;

public interface CrocMemberInfoMapper {
	
	int insertCrocMemberInfo(CrocMemberInfo crocMemberInfo);

	CrocMemberInfo selectCrocMemberInfo(int crocMemberId);

	int updateCrocMemberInfo(CrocMemberInfo crocMemberInfo);

	int deleteCrocMemberInfo(int crocMemberId);

}
