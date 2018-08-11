package primefacesbarchartjpa.model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Population.java: Entity Class or the image of the table <b>population.</b>
 * @author MichkaDaCoder
 */
@Entity
@Table(name = "population")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Population.findAll", query = "SELECT p FROM Population p"),
    @NamedQuery(name = "Population.findById", query = "SELECT p FROM Population p WHERE p.id = :id"),
    @NamedQuery(name = "Population.findByYear", query = "SELECT p FROM Population p WHERE p.year = :year"),
    @NamedQuery(name = "Population.findByNumber", query = "SELECT p FROM Population p WHERE p.number = :number")})
public class Population implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    @Column(name = "YEAR")
    private Long year;
    @Column(name = "NUMBER")
    private Long number;

    public Population() {
    }

    public Population(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Long getYear() {
        return year;
    }

    public void setYear(Long year) {
        this.year = year;
    }

    public Long getNumber() {
        return number;
    }

    public void setNumber(Long number) {
        this.number = number;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Population)) {
            return false;
        }
        Population other = (Population) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "primefacesbarchartjpa.model.Population[ id=" + id + " ]";
    }

}
