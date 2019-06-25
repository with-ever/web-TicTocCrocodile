package kr.whenever.crocodile.repo;

import kr.whenever.crocodile.domain.CrocMemberInfo;
import kr.whenever.crocodile.repo.mapper.CrocMemberInfoMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class CrocMemberInfoRepository {
	
	@Autowired
	private CrocMemberInfoMapper crocMemberInfoMapper;

	public int registerCrocMemberInfo(CrocMemberInfo crocMemberInfo) {
		return this.crocMemberInfoMapper.insertCrocMemberInfo(crocMemberInfo);
	}
	
	public CrocMemberInfo retrieveCrocMemberInfo(int crocMemberId) {
		return this.crocMemberInfoMapper.selectCrocMemberInfo(crocMemberId);
	}
	
	public int modifyCrocMemberInfo(CrocMemberInfo crocMemberInfo) {
		return this.crocMemberInfoMapper.updateCrocMemberInfo(crocMemberInfo); 
	}

	public int removeCrocMemberInfo(int crocMemberId) {
		return this.crocMemberInfoMapper.deleteCrocMemberInfo(crocMemberId);
	}


}
