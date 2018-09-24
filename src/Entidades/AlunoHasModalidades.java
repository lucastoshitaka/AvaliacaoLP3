/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidades;

import DAOs.DAOModalidades;
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
@Table(name = "aluno_has_modalidades")
@NamedQueries({
    @NamedQuery(name = "AlunoHasModalidades.findAll", query = "SELECT a FROM AlunoHasModalidades a")})
public class AlunoHasModalidades implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    public AlunoHasModalidadesPK alunoHasModalidadesPK;
    @JoinColumns({
        @JoinColumn(name = "aluno_cpf", referencedColumnName = "cpf", insertable = false, updatable = false)
        , @JoinColumn(name = "aluno_cpf", referencedColumnName = "cpf", insertable = false, updatable = false)})
    @OneToOne(optional = false)
    private Aluno aluno;
    @JoinColumns({
        @JoinColumn(name = "modalidades_id_modalidades", referencedColumnName = "id_modalidades", insertable = false, updatable = false)
        , @JoinColumn(name = "modalidades_id_modalidades", referencedColumnName = "id_modalidades", insertable = false, updatable = false)})
    @OneToOne(optional = false)
    private Modalidades modalidades;

    public AlunoHasModalidades() {
    }

    public AlunoHasModalidades(AlunoHasModalidadesPK alunoHasModalidadesPK) {
        this.alunoHasModalidadesPK = alunoHasModalidadesPK;
    }

    public AlunoHasModalidades(String alunoCpf, int modalidadesIdModalidades) {
        this.alunoHasModalidadesPK = new AlunoHasModalidadesPK(alunoCpf, modalidadesIdModalidades);
    }

    public AlunoHasModalidadesPK getAlunoHasModalidadesPK() {
        return alunoHasModalidadesPK;
    }

    public void setAlunoHasModalidadesPK(AlunoHasModalidadesPK alunoHasModalidadesPK) {
        this.alunoHasModalidadesPK = alunoHasModalidadesPK;
    }

    public Aluno getAluno() {
        return aluno;
    }

    public void setAluno(Aluno aluno) {
        this.aluno = aluno;
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
        hash += (alunoHasModalidadesPK != null ? alunoHasModalidadesPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AlunoHasModalidades)) {
            return false;
        }
        AlunoHasModalidades other = (AlunoHasModalidades) object;
        if ((this.alunoHasModalidadesPK == null && other.alunoHasModalidadesPK != null) || (this.alunoHasModalidadesPK != null && !this.alunoHasModalidadesPK.equals(other.alunoHasModalidadesPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
                System.out.println(alunoHasModalidadesPK);

        return alunoHasModalidadesPK + "";
    }
 public static void main(String[] args) {
     AlunoHasModalidades alunoHasModalidades = new AlunoHasModalidades();
 }}
