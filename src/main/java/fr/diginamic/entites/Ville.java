package fr.diginamic.entites;

import java.util.Date;

import javax.persistence.*;

@Entity
@Table(name = "ville")
public class Ville{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    private String nom;
    
    @Column(name = "code_postal")
    private String codePostal;
    
    @Temporal(TemporalType.DATE)
    @Column(name = "date_dernier_recensement")
    private Date dateDernierRecensement;
    
    @Enumerated(EnumType.STRING)
    private Categorie categorie;
	
	/**
	 * Constructeur
	 */
	public Ville() {

	}

	/**
	 * @param id
	 * @param nom
	 * @param codePostal
	 * @param dernierRecensement
	 * @param categorie
	 */
	public Ville(int id, String nom, String codePostal, Date dateDernierRecensement, Categorie categorie) {
		super();
		this.id = id;
		this.nom = nom;
		this.codePostal = codePostal;
		this.dateDernierRecensement = dateDernierRecensement;
		this.categorie = categorie;
	}

	
}
