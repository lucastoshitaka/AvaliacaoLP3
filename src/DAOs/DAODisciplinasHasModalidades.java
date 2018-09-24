package DAOs;
import Entidades.DisciplinasHasModalidades;
import java.util.ArrayList;
import java.util.List;

public class DAODisciplinasHasModalidades extends DAOGenerico<DisciplinasHasModalidades> {

    public DAODisciplinasHasModalidades() {
        super(DisciplinasHasModalidades.class);
    }

    public int autoIdDisciplinasHasModalidades() {
        Integer a = (Integer) em.createQuery("SELECT MAX(e.idDisciplinasHasModalidades) FROM DisciplinasHasModalidades e ").getSingleResult();
        if (a != null) {
            return a + 1;
        } else {
            return 1;
        }
    }

    public List<DisciplinasHasModalidades> listByNome(String modalidades) {
        return em.createQuery("SELECT e FROM DisciplinasHasModalidades e WHERE e.modalidades LIKE :modalidades").setParameter("modalidades", "%" + modalidades + "%").getResultList();
    }

    public List<DisciplinasHasModalidades> listById(int id) {
        return em.createQuery("SELECT e FROM DisciplinasHasModalidades e WHERE e.idDisciplinasHasModalidades = :id").setParameter("id", id).getResultList();
    }

    public List<DisciplinasHasModalidades> listInOrderNome() {
        return em.createQuery("SELECT e FROM DisciplinasHasModalidades e ORDER BY e.modalidades").getResultList();
    }

    public List<DisciplinasHasModalidades> listInOrderId() {
        return em.createQuery("SELECT e FROM DisciplinasHasModalidades e ORDER BY e.idDisciplinasHasModalidades").getResultList();
    }

    public List<String> listInOrderNomeStrings(String qualOrdem) {
        List<DisciplinasHasModalidades> lf;
        if (qualOrdem.equals("id")) {
            lf = listInOrderId();
        } else {
            lf = listInOrderNome();
        }

        List<String> ls = new ArrayList<>();
        for (int i = 0; i < lf.size(); i++) {
            ls.add(lf.get(i).getDisciplinasHasModalidadesPK()
 + "-" + lf.get(i).getModalidades()
);
        }
        return ls;
    }
}
