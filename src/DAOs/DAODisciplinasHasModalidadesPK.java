package DAOs;

import Entidades.DisciplinasHasModalidadesPK;
import java.util.ArrayList;
import java.util.List;

public class DAODisciplinasHasModalidadesPK extends DAOGenerico<DisciplinasHasModalidadesPK> {

    private List<DisciplinasHasModalidadesPK> lista = new ArrayList<>();

    public DAODisciplinasHasModalidadesPK() {
        super(DisciplinasHasModalidadesPK.class);
    }

    public static void main(String[] args) {
        DAODisciplinasHasModalidadesPK daoDisciplinasHasModalidadesPK = new DAODisciplinasHasModalidadesPK();
        List<DisciplinasHasModalidadesPK> listaDisciplinasHasModalidadesPK = daoDisciplinasHasModalidadesPK.list();
        for (DisciplinasHasModalidadesPK precoProdutoPK : listaDisciplinasHasModalidadesPK) {
            System.out.println(precoProdutoPK.getModalidadesIdModalidades()+ "-" + precoProdutoPK.getDisciplinasIdDisciplinas());
        }
    }
}
