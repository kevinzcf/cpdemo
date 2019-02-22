package com.mypj.controller;

import java.util.List;

import javax.validation.Valid;

import com.mypj.domain.CPOrder;
import com.mypj.repository.CPOrderRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mypj.domain.Result;
import com.mypj.service.CPOrderService;
import com.mypj.utils.MyUtils;
import com.mypj.utils.ResultUtils;

/**
 * @author kevinzcf
 */
@RestController
public class CPOrderController {

	private final static Logger logger = LoggerFactory.getLogger(CPOrderController.class);

	@Autowired
	private CPOrderRepository CPOrderRepository;

	@Autowired
	private CPOrderService CPOrderService;

	/**
	 * find all company
	 * 
	 * @return
	 */
	@GetMapping(value = "/companylist")
	public List<CPOrder> companyList() {
		logger.info("companyList");

		return CPOrderRepository.findAll();
	}

	/**
	 * add a CPOrder
	 * 
	 * @return
	 */
	@PostMapping(value = "/company")
	public Result<CPOrder> addCompany(@Valid CPOrder CPOrder, BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			return ResultUtils.error(1, bindingResult.getFieldError().getDefaultMessage());
		}

		CPOrder.setName(CPOrder.getName());
		CPOrder.setDescriptions(CPOrder.getDescriptions());

		return ResultUtils.success(CPOrderRepository.save(CPOrder));
	}

	// find a company
	@GetMapping(value = "/company/{id}")
	public CPOrder findOneCompany(@PathVariable("id") Integer id) {
		return CPOrderRepository.findOne(id);
	}

	// update
	@PutMapping(value = "/company/{id}")
	public CPOrder updateCompany(@PathVariable("id") Integer id, @RequestParam("name") String name, @RequestParam("descriptions") String descriptions,
								 @RequestParam("tags") String tags, @RequestParam("quoted") Boolean quoted) {
		CPOrder CPOrder = new CPOrder();
		CPOrder.setId(id);
		CPOrder.setDescriptions(descriptions);
		CPOrder.setTags(MyUtils.stringSplitBySep(tags, ";"));
		CPOrder.setQuoted(quoted);

		return CPOrderRepository.save(CPOrder);
	}

	// delete
	@DeleteMapping(value = "/company/{id}")
	public void deleteCompany(@PathVariable("id") Integer id) {
		CPOrderRepository.delete(id);
	}

	// find company by name
	@GetMapping(value = "/company/name/{name}")
	public List<CPOrder> findByName(@PathVariable("name") String name) {
		return CPOrderRepository.findByName(name);
	}

	@PostMapping(value = "/company/addtwo")
	public void addTwoCompany() {
		CPOrderService.insertTwo();
	}

	@GetMapping(value = "company/gettags/{id}")
	public void getTags(@PathVariable("id") Integer id) throws Exception {
		CPOrderService.getTags(id);
	}
}
