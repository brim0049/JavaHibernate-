package com.newthinktank.JEETut3;

import javax.persistence.*;
import java.io.Serializable;
@Embeddable 
public class DetailLivraisonKey implements Serializable {

	@Column(name = "idCommande")
	private Integer idCommande;
	
	@Column(name = "idArticle")
	private Integer idArticle;
	
	@Column(name = "idLivraison")
	private Integer idLivraison;
}
