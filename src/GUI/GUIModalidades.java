package GUI;

import DAOs.DAOModalidades;
import Entidades.*;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JToolBar;
import javax.swing.WindowConstants;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.ScrollPane;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.text.SimpleDateFormat;
import java.text.ParseException;
import java.util.List;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JComboBox;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import java.io.File;
import javax.swing.JFileChooser;
import java.awt.Image;
import javax.swing.JTextField;
import tools.*;
import DAOs.*;
import java.util.Objects;

public class GUIModalidades extends JFrame {

    ImageIcon iconeCreate = new ImageIcon(getClass().getResource("/icones/create.png"));
    ImageIcon iconeRetrieve = new ImageIcon(getClass().getResource("/icones/retrieve.png"));
    ImageIcon iconeUpdate = new ImageIcon(getClass().getResource("/icones/update.png"));
    ImageIcon iconeDelete = new ImageIcon(getClass().getResource("/icones/delete.png"));
    ImageIcon iconeSave = new ImageIcon(getClass().getResource("/icones/save.png"));
    ImageIcon iconeCancel = new ImageIcon(getClass().getResource("/icones/cancel.png"));
    ImageIcon iconeListar = new ImageIcon(getClass().getResource("/icones/list.png"));
    JButton btnCreate = new JButton(iconeCreate);
    JButton btnRetrieve = new JButton(iconeRetrieve);
    JButton btnUpdate = new JButton(iconeUpdate);
    JButton btnDelete = new JButton(iconeDelete);
    JButton btnSave = new JButton(iconeSave);
    JButton btnCancel = new JButton(iconeCancel);
    JButton btnList = new JButton(iconeListar);
    private JPanel pnNorte = new JPanel(new FlowLayout(FlowLayout.LEFT));
    private JPanel pnCentro = new JPanel(new GridLayout(1, 2));
    private JPanel pnSul = new JPanel(new GridLayout(1, 1));
    private JLabel lbIdModalidades = new JLabel("IdModalidades");
    private JTextField tfIdModalidades = new JTextField(10);
    private JLabel lbNomeModalidades = new JLabel("NomeModalidades");
    private JTextField tfNomeModalidades = new JTextField(10);
    ScrollPane scroll = new ScrollPane();
    //JLabel lbAluno= new JLabel("Aluno");
    JLabel lbDisciplinas= new JLabel("Disciplinas");

    JTextArea jTextArea = new JTextArea();
    //JTextArea jTextArea2 = new JTextArea();
    JPanel aviso = new JPanel();
    JLabel labelAviso = new JLabel("");
    String qualAcao = "";//variavel para facilitar insert e update
    DAOModalidades daoModalidades = new DAOModalidades();
    Modalidades modalidades;
    private CaixaDeFerramentas ferramentas = new CaixaDeFerramentas();

