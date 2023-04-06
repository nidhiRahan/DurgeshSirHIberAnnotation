package com.MTM;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Project {

	@Id
		private int pid;
	@Column(name="project_name")
		private String name;
	@ManyToMany(mappedBy="Projects")
private List<Emp> Employee;
	public int getPid() {
		return pid;
	}
	public void setPid(int pid) {
		this.pid = pid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<Emp> getEmployee() {
		return Employee;
	}
	public void setEmployee(List<Emp> employee) {
		Employee = employee;
	}
	
	
	}


