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
public class AlunoHasModalidadesPK implements Serializable {

    @Basic(optional = false)
    @Column(name = "aluno_cpf")
    private String alunoCpf;
    @Basic(optional = false)
    @Column(name = "modalidades_id_modalidades")
    private int modalidadesIdModalidades;

    public AlunoHasModalidadesPK() {
    }

    public AlunoHasModalidadesPK(String alunoCpf, int modalidadesIdModalidades) {
        this.alunoCpf = alunoCpf;
        this.modalidadesIdModalidades = modalidadesIdModalidades;
    }

    public String getAlunoCpf() {
        return alunoCpf;
    }

    public void setAlunoCpf(String alunoCpf) {
        this.alunoCpf = alunoCpf;
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
        hash += (alunoCpf != null ? alunoCpf.hashCode() : 0);
        hash += (int) modalidadesIdModalidades;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AlunoHasModalidadesPK)) {
            return false;
        }
        AlunoHasModalidadesPK other = (AlunoHasModalidadesPK) object;
        if ((this.alunoCpf == null && other.alunoCpf != null) || (this.alunoCpf != null && !this.alunoCpf.equals(other.alunoCpf))) {
            return false;
        }
        if (this.modalidadesIdModalidades != other.modalidadesIdModalidades) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return modalidadesIdModalidades + "";
    }
    
}
