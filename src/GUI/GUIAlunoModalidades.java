/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import DAOs.DAOAluno;
import DAOs.DAOAlunoHasModalidades;
import Entidades.Aluno;
import Entidades.AlunoHasModalidades;
import Entidades.AlunoHasModalidadesPK;

/**
 *
 * @author lucastoshitaka
 */
public class GUIAlunoModalidades {

    AlunoHasModalidadesPK alunoHasModalidadesPK = new AlunoHasModalidadesPK();
    AlunoHasModalidades alunoHasModalidades = new AlunoHasModalidades();
    DAOAlunoHasModalidades daoAlunoHasModalidades = new DAOAlunoHasModalidades();

     GUIAlunoModalidades() {
    }
     
    public GUIAlunoModalidades(String alunoPK, int modalidadePK) {


        alunoHasModalidadesPK.setAlunoCpf(alunoPK);
        alunoHasModalidadesPK.setModalidadesIdModalidades(modalidadePK);

        alunoHasModalidades.setAlunoHasModalidadesPK(alunoHasModalidadesPK);
        daoAlunoHasModalidades.inserir(alunoHasModalidades);

    }


    
public static void main(String[] args) {
    GUIAlunoModalidades guiAlunoModalidades = new GUIAlunoModalidades("112", 3);    }
}
