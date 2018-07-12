/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
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
@Table(name = "logradouros")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Logradouros.findAll", query = "SELECT l FROM Logradouros l"),
    @NamedQuery(name = "Logradouros.findByNumCep", query = "SELECT l FROM Logradouros l WHERE l.numCep = :numCep"),
    @NamedQuery(name = "Logradouros.findByBairroId", query = "SELECT l FROM Logradouros l WHERE l.bairroId = :bairroId"),
    @NamedQuery(name = "Logradouros.findByDescLogradouro", query = "SELECT l FROM Logradouros l WHERE l.descLogradouro = :descLogradouro"),
    @NamedQuery(name = "Logradouros.findByDescTipo", query = "SELECT l FROM Logradouros l WHERE l.descTipo = :descTipo")})
public class Logradouros implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "num_cep")
    private Integer numCep;
    @Basic(optional = false)
    @Column(name = "bairro_id")
    private int bairroId;
    @Basic(optional = false)
    @Column(name = "desc_logradouro")
    private String descLogradouro;
    @Basic(optional = false)
    @Column(name = "desc_tipo")
    private String descTipo;

    public Logradouros() {
    }

    public Logradouros(Integer numCep) {
        this.numCep = numCep;
    }

    public Logradouros(Integer numCep, int bairroId, String descLogradouro, String descTipo) {
        this.numCep = numCep;
        this.bairroId = bairroId;
        this.descLogradouro = descLogradouro;
        this.descTipo = descTipo;
    }

    public Integer getNumCep() {
        return numCep;
    }

    public void setNumCep(Integer numCep) {
        this.numCep = numCep;
    }

    public int getBairroId() {
        return bairroId;
    }

    public void setBairroId(int bairroId) {
        this.bairroId = bairroId;
    }

    public String getDescLogradouro() {
        return descLogradouro;
    }

    public void setDescLogradouro(String descLogradouro) {
        this.descLogradouro = descLogradouro;
    }

    public String getDescTipo() {
        return descTipo;
    }

    public void setDescTipo(String descTipo) {
        this.descTipo = descTipo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (numCep != null ? numCep.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Logradouros)) {
            return false;
        }
        Logradouros other = (Logradouros) object;
        if ((this.numCep == null && other.numCep != null) || (this.numCep != null && !this.numCep.equals(other.numCep))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Logradouros[ numCep=" + numCep + " ]";
    }
    
}
