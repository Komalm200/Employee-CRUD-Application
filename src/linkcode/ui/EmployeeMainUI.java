package linkcode.ui;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import linkcode.dao.EmployeeDaolmpl;
import linkcode.entity.Employee;

public class EmployeeMainUI {
	
	public static void main(String args[])
	{
	    Scanner sc=new Scanner(System.in);
	    
	    int i=0;
	    Employee etemp=null;
	    EmployeeDaolmpl edao=new EmployeeDaolmpl();
	    List<Employee> lst=new ArrayList<Employee>();
	    
	    do
	    {
	    	 System.out.println("1-Create\n2-Delete\n3-Update\n4-Search\n5-Display");
	 	    System.out.println("Enter your choice...");
	 	    int ch=sc.nextInt();
	 	    switch(ch)
	 	    {
	 	    case 1:
	 	    	System.out.println("Enter Employee Id,Name,Salary");
	 	    	Employee eobj=new Employee(sc.nextInt(), sc.next(), sc.nextInt());
	 	    	lst.add(eobj);
	 	    	int j=edao.createRecord(lst);
	 	    	
	 	    	if(j>0)
	 	    	{
	 	    		System.out.println("Record Save..");
	 	    	}
	 	    	else
	 	    	{
	 	    		System.out.println("Record not save...");
	 	    	}
	 	    	break;
	 	    	
	 	    case 2 :
	 	    	System.out.println("Enter Employee id to delete Record");
	 	    	int empId=sc.nextInt();
	 	    	i=edao.deleteRecord(empId);
	 	    	if(i>0)
	 	    	{
	 	    		System.out.println("Record Deleted..");
	 	    	}
	 	    	break;
	 	    	
	 	    case 3:
	 	    	System.out.println("Enter employee id and new salary to update in database");
	 	    	int eid=sc.nextInt();
	 	    	int empsal=sc.nextInt();
	 	    	etemp=new Employee(eid, null, empsal);
	 	    	etemp.setEmpId(eid);
	 	    	etemp.setEmpSalary(empsal);
	 	    	lst.add(etemp);
	 	        i=edao.updateRecord(lst);
	 	    	if(i>0)
	 	    	{
	 	    		System.out.println("Record Update..");
	 	    	}
	 	    	break;
	 	    	
	 	    case 4:
	 	    	System.out.println("Enter employee id to search record");
	 	    	eid=sc.nextInt();
	 	    	lst=edao.searchRecord(eid);
	 	    	if(lst!=null)
	 	    	{
	 	    		etemp=lst.get(0);
	 	    		System.out.println(etemp.getEmpId()+"\t"+etemp.getEmpName()+"\t"+etemp.getEmpSalary());
	 	    	}
	 	    	else
	 	    	{
	 	    		System.out.println("Invalid employee Id");
	 	    	}
	 	    	break;
	 	    	
	 	    case 5:
               //	 display aal record
    	    	lst=edao.displayAll();
    	    	//System.out.println(lst);
    	    	
	 	    	break;
	 	    }
	 	    
	 	    System.out.println("Do you want to continue press yes/no");
	    }while(sc.next().equals("yes"));
	    System.out.println("---------------THANK YOU--------------------------"); 	
	   
	}

}

/*
  create table employeedb1 (
    EmpId number(10) ,
    EmpName varchar2(30),
    EmpSalary number(30)
    );
 
 */
