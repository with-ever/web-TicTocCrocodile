package kr.whenever.crocodile.repo.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import kr.whenever.crocodile.domain.CrocAvailableTime;

public interface CrocAvailableTimeMapper {
	
	int insertCrocAvailableTime(CrocAvailableTime CrocAvailableTime);

	List<CrocAvailableTime> selectCrocAvailableTimeList(int memberId);
	
	int deleteCrocAvailableTime(@Param("memberId") int memberId, @Param("timeId") int timeId);

	int deleteAllCrocAvailableTime(@Param("memberId") int memberId);
}
