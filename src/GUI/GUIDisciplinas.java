package GUI;

import DAOs.DAODisciplinas;
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

public class GUIDisciplinas extends JFrame {

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
    private JLabel lbIdDisciplinas = new JLabel("IdDisciplinas");
    private JTextField tfIdDisciplinas = new JTextField(10);
    private JLabel lbNomeDisciplinas = new JLabel("NomeDisciplinas");
    private JTextField tfNomeDisciplinas = new JTextField(10);
    ScrollPane scroll = new ScrollPane();
    JTextArea jTextArea = new JTextArea();
    JPanel aviso = new JPanel();
    JLabel labelAviso = new JLabel("");
    String qualAcao = "";//variavel para facilitar insert e update
    DAODisciplinas daoDisciplinas = new DAODisciplinas();
    Disciplinas disciplinas;
    private CaixaDeFerramentas ferramentas = new CaixaDeFerramentas();

    public GUIDisciplinas() {
        setSize(900, 400);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setTitle("CRUD - Disciplinas");
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
        pnNorte.add(lbIdDisciplinas);
        pnNorte.add(tfIdDisciplinas);
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
        pnCentro.add(lbNomeDisciplinas);
        pnCentro.add(tfNomeDisciplinas);
        pnSul.setBackground(Color.red);
        scroll.add(jTextArea);
        pnSul.add(scroll);
        tfNomeDisciplinas.setEditable(false);
        btnRetrieve.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    tfIdDisciplinas.setBackground(Color.white);
                    jTextArea.setText("");
                    disciplinas = new Disciplinas();
                    int identificador = Integer.valueOf(tfIdDisciplinas.getText());
                    disciplinas.setIdDisciplinas(identificador);
                    disciplinas = daoDisciplinas.obter(disciplinas.getIdDisciplinas());
                    if (disciplinas == null) {
                        pnNorte.setBackground(Color.red);
                        tfNomeDisciplinas.setText("");
                        btnCreate.setVisible(true);
                    } else {
                        pnNorte.setBackground(Color.green);
                        tfNomeDisciplinas.setText(disciplinas.getNomeDisciplinas());

                        DAODisciplinasHasModalidades daoDisciplinasHasModalidades = new DAODisciplinasHasModalidades();
                        List<DisciplinasHasModalidades> listaDisciplinasHasModalidades = daoDisciplinasHasModalidades.list();

                        String aux3 = "";

                        for (DisciplinasHasModalidades aux : listaDisciplinasHasModalidades) {

                            DisciplinasHasModalidadesPK a = aux.getDisciplinasHasModalidadesPK();

                            if (String.valueOf(a.getDisciplinasIdDisciplinas()) == null ? (String.valueOf(tfIdDisciplinas.getText())) == null : String.valueOf(a.getDisciplinasIdDisciplinas()).equals(String.valueOf(tfIdDisciplinas.getText()))) {
                                aux3 += a.getModalidadesIdModalidades();
                            }
                        }

                        jTextArea.setText(aux3);

                        btnUpdate.setVisible(true);
                        btnDelete.setVisible(true);
                        btnCreate.setVisible(false);
                    }
                    tfIdDisciplinas.setEditable(false);
                    tfNomeDisciplinas.setEditable(false);
                    tfIdDisciplinas.selectAll();
                } catch (Exception erro) {
                    pnNorte.setBackground(Color.yellow);
                    tfIdDisciplinas.requestFocus();
                    tfIdDisciplinas.setBackground(Color.red);
                    jTextArea.setText("Erro... \n");
                    jTextArea.append(erro.getMessage());
                }
            }
        });
        btnCreate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                tfIdDisciplinas.setEditable(false);
                tfNomeDisciplinas.requestFocus();
                btnCreate.setVisible(false);
                btnSave.setVisible(true);
                qualAcao = "incluir";
                disciplinas = new Disciplinas();
                tfNomeDisciplinas.setEditable(true);
                tfIdDisciplinas.setEditable(false);
            }
        });
        btnSave.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    //jTextArea.setText("");
                    disciplinas = new Disciplinas();
                    disciplinas.setIdDisciplinas(Integer.valueOf(tfIdDisciplinas.getText()));
                    disciplinas.setNomeDisciplinas(tfNomeDisciplinas.getText());
                    
                   
                    
                    if (qualAcao.equals("incluir")) {
                        daoDisciplinas.inserir(disciplinas);
                         GUIAlunoModalidades guiAlunoModalidades;
//                    guiAlunoModalidades = new GUIAlunoModalidades(tfCpf.getText(), Integer.valueOf(d11.getIdModalidades()));
                    DAOAlunoHasModalidades daoAlunoHasModalidades = new DAOAlunoHasModalidades();
                    AlunoHasModalidadesPK alunoHasModalidadesPK = new AlunoHasModalidadesPK();
                    AlunoHasModalidades alunoHasModalidades = new AlunoHasModalidades();
                    
                    String aux1 = String.valueOf(jTextArea.getText());
                    System.out.println(aux1);
                    String[] aux2 = aux1.split(",");
                    System.out.println("2");
                    for (int i = 0; i < aux2.length; i++) {
                        System.out.println(String.valueOf("aux2[i]= " + aux2[i]));
                        
                        int o = 0;
                        
                        for (int j = 0; j < aux2.length; j++) {
                            if (aux2[i] == aux2[j]) {
                                o += 1;
                                System.out.println("o= " + o);
                                
                            }
                            
                        }
                        
                        if (o < 2) {
                            System.out.println("tfcpf= " + tfIdDisciplinas.getText());
                            
                            GUIDisciplinasModalidades a = new GUIDisciplinasModalidades(Integer.valueOf(tfIdDisciplinas.getText()), Integer.valueOf(aux2[i]));
                        }
                    }
                    } else {
                        daoDisciplinas.atualizar(disciplinas);
                    }
                    tfIdDisciplinas.setEditable(true);
                    tfIdDisciplinas.requestFocus();
                    tfNomeDisciplinas.setText("");
                    btnSave.setVisible(false);
                    jTextArea.setText("");
                    pnNorte.setBackground(Color.green);
                    tfNomeDisciplinas.setEditable(false);
                } catch (Exception erro) {
                    jTextArea.append("Erro............");
                    tfIdDisciplinas.setEditable(true);
                    pnNorte.setBackground(Color.red);
                }
            }
        });
        btnUpdate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                btnUpdate.setVisible(false);
                btnDelete.setVisible(false);
                tfNomeDisciplinas.requestFocus();
                btnSave.setVisible(true);
                qualAcao = "editar";
                tfNomeDisciplinas.setEditable(true);
            }
        });
        btnDelete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (JOptionPane.YES_OPTION == JOptionPane.showConfirmDialog(null,
                        "Confirma a exclusão do registro <ID = " + disciplinas.getIdDisciplinas() + ">?", "Confirm",
                        JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE)) {
                    
                     DAODisciplinasHasModalidades dAODisciplinasHasModalidades = new DAODisciplinasHasModalidades();
                    List<DisciplinasHasModalidades> listaDisciplinasHasModalidades = dAODisciplinasHasModalidades.list();
                    
                    for (DisciplinasHasModalidades aux : listaDisciplinasHasModalidades) {
                        
                        DisciplinasHasModalidadesPK a = aux.getDisciplinasHasModalidadesPK();
                        
                        if (disciplinas.getIdDisciplinas()==a.getDisciplinasIdDisciplinas()) {
                       
                            dAODisciplinasHasModalidades.remover(aux);
                         }
                        
                    }
                    
                    jTextArea.setText("");
                    daoDisciplinas.remover(disciplinas);
                    tfIdDisciplinas.requestFocus();
                    tfNomeDisciplinas.setText("");
                    tfIdDisciplinas.setEditable(true);
                    btnUpdate.setVisible(false);
                    btnDelete.setVisible(false);
                }
            }
        });
        btnList.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                GUIListagemDisciplinas guiListagem = new GUIListagemDisciplinas(daoDisciplinas.list());
            }
        });
//        setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
//        addWindowListener(new WindowAdapter() {
//            @Override
//            public void windowClosing(WindowEvent e) {
//                System.exit(0);
//            }
//        });
        tfIdDisciplinas.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                List<String> listaAuxiliar = daoDisciplinas.listInOrderNomeStrings("id");
                if (listaAuxiliar.size() > 0) {
                    String selectedItem = new JanelaPesquisar(listaAuxiliar).getValorRetornado();
                    if (!selectedItem.equals("")) {
                        String[] aux = selectedItem.split("-");
                        tfIdDisciplinas.setText(aux[0]);
                        btnRetrieve.doClick();

                    } else {
                        tfIdDisciplinas.requestFocus();
                        tfIdDisciplinas.selectAll();
                    }
                }
            }
        });
        CentroDoMonitorMaior centroDoMonitorMaior = new CentroDoMonitorMaior();
        setLocation(centroDoMonitorMaior.getCentroMonitorMaior(this));
        setVisible(true);
    }

    public static void main(String[] args) {
        GUIDisciplinas guiDisciplinas = new GUIDisciplinas();
    }
}
