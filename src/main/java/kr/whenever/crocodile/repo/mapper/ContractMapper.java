package kr.whenever.crocodile.repo.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import kr.whenever.crocodile.domain.Contract;
import kr.whenever.crocodile.domain.ContractSearch;


public interface ContractMapper {

	int insertContract(Contract contract);

	Contract selectContract(int contractId);

	List<Contract> selectContractList();
	
	List<Contract> selectContractListBySearch(ContractSearch search);
	
	int selectContractListTotalCount(ContractSearch search);

	int updateContract(Contract contract);

	int deleteContract(int contractId);

	int updateContractStatus(@Param("contractId") int contractId, @Param("status") int status);
	
}
