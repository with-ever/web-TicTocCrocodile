package kr.whenever.crocodile.repo;

import java.util.List;

import kr.whenever.crocodile.domain.GCMInfo;
import kr.whenever.crocodile.repo.mapper.GCMInfoMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class GCMInfoRepository {
	
	@Autowired
	private GCMInfoMapper gcmInfoMapper;
	
	public int registerGCMInfo(GCMInfo GCMInfo) {
		this.gcmInfoMapper.insertGCMInfo(GCMInfo);
		return GCMInfo.getIdx();
	}

	public GCMInfo retrieveGCMInfo(int index) {
		return this.gcmInfoMapper.selectGCMInfo(index);
	}
	
	public GCMInfo retrieveGCMInfoByMemberId(int memberId) {
		return this.gcmInfoMapper.selectGCMInfoByMemberId(memberId);
	}
	
	public GCMInfo retrieveGCMInfoByDeviceId(String deviceId) {
		return this.gcmInfoMapper.selectGCMInfoByDeviceId(deviceId);
	}

	public List<GCMInfo> retrieveGCMInfoByMemberIds(List<Integer> memberIds) {
		return this.gcmInfoMapper.selectGCMInfoByMemberIds(memberIds);
	}
	
	public int modifyGCMInfo(GCMInfo gcmInfo) {
		return this.gcmInfoMapper.updateGCMInfo(gcmInfo);
	}
	
	public int removeGCMInfo(int index) {
		return this.gcmInfoMapper.deleteGCMInfo(index);
	}

	public int removeGCMInfoByMemberId(int memberId) {
		return this.gcmInfoMapper.deleteGCMInfoByMemberId(memberId);
	}

}
