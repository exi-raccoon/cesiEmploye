package business;

import java.util.List;

import common.models.Employe;
import common.resources.EmployeResource;

public interface IEmployeService {
	public String Add(EmployeResource employeResource);

	public String Update(EmployeResource employeResource);

	public String Remove(int id);

	public Employe GetById(int id);

	public List<Employe> GetAll();
}
