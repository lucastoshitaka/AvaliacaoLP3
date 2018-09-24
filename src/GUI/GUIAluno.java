package GUI;
//import CodigoGerado.GUIListagemAluno;

import DAOs.DAOAluno;
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
import static Entidades.AlunoHasModalidades_.alunoHasModalidadesPK;

public class GUIAluno extends JFrame {
    
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
    private SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
    private Date data3;
    private JPanel pnNorte = new JPanel(new FlowLayout(FlowLayout.LEFT));
    private JPanel pnCentro = new JPanel(new GridLayout(4, 2));
    private JPanel pnSul = new JPanel(new GridLayout(1, 1));
    private JPanel pnE1 = new JPanel(new FlowLayout(FlowLayout.CENTER));
    private JPanel pnE2 = new JPanel(new FlowLayout(FlowLayout.CENTER));
    private JPanel pnE3 = new JPanel(new GridLayout(1, 1));
    private JLabel lbCpf = new JLabel("Cpf");
    private JTextField tfCpf = new JTextField(10);
    private JLabel lbNome = new JLabel("Nome");
    private JTextField tfNome = new JTextField(10);
    private JLabel lbSenha = new JLabel("Senha");
    private JTextField tfSenha = new JTextField(10);
    private JLabel lbDataInscricao = new JLabel("DataInscricao");
    private JTextField tfDataInscricao = new JTextField(10);
    private JButton btEscolha3 = new JButton("Escolha");
    private JPanel pnDataInscricao = new JPanel(new GridLayout(1, 2));
    private JPanel pnEstadoSiglaEstado = new JPanel(new GridLayout(1, 2));
    private JLabel lbEstadoSiglaEstado = new JLabel("EstadoSiglaEstado");
    private JTextField tfEstadoSiglaEstado = new JTextField();
    private JButton btEstadoSiglaEstado = new JButton("Procurar");
    JTextField tfCaminho = new JTextField();
    ScrollPane scroll = new ScrollPane();
    JTextArea jTextArea = new JTextArea();
    JPanel aviso = new JPanel();
    JLabel labelAviso = new JLabel("");
    String qualAcao = "";//variavel para facilitar insert e update
    DAOAluno daoAluno = new DAOAluno();
    Aluno aluno;
    private CaixaDeFerramentas ferramentas = new CaixaDeFerramentas();
    private JPanel pnEsquerda = new JPanel(new BorderLayout());
    private JPanel pnDireita = new JPanel(new BorderLayout());
    private JLabel rotulo = new JLabel();
    private JButton btAbrirImagem = new JButton("Selecionar imagem");
    private String caminho;
    private Image imagemAux;
    
    private ImageIcon icone;

