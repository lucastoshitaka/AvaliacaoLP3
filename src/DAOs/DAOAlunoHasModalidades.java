package DAOs;
import Entidades.AlunoHasModalidades;
import java.util.ArrayList;
import java.util.List;

public class DAOAlunoHasModalidades extends DAOGenerico<AlunoHasModalidades> {

    public DAOAlunoHasModalidades() {
        super(AlunoHasModalidades.class);
    }

    public int autoIdAlunoHasModalidades() {
        Integer a = (Integer) em.createQuery("SELECT MAX(e.idAlunoHasModalidades) FROM AlunoHasModalidades e ").getSingleResult();
        if (a != null) {
            return a + 1;
        } else {
            return 1;
        }
    }

    public List<AlunoHasModalidades> listByNome(String modalidades) {
        return em.createQuery("SELECT e FROM AlunoHasModalidades e WHERE e.modalidades LIKE :modalidades").setParameter("modalidades", "%" + modalidades + "%").getResultList();
    }

    public List<AlunoHasModalidades> listById(int id) {
        return em.createQuery("SELECT e FROM AlunoHasModalidades e WHERE e.idAlunoHasModalidades = :id").setParameter("id", id).getResultList();
    }

    public List<AlunoHasModalidades> listInOrderNome() {
        return em.createQuery("SELECT e FROM AlunoHasModalidades e ORDER BY e.modalidades").getResultList();
    }

    public List<AlunoHasModalidades> listInOrderId() {
        return em.createQuery("SELECT e FROM AlunoHasModalidades e ORDER BY e.idAlunoHasModalidades").getResultList();
    }

    public List<String> listInOrderNomeStrings(String qualOrdem) {
        List<AlunoHasModalidades> lf;
        if (qualOrdem.equals("id")) {
            lf = listInOrderId();
        } else {
            lf = listInOrderNome();
        }

        List<String> ls = new ArrayList<>();
        for (int i = 0; i < lf.size(); i++) {
            ls.add(lf.get(i).getAlunoHasModalidadesPK()
 + "-" + lf.get(i).getModalidades()
);
        }
        return ls;
    }
}
