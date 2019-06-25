package kr.whenever.crocodile.repo.mapper;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import java.util.ArrayList;
import java.util.List;

import kr.whenever.crocodile.domain.GCMInfo;
import kr.whenever.crocodile.shared.WheneverDbUnitTest;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.github.springtestdbunit.annotation.DatabaseOperation;
import com.github.springtestdbunit.annotation.DatabaseSetup;
import com.github.springtestdbunit.annotation.DatabaseTearDown;

@DatabaseSetup(value = {"/dataset/GCMInfo.xml"}, type = DatabaseOperation.INSERT)
@DatabaseTearDown(value = {"/dataset/GCMInfo.xml"}, type = DatabaseOperation.DELETE_ALL)
public class GCMInfoMapperTest extends WheneverDbUnitTest {
	
	@Autowired
	private GCMInfoMapper gcmInfoMapper;

	@Test
	public void testInsertGCMInfo() {
		GCMInfo gcmInfo = new GCMInfo(4, "123456789", "abcdefg");
		this.gcmInfoMapper.insertGCMInfo(gcmInfo);
		
		GCMInfo insertedGcmInfo = this.gcmInfoMapper.selectGCMInfo(4);
		assertEquals(gcmInfo.getMemberId(), insertedGcmInfo.getMemberId());
		assertEquals(gcmInfo.getGcmId(), insertedGcmInfo.getGcmId());
		assertEquals(gcmInfo.getDeviceId(), insertedGcmInfo.getDeviceId());
		
	}

	@Test
	public void testSelectGCMInfo() {
		GCMInfo gcmInfo = this.gcmInfoMapper.selectGCMInfo(1);
		assertEquals(gcmInfo.getMemberId(), 1);
		assertEquals(gcmInfo.getGcmId(), "2393812391");
		assertEquals(gcmInfo.getDeviceId(), "bsdfsadfasd");
	}

	@Test
	public void testSelectGCMInfoByMemberId() {
		GCMInfo gcmInfo = this.gcmInfoMapper.selectGCMInfoByMemberId(2);
		assertEquals(gcmInfo.getMemberId(), 2);
		assertEquals(gcmInfo.getGcmId(), "kfskafskdafasdk");
		assertEquals(gcmInfo.getDeviceId(), "1023123");
	}

	@Test
	public void testDeleteGCMInfo() {
		this.gcmInfoMapper.deleteGCMInfo(3);
		GCMInfo gcmInfo = this.gcmInfoMapper.selectGCMInfo(3);
		assertNull(gcmInfo);
	}
	
	@Test
	public void testSelectGCMInfoByMemberIds() {
		List<Integer> memberIds = new ArrayList<Integer>();
		memberIds.add(1);
		memberIds.add(2);
		memberIds.add(3);
		List<GCMInfo> gcmInfos = this.gcmInfoMapper.selectGCMInfoByMemberIds(memberIds);
		assertEquals(gcmInfos.size(), 3);
	}
	

	@Test
	public void testDeleteGCMInfoByMemberId() {
		this.gcmInfoMapper.deleteGCMInfoByMemberId(3);
		GCMInfo gcmInfo = this.gcmInfoMapper.selectGCMInfoByMemberId(3);
		assertNull(gcmInfo);
	}

}
