package DAOs;

import Entidades.AlunoHasModalidadesPK;
import java.util.ArrayList;
import java.util.List;

public class DAOAlunoHasModalidadesPK extends DAOGenerico<AlunoHasModalidadesPK> {

    private List<AlunoHasModalidadesPK> lista = new ArrayList<>();

    public DAOAlunoHasModalidadesPK() {
        super(AlunoHasModalidadesPK.class);
    }

    public static void main(String[] args) {
        DAOAlunoHasModalidadesPK daoAlunoHasModalidadesPK = new DAOAlunoHasModalidadesPK();
        List<AlunoHasModalidadesPK> listaAlunoHasModalidadesPK = daoAlunoHasModalidadesPK.list();
        for (AlunoHasModalidadesPK precoProdutoPK : listaAlunoHasModalidadesPK) {
            System.out.println(precoProdutoPK.getModalidadesIdModalidades()+ "-" + precoProdutoPK.getAlunoCpf());
        }
    }
}
