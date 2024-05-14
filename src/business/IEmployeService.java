package business;

public interface IEmployeService {

	public void AjouterEmploye(String name, String post, int salary, boolean active);

	public void MAJEmploye(int id, String name, String post, int salary, boolean active);

	public void SupprimerEmploye(int id);

	public void AfficherEmploye(int id);

}
