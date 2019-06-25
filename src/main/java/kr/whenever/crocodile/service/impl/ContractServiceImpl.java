package kr.whenever.crocodile.service.impl;

import java.util.List;

import kr.whenever.crocodile.domain.Contract;
import kr.whenever.crocodile.domain.ContractSearch;
import kr.whenever.crocodile.domain.common.contract.ContractStatus;
import kr.whenever.crocodile.service.ContractService;
import kr.whenever.crocodile.repo.ContractRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ContractServiceImpl implements ContractService {
	
	@Autowired
	private ContractRepository contractRepository;
	
	@Override
	public int registerContract(Contract contract) {		
		contract.setStatus(ContractStatus.REQUEST.getCode());
		contract.setTimeInfo();
		return this.contractRepository.registerContract(contract);
	}

	@Override
	public Contract retrieveContract(int contractId) {
		return this.contractRepository.retrieveContract(contractId);
	}

	@Override
	public List<Contract> retrieveContractList() {
		return this.contractRepository.retrieveContractList();
	}
	
	@Override
	public ContractSearch retrieveContractListBySearch(ContractSearch search) {
		return this.contractRepository.retrieveContractListBySearch(search);
	}

	@Override
	public int modifyContract(Contract contract) {
		return this.contractRepository.modifyContract(contract);
	}

	@Override
	public int removeContract(int contractId) {
		return this.contractRepository.removeContract(contractId);
	}

}
