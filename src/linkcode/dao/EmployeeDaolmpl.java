package linkcode.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import linkcode.DataSource.DBConnection;
import linkcode.entity.Employee;


public class EmployeeDaolmpl implements EmployeeDao {

	public int createRecord(List<Employee> lst)
	{
		int i=0;
		Connection con=DBConnection.getConnection();
		
		try {
			PreparedStatement pstate=con.prepareStatement("insert into employeedb1 values(?,?,?)");
			Employee eobj=lst.get(0);
			pstate.setInt(1, eobj.getEmpId());
			pstate.setString(2, eobj.getEmpName());
			pstate.setInt(3, eobj.getEmpSalary());
			i=pstate.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return i;
	}
	
	public int deleteRecord(int empId)
	{
		int i=0;
		Connection con=DBConnection.getConnection();
		
		try {
			PreparedStatement pstate=con.prepareStatement("delete from employeedb1 where empId=?");
			pstate.setInt(1, empId);
			i=pstate.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return i;
	}
	public int updateRecord(List<Employee> lst)
	{
		int i=0;
		Connection con=DBConnection.getConnection();
		
		try {
			PreparedStatement pstate=con.prepareStatement("update employeedb1 set empsalary=? where empId=?");
			Employee etemp=lst.get(0);
			pstate.setDouble(1, etemp.getEmpSalary());
			pstate.setInt(2, etemp.getEmpId());
			i=pstate.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return i;
	}
	public List<Employee> searchRecord(int eid)
	{
//		int i=0;
		Connection con=DBConnection.getConnection();
		List<Employee> lst=null;
		
		try {
			PreparedStatement pstate=con.prepareStatement("select * from employeedb1 where empId=?");
			pstate.setInt(1, eid);
			ResultSet rs=pstate.executeQuery();
			
			if(rs.next())
			{
				lst=new ArrayList<Employee>();
				eid=rs.getInt(1);
				String enm=rs.getString(2);
				int sal=rs.getInt(3);
//				System.out.println(eid+" "+enm+" "+sal);
				Employee etemp=new Employee(eid, enm, sal);
				lst.add(etemp);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return lst;
	}
	public List<Employee> displayAll()
	{
	 List<Employee> lst=new LinkedList<Employee>();
	String str="select * from employeedb1";
	Connection con=DBConnection.getConnection();
	
	try {
	    PreparedStatement stat=con.prepareStatement(str);
		ResultSet resultSet=stat.executeQuery();
		while(resultSet.next())
		{
			
			System.out.println(resultSet.getInt(1)+"\t\t\t "+resultSet.getString(2)+"\t\t"+resultSet.getInt(3));
//			Employee emp=new Employee(resultSet.getInt(1),resultSet.getString(2),resultSet.getInt(3));
//			 lst.add(emp);
		}
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return lst;
}
	
}
