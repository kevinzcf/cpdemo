package com.mypj.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author kevinzcf
 */
@Component
@ConfigurationProperties(prefix = "myproperty")
public class MyProperties {

	private String p1;

	private Integer p2;

	public String getP1() {
		return p1;
	}

	public void setP1(String p1) {
		this.p1 = p1;
	}

	public Integer getP2() {
		return p2;
	}

	public void setP2(Integer p2) {
		this.p2 = p2;
	}

}
