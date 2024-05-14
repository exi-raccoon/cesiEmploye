package common.models;

public class Employe {

	private int Id;

	private String Name;

	private String Post;

	private Double Salary;

	public Employe() {
	}

	public int GetId() {
		return Id;
	}

	public void SetId(int id) {
		Id = id;
	}

	public String GetName() {
		return Name;
	}

	public void SetName(String name) {
		Name = name;
	}

	public String GetPost() {
		return Post;
	}

	public void SetPost(String post) {
		Post = post;
	}

	public Double GetSalary() {
		return Salary;
	}

	public void SetSalary(Double salary) {
		Salary = salary;
	}

}
