package business;

public interface IEmployeeService {
	// add an employee to the database (id serial in database)
	public void AddEmployee(String name, String post, int salary, boolean active);

	// update the name, post, salary and active status of an employe by their id
	public void UpdateEmployee(int id, String name, String post, int salary, boolean active);

	// remove an employee by their id
	public void RemoveEmployee(int id);

	// display the information of an employee using their id
	public void DisplayEmployee(int id);

}
