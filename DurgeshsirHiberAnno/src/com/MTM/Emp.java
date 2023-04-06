package com.MTM;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

@Entity
public class Emp {
@Id
private int eid;
private String name;
@ManyToMany
@JoinTable(name="emp_learn")
private List<Project> Projects;
public int getEid() {
	return eid;
}
public void setEid(int eid) {
	this.eid = eid;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public List<Project> getProjects() {
	return Projects;
}
public void setProjects(List<Project> projects) {
	Projects = projects;
}


}
