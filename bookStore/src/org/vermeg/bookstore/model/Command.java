package org.vermeg.bookstore.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="orderbook")
public class Command {
	
	@Id
	@Column(name="orderid")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long numDocAchat;
	@Column(name="orderdate")
	private String DateAchat;
	@OneToMany(mappedBy = "documentAchat", cascade = CascadeType.ALL)
    private List<CommandLine> achat;
	@ManyToOne(fetch= FetchType.LAZY)
	@JoinColumn(name="userid")
	private User utilisateur;
	
	
	public long getId() {
		return numDocAchat;
	}
	public void setId(long id) {
		this.numDocAchat = id;
	}
	public String getDateAchat() {
		return DateAchat;
	}
	public void setDateAchat(String dateAchat) {
		DateAchat = dateAchat;
	}
	public User getUtilisateur() {
		return utilisateur;
	}
	public void setUtilisateur(User utilisateur) {
		this.utilisateur = utilisateur;
	}
	
	public Command(long id, String dateAchat, User utilisateur) {
		super();
		this.numDocAchat = id;
		DateAchat = dateAchat;
		this.utilisateur = utilisateur;
	}
	
	public Command() {
	}
	@Override
	public String toString() {
		return utilisateur.toString() + "DocumentAchat [ id=" + numDocAchat + ", DateAchat=" + DateAchat + "]";
	}
	
	
	

}
