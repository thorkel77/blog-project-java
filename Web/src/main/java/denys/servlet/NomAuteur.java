package denys.servlet;


import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import denys.dao.DAOArticle;
import denys.dao.DAOAuteur;
import denys.dao.DaoFactory;
import denys.model.Article;
import denys.model.Auteur;

public class NomAuteur extends HttpServlet {
	
	@Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        
		DaoFactory factory= new DaoFactory();
		DAOAuteur daoauteur= factory.getDaoAuteur();
		List<Auteur> auteur = daoauteur.getAllAuteur();
		
		DaoFactory factoryi= new DaoFactory();
		DAOArticle daoArticle= factoryi.getDaoArticle();
		List<Article> article = daoArticle.getAllArticle();
				
		
        req.setAttribute("auteur",auteur);
        req.setAttribute("article",article);
        
        
        this.getServletContext().getRequestDispatcher("/WEB-INF/NomAuteur.jsp").forward(req, resp);
    }
	
}
