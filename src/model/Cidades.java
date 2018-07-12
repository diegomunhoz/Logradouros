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

@Entity
@Table(name = "cidades")
@XmlRootElement
public class Cidades implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "cidade_id")
    private Integer cidadeId;
    @Basic(optional = false)
    @Column(name = "desc_cidade")
    private String descCidade;
    @Basic(optional = false)
    @Column(name = "flg_estado")
    private String flgEstado;

    public Cidades() {
    }

    public Cidades(Integer cidadeId) {
        this.cidadeId = cidadeId;
    }

    public Cidades(Integer cidadeId, String descCidade, String flgEstado) {
        this.cidadeId = cidadeId;
        this.descCidade = descCidade;
        this.flgEstado = flgEstado;
    }

    public Integer getCidadeId() {
        return cidadeId;
    }

    public void setCidadeId(Integer cidadeId) {
        this.cidadeId = cidadeId;
    }

    public String getDescCidade() {
        return descCidade;
    }

    public void setDescCidade(String descCidade) {
        this.descCidade = descCidade;
    }

    public String getFlgEstado() {
        return flgEstado;
    }

    public void setFlgEstado(String flgEstado) {
        this.flgEstado = flgEstado;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (cidadeId != null ? cidadeId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Cidades)) {
            return false;
        }
        Cidades other = (Cidades) object;
        if ((this.cidadeId == null && other.cidadeId != null) || (this.cidadeId != null && !this.cidadeId.equals(other.cidadeId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Cidades[ cidadeId=" + cidadeId + " ]";
    }
    
}
