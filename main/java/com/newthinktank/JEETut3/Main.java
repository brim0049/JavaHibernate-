package com.newthinktank.JEETut3;

import java.util.List;

import javax.persistence.PrePersist;

import java.util.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.ConstraintViolationException;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;
import org.apache.commons.collections4.CollectionUtils;


public class Main {

	public static void main(String[] args) {

		client_commande_facture();
		ArticleAdd();
	
	}	
	
   
	public static void client_commande_facture() {
		
		SessionFactory sf = HibernateUtil.getSessionFactory();
		Session session = sf.openSession();
		session.beginTransaction();
		
		Client d1 = new Client();
		d1.setNom("Brik");
		d1.setTel("7877557");
		session.save(d1);
//		
		Commande e1 = new Commande();
		e1.setDate(new Date(2015-05-01));
		
		Commande e2 = new Commande();
		e2.setDate(new Date(2019-05-01));
		
		e1.setClient(d1);
		e2.setClient(d1);
		
		session.save(e1);
		session.save(e2);
		
		Article a2 = new Article();
		a2.setdescription("Brghjkik");
		a2.setquantiteDisponible(585);
		a2.setprixUnitaire(242);
		a2.setNumSerie("SN-abc-142345");
		prePersist(a2);
		session.save(a2);
//
		Facture f1 = new Facture();
		f1.setTotal(55.00);
		f1.setClient(d1);
		session.save(f1);
		//
		session.getTransaction().commit();
		session.close();
		//sf.close();
		
	}
	public static void ArticleAdd() {
		
		SessionFactory sf = HibernateUtil.getSessionFactory();
		Session session = sf.openSession();
		session.beginTransaction();

		Article a2 = new Article();
		a2.setdescription("Brghjkik");
		a2.setquantiteDisponible(585);
		a2.setprixUnitaire(242);
		a2.setNumSerie("SN-abl-142345");
		prePersist(a2);
		session.save(a2);
		session.getTransaction().commit();
		session.close();
		//sf.close();
		
	}
	@PrePersist
	public static void prePersist(Article Entity){
		ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
		Validator validator = factory.getValidator();
		Set<ConstraintViolation<Article>> violations = validator.validate(Entity);
		if(CollectionUtils.isNotEmpty(violations)){
	          throw new ConstraintViolationException(violations);	}
	

	}
}
