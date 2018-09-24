package DAOs;


import Entidades.Disciplinas;
import DAOs.DAOGenerico;
import static DAOs.DAOGenerico.em;
import java.util.ArrayList;
import java.util.List;

public class DAODisciplinas extends DAOGenerico<Disciplinas> {

    public DAODisciplinas() {
        super(Disciplinas.class);
    }

    public int autoIdDisciplinas() {
        Integer a = (Integer) em.createQuery("SELECT MAX(e.idDisciplinas) FROM Disciplinas e ").getSingleResult();
        if (a != null) {
            return a + 1;
        } else {
            return 1;
        }
    }

    public List<Disciplinas> listByNome(String nome) {
        return em.createQuery("SELECT e FROM Disciplinas e WHERE e.nomeDisciplinas LIKE :nome").setParameter("nome", "%" + nome + "%").getResultList();
    }

    public List<Disciplinas> listById(int id) {
        return em.createQuery("SELECT e FROM Disciplinas e WHERE e.idDisciplinas = :id").setParameter("id", id).getResultList();
    }

    public List<Disciplinas> listInOrderNome() {
        return em.createQuery("SELECT e FROM Disciplinas e ORDER BY e.nomeDisciplinas").getResultList();
    }

    public List<Disciplinas> listInOrderId() {
        return em.createQuery("SELECT e FROM Disciplinas e ORDER BY e.idDisciplinas").getResultList();
    }

    public List<String> listInOrderNomeStrings(String qualOrdem) {
        List<Disciplinas> lf;
        if (qualOrdem.equals("id")) {
            lf = listInOrderId();
        } else {
            lf = listInOrderNome();
        }

        List<String> ls = new ArrayList<>();
        for (int i = 0; i < lf.size(); i++) {
            ls.add(lf.get(i).getIdDisciplinas() + "-" + lf.get(i).getNomeDisciplinas());
        }
        return ls;
    }
public static void main(String[] args) {
        DAODisciplinas daoDisciplinas = new DAODisciplinas();
        List<Disciplinas> listaDisciplinas = daoDisciplinas.list();
        for (Disciplinas disciplinas : listaDisciplinas) {
            System.out.println(disciplinas.getIdDisciplinas() + "-" + disciplinas.getNomeDisciplinas());
        }
    }}
