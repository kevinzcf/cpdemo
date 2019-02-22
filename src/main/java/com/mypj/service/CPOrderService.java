package com.mypj.service;

import com.mypj.domain.CPOrder;
import com.mypj.repository.CPOrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author kevinzcf
 */
@Service
public class CPOrderService {

	@Autowired
	private CPOrderRepository CPOrderRepository;

	@Transactional
	public void insertTwo() {
	}

	public void getTags(Integer id) throws Exception {
		CPOrder CPOrder = CPOrderRepository.findOne(id);
	}

	/**
	 * @param id
	 * @return
	 */
	public CPOrder findOne(Integer id) {
		return CPOrderRepository.findOne(id);
	}
}
