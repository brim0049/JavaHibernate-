package com.newthinktank.JEETut3;

import java.util.*;
import javax.persistence.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
@Entity 
public class Livraison {

	@Id
	@GeneratedValue
	private Integer idLivraison;
	@Column(nullable = false)
	private Date date;

	@OneToMany(mappedBy = "livraison")
    Set<DetailLivraison> detaillivraison;

	public Integer getIdLivraison() {
		return idLivraison;
	}

	public void setIdLivraison(Integer idLivraison) {
		this.idLivraison = idLivraison;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Collection<DetailLivraison> getDetaillivraison() {
		return detaillivraison;
	}

	public void setDetaillivraison(Collection<DetailLivraison> detaillivraison) {
		this.detaillivraison = (Set<DetailLivraison>) detaillivraison;
	}

}