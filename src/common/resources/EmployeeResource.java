package common.resources;

//DTO
public class EmployeeResource {
	// id unique of the employee
	private int Id;

	// name of the employee
	private String Name;

	// post occupied by the employee
	private String Post;

	// salary per month of the employee
	private int Salary;

	// void constructor
	public EmployeeResource() {
	}

	// get id of the employee
	// no parameter
	// returns int
	public int GetId() {
		return Id;
	}

	// set id of the employee
	// int Id
	// void
	// SetId(123) => the employee's id is set to 123
	public void SetId(int id) {
		Id = id;
	}

	// get name of the employee
	// no parameter
	// returns String
	public String GetName() {
		return Name;
	}

	// set name of the employee
	// String Name
	// void
	// SetName("Gerard") => the employee's name is set to Gerard
	public void SetName(String name) {
		Name = name;
	}

	// get post occupied by the employee
	// no parameter
	// returns String
	public String GetPost() {
		return Post;
	}

	// set post occupied by the employee
	// String Post
	// void
	// SetPost("DEV") => the employee's post to DEV
	public void SetPost(String post) {
		Post = post;
	}

	// get salary per month of the employee
	// no parameter
	// returns int
	public int GetSalary() {
		return Salary;
	}

	// set salary per month of the employee
	// int Id
	// void
	// SetSalary(700) => the employee's salary per month is set to 700
	public void SetSalary(int salary) {
		Salary = salary;
	}

}
