package kr.whenever.crocodile.repo.mapper;

import static org.junit.Assert.*;

import java.util.List;

import kr.whenever.crocodile.domain.BabyInfo;
import kr.whenever.crocodile.domain.common.member.MemberGender;
import kr.whenever.crocodile.shared.WheneverDbUnitTest;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.github.springtestdbunit.annotation.DatabaseOperation;
import com.github.springtestdbunit.annotation.DatabaseSetup;
import com.github.springtestdbunit.annotation.DatabaseTearDown;

@DatabaseSetup(value = {"/dataset/BabyInfo.xml"}, type = DatabaseOperation.INSERT)
@DatabaseTearDown(value = {"/dataset/BabyInfo.xml"}, type = DatabaseOperation.DELETE_ALL)
public class BabyInfoMapperTest extends WheneverDbUnitTest {
	
	@Autowired
	private BabyInfoMapper babyInfoMapper;

	@Test
	public void testInsertBabyInfo() {
		BabyInfo babyInfo = new BabyInfo(3);
		babyInfo.setName("영진킴아기");
		babyInfo.setAge(1);
		babyInfo.setGender(Integer.parseInt(MemberGender.MALE.getCode()));
		babyInfo.setImageUrl("123");
		
		this.babyInfoMapper.insertBabyInfo(babyInfo);
		
		BabyInfo insertedBabyInfo = this.babyInfoMapper.selectBabyInfo(4);
		assertEquals(babyInfo.getName(), insertedBabyInfo.getName());
		assertEquals(babyInfo.getAge(), insertedBabyInfo.getAge());
		assertEquals(babyInfo.getGender(), insertedBabyInfo.getGender());
		assertEquals(babyInfo.getImageUrl(), insertedBabyInfo.getImageUrl());
	}

	@Test
	public void testSelectBabyInfo() {
		BabyInfo babyInfo = this.babyInfoMapper.selectBabyInfo(1);
		assertEquals(1, babyInfo.getBabyId());
		assertEquals(1, babyInfo.getMemberId());
		assertEquals("김아기", babyInfo.getName());
		assertEquals(2, babyInfo.getAge());
		assertEquals("abc", babyInfo.getImageUrl());
		assertEquals(Integer.parseInt(MemberGender.MALE.getCode()), babyInfo.getGender());
	}

	@Test
	public void testSelectBabyInfoList() {
		List<BabyInfo> babyInfoList = this.babyInfoMapper.selectBabyInfoList(1);
		assertEquals(2, babyInfoList.size());
	}

	@Test
	public void testUpdateBabyInfo() {
		BabyInfo babyInfo = this.babyInfoMapper.selectBabyInfo(1);
		babyInfo.setName("123");
		babyInfo.setAge(3);
		babyInfo.setImageUrl("kkk");
		
		this.babyInfoMapper.updateBabyInfo(babyInfo);
		
		BabyInfo updatedBabyInfo = this.babyInfoMapper.selectBabyInfo(1);
		assertEquals(babyInfo.getName(), updatedBabyInfo.getName());
		assertEquals(babyInfo.getAge(), updatedBabyInfo.getAge());
		assertEquals(babyInfo.getImageUrl(), updatedBabyInfo.getImageUrl());
	}

	@Test
	public void testDeleteBabyInfo() {
		this.babyInfoMapper.deleteBabyInfo(1);
		BabyInfo babyInfo = this.babyInfoMapper.selectBabyInfo(1);
		assertNull(babyInfo);
	}

}