    //JButton btModalidades= new JButton("Modalidades");
//    JLabel lbModalidades = new JLabel("Modalidade");
//    JComboBox cbModalidades = new JComboBox();
    public GUIAluno() {
        setSize(900, 400);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setTitle("CRUD - Aluno");
        Container cp = getContentPane();
        cp = getContentPane();
        btnCreate.setToolTipText("Inserir novo registro");
        btnRetrieve.setToolTipText("Pesquisar por chave");
        btnUpdate.setToolTipText("Alterar");
        btnDelete.setToolTipText("Excluir");
        btnList.setToolTipText("Listar todos");
        btnSave.setToolTipText("Salvar");
        btnCancel.setToolTipText("Cancelar");
        cp.setLayout(new GridLayout(1, 2));
        cp.add(pnEsquerda);
        cp.add(pnDireita);
        try {
            String caminho = "";
            tfCaminho.setText(caminho);
            icone = new ImageIcon(getClass().getResource(caminho));
            imagemAux = icone.getImage();
            icone.setImage(imagemAux.getScaledInstance(300, 300, Image.SCALE_FAST));
            rotulo.setIcon(icone);
        } catch (Exception err) {
            System.out.println("erro " + err.getLocalizedMessage());
        }
        pnDireita.add(pnE1, BorderLayout.NORTH);
        pnE1.add(rotulo);
        pnDireita.add(pnE2, BorderLayout.CENTER);
        pnE2.add(btAbrirImagem);
        pnDireita.add(pnE3, BorderLayout.SOUTH);
        pnE3.add(tfCaminho);
        pnEsquerda.add(pnNorte, BorderLayout.NORTH);
        pnEsquerda.add(pnCentro, BorderLayout.CENTER);
        pnEsquerda.add(pnSul, BorderLayout.SOUTH);
        pnNorte.add(lbCpf);
        pnNorte.add(tfCpf);
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
        btAbrirImagem.setEnabled(false);
        tfCaminho.setEditable(false);
        pnCentro.add(lbNome);
        pnCentro.add(tfNome);
        pnCentro.add(lbSenha);
        pnCentro.add(tfSenha);
        pnCentro.add(lbDataInscricao);
        pnCentro.add(pnDataInscricao);
        pnDataInscricao.add(btEscolha3);
        pnDataInscricao.add(tfDataInscricao);
        pnCentro.add(lbEstadoSiglaEstado);
        pnCentro.add(pnEstadoSiglaEstado);

        // pnCentro.add(btModalidades);
        // btModalidades.setVisible(true);
//        pnCentro.add(lbModalidades);
//        pnCentro.add(cbModalidades);
        pnEstadoSiglaEstado.add(tfEstadoSiglaEstado);
        pnEstadoSiglaEstado.add(btEstadoSiglaEstado);
        pnSul.setBackground(Color.red);
        scroll.add(jTextArea);
        pnSul.add(scroll);
        tfCaminho.setEditable(false);
        tfNome.setEditable(false);
        tfSenha.setEditable(false);
        btEscolha3.setEnabled(false);
        tfDataInscricao.setEditable(false);
        tfEstadoSiglaEstado.setEditable(false);
        btEstadoSiglaEstado.setEnabled(false);
        btnRetrieve.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {

//                    cbModalidades.setVisible(false);
                    tfCpf.setBackground(Color.white);
                    jTextArea.setText("");
                    aluno = new Aluno();
                    String identificador = tfCpf.getText();
                    aluno.setCpf(identificador);
                    aluno = daoAluno.obter(aluno.getCpf());
                    if (aluno == null) {
                        pnNorte.setBackground(Color.red);
                        tfCaminho.setText("");
                        tfNome.setText("");
                        tfSenha.setText("");
                        tfDataInscricao.setText("");
                        tfEstadoSiglaEstado.setText("");
                        btnCreate.setVisible(true);
                    } else {
                        pnNorte.setBackground(Color.green);
                        caminho = aluno.getCaminho();
                        tfCaminho.setText(caminho);
                        icone = new ImageIcon(caminho);
                        imagemAux = icone.getImage();
                        icone.setImage(imagemAux.getScaledInstance(300, 300, Image.SCALE_FAST));
                        rotulo.setIcon(icone);
                        tfNome.setText(aluno.getNome());
                        tfSenha.setText(aluno.getSenha());
                        tfDataInscricao.setText(sdf.format(aluno.getDataInscricao()));
                        String dao1 = String.valueOf(aluno.getEstado());
                        String[] aux1 = dao1.split("-");
                        tfEstadoSiglaEstado.setText(aux1[0]);
                        
                        DAOAlunoHasModalidades daoAlunoHasModalidades = new DAOAlunoHasModalidades();
                        List<AlunoHasModalidades> listaAlunoHasModalidades = daoAlunoHasModalidades.list();
                        //AlunoHasModalidadesPK alunoHasModalidadesPK1 = new AlunoHasModalidadesPK();
                        String aux3 = "";
                        
                        for (AlunoHasModalidades aux : listaAlunoHasModalidades) {
                            
                            AlunoHasModalidadesPK a = aux.getAlunoHasModalidadesPK();
                            
                            if (String.valueOf(a.getAlunoCpf()) == null ? (String.valueOf(tfCpf.getText())) == null : String.valueOf(a.getAlunoCpf()).equals(String.valueOf(tfCpf.getText()))) {
                                aux3 += a.getModalidadesIdModalidades()+",";
                            }
                        }
                        
                        jTextArea.setText(aux3);
//                        GUIAlunoModalidades guiAlunoModalidades = new GUIAlunoModalidades();
//                        jTextArea.setText(guiAlunoModalidades.GUIAlunoModalidadesBuscarNomeModalidade(tfCpf.getText()));
//                        

                        btnUpdate.setVisible(true);
                        btnDelete.setVisible(true);
                        btnCreate.setVisible(false);
                    }
                    btAbrirImagem.setEnabled(false);
                    tfCpf.setEditable(false);
                    tfNome.setEditable(false);
                    tfSenha.setEditable(false);
                    tfDataInscricao.setEditable(false);
                    btEstadoSiglaEstado.setEnabled(false);
                    tfCpf.selectAll();
                } catch (Exception erro) {
                    pnNorte.setBackground(Color.yellow);
                    tfCpf.requestFocus();
                    tfCpf.setBackground(Color.red);
                    jTextArea.setText("Erro... \n");
                    jTextArea.append(erro.getMessage());
                }
            }
        });
        btnCreate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                tfCpf.setEditable(false);
                tfNome.requestFocus();
                btnCreate.setVisible(false);
                btnSave.setVisible(true);
                qualAcao = "incluir";
                aluno = new Aluno();
                tfNome.setEditable(true);
                tfSenha.setEditable(true);
                btEscolha3.setEnabled(true);
                btEstadoSiglaEstado.setEnabled(true);
                tfCpf.setEditable(false);
                btAbrirImagem.setEnabled(true);

