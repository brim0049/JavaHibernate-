package com.newthinktank.JEETut3;

import javax.persistence.*;
@Entity

public class DetailLivraison {
	@EmbeddedId
	//pour creer une association de type many to many
    private DetailLivraisonKey id;
    // J'ai choisi ce code pour joindre la table de Livraison
	//et ligne Commande pour créer une association de type  plusieurs à plusieurs 
	@ManyToOne
    @MapsId
    @JoinColumns({
    @JoinColumn(name="idCommande", referencedColumnName="idCommande"),
    @JoinColumn(name="idArticle", referencedColumnName="idArticle"), 
    })
    private LigneCommande lignecommande;
 
    @ManyToOne
    @MapsId("idLivraison")
    @JoinColumn(name = "idLivraison")
    private Livraison livraison;
    @Column(nullable = false)
    private Integer quantite_livree;
    
	public Integer getQuantite_livree() {
		return quantite_livree;
	}


	public void setQuantite_livree(Integer quantite_livree) {
		this.quantite_livree = quantite_livree;
	}


	public DetailLivraisonKey getId() {
		return id;
	}


	public void setId(DetailLivraisonKey id) {
		this.id = id;
	}


	public LigneCommande getLignecommande() {
		return lignecommande;
	}


	public void setLignecommande(LigneCommande lignecommande) {
		this.lignecommande = lignecommande;
	}


	public Livraison getLivraison() {
		return livraison;
	}


	public void setLivraison(Livraison livraison) {
		this.livraison = livraison;
	}

}

