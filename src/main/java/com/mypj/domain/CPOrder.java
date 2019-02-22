package com.mypj.domain;

import javax.persistence.Entity;

/**
 * @author kevinzcf
 */
@Entity
public class CPOrder extends BasicEntity {
	private boolean quoted;

	public boolean isQuoted() {
		return quoted;
	}

	public void setQuoted(boolean quoted) {
		this.quoted = quoted;
	}
}
