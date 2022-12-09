package linkcode.dao;

import java.util.List;
import linkcode.entity.Employee;

public interface EmployeeDao {
	
	 public int createRecord(List<Employee> lst);
	 
      public int deleteRecord(int n);
    
    public int updateRecord(List<Employee> lst);
    
    public List<Employee> searchRecord(int n);
    
    public List<Employee> displayAll();     
}
