package fr.digi.cda2024.entities;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name="LIVRE")
public class Livre {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int Id;

    @Column(name="titre")
    private String titre;

    @Column(name="auteur")
    private String auteur;

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
}
