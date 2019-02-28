package com.mypj.service;

import com.mypj.domain.CPOrder;
import com.mypj.enums.CPOrderStatus;
import com.mypj.repository.CPOrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author kevinzcf
 */
@Service
public class CPOrderService {

	@Autowired
	private CPOrderRepository cpOrderRepository;

	/**
	 * @param id
	 * @return
	 */
	public CPOrder findOne(Integer id) {
		return cpOrderRepository.findById(id).get();
	}

	public void createOrders(int count){
		for (int ii = 0; ii < count; ii++) {
			CPOrder order = new CPOrder();
			order.setItemName("Item_"+ii);
			order.setItemDescriptions("Descriptions for Item: "+ order.getItemName());
			order.setItemDescriptionsHide("Hide Descriptions for Item: "+ order.getItemName());
			order.setSupplierId("SupplierId_"+ii);
			order.setConsumerId("ConsumerId_"+ii);
			order.setStatus(CPOrderStatus.OPEN);
			cpOrderRepository.save(order);
		}
	}

	public void cleanOrders(){
		cpOrderRepository.deleteAll();
	}

	public void apply(Integer id){
		CPOrder order=findOne(id);
		order.setStatus(CPOrderStatus.APPLIED);
		cpOrderRepository.save(order);
	}

	public void apply(CPOrder order){
		order.setStatus(CPOrderStatus.APPLIED);
		cpOrderRepository.save(order);
	}

	public void approve(Integer id){
		CPOrder order=findOne(id);
		order.setStatus(CPOrderStatus.APPROVED);
		cpOrderRepository.save(order);
	}

	public void uploadOrder(Integer id,String amaOrderId){
		CPOrder order=findOne(id);
		order.setStatus(CPOrderStatus.ORDERED);
		order.setAmaOrderId(amaOrderId);
		cpOrderRepository.save(order);
	}

	public void received(Integer id){
		CPOrder order=findOne(id);
		order.setStatus(CPOrderStatus.RECEIVED);
		cpOrderRepository.save(order);
	}


	public void reviewed(Integer id, String reviewUrl){
		CPOrder order=findOne(id);
		order.setStatus(CPOrderStatus.REVIEWED);
		order.setReviewUrl(reviewUrl);
		cpOrderRepository.save(order);
	}

	public void payed(Integer id){
		CPOrder order=findOne(id);
		order.setStatus(CPOrderStatus.PAYED);
		cpOrderRepository.save(order);
	}

	public void cancell(Integer id){
		CPOrder order=findOne(id);
		order.setStatus(CPOrderStatus.CANCELLED);
		cpOrderRepository.save(order);
	}

	public void close(Integer id){
		CPOrder order=findOne(id);
		order.setStatus(CPOrderStatus.FINISHED);
		cpOrderRepository.save(order);
	}

}
