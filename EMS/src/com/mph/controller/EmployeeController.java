package com.mph.controller;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.mph.dao.EmployeeDao;
import com.mph.model.Employee;
import com.mph.model.Manager;
import com.mph.model.Salary;


public class EmployeeController implements EmployeeInterface {
	

	public EmployeeController() {
		super();
	}

	Employee emp;
	Manager m;
	Salary sal;
	List emplist = new ArrayList();
	EmployeeDao empdao = new EmployeeDao();
	
	
	public List addEmployee()
	{
		
		emp = new Employee();
		Scanner  sc = new Scanner(System.in);
		System.out.println("Enter the Eid");
		int eno = sc.nextInt();
		emp.setEid(eno);
		System.out.println("Enter the Ename ");
		String enam = sc.next();
		emp.setEname(enam);
		
		
		
		
		System.out.println("Enter basic Salary");
		double basic = sc.nextDouble();
		sal= new Salary(basic);
		
		
		emp.setSalary(sal);
		
		
		
		//emplist.add(emp);
				empdao.insertEmp(emp);
				
				
				System.out.println("Employee "  + eno + " Succesfully added");
				return emplist;
		
		
		
	}
	
	public void addManager() {
		
		m= new Manager();
		Scanner  sc = new Scanner(System.in);
		
		
		
		System.out.println("Enter the Eid");
		int eno = sc.nextInt();
		m.setEid(eno);
		System.out.println("Enter the Ename ");
		String enam = sc.next();
		m.setEname(enam);
		
		m.setEid(eno);
		m.setEname(enam);
		
		
		sal= new Salary();
		
		System.out.println("Enter basic Salary");
		double basic = sc.nextDouble();
		sal.setBasic(basic);
		System.out.println("Enter DA");
		int da = sc.nextInt();
		sal.setDa(da);
		System.out.println("Enter HRA");
		int hra = sc.nextInt();
		sal.setHra(hra);
		System.out.println("Enter PF");
		int pf= sc.nextInt();
		sal.setPf(pf);
		
		
		System.out.println("Enter dept");
		String dept= sc.next();
		m.setDept(dept);
		m.setSalary(sal);
		
		
	}
	
	public void viewEmployee(List elist)
	{
		/*Iterator i= elist.iterator();

		while(i.hasNext())
		{
			System.out.println(i.next());
		}*/	
		
		
		//elist.forEach(lis ->System.out.println(lis));
		
		empdao.viewEmp();
	}
	
	public void viewManager()
	{
		System.out.println(m);	
	}
	
	public void sortEmp()
	{
	
	Collections.sort(emplist,Employee.nameComparator);
	
	}

	public void sortbyName(List elist)
	{
	
		elist.stream().filter((enam -> (((Employee) enam).getEname().startsWith("A") || 
				((Employee) enam).getEname().startsWith("a")))).
		sorted(Comparator.comparing(Employee::getEname))
				.forEach(System.out::println);
	    
	
	}
	
	
	public void  serialize(List elist) throws IOException, FileNotFoundException {
		
	
		 
		FileOutputStream fos= new FileOutputStream("myfile1.txt");
		ObjectOutputStream oos = new ObjectOutputStream(fos);
			
			oos.writeObject(elist);
				
			oos.close();
			System.out.println("Data successfully Serialized...");
			
		}
public void  deserialize(List elist) throws IOException, ClassNotFoundException {
		
	
	System.out.println("Data successfully Deserialized...");
	
		FileInputStream fis= new FileInputStream("myfile1.txt");
		ObjectInputStream  ois = new ObjectInputStream(fis);
			
			List<Employee> deserial = (List<Employee>) ois.readObject();
			fis.close();
			ois.close();
			
			
			deserial.forEach(System.out::println);
			
			
		
			
		}


public void insertUsingProc()
{
	Employee e = new Employee();
	Scanner  sc = new Scanner(System.in);
	System.out.println("Enter the Eid");
	int eno = sc.nextInt();
	e.setEid(eno);
	System.out.println("Enter the Ename ");
	String enam = sc.next();
	e.setEname(enam);
	
	empdao.insertUsingProcedure(e);
}


public void rsmd()
{
	empdao.rsmd();
}
		


@Override
public void type_forward_only_rs() {
	empdao.type_forward_only_rs();
	
}

@Override
public void type_scroll_insensitive_rs() {
	empdao.type_scroll_insensitive_rs();
	
}

@Override
public void type_scroll_sensitive_rs_insert() {
	empdao.type_scroll_sensitive_rs_insert();
	
}

@Override
public void type_scroll_sensitive_rs_update() {
	empdao.type_scroll_sensitive_rs_update();
	
}

@Override
public void batchUpdate() {
	empdao.batchUpdate();
	
}

	}


	
	

	

