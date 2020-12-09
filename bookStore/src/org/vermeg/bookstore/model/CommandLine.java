package org.vermeg.bookstore.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="lineorder")
public class CommandLine {

	@Id
	@Column(name="linenumber")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long numLigne;
	@Column(name = "quantity")
	private double quantite;
	@Column(name = "lineprice")
	private double prixpd;
	@ManyToOne(fetch= FetchType.LAZY)
	@JoinColumn(name="id")
	private Book livre;
	@ManyToOne(fetch= FetchType.LAZY)
	@JoinColumn(name="orderid")
	private Command c;
	
	
	public long getNumLigne() {
		return numLigne;
	}
	public void setNumLigne(long numLigne) {
		this.numLigne = numLigne;
	}
	public double getQuantite() {
		return quantite;
	}
	public void setQuantite(double quantite) {
		this.quantite = quantite;
	}
	public double getPrixpd() {
		return prixpd;
	}
	public void setPrixpd(double prixpd) {
		this.prixpd = prixpd;
	}
	public Book getLivre() {
		return livre;
	}
	public void setLivre(Book livre) {
		this.livre = livre;
	}
	public Command getCommand() {
		return c;
	}
	public void setCommand(Command c) {
		this.c = c;
	}
	
	
	public CommandLine(long numLigne, double quantite, Book livre, Command c) {
		this.numLigne = numLigne;
		this.quantite = quantite;
		this.prixpd = this.quantite*this.livre.getPrixUnitaire();
		this.livre = livre;
		this.c = c;
	}
	
	public CommandLine() {
	}
	@Override
	public String toString() {
		return "Commandline [numLigne=" + numLigne + livre.toString() + ", quantite=" + quantite + ", prixpd=" + prixpd + "]";
	}
	
	
	
}