//                cbModalidades.setVisible(true);
//                DAOAlunoHasModalidades daoAlunoHasModalidades = new DAOAlunoHasModalidades();
//                List<AlunoHasModalidades> listaAlunoHasModalidades = daoAlunoHasModalidades.list();
//                for (AlunoHasModalidades aux3 : listaAlunoHasModalidades) {
//                cbModalidades.addItem(aux3.toString());
//                }
            }
        });

////        btModalidades.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                GUIAlunoModalidadesTable guiAlunoModalidadesTable = new GUIAlunoModalidadesTable();
//                
//            }
//        });
        btnSave.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    // jTextArea.setText("");
                    aluno = new Aluno();
                    aluno.setCpf(tfCpf.getText());
                    aluno.setNome(tfNome.getText());
                    aluno.setSenha(tfSenha.getText());
                    sdf.setLenient(false);
                    data3 = sdf.parse(tfDataInscricao.getText());
                    try {
                        aluno.setDataInscricao(sdf.parse(tfDataInscricao.getText()));
                    } catch (ParseException ex) {
                        Logger.getLogger(GUIAluno.class
                                .getName()).log(Level.SEVERE, null, ex);
                    }
                    String[] aux0 = tfEstadoSiglaEstado.getText().split("-");
                    DAOEstado daoEstado = new DAOEstado();
                    Estado d0 = daoEstado.obter(String.valueOf(aux0[0]));
                    aluno.setEstado(d0);
                    caminho = tfCaminho.getText();
                    aluno.setCaminho(caminho);
                    caminho = "";
                    icone = new ImageIcon(caminho);
                    rotulo.setIcon(icone);

//                    DAOModalidades daoModalidades = new DAOModalidades();
//                    Modalidades d11 = daoModalidades.obter(String.valueOf(cbModalidades.getSelectedItem()));
//
                    
                    
                    if (qualAcao.equals("incluir")) {
                        daoAluno.inserir(aluno);
                        GUIAlunoModalidades guiAlunoModalidades;
//                    guiAlunoModalidades = new GUIAlunoModalidades(tfCpf.getText(), Integer.valueOf(d11.getIdModalidades()));
                    DAOAlunoHasModalidades daoAlunoHasModalidades = new DAOAlunoHasModalidades();
                    AlunoHasModalidadesPK alunoHasModalidadesPK = new AlunoHasModalidadesPK();
                    AlunoHasModalidades alunoHasModalidades = new AlunoHasModalidades();
                    
                    String aux1 = String.valueOf(jTextArea.getText());
                    System.out.println(aux1);
                    String[] aux2 = aux1.split(",");
                    System.out.println("2");
                    for (String aux22 : aux2) {
                        System.out.println(String.valueOf("aux2[i]= " + aux22));
                        int o = 0;
                        for (String aux21 : aux2) {
                            if (aux22 == aux21) {
                                o += 1;
                                System.out.println("o= " + o);
                            }
                        }
                        if (o < 2) {
                            System.out.println("tfcpf= " + tfCpf.getText());
                            GUIAlunoModalidades a = new GUIAlunoModalidades(String.valueOf(tfCpf.getText()), Integer.valueOf(aux22));
                        }
                    }
                        System.out.println("3");
                    } else {
                        daoAluno.atualizar(aluno);
                        System.out.println("4");
                    }
                    tfCpf.setEditable(true);
                    tfCpf.requestFocus();
                    tfNome.setText("");
                    tfSenha.setText("");
                    tfDataInscricao.setText("");
                    tfEstadoSiglaEstado.setText("");
                    tfCaminho.setText("");
                    
                    jTextArea.setText("");
                    btnSave.setVisible(false);
                    pnNorte.setBackground(Color.green);
                    tfNome.setEditable(false);
                    tfSenha.setEditable(false);
                    btEscolha3.setEnabled(false);
                    btEstadoSiglaEstado.setEnabled(false);
                    btAbrirImagem.setEnabled(false);
                } catch (Exception erro) {
                    jTextArea.append("Erro............");
                    tfCpf.setEditable(true);
                    pnNorte.setBackground(Color.red);
                }
            }
        });
        btnUpdate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                btnUpdate.setVisible(false);
                btnDelete.setVisible(false);
                btAbrirImagem.setEnabled(true);
                tfNome.requestFocus();
                btnSave.setVisible(true);
                qualAcao = "editar";
                tfNome.setEditable(true);
                tfSenha.setEditable(true);
                btEscolha3.setEnabled(true);
                btEstadoSiglaEstado.setEnabled(true);
            }
        });
        btnDelete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (JOptionPane.YES_OPTION == JOptionPane.showConfirmDialog(null,
                        "Confirma a exclusão do registro <ID = " + aluno.getCpf() + ">?", "Confirm",
                        JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE)) {
                    
                    DAOAlunoHasModalidades daoAlunoHasModalidades = new DAOAlunoHasModalidades();
                    List<AlunoHasModalidades> listaAlunoHasModalidades = daoAlunoHasModalidades.list();
                    
                    for (AlunoHasModalidades aux : listaAlunoHasModalidades) {
                        
                        AlunoHasModalidadesPK a = aux.getAlunoHasModalidadesPK();
                        
                        if (aluno.getCpf() == null ? a.getAlunoCpf() == null : aluno.getCpf().equals(a.getAlunoCpf())) {
                            daoAlunoHasModalidades.remover(aux);
                        }
                        
                    }
                    jTextArea.setText("");
                    daoAluno.remover(aluno);
                    
                    tfCpf.requestFocus();
                    tfNome.setText("");
                    tfSenha.setText("");
                    tfDataInscricao.setText("");
                    tfEstadoSiglaEstado.setText("");
                    String caminho = "";
                    
                    icone = new ImageIcon(caminho);
                    rotulo.setIcon(icone);
                    
                    tfCaminho.setText("");
                    tfCpf.setEditable(true);
                    btnUpdate.setVisible(false);
                    btnDelete.setVisible(false);
                }
            }
        });
        btnList.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                GUIListagemAluno guiListagem = new GUIListagemAluno(daoAluno.list());
            }
        });
