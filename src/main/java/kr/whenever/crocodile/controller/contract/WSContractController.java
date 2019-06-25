package kr.whenever.crocodile.controller.contract;

import java.util.HashMap;
import java.util.Map;

import kr.whenever.crocodile.domain.Contract;
import kr.whenever.crocodile.domain.ContractSearch;
import kr.whenever.crocodile.service.ContractService;
import kr.whenever.crocodile.util.JSONUtil;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(value = "/api/v1/contracts")
public class WSContractController {
	
	@Autowired
	private ContractService contractService;

	/**
	 * 계약서 목록 조회.
	 * ../ws/contracts?pageNo=1 -> 1페이지 요청.
	 * @param search
	 * @return
	 */
	@RequestMapping(method = RequestMethod.GET)
	@ResponseBody
	public ContractSearch getContractListBySearch(
			ContractSearch search
			) {
		ContractSearch contractListBySearch = contractService.retrieveContractListBySearch(search);
		return contractListBySearch;
	}
	
	/**
	 * 계약서 조회.
	 * @param contractId
	 * @return
	 */
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	@ResponseBody
	public Contract getContract(
			@PathVariable(value = "id") int contractId
			) {
		Contract contract = this.contractService.retrieveContract(contractId);
		return contract;
	}
	
	/**
	 * 계약서 등록.
	 * @param contract
	 * @return
	 */
	@RequestMapping(method = RequestMethod.POST)
	@ResponseBody
	public Map<String, String> registerContract(
			@RequestBody Map<String, Object> requestParam
			){
		Map<String, String> result = new HashMap<String, String>();
		Contract contract = JSONUtil.fromJson(JSONUtil.toJson(requestParam), Contract.class);
		int contractId = this.contractService.registerContract(contract);
		result.put("result", Integer.toString(contractId));
		return result;
	}
	
	/**
	 * 계약서 수정
	 * @param requestParam
	 * @return
	 */
	@RequestMapping(value = "/{contractId}", method = RequestMethod.PUT)
	@ResponseBody
	public Map<String, String> updateContract(
			@PathVariable(value = "contractId") int contractId,
			@RequestBody Map<String, Object> requestParam
			){
		Map<String, String> result = new HashMap<String, String>();
		Contract updatedContract = JSONUtil.fromJson(JSONUtil.toJson(requestParam), Contract.class);
		updatedContract.setContractId(contractId);
		this.contractService.modifyContract(updatedContract);
		result.put("result", "success");
		
		return result;
	}
	
	/**
	 * 계약서 삭제.
	 * @param requestParam
	 * @return
	 */
	@RequestMapping(value ="/{contractId}", method = RequestMethod.DELETE)
	@ResponseBody
	public Map<String, String> removeContract(
			@PathVariable(value = "contractId") int contractId
			){
		Map<String, String> result = new HashMap<String, String>();
		contractService.removeContract(contractId);
		result.put("result", "success");
		return result;
	}
}
