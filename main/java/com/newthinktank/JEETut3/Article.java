package com.newthinktank.JEETut3;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Set;

import javax.persistence.*;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
@Entity 
public class Article {

	@Id
	@GeneratedValue
	private Integer idArticle;
	private String description;
	@NumSerieValide
	private String NumSerie;
	
	public String getNumSerie() {
		return NumSerie;
	}

	public void setNumSerie(String numSerie) {
		NumSerie = numSerie;
	}

	@Column(nullable = false)
	private Integer quantiteDisponible;
	
	@Column(nullable = false)
	private Integer prixUnitaire;
	//La table des articles est liée à la table des lignes
	//de commande avec le type un à plusieurs car l'article contient
	//plusieurs lignes de commande
	
	@OneToMany(mappedBy = "article", cascade=CascadeType.ALL)
	@OnDelete(action = OnDeleteAction.CASCADE)
    Set<LigneCommande> lignecommandes;

	public Integer getIdArticle() {
		return idArticle;
	}

	public void setIdArticle(Integer idArticle) {
		this.idArticle = idArticle;
	}

	public String getdescription() {
		return description;
	}

	public void setdescription(String description) {
		this.description = description;
	}

	public Integer getquantiteDisponible() {
		return quantiteDisponible;
	}

	public void setquantiteDisponible(Integer quantiteDisponible) {
		this.quantiteDisponible = quantiteDisponible;
	}
	public Integer getprixUnitaire() {
		return prixUnitaire;
	}

	public void setprixUnitaire(Integer prixUnitaire) {
		this.prixUnitaire = prixUnitaire;
	}
	
}