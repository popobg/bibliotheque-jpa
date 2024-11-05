package fr.digi.cda2024.entities;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "CLIENT")
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="ID")
    private int Id;

    @Column(name = "NOM")
    private String nom;

    @Column(name = "PRENOM")
    private String prenom;

    @OneToMany(mappedBy = "client")
    private Set<Emprunt> emprunts;

    public Client() {
        this.emprunts = new HashSet<>();
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Client{");
        sb.append("Id=").append(Id);
        sb.append(", nom='").append(nom).append('\'');
        sb.append(", prenom='").append(prenom).append('\'');
        sb.append('}');
        return sb.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Client client)) return false;
        return Id == client.Id && Objects.equals(nom, client.nom) && Objects.equals(prenom, client.prenom);
    }

    @Override
    public int hashCode() {
        return Objects.hash(Id, nom, prenom);
    }

    /** Getter
     * @return Id
     */
    public int getId() {
        return Id;
    }

    /** Getter
     * @return nom
     */
    public String getNom() {
        return nom;
    }

    /** Setter
     * @param nom nom
     */
    public void setNom(String nom) {
        this.nom = nom;
    }

    /** Getter
     * @return prenom
     */
    public String getPrenom() {
        return prenom;
    }

    /** Setter
     * @param prenom prenom
     */
    public void setPrenom(String prenom) {
        this.prenom = prenom;
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
