package com.mypj.repository;

import java.util.List;

import com.mypj.domain.CPOrder;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author kevinzcf
 */
public interface CPOrderRepository extends JpaRepository<CPOrder, Integer> {

}
