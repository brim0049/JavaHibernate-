package com.newthinktank.JEETut3;
import javax.persistence.*;
import java.io.Serializable;
@Embeddable 
public class LigneCommandeKey implements Serializable {
	 @Column(name = "idCommande")
	    private Integer idCommande;

	    @Column(name = "idArticle")
	    private Integer idArticle;
}
