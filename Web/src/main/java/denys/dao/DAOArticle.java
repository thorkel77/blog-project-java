package denys.dao;


import java.util.List;

import denys.model.Article;

public interface DAOArticle {

		public Article getArticle(int id);
		
		public List<Article> getAllArticle();
		
		public void addArticle (Article article);
		
		public void updateArticle(Article article);
		
		public void deleteArticle(Article article);
		
		public List<Article> getArtdeux();
	}


