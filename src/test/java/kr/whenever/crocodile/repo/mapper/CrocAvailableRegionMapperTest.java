package kr.whenever.crocodile.repo.mapper;

import static org.junit.Assert.*;

import java.util.List;

import kr.whenever.crocodile.domain.CrocAvailableRegion;
import kr.whenever.crocodile.domain.common.member.CrocServiceType;
import kr.whenever.crocodile.shared.WheneverDbUnitTest;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.github.springtestdbunit.annotation.DatabaseOperation;
import com.github.springtestdbunit.annotation.DatabaseSetup;
import com.github.springtestdbunit.annotation.DatabaseTearDown;

@DatabaseSetup(value = {"/dataset/CrocAvailableRegion.xml"}, type = DatabaseOperation.INSERT)
@DatabaseTearDown(value = {"/dataset/CrocAvailableRegion.xml"}, type = DatabaseOperation.DELETE_ALL)
public class CrocAvailableRegionMapperTest extends WheneverDbUnitTest{
	
	@Autowired
	private CrocAvailableRegionMapper crocAvailableRegionMapper;

	@Test
	public void testInsertCrocAvailableRegion() {
		CrocAvailableRegion CrocAvailableRegion = new CrocAvailableRegion(2, CrocServiceType.CARE.getCode());
		this.crocAvailableRegionMapper.insertCrocAvailableRegion(CrocAvailableRegion);
		
		CrocAvailableRegion insertedCrocAvailableRegion = this.crocAvailableRegionMapper.selectCrocAvailableRegion(2, CrocServiceType.CARE.getCode());
		assertEquals(CrocAvailableRegion.getMemberId(), insertedCrocAvailableRegion.getMemberId());
		assertEquals(CrocAvailableRegion.getRegionId(), insertedCrocAvailableRegion.getRegionId());
	}

	@Test
	public void testSelectCrocAvailableRegion() {
		CrocAvailableRegion CrocAvailableRegion = this.crocAvailableRegionMapper.selectCrocAvailableRegion(2, CrocServiceType.SCHOOL.getCode());
		assertEquals(CrocAvailableRegion.getMemberId(), 2);
		assertEquals(CrocAvailableRegion.getRegionId(), CrocServiceType.SCHOOL.getCode());
	}

	@Test
	public void testSelecCrocAvailableRegionList() {
		List<CrocAvailableRegion> CrocAvailableRegionList = this.crocAvailableRegionMapper.selectCrocAvailableRegionList(1);
		assertEquals(CrocAvailableRegionList.size(), 3);
	}

	@Test
	public void testDeleteCrocAvailableRegion() {
		this.crocAvailableRegionMapper.deleteCrocAvailableRegion(2, CrocServiceType.SCHOOL.getCode());
		CrocAvailableRegion CrocAvailableRegion = this.crocAvailableRegionMapper.selectCrocAvailableRegion(2, CrocServiceType.SCHOOL.getCode());
		assertNull(CrocAvailableRegion);
	}

}
