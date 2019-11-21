package fr.cesi.commerce.dao;

import java.util.List;

import fr.cesi.commerce.entity.Commentaire;
import fr.cesi.commerce.entity.Projet;

public interface CommentaireDao {

	public Commentaire addCommentaire(Commentaire c) ;
	public void editCommentaire(Commentaire c) ;
	public List<Commentaire> getAllCommentaires() ;
	public Commentaire findCommentaireById(Long id) ;
	public void removeCommentaire(Commentaire c) ;
}
