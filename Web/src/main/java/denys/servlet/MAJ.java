package denys.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import denys.dao.DAOArticle;
import denys.dao.DaoFactory;
import denys.model.Article;
import denys.model.Auteur;

public class MAJ extends HttpServlet {
	private int id;
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		DaoFactory factory= new DaoFactory();
		DAOArticle daoarticle= factory.getDaoArticle();
		String selectArticle =req.getParameter("article");
		setId(Integer.parseInt(selectArticle));
		Article article = daoarticle.getArticle(getId());
		
				
		
        req.setAttribute("article",article);
		this.getServletContext().getRequestDispatcher("/WEB-INF/MAJ.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String selectTitre = req.getParameter("Titre");
		String selectDescription = req.getParameter("Description");
		String select = req.getParameter("Texte");
		

		
		Article a = new Article();
		java.util.Date d1 = new java.util.Date();
		java.sql.Date sqlDate = new java.sql.Date(d1.getTime());

		a.setId(getId());
		a.setDescription(selectDescription);
		a.setTitre(selectTitre);
		a.setTexte(select);
		a.setDate(sqlDate);

		DaoFactory factory = new DaoFactory();
		DAOArticle daoarticle = factory.getDaoArticle();
		daoarticle.updateArticle(a);

		this.getServletContext().getRequestDispatcher("/WEB-INF/MAJ.jsp").forward(req, resp);
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

}