//        setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
//        addWindowListener(new WindowAdapter() {
//            @Override
//            public void windowClosing(WindowEvent e) {
//                System.exit(0);
//            }
//        });
        btEscolha3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    jTextArea.setText("");
                    DateChooser dc3 = new DateChooser((JFrame) null, "Escolha uma data");
                    data3 = dc3.select();
                    tfDataInscricao.setText(sdf.format(data3));
                } catch (Exception ex) {
                    jTextArea.setText("Escolha uma data\n");
                }
            }
        });
        btAbrirImagem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser fc = new JFileChooser();
                fc.setFileSelectionMode(JFileChooser.FILES_ONLY);
                if (fc.showOpenDialog(pnDireita) == JFileChooser.APPROVE_OPTION) {
                    File img = fc.getSelectedFile();
                    String caminho = fc.getSelectedFile().getAbsolutePath();
                    try {
                        tfCaminho.setText(caminho);
                        icone = new javax.swing.ImageIcon(img.getAbsolutePath());
                        imagemAux = icone.getImage();
                        icone.setImage(imagemAux.getScaledInstance(300, 300, Image.SCALE_FAST));
                        rotulo.setIcon(icone);
                    } catch (Exception ex) {
                        System.out.println("Erro: " + ex.getMessage());
                    }
                }
            }
        });
        DAOEstado daoEstado = new DAOEstado();
        btEstadoSiglaEstado.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                List<String> listaAuxiliar = daoEstado.listInOrderNomeStrings("id");
                if (listaAuxiliar.size() > 0) {
                    String selectedItem = new JanelaPesquisar(listaAuxiliar).getValorRetornado();
                    if (!selectedItem.equals("")) {
                        String[] aux = selectedItem.split("-");
                        tfEstadoSiglaEstado.setText(aux[0]);
                    } else {
                        jTextArea.setText("Nenhum dado adicionado!");
                    }
                }
            }
        });
        tfCpf.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                List<String> listaAuxiliar = daoAluno.listInOrderNomeStrings("id");
                if (listaAuxiliar.size() > 0) {
                    String selectedItem = new JanelaPesquisar(listaAuxiliar).getValorRetornado();
                    if (!selectedItem.equals("")) {
                        String[] aux = selectedItem.split("-");
                        tfCpf.setText(aux[0]);
                        btnRetrieve.doClick();
                        
                    } else {
                        tfCpf.requestFocus();
                        tfCpf.selectAll();
                    }
                }
            }
        });
        CentroDoMonitorMaior centroDoMonitorMaior = new CentroDoMonitorMaior();
        setLocation(centroDoMonitorMaior.getCentroMonitorMaior(this));
        setVisible(true);
    }
    
    public static void main(String[] args) {
        GUIAluno guiAluno = new GUIAluno();
    }
}
