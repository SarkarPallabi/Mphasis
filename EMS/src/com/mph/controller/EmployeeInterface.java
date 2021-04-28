package com.mph.controller;

import java.io.IOException;
import java.util.List;

public interface EmployeeInterface {
	public List addEmployee();
	public void viewEmployee(List elist);
	
	public void addManager();
		
	
	public void viewManager();
	public void sortEmp();
	
	public void sortbyName(List elist);
	public void serialize(List elist) throws IOException;
	public void deserialize(List elist) throws IOException, ClassNotFoundException;
	public void insertUsingProc();
	public void rsmd();
	void type_forward_only_rs();
	void type_scroll_insensitive_rs();
	void type_scroll_sensitive_rs_insert();
	void type_scroll_sensitive_rs_update();
	void batchUpdate();
}
