package kr.whenever.crocodile.repo.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import kr.whenever.crocodile.domain.CrocAvailableRegion;

public interface CrocAvailableRegionMapper {
	
	int insertCrocAvailableRegion(CrocAvailableRegion crocAvailableRegion);
	
	CrocAvailableRegion selectCrocAvailableRegion(@Param("memberId") int memberId, @Param("regionId") int regionId);

	List<CrocAvailableRegion> selectCrocAvailableRegionList(int memberId);
	
	int deleteCrocAvailableRegion(@Param("memberId") int memberId, @Param("regionId") int regionId);
	
	int deleteAllCrocAvailableRegion(@Param("memberId") int memberId);
}
