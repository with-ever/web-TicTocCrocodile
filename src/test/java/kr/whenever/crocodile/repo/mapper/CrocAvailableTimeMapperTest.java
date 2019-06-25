package kr.whenever.crocodile.repo.mapper;

import static org.junit.Assert.assertEquals;

import java.util.List;

import kr.whenever.crocodile.domain.CrocAvailableTime;
import kr.whenever.crocodile.domain.common.member.CrocDayOfWeek;
import kr.whenever.crocodile.shared.WheneverDbUnitTest;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.github.springtestdbunit.annotation.DatabaseOperation;
import com.github.springtestdbunit.annotation.DatabaseSetup;
import com.github.springtestdbunit.annotation.DatabaseTearDown;

@DatabaseSetup(value = {"/dataset/CrocAvailableTime.xml"}, type = DatabaseOperation.INSERT)
@DatabaseTearDown(value = {"/dataset/CrocAvailableTime.xml"}, type = DatabaseOperation.DELETE_ALL)
public class CrocAvailableTimeMapperTest extends WheneverDbUnitTest{
	
	@Autowired
	private CrocAvailableTimeMapper crocAvailableTimeMapper;

	@Test
	public void testInsertCrocAvailableTime() {
		CrocAvailableTime crocAvailableTime = new CrocAvailableTime(2);
		crocAvailableTime.setDay(CrocDayOfWeek.MONDAY.getCode());
		crocAvailableTime.setStartTime(20);
		crocAvailableTime.setEndTime(22);
		
		this.crocAvailableTimeMapper.insertCrocAvailableTime(crocAvailableTime);
		
		List<CrocAvailableTime> crocAvailableTimeList = this.crocAvailableTimeMapper.selectCrocAvailableTimeList(2);
		assertEquals(crocAvailableTimeList.size(), 2);
		
	}

	@Test
	public void testSelecCrocAvailableTimeList() {
		List<CrocAvailableTime> crocAvailableTimeList = this.crocAvailableTimeMapper.selectCrocAvailableTimeList(1);
		assertEquals(crocAvailableTimeList.size(), 3);
	}

	@Test
	public void testDeleteCrocAvailableTime() {
		this.crocAvailableTimeMapper.deleteCrocAvailableTime(2, 4);
		List<CrocAvailableTime> crocAvailableTimeList = this.crocAvailableTimeMapper.selectCrocAvailableTimeList(2);
		assertEquals(crocAvailableTimeList.size(), 0);
	}

}
