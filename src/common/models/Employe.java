package common.models;

public class Employe {

	private int Id;

	private String Name;

	private String Post;

	private int Salary;

	private boolean Active;

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

	public int GetSalary() {
		return Salary;
	}

	public void SetSalary(int salary) {
		Salary = salary;
	}

	public boolean IsActive() {
		return Active;
	}

	public void SetActive(boolean active) {
		Active = active;
	}

}
