package kr.whenever.crocodile.repo.mapper;

import static org.junit.Assert.*;
import kr.whenever.crocodile.domain.SNSInfo;
import kr.whenever.crocodile.domain.common.sns.SNSType;
import kr.whenever.crocodile.shared.WheneverDbUnitTest;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.github.springtestdbunit.annotation.DatabaseOperation;
import com.github.springtestdbunit.annotation.DatabaseSetup;
import com.github.springtestdbunit.annotation.DatabaseTearDown;

@DatabaseSetup(value = {"/dataset/SNSInfo.xml"}, type = DatabaseOperation.INSERT)
@DatabaseTearDown(value = {"/dataset/SNSInfo.xml"}, type = DatabaseOperation.DELETE_ALL)
public class SNSInfoMapperTest extends WheneverDbUnitTest {
	
	@Autowired
	private SNSInfoMapper snsInfoMapper;

	@Test
	public void testInsertSNSInfo() {
		SNSInfo snsInfo = new SNSInfo(4, "123456789", SNSType.KAKAO.getCode());
		this.snsInfoMapper.insertSNSInfo(snsInfo);
		
		SNSInfo insertedSnsInfo = this.snsInfoMapper.selectSNSInfo(4);
		assertEquals(snsInfo.getMemberId(), insertedSnsInfo.getMemberId());
		assertEquals(snsInfo.getSnsId(), insertedSnsInfo.getSnsId());
		assertEquals(snsInfo.getSnsType(), insertedSnsInfo.getSnsType());
		
	}

	@Test
	public void testSelectSNSInfo() {
		SNSInfo snsInfo = this.snsInfoMapper.selectSNSInfo(1);
		assertEquals(snsInfo.getMemberId(), 1);
		assertEquals(snsInfo.getSnsId(), "2393812391");
		assertEquals(snsInfo.getSnsType(), SNSType.KAKAO.getCode());
	}

	@Test
	public void testSelectSNSInfoBySnsId() {
		SNSInfo snsInfo = this.snsInfoMapper.selectSNSInfoBySnsId("2393812391", SNSType.KAKAO.getCode());
		assertEquals(snsInfo.getMemberId(), 1);
		assertEquals(snsInfo.getSnsId(), "2393812391");
		assertEquals(snsInfo.getSnsType(), SNSType.KAKAO.getCode());
	}
	
	@Test
	public void testSelectSNSInfoByMemberId() {
		SNSInfo snsInfo = this.snsInfoMapper.selectSNSInfoByMemberId(1);
		assertEquals(snsInfo.getMemberId(), 1);
		assertEquals(snsInfo.getSnsId(), "2393812391");
		assertEquals(snsInfo.getSnsType(), SNSType.KAKAO.getCode());
	}

	@Test
	public void testDeleteSNSInfo() {
		this.snsInfoMapper.deleteSNSInfo(1);
		SNSInfo snsInfo = this.snsInfoMapper.selectSNSInfo(1);
		assertNull(snsInfo);
	}

}
