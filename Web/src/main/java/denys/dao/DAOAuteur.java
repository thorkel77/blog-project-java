package denys.dao;

import java.util.List;

import denys.model.Auteur;

public interface DAOAuteur {
	public List<Auteur> getAllAuteur();
	public void addAuteur(Auteur auteur);
}
