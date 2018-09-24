/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidades;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 *
 * @author lucastoshitaka
 */
@Embeddable
public class DisciplinasHasModalidadesPK implements Serializable {

    @Basic(optional = false)
    @Column(name = "disciplinas_id_disciplinas")
    private int disciplinasIdDisciplinas;
    @Basic(optional = false)
    @Column(name = "modalidades_id_modalidades")
    private int modalidadesIdModalidades;

    public DisciplinasHasModalidadesPK() {
    }

    public DisciplinasHasModalidadesPK(int disciplinasIdDisciplinas, int modalidadesIdModalidades) {
        this.disciplinasIdDisciplinas = disciplinasIdDisciplinas;
        this.modalidadesIdModalidades = modalidadesIdModalidades;
    }

    public int getDisciplinasIdDisciplinas() {
        return disciplinasIdDisciplinas;
    }

    public void setDisciplinasIdDisciplinas(int disciplinasIdDisciplinas) {
        this.disciplinasIdDisciplinas = disciplinasIdDisciplinas;
    }

    public int getModalidadesIdModalidades() {
        return modalidadesIdModalidades;
    }

    public void setModalidadesIdModalidades(int modalidadesIdModalidades) {
        this.modalidadesIdModalidades = modalidadesIdModalidades;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) disciplinasIdDisciplinas;
        hash += (int) modalidadesIdModalidades;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DisciplinasHasModalidadesPK)) {
            return false;
        }
        DisciplinasHasModalidadesPK other = (DisciplinasHasModalidadesPK) object;
        if (this.disciplinasIdDisciplinas != other.disciplinasIdDisciplinas) {
            return false;
        }
        if (this.modalidadesIdModalidades != other.modalidadesIdModalidades) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entidades.DisciplinasHasModalidadesPK[ disciplinasIdDisciplinas=" + disciplinasIdDisciplinas + ", modalidadesIdModalidades=" + modalidadesIdModalidades + " ]";
    }
    
}
