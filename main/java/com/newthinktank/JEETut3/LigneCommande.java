package com.newthinktank.JEETut3;
import java.util.Set;

import javax.persistence.*;
@Entity
public class LigneCommande {
	@EmbeddedId
	//pour creer une association de type many to many
    private LigneCommandeKey id;
	//J'ai choisi ce code pour relier les tables des lignes
	//de commande et de livraison pour créer une association de type plusieurs à plusieurs 
	@ManyToOne
    @MapsId("idCommande")
    @JoinColumn(name = "idCommande")
    private Commande commande;
    
    @ManyToOne
    @MapsId("idArticle")
    @JoinColumn(name = "idArticle")
    private Article article;
    
    @Column(nullable = false)
    private Integer quantite;
    //ligne commande est associ�e � la table detail livraison avec une association de type many to many
    @OneToMany(mappedBy = "lignecommande")
    Set<DetailLivraison> detaillivraison;
	public LigneCommandeKey getId() {
		return id;
	}

	public void setId(LigneCommandeKey id) {
		this.id = id;
	}

	public Commande getCommande() {
		return commande;
	}

	public void setCommande(Commande commande) {
		this.commande = commande;
	}

	public Article getArticle() {
		return article;
	}

	public void setArticle(Article article) {
		this.article = article;
	}

	public Integer getQuantite() {
		return quantite;
	}

	public void setQuantite(Integer quantite) {
		this.quantite = quantite;
	}
}
