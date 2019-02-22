package com.mypj.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CPOrderServiceTest {

	@Autowired
	private CPOrderService CPOrderService;

	@Test
	public void findOneTest() {
	}
}
