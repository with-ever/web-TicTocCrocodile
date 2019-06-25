package kr.whenever.crocodile.repo.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import kr.whenever.crocodile.domain.CrocAvailableService;

public interface CrocAvailableServiceMapper {
	
	int insertCrocAvailableService(CrocAvailableService CrocAvailableService);
	
	CrocAvailableService selectCrocAvailableService(@Param("memberId") int memberId, @Param("serviceId") int serviceId);

	List<CrocAvailableService> selectCrocAvailableServiceList(int memberId);
	
	int deleteCrocAvailableService(@Param("memberId") int memberId, @Param("serviceId") int serviceId);

	int deleteAllCrocAvailableService(@Param("memberId") int memberId);
}
