package kr.whenever.crocodile.repo.mapper;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.util.List;

import kr.whenever.crocodile.domain.Member;
import kr.whenever.crocodile.domain.MemberSearch;
import kr.whenever.crocodile.domain.common.member.MemberType;
import kr.whenever.crocodile.shared.WheneverDbUnitTest;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.github.springtestdbunit.annotation.DatabaseOperation;
import com.github.springtestdbunit.annotation.DatabaseSetup;
import com.github.springtestdbunit.annotation.DatabaseTearDown;

@DatabaseSetup(value = {"/dataset/Member.xml", "/dataset/MemberInfo.xml"}, type = DatabaseOperation.INSERT)
@DatabaseTearDown(value = {"/dataset/Member.xml", "/dataset/MemberInfo.xml"}, type = DatabaseOperation.DELETE_ALL)
public class MemberMapperTest extends WheneverDbUnitTest{

	@Autowired
	private MemberMapper memberMapper;
	
	@Test
	public void testInsertMember() {
		Member member = new Member("yjkim2", 0, "1234");
		this.memberMapper.insertMember(member);
		
		Member insertedMember = this.memberMapper.selectMember("yjkim2");
		assertEquals(member.getId(), insertedMember.getId());
		assertEquals(member.getPassword(), insertedMember.getPassword());
		assertEquals(member.getType(), insertedMember.getType());
	}

	@Test
	public void testSelectMember() {
		Member member = this.memberMapper.selectMember("yjkim");
		assertEquals("yjkim", member.getId());
		assertEquals("123", member.getPassword());
		assertEquals(1, member.getType());
	}

	@Test
	public void testSelectMemberList() {
		List<Member> memberList = this.memberMapper.selectMemberList();
		assertEquals(3, memberList.size());
		
	}

	@Test
	public void testSelectMemberListBySearch() {
		MemberSearch search = new MemberSearch();
		search.setType(Integer.parseInt(MemberType.PARENTS.getCode()));
		search.setName("영진");
		List<Member> memberList = this.memberMapper.selectMemberListBySearch(search);
		assertEquals(1, memberList.size());
	}

	@Test
	public void testSelectMemberListTotalCount() {
		MemberSearch search = new MemberSearch();
		search.setType(Integer.parseInt(MemberType.PARENTS.getCode()));
		search.setName("영진");
		int totalCount = this.memberMapper.selectMemberListTotalCount(search);
		assertEquals(1, totalCount);
	}

	@Test
	public void testUpdateMember() {
		Member member = this.memberMapper.selectMember("yjkim");
		member.setUpdateTime(System.currentTimeMillis() / 1000);
		this.memberMapper.updateMember(member);
		
		Member updatedMember = this.memberMapper.selectMember("yjkim");
		assertEquals(updatedMember.getId(), member.getId());
	}

	@Test
	public void testRemoveMember() {
		this.memberMapper.deleteMember("yjkim");
		Member selectMember = this.memberMapper.selectMember("yjkim");
		assertNull(selectMember);
	}
	
	@Test
	public void testSelectMemberByIdWithPassword() {
		boolean isMembered = this.memberMapper.selectMemberByIdWithPassword("yjkim", "123");
		assertTrue(isMembered);
	}
	
	@Test
	public void testUpdateMemberPassword() {
		this.memberMapper.updateMemberPassword("yjkim", "1234");
		
		Member member = this.memberMapper.selectMember("yjkim");
		assertEquals(member.getPassword(), "1234");
	}
	
	@Test
	public void testSelectLastMemberId() {
		assertEquals(4, this.memberMapper.selectLastMemberId());
	}

}