    public GUIModalidades() {
        setSize(900, 400);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setTitle("CRUD - Modalidades");
        Container cp = getContentPane();
        cp = getContentPane();
        btnCreate.setToolTipText("Inserir novo registro");
        btnRetrieve.setToolTipText("Pesquisar por chave");
        btnUpdate.setToolTipText("Alterar");
        btnDelete.setToolTipText("Excluir");
        btnList.setToolTipText("Listar todos");
        btnSave.setToolTipText("Salvar");
        btnCancel.setToolTipText("Cancelar");
        cp.setLayout(new BorderLayout());
        cp.add(pnNorte, BorderLayout.NORTH);
        cp.add(pnCentro, BorderLayout.CENTER);
        cp.add(pnSul, BorderLayout.SOUTH);
        pnNorte.add(lbIdModalidades);
        pnNorte.add(tfIdModalidades);
        pnNorte.add(btnRetrieve);
        pnNorte.add(btnCreate);
        pnNorte.add(btnUpdate);
        pnNorte.add(btnDelete);
        pnNorte.add(btnSave);
        pnNorte.add(btnList);
        btnCancel.setVisible(false);
        btnDelete.setVisible(false);
        btnCreate.setVisible(false);
        btnSave.setVisible(false);
        btnUpdate.setVisible(false);
        pnCentro.add(lbNomeModalidades);
        pnCentro.add(tfNomeModalidades);
        pnCentro.add(lbDisciplinas);
        //pnCentro.add(jTextArea2);
        //pnCentro.add(lbAluno);
        pnSul.setBackground(Color.red);
        scroll.add(jTextArea);
        //scroll.add(jTextArea2);
        pnSul.add(scroll);
        tfNomeModalidades.setEditable(false);
        btnRetrieve.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    tfIdModalidades.setBackground(Color.white);
                    jTextArea.setText("");
                    //jTextArea2.setText("");
                    modalidades = new Modalidades();
                    int identificador = Integer.valueOf(tfIdModalidades.getText());
                    modalidades.setIdModalidades(identificador);
                    modalidades = daoModalidades.obter(modalidades.getIdModalidades());
                    if (modalidades == null) {
                        pnNorte.setBackground(Color.red);
                        tfNomeModalidades.setText("");
                        btnCreate.setVisible(true);
                    } else {
                        pnNorte.setBackground(Color.green);
                        tfNomeModalidades.setText(modalidades.getNomeModalidades());

//                        DAOAlunoHasModalidades daoAlunoHasModalidades = new DAOAlunoHasModalidades();
//                        List<AlunoHasModalidades> listaAlunoHasModalidades = daoAlunoHasModalidades.list();
//                        //AlunoHasModalidadesPK alunoHasModalidadesPK1 = new AlunoHasModalidadesPK();
//                        String aux3 = "";
//
//                        for (AlunoHasModalidades aux : listaAlunoHasModalidades) {
//
//                            AlunoHasModalidadesPK a = aux.getAlunoHasModalidadesPK();
//
//                            if (Objects.equals(Integer.valueOf(tfIdModalidades.getText()), a.getModalidadesIdModalidades())) {
//                                aux3 += a.getAlunoCpf() + ",";
//                            }
//                        }
//
//                        jTextArea.setText(aux3);

                        DAODisciplinasHasModalidades dAODisciplinasHasModalidades = new DAODisciplinasHasModalidades();
                        List<DisciplinasHasModalidades> listaDisciplinaHasModalidadeses = dAODisciplinasHasModalidades.list();
                        String aux4 = "";

                        for (DisciplinasHasModalidades aux : listaDisciplinaHasModalidadeses) {

                            DisciplinasHasModalidadesPK a = aux.getDisciplinasHasModalidadesPK();

                            if (Integer.valueOf(tfIdModalidades.getText()) == a.getModalidadesIdModalidades()) {
                                aux4 += a.getDisciplinasIdDisciplinas() + ",";
                            }
                        }

                        jTextArea.setText(aux4);

                        btnUpdate.setVisible(true);
                        btnDelete.setVisible(true);
                        btnCreate.setVisible(false);
                    }
                    tfIdModalidades.setEditable(false);
                    tfNomeModalidades.setEditable(false);
                    tfIdModalidades.selectAll();
                } catch (Exception erro) {
                    pnNorte.setBackground(Color.yellow);
                    tfIdModalidades.requestFocus();
                    tfIdModalidades.setBackground(Color.red);
                    jTextArea.setText("Erro... \n");
                    jTextArea.append(erro.getMessage());
                }
            }
        });
        btnCreate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                tfIdModalidades.setEditable(false);
                tfNomeModalidades.requestFocus();
                btnCreate.setVisible(false);
                btnSave.setVisible(true);
                qualAcao = "incluir";
                modalidades = new Modalidades();
                tfNomeModalidades.setEditable(true);
                tfIdModalidades.setEditable(false);
            }
        });
        btnSave.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    // jTextArea.setText("");
                    modalidades = new Modalidades();
                    modalidades.setIdModalidades(Integer.valueOf(tfIdModalidades.getText()));
                    modalidades.setNomeModalidades(tfNomeModalidades.getText());

//                    GUIAlunoModalidades guiAlunoModalidades;
////                    guiAlunoModalidades = new GUIAlunoModalidades(tfCpf.getText(), Integer.valueOf(d11.getIdModalidades()));
//                    DAOAlunoHasModalidades daoAlunoHasModalidades = new DAOAlunoHasModalidades();
//                    AlunoHasModalidadesPK alunoHasModalidadesPK = new AlunoHasModalidadesPK();
//                    AlunoHasModalidades alunoHasModalidades = new AlunoHasModalidades();
//                    
//                    String aux1 = String.valueOf(jTextArea.getText());
//                    System.out.println(aux1);
//                    String[] aux2 = aux1.split(",");
//                    System.out.println("2");
//                    for (String aux22 : aux2) {
//                        System.out.println(String.valueOf("aux2[i]= " + aux22));
//                        int o = 0;
//                        for (String aux21 : aux2) {
//                            if (aux22.equals(aux21)) {
//                                o += 1;
//                                System.out.println("o= " + o);
//                            }
//                        }
//                        if (o < 2) {
//                            System.out.println("tfcpf= " + aux22);
//                            GUIAlunoModalidades a = new GUIAlunoModalidades(String.valueOf(aux22), Integer.valueOf(tfIdModalidades.getText()));
//                        }
//                        System.out.println("deu1");
//                    }
//                    System.out.println("deu2");
                   
                    if (qualAcao.equals("incluir")) {
                        daoModalidades.inserir(modalidades);
                         GUIDisciplinasModalidades guiDisciplinasModalidades;
                    DAODisciplinasHasModalidades dAODisciplinasHasModalidades = new DAODisciplinasHasModalidades();
                    DisciplinasHasModalidadesPK disciplinasHasModalidadesPK = new DisciplinasHasModalidadesPK();
                    DisciplinasHasModalidades disciplinasHasModalidades = new DisciplinasHasModalidades();

                    String aux5 = String.valueOf(jTextArea.getText());
                    System.out.println(aux5);
                    String[] aux6 = aux5.split(",");
                    System.out.println("2");
                    for (int i = 0; i < aux6.length; i++) {
                        System.out.println(String.valueOf("aux6[i]= " + aux6[i]));

                        int o = 0;

                        for (int j = 0; j < aux6.length; j++) {
                            if (aux6[i] == aux6[j]) {
                                o += 1;
                                System.out.println("o= " + o);

                            }

                        }

                        if (o < 2) {
                            System.out.println("tfcpf= " + tfIdModalidades.getText());

                            GUIDisciplinasModalidades a = new GUIDisciplinasModalidades(Integer.valueOf(aux6[i]), Integer.valueOf(tfIdModalidades.getText()));
                        }
                    }

                    } else {
                        daoModalidades.atualizar(modalidades);
                    }
                    tfIdModalidades.setEditable(true);
                    tfIdModalidades.requestFocus();
                    tfNomeModalidades.setText("");
                    btnSave.setVisible(false);
                    jTextArea.setText("");
