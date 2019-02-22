package com.mypj.domain;
/**
 * @author kevinzcf
 */

import java.util.List;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.hibernate.validator.constraints.NotBlank;
@Entity
public abstract class BasicEntity {
	@Id
	@GeneratedValue
	protected Integer id;
	@NotBlank(message = "required")
	protected String name;
	protected String descriptions;
	@Column
	@ElementCollection(targetClass = String.class)
	private List<String> tags;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescriptions() {
		return descriptions;
	}
	public void setDescriptions(String descriptions) {
		this.descriptions = descriptions;
	}
	public List<String> getTags() {
		return tags;
	}
	public void setTags(List<String> tags) {
		this.tags = tags;
	}

}
