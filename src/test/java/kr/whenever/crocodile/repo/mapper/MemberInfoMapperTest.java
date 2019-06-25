package kr.whenever.crocodile.repo.mapper;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import kr.whenever.crocodile.domain.MemberInfo;
import kr.whenever.crocodile.domain.common.member.MemberGender;
import kr.whenever.crocodile.shared.WheneverDbUnitTest;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.github.springtestdbunit.annotation.DatabaseOperation;
import com.github.springtestdbunit.annotation.DatabaseSetup;
import com.github.springtestdbunit.annotation.DatabaseTearDown;

@DatabaseSetup(value = {"/dataset/MemberInfo.xml"}, type = DatabaseOperation.INSERT)
@DatabaseTearDown(value = {"/dataset/MemberInfo.xml"}, type = DatabaseOperation.DELETE_ALL)
public class MemberInfoMapperTest extends WheneverDbUnitTest {

	@Autowired
	private MemberInfoMapper memberInfoMapper;
	
	@Test
	public void testInsertMemberInfo() {
		MemberInfo memberInfo = new MemberInfo(4);
		memberInfo.setName("yjkim");
		memberInfo.setGender(Integer.parseInt(MemberGender.MALE.getCode()));
		memberInfo.setTel("0107229000");
		memberInfo.setAddr("우리집강아지우리집입니다.");
		memberInfo.setImageUrl("111");
		
		this.memberInfoMapper.insertMemberInfo(memberInfo);
		
		MemberInfo insertedMemberInfo = this.memberInfoMapper.selectMemberInfo(4);
		assertEquals(memberInfo.getName(), insertedMemberInfo.getName());
		assertEquals(memberInfo.getGender(), insertedMemberInfo.getGender());
		assertEquals(memberInfo.getTel(), insertedMemberInfo.getTel());
		assertEquals(memberInfo.getAddr(), insertedMemberInfo.getAddr());
		assertEquals(memberInfo.getImageUrl(), insertedMemberInfo.getImageUrl());
		
	}

	@Test
	public void testSelectMemberInfo() {
		MemberInfo memberInfo = this.memberInfoMapper.selectMemberInfo(1);
		assertEquals(memberInfo.getMemberId(), 1);
		assertEquals(memberInfo.getName(), "김영진");
		assertEquals(memberInfo.getGender(), Integer.parseInt(MemberGender.MALE.getCode()));
		assertEquals(memberInfo.getTel(), "01012345678");
		assertEquals(memberInfo.getAddr(), "우리집1");
		assertEquals(memberInfo.getImageUrl(), "abc");
	}

	@Test
	public void testUpdateMemberInfo() {
		MemberInfo memberInfo = this.memberInfoMapper.selectMemberInfo(1);
		memberInfo.setName("김영진2");
		memberInfo.setGender(Integer.parseInt(MemberGender.FEMALE.getCode()));
		memberInfo.setTel("1234");
		memberInfo.setAddr("우리집2");
		memberInfo.setImageUrl("1111");
		this.memberInfoMapper.updateMemberInfo(memberInfo);
		
		MemberInfo updatedMemberInfo = this.memberInfoMapper.selectMemberInfo(1);
		assertEquals(memberInfo.getName(), updatedMemberInfo.getName());
		assertEquals(memberInfo.getGender(), updatedMemberInfo.getGender());
		assertEquals(memberInfo.getTel(), updatedMemberInfo.getTel());
		assertEquals(memberInfo.getAddr(), updatedMemberInfo.getAddr());
		assertEquals(memberInfo.getImageUrl(), updatedMemberInfo.getImageUrl());
	}

	@Test
	public void testDeleteMemberInfo() {
		this.memberInfoMapper.deleteMemberInfo(1);
		MemberInfo selectMemberInfo = this.memberInfoMapper.selectMemberInfo(1);
		assertNull(selectMemberInfo);
	}

}
