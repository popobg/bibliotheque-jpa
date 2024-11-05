package fr.digi.cda2024.entities;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "LIVRE")
// Serializable = optimisation des requêtes
public class Livre implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="ID")
    private int Id;

    @Column(name = "TITRE", nullable = false)
    private String titre;

    @Column(name = "AUTEUR", length = 50)
    private String auteur;

    @ManyToMany(mappedBy = "livres")
    private Set<Emprunt> emprunts;

    public Livre() {}

    public Livre(String auteur, String titre) {
        this.auteur = auteur;
        this.titre = titre;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Livre{");
        sb.append("Id=").append(Id);
        sb.append(", titre='").append(titre).append('\'');
        sb.append(", auteur='").append(auteur).append('\'');
        sb.append('}');
        return sb.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Livre livre)) return false;
        return Id == livre.Id && Objects.equals(titre, livre.titre) && Objects.equals(auteur, livre.auteur);
    }

    @Override
    public int hashCode() {
        return Objects.hash(Id, titre, auteur);
    }

    /** Getter
     * @return Id
     */
    public int getId() {
        return Id;
    }

    /** Getter
     * @return titre
     */
    public String getTitre() {
        return titre;
    }

    /** Setter
     * @param titre titre
     */
    public void setTitre(String titre) {
        this.titre = titre;
    }

    /** Getter
     * @return auteur
     */
    public String getAuteur() {
        return auteur;
    }

    /** Setter
     * @param auteur auteur
     */
    public void setAuteur(String auteur) {
        this.auteur = auteur;
    }

    /** Getter
     * @return emprunts
     */
    public Set<Emprunt> getEmprunts() {
        return emprunts;
    }

    /** Setter
     * @param emprunts emprunts
     */
    public void setEmprunts(Set<Emprunt> emprunts) {
        this.emprunts = emprunts;
    }
}
