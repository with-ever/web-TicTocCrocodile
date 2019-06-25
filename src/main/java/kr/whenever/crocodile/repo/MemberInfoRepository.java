package kr.whenever.crocodile.repo;

import kr.whenever.crocodile.domain.MemberInfo;
import kr.whenever.crocodile.repo.mapper.MemberInfoMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class MemberInfoRepository {
	
	@Autowired
	private MemberInfoMapper memberInfoMapper;

	public int registerMemberInfo(MemberInfo memberInfo) {
		return this.memberInfoMapper.insertMemberInfo(memberInfo);
	}
	
	public MemberInfo retrieveMemberInfo(int memberId) {
		return this.memberInfoMapper.selectMemberInfo(memberId);
	}
	
	public int modifyMemberInfo(MemberInfo memberInfo) {
		return this.memberInfoMapper.updateMemberInfo(memberInfo); 
	}

	public int removeMemberInfo(int memberId) {
		return this.memberInfoMapper.deleteMemberInfo(memberId);
	}


}
