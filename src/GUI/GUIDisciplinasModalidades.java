/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import DAOs.DAOAluno;
import DAOs.DAODisciplinasHasModalidades;
import Entidades.Aluno;
import Entidades.DisciplinasHasModalidades;
import Entidades.DisciplinasHasModalidadesPK;

/**
 *
 * @author lucastoshitaka
 */
public class GUIDisciplinasModalidades {

    DisciplinasHasModalidadesPK disciplinasHasModalidadesPK = new DisciplinasHasModalidadesPK();
    DisciplinasHasModalidades disciplinasHasModalidades = new DisciplinasHasModalidades();
    DAODisciplinasHasModalidades daoDisciplinasHasModalidades = new DAODisciplinasHasModalidades();

     GUIDisciplinasModalidades() {
    }
     
    public GUIDisciplinasModalidades(int disciplinaPK, int modalidadePK) {

        
        disciplinasHasModalidadesPK.setDisciplinasIdDisciplinas(disciplinaPK);
        disciplinasHasModalidadesPK.setModalidadesIdModalidades(modalidadePK);

        disciplinasHasModalidades.setDisciplinasHasModalidadesPK(disciplinasHasModalidadesPK);

        daoDisciplinasHasModalidades.inserir(disciplinasHasModalidades);

    }


    

}
