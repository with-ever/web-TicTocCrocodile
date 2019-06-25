package kr.whenever.crocodile.repo;

import java.util.List;

import kr.whenever.crocodile.domain.Contract;
import kr.whenever.crocodile.domain.ContractSearch;
import kr.whenever.crocodile.repo.mapper.BabyInfoMapper;
import kr.whenever.crocodile.repo.mapper.ContractMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class ContractRepository {
	
	@Autowired
	private ContractMapper contractMapper;
	
	@Autowired
	private BabyInfoMapper babyInfoMapper;
	
	
	public int registerContract(Contract contract) {
		this.contractMapper.insertContract(contract);
		return contract.getContractId();
	}
	
	public Contract retrieveContract(int contractId) {
		return this.contractMapper.selectContract(contractId);
	}
	
	public List<Contract> retrieveContractList() {
		return this.contractMapper.selectContractList();
	}
	
	public ContractSearch retrieveContractListBySearch(ContractSearch search) {
		List<Contract> contracts = this.contractMapper.selectContractListBySearch(search);
//		for(Contract contract : contracts) {
//			contract.setBabyInfo(this.babyInfoMapper.selectBabyInfo(contract.getBabyId()));
//		}
		search.setResults(contracts);
		
		if (contracts.size() != 0) {
			int totalCount = this.contractMapper.selectContractListTotalCount(search);
			search.setTotalCount(totalCount);
		}
		return search;
	}
	
	public int modifyContract(Contract contract) {
		return this.contractMapper.updateContract(contract); 
	}

	public int removeContract(int contractId) {
		return this.contractMapper.deleteContract(contractId);
	}

	public int modifyContractStatus(int contractId,
			int status) {
		return this.contractMapper.updateContractStatus(contractId, status);
	}


}
