/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

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
 *
 * @author Diego Munhoz
 */
@Entity
@Table(name = "bairros")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Bairros.findAll", query = "SELECT b FROM Bairros b"),
    @NamedQuery(name = "Bairros.findByBairroId", query = "SELECT b FROM Bairros b WHERE b.bairroId = :bairroId"),
    @NamedQuery(name = "Bairros.findByCidadeId", query = "SELECT b FROM Bairros b WHERE b.cidadeId = :cidadeId"),
    @NamedQuery(name = "Bairros.findByDescBairro", query = "SELECT b FROM Bairros b WHERE b.descBairro = :descBairro")})
public class Bairros implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "bairro_id")
    private Integer bairroId;
    @Basic(optional = false)
    @Column(name = "cidade_id")
    private int cidadeId;
    @Basic(optional = false)
    @Column(name = "desc_bairro")
    private String descBairro;

    public Bairros() {
    }

    public Bairros(Integer bairroId) {
        this.bairroId = bairroId;
    }

    public Bairros(Integer bairroId, int cidadeId, String descBairro) {
        this.bairroId = bairroId;
        this.cidadeId = cidadeId;
        this.descBairro = descBairro;
    }

    public Integer getBairroId() {
        return bairroId;
    }

    public void setBairroId(Integer bairroId) {
        this.bairroId = bairroId;
    }

    public int getCidadeId() {
        return cidadeId;
    }

    public void setCidadeId(int cidadeId) {
        this.cidadeId = cidadeId;
    }

    public String getDescBairro() {
        return descBairro;
    }

    public void setDescBairro(String descBairro) {
        this.descBairro = descBairro;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (bairroId != null ? bairroId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Bairros)) {
            return false;
        }
        Bairros other = (Bairros) object;
        if ((this.bairroId == null && other.bairroId != null) || (this.bairroId != null && !this.bairroId.equals(other.bairroId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Bairros[ bairroId=" + bairroId + " ]";
    }
    
}
