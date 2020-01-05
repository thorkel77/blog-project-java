package denys.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import denys.model.Article;
import denys.model.Auteur;

public class DAOArticleImpl implements DAOArticle {
	private Connection connection;

	public DAOArticleImpl(Connection connection) {
		this.connection = connection;
	}

	public Article getArticle(int id) {
		Article a = new Article();
		try {
			String query = "Select * FROM article JOIN auteur On auteur.id_auteur=article.id_auteur WHERE id=?;";

			PreparedStatement ps = connection.prepareStatement(query);
			ps.setInt(1, id);

			ResultSet resultat = ps.executeQuery();

			while (resultat.next()) {

				Auteur aut = new Auteur();
				
				a.setTitre(resultat.getString("titre"));
				a.setDescription(resultat.getString("description"));
				a.setTexte(resultat.getString("texte"));
				a.setDate(resultat.getDate("date"));
				aut.setPseudo(resultat.getString("pseudo"));
				a.setAuteur(aut);

			}

		} catch (SQLException e) {
			System.out.println(e.getMessage());

		}
		return a;
	}

	public List<Article> getAllArticle() {

		List<Article> article = new ArrayList<Article>();
		try {
			String query = "SELECT * FROM article JOIN auteur On auteur.id_auteur=article.id_auteur;";
			PreparedStatement pr = connection.prepareStatement(query);

			ResultSet resultat = pr.executeQuery();

			while (resultat.next()) {
				Article a = new Article();
				Auteur aut = new Auteur();

				a.setId(resultat.getInt("id"));
				a.setTitre(resultat.getString("titre"));
				a.setDescription(resultat.getString("description"));
				a.setTexte(resultat.getString("texte"));
				a.setDate(resultat.getDate("date"));
				aut.setId_auteur(resultat.getInt("id_auteur"));
				a.setAuteur(aut);

				article.add(a);

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return article;
	}

	public void addArticle(Article article) {
		try {
			PreparedStatement p = connection.prepareStatement(
					"INSERT INTO article (id_auteur, titre, description, texte, date) VALUES (?,?,?,?,?);");
			p.setInt(1, article.getAuteur().getId_auteur());
			p.setString(2, article.getTitre());
			p.setString(3, article.getDescription());
			p.setString(4, article.getTexte());
			p.setDate(5, (Date) article.getDate());

			int statut = p.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void updateArticle(Article article) {
		try {
			String query = "UPDATE article SET titre=?, description=?, texte=?, date=? WHERE id=? ;";
			PreparedStatement p = connection.prepareStatement(query);
			
			p.setString(1, article.getTitre());
			p.setString(2, article.getDescription());
			p.setString(3, article.getTexte());
			p.setDate(4, (Date) article.getDate());
			p.setInt(5, article.getId());

			int statut = p.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void deleteArticle(Article article) {
		try {
			String query = "DELETE FROM article WHERE id=? ;";
			PreparedStatement p = connection.prepareStatement(query);
			p.setInt(1, article.getId());
			boolean resultat = p.execute();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public List<Article> getArtdeux() {
		List<Article> article = new ArrayList<Article>();
		try {
			String query = "SELECT * FROM article ORDER BY date desc LIMIT 2;";
			PreparedStatement pr = connection.prepareStatement(query);

			ResultSet resultat = pr.executeQuery();

			while (resultat.next()) {
				Article a = new Article();

				a.setTitre(resultat.getString("titre"));
				a.setDescription(resultat.getString("description"));
				a.setTexte(resultat.getString("texte"));
				a.setDate(resultat.getDate("date"));
				System.out.println(a.getTitre());
				article.add(a);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return article;
	}

}
