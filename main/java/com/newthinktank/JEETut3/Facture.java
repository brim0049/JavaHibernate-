package com.newthinktank.JEETut3;
import javax.persistence.*;

@Entity
public class Facture {
	@Id
	@GeneratedValue
	private int id;
	@Column(nullable = false)
	private Double total;
	//a table des factures est liée à la table Clients avec un type 
	//d'association un-à-plus car de nombreuses factures sont pour un seul client.
	@ManyToOne
	@JoinColumn(name="idClient" ,nullable = false)
	private Client client;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Double getTotal() {
		return total;
	}
	public void setTotal(Double total) {
		this.total = total;
	}
	public Client getClient() {
		return client;
	}
	public void setClient(Client client) {
		this.client = client;
	}
	
}
