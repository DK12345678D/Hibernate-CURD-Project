package com.app.model.student;
import javax.persistence.Column; 
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author Dinkar
 *
 */
@Entity
@Table(name="StudentTab")
public class Student {
	@Id
	private Integer stdId;
    private String stdName;
    private Double stdFee;
    private Integer age;
    private Long mob;

	public Student() {
		super();
	}

	public Student(Integer stdId, String stdName, Double stdFee, Integer age, Long mob) {
		super();
		this.stdId = stdId;
		this.stdName = stdName;
		this.stdFee = stdFee;
		this.age = age;
		this.mob = mob;
	}

	public Integer getStdId() {
		return stdId;
	}

	public void setStdId(Integer stdId) {
		this.stdId = stdId;
	}

	public String getStdName() {
		return stdName;
	}

	public void setStdName(String stdName) {
		this.stdName = stdName;
	}

	public Double getStdFee() {
		return stdFee;
	}

	public void setStdFee(Double stdFee) {
		this.stdFee = stdFee;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public Long getMob() {
		return mob;
	}

	public void setMob(Long mob) {
		this.mob = mob;
	}

	@Override
	public String toString() {
		return "Student [stdId=" + stdId + ", stdName=" + stdName + ", stdFee=" + stdFee + ", age=" + age + ", mob="
				+ mob + "]";
	}

	}
