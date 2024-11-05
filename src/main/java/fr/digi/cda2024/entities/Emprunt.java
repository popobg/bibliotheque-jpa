package fr.digi.cda2024.entities;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "EMPRUNT")
public class Emprunt {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private int Id;

    @Column(name = "DATE_DEBUT")
    private LocalDateTime debutEmprunt;

    @Column(name = "DELAI")
    private int delaiMax;

    @Column(name = "DATE_FIN")
    private LocalDateTime dateFin;

    @ManyToOne
    @JoinColumn(name = "ID_CLIENT")
    private Client client;

    @ManyToMany
    @JoinTable(name = "COMPO",
            joinColumns = @JoinColumn(name="ID_EMP", referencedColumnName="ID"),
            inverseJoinColumns = @JoinColumn(name="ID_LIV", referencedColumnName="ID")
    )
    private Set<Livre> livres;

    public Emprunt() {}

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Emprunt{");
        sb.append("Id=").append(Id);
        sb.append(", debutEmprunt=").append(debutEmprunt);
        sb.append(", delaiMax=").append(delaiMax);
        sb.append(", dateFin=").append(dateFin);
        sb.append(", client=").append(client);
        sb.append(", livres=").append(livres);
        sb.append('}');
        return sb.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Emprunt emprunt)) return false;
        return Id == emprunt.Id && delaiMax == emprunt.delaiMax && Objects.equals(debutEmprunt, emprunt.debutEmprunt) && Objects.equals(dateFin, emprunt.dateFin) && Objects.equals(client, emprunt.client) && Objects.equals(livres, emprunt.livres);
    }

    @Override
    public int hashCode() {
        return Objects.hash(Id, debutEmprunt, delaiMax, dateFin, client, livres);
    }

    /**
     * Getter
     *
     * @return Id
     */
    public int getId() {
        return Id;
    }

    /** Getter
     * @return debutEmprunt
     */
    public LocalDateTime getDebutEmprunt() {
        return debutEmprunt;
    }

    /** Setter
     * @param debutEmprunt debutEmprunt
     */
    public void setDebutEmprunt(LocalDateTime debutEmprunt) {
        this.debutEmprunt = debutEmprunt;
    }

    /** Getter
     * @return delaiMax
     */
    public int getDelaiMax() {
        return delaiMax;
    }

    /** Setter
     * @param delaiMax delaiMax
     */
    public void setDelaiMax(int delaiMax) {
        this.delaiMax = delaiMax;
    }

    /** Getter
     * @return dateFin
     */
    public LocalDateTime getDateFin() {
        return dateFin;
    }

    /** Setter
     * @param dateFin dateFin
     */
    public void setDateFin(LocalDateTime dateFin) {
        this.dateFin = dateFin;
    }

    /** Getter
     * @return client
     */
    public Client getClient() {
        return client;
    }

    /** Setter
     * @param client client
     */
    public void setClient(Client client) {
        this.client = client;
    }

    /** Getter
     * @return livres
     */
    public Set<Livre> getLivres() {
        return livres;
    }

    /** Setter
     * @param livres livres
     */
    public void setLivres(Set<Livre> livres) {
        this.livres = livres;
    }
}
