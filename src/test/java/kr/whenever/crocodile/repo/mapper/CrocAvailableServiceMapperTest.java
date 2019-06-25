package kr.whenever.crocodile.repo.mapper;

import static org.junit.Assert.*;

import java.util.List;

import kr.whenever.crocodile.domain.CrocAvailableService;
import kr.whenever.crocodile.domain.common.member.CrocServiceType;
import kr.whenever.crocodile.shared.WheneverDbUnitTest;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.github.springtestdbunit.annotation.DatabaseOperation;
import com.github.springtestdbunit.annotation.DatabaseSetup;
import com.github.springtestdbunit.annotation.DatabaseTearDown;

@DatabaseSetup(value = {"/dataset/CrocAvailableService.xml"}, type = DatabaseOperation.INSERT)
@DatabaseTearDown(value = {"/dataset/CrocAvailableService.xml"}, type = DatabaseOperation.DELETE_ALL)
public class CrocAvailableServiceMapperTest extends WheneverDbUnitTest {

	@Autowired
	private CrocAvailableServiceMapper crocAvailableServiceMapper;
	
	@Test
	public void testInsertCrocAvailableService() {
		CrocAvailableService crocAvailableService = new CrocAvailableService(2, CrocServiceType.CARE.getCode());
		this.crocAvailableServiceMapper.insertCrocAvailableService(crocAvailableService);
		
		CrocAvailableService insertedCrocAvailableService = this.crocAvailableServiceMapper.selectCrocAvailableService(2, CrocServiceType.CARE.getCode());
		assertEquals(crocAvailableService.getMemberId(), insertedCrocAvailableService.getMemberId());
		assertEquals(crocAvailableService.getServiceId(), insertedCrocAvailableService.getServiceId());
		
	}

	@Test
	public void testSelectCrocAvailableService() {
		CrocAvailableService crocAvailableService = this.crocAvailableServiceMapper.selectCrocAvailableService(2, CrocServiceType.SCHOOL.getCode());
		assertEquals(crocAvailableService.getMemberId(), 2);
		assertEquals(crocAvailableService.getServiceId(), CrocServiceType.SCHOOL.getCode());
	}

	@Test
	public void testSelecCrocAvailableServiceList() {
		List<CrocAvailableService> crocAvailableServiceList = this.crocAvailableServiceMapper.selectCrocAvailableServiceList(1);
		assertEquals(crocAvailableServiceList.size(), 3);
	}

	@Test
	public void testDeleteCrocAvailableService() {
		this.crocAvailableServiceMapper.deleteCrocAvailableService(2, CrocServiceType.SCHOOL.getCode());
		CrocAvailableService crocAvailableService = this.crocAvailableServiceMapper.selectCrocAvailableService(2, CrocServiceType.SCHOOL.getCode());
		assertNull(crocAvailableService);
	}

}
