package com.newthinktank.JEETut3;

import java.util.*;
import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Entity
public class Commande {
	@Id
	@GeneratedValue
	private int idCommande;
	
	private Date date;
//la table des commandes est liée à la table des lignes de commandes avec un type de lien
	//un-à-plusieurs car une commande peut avoir plusieurs lignes de commande
	@OneToMany(mappedBy = "commande", cascade=CascadeType.ALL)
	@OnDelete(action = OnDeleteAction.CASCADE)
    Set<LigneCommande> lignecommandes; 
	////La table Commandes est liée à la table Clients avec un type d'association
	//un-à-plusieurs car de nombreuses commandes appartiennent à un seul client.
	@ManyToOne
	@JoinColumn(name="idClient", nullable = false)
	private Client client;
	
	public int getIdCommande() {
		return idCommande;
	}
	public void setIdCommande(int idCommande) {
		this.idCommande = idCommande;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public Client getClient() {
		return client;
	}
	public void setClient(Client client) {
		this.client = client;
	}
	
}
