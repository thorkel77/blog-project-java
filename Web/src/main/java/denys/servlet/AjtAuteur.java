package denys.servlet;

import java.io.IOException;
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

public class AjtAuteur extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.getServletContext().getRequestDispatcher("/WEB-INF/AjtAuteur.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String selectPseudo = req.getParameter("Pseudo");
		String selectPassword = req.getParameter("Password");
		
		

		Auteur aut = new Auteur();
		

		aut.setPseudo(selectPseudo);
		aut.setPassword(selectPassword);
		


		DaoFactory factory = new DaoFactory();
		DAOAuteur daoauteur = factory.getDaoAuteur();
		daoauteur.addAuteur(aut);

		this.getServletContext().getRequestDispatcher("/WEB-INF/AjtAuteur.jsp").forward(req, resp);
	}

}

