package DAOs;


import Entidades.Estado;
import DAOs.DAOGenerico;
import static DAOs.DAOGenerico.em;
import java.util.ArrayList;
import java.util.List;

public class DAOEstado extends DAOGenerico<Estado> {

    public DAOEstado() {
        super(Estado.class);
    }

    public int autoIdEstado() {
        Integer a = (Integer) em.createQuery("SELECT MAX(e.idEstado) FROM Estado e ").getSingleResult();
        if (a != null) {
            return a + 1;
        } else {
            return 1;
        }
    }

    public List<Estado> listByNome(String nome) {
        return em.createQuery("SELECT e FROM Estado e WHERE e.nomeEstado LIKE :nome").setParameter("nome", "%" + nome + "%").getResultList();
    }

    public List<Estado> listById(int id) {
        return em.createQuery("SELECT e FROM Estado e WHERE e.siglaEstado = :id").setParameter("id", id).getResultList();
    }

    public List<Estado> listInOrderNome() {
        return em.createQuery("SELECT e FROM Estado e ORDER BY e.nomeEstado").getResultList();
    }

    public List<Estado> listInOrderId() {
        return em.createQuery("SELECT e FROM Estado e ORDER BY e.siglaEstado").getResultList();
    }

    public List<String> listInOrderNomeStrings(String qualOrdem) {
        List<Estado> lf;
        if (qualOrdem.equals("id")) {
            lf = listInOrderId();
        } else {
            lf = listInOrderNome();
        }

        List<String> ls = new ArrayList<>();
        for (int i = 0; i < lf.size(); i++) {
            ls.add(lf.get(i).getSiglaEstado() + "-" + lf.get(i).getNomeEstado());
        }
        return ls;
    }
public static void main(String[] args) {
        DAOEstado daoEstado = new DAOEstado();
        List<Estado> listaEstado = daoEstado.list();
        for (Estado estado : listaEstado) {
            System.out.println(estado.getSiglaEstado() + "-" + estado.getNomeEstado());
        }
    }}
