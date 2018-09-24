/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidades;

import java.io.Serializable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 *
 * @author lucastoshitaka
 */
@Entity
@Table(name = "disciplinas_has_modalidades")
@NamedQueries({
    @NamedQuery(name = "DisciplinasHasModalidades.findAll", query = "SELECT d FROM DisciplinasHasModalidades d")})
public class DisciplinasHasModalidades implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected DisciplinasHasModalidadesPK disciplinasHasModalidadesPK;
    @JoinColumns({
        @JoinColumn(name = "disciplinas_id_disciplinas", referencedColumnName = "id_disciplinas", insertable = false, updatable = false)
        , @JoinColumn(name = "disciplinas_id_disciplinas", referencedColumnName = "id_disciplinas", insertable = false, updatable = false)})
    @OneToOne(optional = false)
    private Disciplinas disciplinas;
    @JoinColumns({
        @JoinColumn(name = "modalidades_id_modalidades", referencedColumnName = "id_modalidades", insertable = false, updatable = false)
        , @JoinColumn(name = "modalidades_id_modalidades", referencedColumnName = "id_modalidades", insertable = false, updatable = false)})
    @OneToOne(optional = false)
    private Modalidades modalidades;

    public DisciplinasHasModalidades() {
    }

    public DisciplinasHasModalidades(DisciplinasHasModalidadesPK disciplinasHasModalidadesPK) {
        this.disciplinasHasModalidadesPK = disciplinasHasModalidadesPK;
    }

    public DisciplinasHasModalidades(int disciplinasIdDisciplinas, int modalidadesIdModalidades) {
        this.disciplinasHasModalidadesPK = new DisciplinasHasModalidadesPK(disciplinasIdDisciplinas, modalidadesIdModalidades);
    }

    public DisciplinasHasModalidadesPK getDisciplinasHasModalidadesPK() {
        return disciplinasHasModalidadesPK;
    }

    public void setDisciplinasHasModalidadesPK(DisciplinasHasModalidadesPK disciplinasHasModalidadesPK) {
        this.disciplinasHasModalidadesPK = disciplinasHasModalidadesPK;
    }

    public Disciplinas getDisciplinas() {
        return disciplinas;
    }

    public void setDisciplinas(Disciplinas disciplinas) {
        this.disciplinas = disciplinas;
    }

    public Modalidades getModalidades() {
        return modalidades;
    }

    public void setModalidades(Modalidades modalidades) {
        this.modalidades = modalidades;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (disciplinasHasModalidadesPK != null ? disciplinasHasModalidadesPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DisciplinasHasModalidades)) {
            return false;
        }
        DisciplinasHasModalidades other = (DisciplinasHasModalidades) object;
        if ((this.disciplinasHasModalidadesPK == null && other.disciplinasHasModalidadesPK != null) || (this.disciplinasHasModalidadesPK != null && !this.disciplinasHasModalidadesPK.equals(other.disciplinasHasModalidadesPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entidades.DisciplinasHasModalidades[ disciplinasHasModalidadesPK=" + disciplinasHasModalidadesPK + " ]";
    }
    
}
