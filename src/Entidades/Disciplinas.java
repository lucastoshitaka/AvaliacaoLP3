/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidades;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 *
 * @author lucastoshitaka
 */
@Entity
@Table(name = "disciplinas")
@NamedQueries({
    @NamedQuery(name = "Disciplinas.findAll", query = "SELECT d FROM Disciplinas d")})
public class Disciplinas implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_disciplinas")
    private Integer idDisciplinas;
    @Basic(optional = false)
    @Column(name = "nome_disciplinas")
    private String nomeDisciplinas;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "disciplinas")
    private DisciplinasHasModalidades disciplinasHasModalidades;

    public Disciplinas() {
    }

    public Disciplinas(Integer idDisciplinas) {
        this.idDisciplinas = idDisciplinas;
    }

    public Disciplinas(Integer idDisciplinas, String nomeDisciplinas) {
        this.idDisciplinas = idDisciplinas;
        this.nomeDisciplinas = nomeDisciplinas;
    }

    public Integer getIdDisciplinas() {
        return idDisciplinas;
    }

    public void setIdDisciplinas(Integer idDisciplinas) {
        this.idDisciplinas = idDisciplinas;
    }

    public String getNomeDisciplinas() {
        return nomeDisciplinas;
    }

    public void setNomeDisciplinas(String nomeDisciplinas) {
        this.nomeDisciplinas = nomeDisciplinas;
    }

    public DisciplinasHasModalidades getDisciplinasHasModalidades() {
        return disciplinasHasModalidades;
    }

    public void setDisciplinasHasModalidades(DisciplinasHasModalidades disciplinasHasModalidades) {
        this.disciplinasHasModalidades = disciplinasHasModalidades;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idDisciplinas != null ? idDisciplinas.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Disciplinas)) {
            return false;
        }
        Disciplinas other = (Disciplinas) object;
        if ((this.idDisciplinas == null && other.idDisciplinas != null) || (this.idDisciplinas != null && !this.idDisciplinas.equals(other.idDisciplinas))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entidades.Disciplinas[ idDisciplinas=" + idDisciplinas + " ]";
    }
    
}
