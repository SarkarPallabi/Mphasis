package com.mph.view;

import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.ObjectOutputStream;
import java.util.List;
import java.util.Scanner;

import com.mph.controller.EmployeeController;
import com.mph.controller.EmployeeInterface;
import com.mph.exception.GiveException;
import com.mph.model.Manager;
import java.util.function.BiPredicate;

public class MainClass {

	public static void main(String[] args) throws Exception {

		EmployeeInterface ec = new EmployeeController();
		List elist =null;
		

		Scanner sc = new Scanner(System.in);
		
		
		
		try{
			InputStreamReader isr = new InputStreamReader(System.in);
			BufferedReader br = new BufferedReader(isr);
			String un,pw;
			System.out.println("Enter UserName");
			un=br.readLine();
			System.out.println("Enter Password");
			pw =br.readLine();
			
			BiPredicate<String, String> pred = (un1,pw1)->un1.equals("po")&&pw1.equals("po");
			if(pred.test(un, pw))				
			{
				
				System.out.print("Loading");
				Thread.sleep(1000);
				System.out.print(".");
				Thread.sleep(1000);
				System.out.print(".");
				Thread.sleep(1000);
				System.out.println(".");
				Thread.sleep(1000);
				
				System.out.println("Welcome !!!" );
				
				String input = null;
				
				do {
					System.out.println("Enter Choice");
					System.out.println("1. Add Employee");
					System.out.println("2. View Employee");
					System.out.println("3. Give Dept");
					System.out.println("4. View All");
					System.out.println("5. Sort Employee According to name");
					System.out.println("6. Show");
					System.out.println("7. Sort By name and view");
					System.out.println("8. Serialize");
					System.out.println("9. DeSerialize");
					System.out.println("10. Procedure Insert");
					System.out.println("11. Get ResultSet MetaData Info ");
					System.out.println("12. RS Forward Only");
					System.out.println("13. RS scroll insensitive");
					System.out.println("14. RS scroll sensitive Insert");
					System.out.println("15. RS scroll sensitive update");
					System.out.println("16. Batch Uppdate");
					int choice = sc.nextInt();
					switch (choice) {
					case 1: {
						elist=ec.addEmployee();
						break;
					}

					case 2: {
						ec.viewEmployee(elist);
						break;
					}
					case 3: {
						ec.addManager();
						break;
					}
					case 4: {
						ec.viewManager();
						break;
					}
					case 5: {
						ec.sortEmp();
						break;
					}
					
					case 6: {
						ec.viewEmployee(elist);
						break;
					}
					case 7: {
						ec.sortbyName(elist);
						break;
					}
					case 8 : {
						ec.serialize(elist);
						break;
					}
					case 9 : {
						ec.deserialize(elist);
						break;
					}
					
					case 10: {
						ec.insertUsingProc();
					}
					
					case 11: {
						ec.rsmd();
					}
					
					case 12: {
						ec.type_forward_only_rs();
					}
					case 13: {
						ec.type_scroll_insensitive_rs();
					}
					case 14: {
						ec.type_scroll_sensitive_rs_insert();
					}
					case 15: {
						ec.type_scroll_sensitive_rs_update();
					}
					case 16: {
						ec.batchUpdate();
					}
					default: {

					}
					
					}
					
					System.out.println("Do you want to continue ? Y or y for yes");
					input = sc.next();
				} while (input.equals("Y") || input.equals("y"));
				System.out.println("System Exited..Thanks for using our system !!!");
				System.exit(0);
			

			}
			else
			{
				System.out.println("User not found" );
			}

			
			}
			finally{
				System.exit(0);
			}
		
		
		
	}
		
		
			
}