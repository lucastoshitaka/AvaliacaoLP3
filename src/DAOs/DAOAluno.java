package DAOs;


import Entidades.Aluno;
import DAOs.DAOGenerico;
import static DAOs.DAOGenerico.em;
import java.util.ArrayList;
import java.util.List;

public class DAOAluno extends DAOGenerico<Aluno> {

    public DAOAluno() {
        super(Aluno.class);
    }

    public int autoIdAluno() {
        Integer a = (Integer) em.createQuery("SELECT MAX(e.idAluno) FROM Aluno e ").getSingleResult();
        if (a != null) {
            return a + 1;
        } else {
            return 1;
        }
    }

    public List<Aluno> listByNome(String nome) {
        return em.createQuery("SELECT e FROM Aluno e WHERE e.nome LIKE :nome").setParameter("nome", "%" + nome + "%").getResultList();
    }

    public List<Aluno> listById(int id) {
        return em.createQuery("SELECT e FROM Aluno e WHERE e.cpf = :id").setParameter("id", id).getResultList();
    }

    public List<Aluno> listInOrderNome() {
        return em.createQuery("SELECT e FROM Aluno e ORDER BY e.nome").getResultList();
    }

    public List<Aluno> listInOrderId() {
        return em.createQuery("SELECT e FROM Aluno e ORDER BY e.cpf").getResultList();
    }

    public List<String> listInOrderNomeStrings(String qualOrdem) {
        List<Aluno> lf;
        if (qualOrdem.equals("id")) {
            lf = listInOrderId();
        } else {
            lf = listInOrderNome();
        }

        List<String> ls = new ArrayList<>();
        for (int i = 0; i < lf.size(); i++) {
            ls.add(lf.get(i).getCpf() + "-" + lf.get(i).getNome());
        }
        return ls;
    }
public static void main(String[] args) {
        DAOAluno daoAluno = new DAOAluno();
        List<Aluno> listaAluno = daoAluno.list();
        for (Aluno aluno : listaAluno) {
            System.out.println(aluno.getCpf() + "-" + aluno.getNome());
        }
    }}