//                    jTextArea2.setText("");

                    pnNorte.setBackground(Color.green);
                    tfNomeModalidades.setEditable(false);
                } catch (Exception erro) {
                    jTextArea.append("Erro............");
                    tfIdModalidades.setEditable(true);
                    pnNorte.setBackground(Color.red);
                }
            }
        });
        btnUpdate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                btnUpdate.setVisible(false);
                btnDelete.setVisible(false);
                tfNomeModalidades.requestFocus();
                btnSave.setVisible(true);
                qualAcao = "editar";
                tfNomeModalidades.setEditable(true);
            }
        });
        btnDelete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (JOptionPane.YES_OPTION == JOptionPane.showConfirmDialog(null,
                        "Confirma a exclusão do registro <ID = " + modalidades.getIdModalidades() + ">?", "Confirm",
                        JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE)) {

//                    DAOAlunoHasModalidades daoAlunoHasModalidades = new DAOAlunoHasModalidades();
//                    List<AlunoHasModalidades> listaAlunoHasModalidades = daoAlunoHasModalidades.list();
//
//                    for (AlunoHasModalidades aux : listaAlunoHasModalidades) {
//
//                        AlunoHasModalidadesPK a = aux.getAlunoHasModalidadesPK();
//
//                        if (Objects.equals(a.getModalidadesIdModalidades(), Integer.valueOf(tfIdModalidades.getText()))) {
//                            daoAlunoHasModalidades.remover(aux);
//                        }
//
//                    }
                    DAODisciplinasHasModalidades dAODisciplinasHasModalidades = new DAODisciplinasHasModalidades();
                    List<DisciplinasHasModalidades> listaDisciplinasHasModalidades = dAODisciplinasHasModalidades.list();

                    for (DisciplinasHasModalidades aux : listaDisciplinasHasModalidades) {

                        DisciplinasHasModalidadesPK a = aux.getDisciplinasHasModalidadesPK();

                        if (modalidades.getIdModalidades()== a.getModalidadesIdModalidades()) {

                            dAODisciplinasHasModalidades.remover(aux);
                        }

                    }
                    daoModalidades.remover(modalidades);
                    tfIdModalidades.requestFocus();
                    tfNomeModalidades.setText("");
                    jTextArea.setText("");
//                    jTextArea2.setText("");
                    tfIdModalidades.setEditable(true);
                    btnUpdate.setVisible(false);
                    btnDelete.setVisible(false);
                }
            }
        });
        btnList.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                GUIListagemModalidades guiListagem = new GUIListagemModalidades(daoModalidades.list());
            }
        });
//        setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
//        addWindowListener(new WindowAdapter() {
//            @Override
//            public void windowClosing(WindowEvent e) {
//                System.exit(0);
//            }
//        });
        tfIdModalidades.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                List<String> listaAuxiliar = daoModalidades.listInOrderNomeStrings("id");
                if (listaAuxiliar.size() > 0) {
                    String selectedItem = new JanelaPesquisar(listaAuxiliar).getValorRetornado();
                    if (!selectedItem.equals("")) {
                        String[] aux = selectedItem.split("-");
                        tfIdModalidades.setText(aux[0]);
                        btnRetrieve.doClick();

                    } else {
                        tfIdModalidades.requestFocus();
                        tfIdModalidades.selectAll();
                    }
                }
            }
        });
        CentroDoMonitorMaior centroDoMonitorMaior = new CentroDoMonitorMaior();
        setLocation(centroDoMonitorMaior.getCentroMonitorMaior(this));
        setVisible(true);
    }

    public static void main(String[] args) {
        GUIModalidades guiModalidades = new GUIModalidades();
    }
}
