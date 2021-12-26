package com.newthinktank.JEETut3;
import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.*;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
public class Client {

	@Id
	@GeneratedValue
	private Integer idClient;
	private String nom;
	@NotBlank
	@Size(min = 6, max = 10, message="nom doit etre entre 6 et 20 svp")
	private String tel;
	//la table client est associ� � la table commande et facture avec un type one to many ou un client peut avoir plusieurs
	//factures et commandes et si un client est supprim� toutes ses actions sera supprimer. 
	@OneToMany(mappedBy="client", cascade=CascadeType.ALL)
	@OnDelete(action = OnDeleteAction.CASCADE)
	private Collection<Commande> commandes = new ArrayList<Commande>();
	@OneToMany(mappedBy="client", cascade=CascadeType.ALL)
	@OnDelete(action = OnDeleteAction.CASCADE)
	private Collection<Facture> factures = new ArrayList<Facture>();
	//public Client() {}

	//public Client(String nom, String tel) {}

	public Integer getIdClient() {
		return idClient;
	}

	public void setIdClient(Integer idClient) {
		this.idClient = idClient;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}
	public Collection<Commande> getCommandes() {
		return commandes;
	}
	public void setCommandes(Collection<Commande> commandes) {
		this.commandes = commandes;
	}
	public Collection<Facture> getFacture() {
		return factures;
	}
	public void setFacture(Collection<Facture> factures) {
		this.factures = factures;
	}
}