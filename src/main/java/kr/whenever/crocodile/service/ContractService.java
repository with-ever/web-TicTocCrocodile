package kr.whenever.crocodile.service;

import java.util.List;

import kr.whenever.crocodile.domain.Contract;
import kr.whenever.crocodile.domain.ContractSearch;

public interface ContractService {
	
	int registerContract(Contract contract);

	Contract retrieveContract(int contractId);
	
	List<Contract> retrieveContractList();
	
	ContractSearch retrieveContractListBySearch(ContractSearch search);
	
	int modifyContract(Contract contract);
	
	int removeContract(int contractId);
	
}
