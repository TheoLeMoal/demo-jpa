/**
 * 
 */
package fr.diginamic.entites;

import javax.persistence.*;

/**
 * 
 */
@Entity
@Table(name = "region")
public class Region {
	@Id
	private int id;
	@Column(length = 20)
	private String nom;
	
	public Region() {
        // Constructeur par défaut
    }

    public Region(int id, String nom) {
        this.id = id;
        this.nom = nom;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

	@Override
	public String toString() {
		return "Region [id=" + id + ", nom=" + nom + "]";
	}

    
}
