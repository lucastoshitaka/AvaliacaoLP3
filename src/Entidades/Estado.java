/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidades;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author lucastoshitaka
 */
@Entity
@Table(name = "estado")
@NamedQueries({
    @NamedQuery(name = "Estado.findAll", query = "SELECT e FROM Estado e")})
public class Estado implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "sigla_estado")
    private String siglaEstado;
    @Basic(optional = false)
    @Column(name = "nome_estado")
    private String nomeEstado;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "estado")
    private List<Aluno> alunoList;

    public Estado() {
    }

    public Estado(String siglaEstado) {
        this.siglaEstado = siglaEstado;
    }

    public Estado(String siglaEstado, String nomeEstado) {
        this.siglaEstado = siglaEstado;
        this.nomeEstado = nomeEstado;
    }

    public String getSiglaEstado() {
        return siglaEstado;
    }

    public void setSiglaEstado(String siglaEstado) {
        this.siglaEstado = siglaEstado;
    }

    public String getNomeEstado() {
        return nomeEstado;
    }

    public void setNomeEstado(String nomeEstado) {
        this.nomeEstado = nomeEstado;
    }

    public List<Aluno> getAlunoList() {
        return alunoList;
    }

    public void setAlunoList(List<Aluno> alunoList) {
        this.alunoList = alunoList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (siglaEstado != null ? siglaEstado.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Estado)) {
            return false;
        }
        Estado other = (Estado) object;
        if ((this.siglaEstado == null && other.siglaEstado != null) || (this.siglaEstado != null && !this.siglaEstado.equals(other.siglaEstado))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return siglaEstado;
    }
    
}
