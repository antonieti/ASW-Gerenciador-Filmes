
package br.edu.ifsp.cmp.gerenciamentofilmes.view;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.GraphicsEnvironment;
import java.awt.Image;
import java.awt.Insets;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.io.File;
import java.io.IOException;
import java.util.List;
import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.plaf.basic.BasicTabbedPaneUI;

import br.edu.ifsp.cmp.gerenciamentofilmes.controller.Controller;
import br.edu.ifsp.cmp.gerenciamentofilmes.models.Movie;
import br.edu.ifsp.cmp.gerenciamentofilmes.models.MovieList;
import br.edu.ifsp.cmp.gerenciamentofilmes.models.User;
import lombok.extern.log4j.Log4j2;
import net.miginfocom.swing.MigLayout;

@Log4j2
public class View {

    public static User user;
    private static Point point = new Point();
    private ImageIcon userIcon;
    private ImageIcon passwordIcon;
    private ImageIcon addIcon;
    private ImageIcon addSelectIcon;
    private ImageIcon logoutIcon;
    private ImageIcon logoutSelectedIcon;
    private ImageIcon closeIcon;
    private ImageIcon minIcon;
    private Image image;
    private Image newimg;
    private JFrame window;
    private JMenuBar menuBar;
    private JMenu miniButton;
    private JMenu closeButton;
    private JPanel root;
    private JPanel login;
    private JLabel logo;
    private JLabel userLabel;
    private JTextField textlogin;
    private JLabel passLabel;
    private JPasswordField textpassword;
    private JButton newuser;
    private JButton logon;
    private JPanel newUser;
    private JLabel cadastrar;
    private JLabel nomeLabel;
    private JTextField textNomeLabel;
    private JLabel newuserLabel;
    private JTextField textNewUserLabel;
    private JLabel passNewUserLabel;
    private JPasswordField textpasswordNewUserLabel;
    private JButton cancel;
    private JButton register;
    private JPanel main;
    private JMenuBar menuMain;
    private JMenu logoHome;
    private JMenu username;
    private JMenu quit;
    private JMenu add;
    private CardLayout cl;
    private JTabbedPane moviePane;
    private JPanel assistindoPanelTab;
    private JScrollPane scrollAssistindo;
    private JPanel assistindoPanel;
    private JScrollPane scrollFinal;
    private JPanel finalizadoPanelTab;
    private JPanel finalizadoPanel;
    private JPanel addDialog;
    private JLabel labelAdd;
    private JLabel dialogLabelNome;
    private JTextField dialogTextNome;
    private JLabel dialogLabelAno;
    private JLabel dialogLabelProdutora;
    private JLabel dialogLabelNota;
    private JTextField dialogTextAno;
    private JTextField dialogTextProd;
    private JComboBox dialogAval;
    private ImageIcon barIcon;
    private ImageIcon removeIcon;
    private JPanel rateDialog;
    private JLabel dialogNome;
    private Component dialogLabelAval;
    private JPanel infoDialog;
    private JLabel dialogLabelData;
    private JLabel dialogData;
    private JLabel dialogProdutora;
    private JLabel dialogAvalLabel;
    private JLabel dialogLabelRate;
    
    
    public View(){
        //Custom Fonts

        String errorFont= "Erro com a fonte";
    try {
            GraphicsEnvironment ge = 
            GraphicsEnvironment.getLocalGraphicsEnvironment();
            ge.registerFont(Font.createFont(Font.TRUETYPE_FONT, new File("src/main/resources/fonts/Mohave.otf")));
        } catch (IOException|FontFormatException e) {
            log.info(errorFont);
        }
    try {
            GraphicsEnvironment ge = 
            GraphicsEnvironment.getLocalGraphicsEnvironment();
            ge.registerFont(Font.createFont(Font.TRUETYPE_FONT, new File("src/main/resources/fonts/Mohave-Bold.otf")));
        } catch (IOException|FontFormatException e) {
           log.info(errorFont);
        }
    try {
            GraphicsEnvironment ge = 
            GraphicsEnvironment.getLocalGraphicsEnvironment();
            ge.registerFont(Font.createFont(Font.TRUETYPE_FONT, new File("src/main/resources/fonts/Mohave-Bold Italics.otf")));
        } catch (IOException|FontFormatException e) {
            System.out.print(errorFont);
        }
    try {
            GraphicsEnvironment ge = 
            GraphicsEnvironment.getLocalGraphicsEnvironment();
            ge.registerFont(Font.createFont(Font.TRUETYPE_FONT, new File("src/main/resources/fonts/Mohave-Italics.otf")));
        } catch (IOException|FontFormatException e) {
            System.out.print(errorFont);
        }
    try {
            GraphicsEnvironment ge = 
            GraphicsEnvironment.getLocalGraphicsEnvironment();
            ge.registerFont(Font.createFont(Font.TRUETYPE_FONT, new File("src/main/resources/fonts/Mohave-SemiBold.otf")));
        } catch (IOException|FontFormatException e) {
            System.out.print(errorFont);
        }
    try {
            GraphicsEnvironment ge = 
            GraphicsEnvironment.getLocalGraphicsEnvironment();
            ge.registerFont(Font.createFont(Font.TRUETYPE_FONT, new File("src/main/resources/fonts/Mohave-SemiBold Italics.otf")));
        } catch (IOException|FontFormatException e) {
            System.out.print(errorFont);
        }
    
        //Icons + Resize

        userIcon = new ImageIcon("src/main/resources/Icons/icons8-user-50.png");
        passwordIcon = new ImageIcon("src/main/resources/Icons/icons8-lock-50.png");
        addIcon = new ImageIcon("src/main/resources/Icons/icons8-add-filled-50.png");
        addSelectIcon = new ImageIcon("src/main/resources/Icons/icons8-add-filled-50-selected.png");
        logoutIcon = new ImageIcon("src/main/resources/Icons/icons8-exit-50.png");
        logoutSelectedIcon = new ImageIcon("src/main/resources/Icons/icons8-exit-50-selected.png");
        closeIcon = new ImageIcon("src/main/resources/Icons/icons8-delete-50.png");
        minIcon = new ImageIcon("src/main/resources/Icons/icons8-minus-50.png");
        barIcon = new ImageIcon("src/main/resources/Icons/Bar.png");
        removeIcon = new ImageIcon("src/main/resources/Icons/icons8-remove-50.png");
        
        image = passwordIcon.getImage();
        newimg = image.getScaledInstance(25, 25,  java.awt.Image.SCALE_SMOOTH); 
        passwordIcon = new ImageIcon(newimg);  
        
        image = userIcon.getImage();
        newimg = image.getScaledInstance(25, 25,  java.awt.Image.SCALE_SMOOTH); 
        userIcon = new ImageIcon(newimg);
        
        image = closeIcon.getImage();
        newimg = image.getScaledInstance(25, 25,  java.awt.Image.SCALE_SMOOTH); 
        closeIcon = new ImageIcon(newimg);
        
        image = minIcon.getImage();
        newimg = image.getScaledInstance(25, 25,  java.awt.Image.SCALE_SMOOTH); 
        minIcon = new ImageIcon(newimg);
        
        image = logoutIcon.getImage();
        newimg = image.getScaledInstance(25, 25,  java.awt.Image.SCALE_SMOOTH); 
        logoutIcon = new ImageIcon(newimg);
        
        image = addIcon.getImage();
        newimg = image.getScaledInstance(25, 25,  java.awt.Image.SCALE_SMOOTH); 
        addIcon = new ImageIcon(newimg);
        
        image = addSelectIcon.getImage();
        newimg = image.getScaledInstance(25, 25,  java.awt.Image.SCALE_SMOOTH); 
        addSelectIcon = new ImageIcon(newimg);
        
        image = logoutSelectedIcon.getImage();
        newimg = image.getScaledInstance(25, 25,  java.awt.Image.SCALE_SMOOTH); 
        logoutSelectedIcon = new ImageIcon(newimg);
        
        image = removeIcon.getImage();
        newimg = image.getScaledInstance(25, 25,  java.awt.Image.SCALE_SMOOTH); 
        removeIcon = new ImageIcon(newimg);
        
        //Main Window
        window = new JFrame();
        window.setSize(826, 550);
        window.setLocationRelativeTo(null);
        window.setUndecorated(true);
        window.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        window.setLayout(new BorderLayout());
        
        
        window.addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent e) {
                windowMousePressed(e);
            }
        });
        window.addMouseMotionListener(new MouseMotionAdapter() {
            public void mouseDragged(MouseEvent e) {
                windowMouseDragged(e);
            }
        });
        
        //UI Settings
        UIManager.put("Menu.selectionBackground", new Color(236,110,69));
        UIManager.put("Menu.borderPainted",false);
        UIManager.put("Button.select", new Color(232,101,54));
        UIManager.put("OptionPane.messageForeground", Color.white);
        
        UIManager.put("ScrollBar.background",new Color(251,251,251));
        UIManager.put("ScrollBar.track",new Color(251,251,251));
        UIManager.put("ScrollBar.foreground",new Color(251,251,251));
        UIManager.put("ScrollBar.thumb",new Color(44,62,80));
        
        UIManager.put("TabbedPane.selected", new Color(232,101,54));
        UIManager.put("TabbedPane.selectedForeground", Color.white);
        UIManager.put("TabbedPane.contentBorderInsets", new Insets(0, 0, 0, 0));
        
        UIManager.put("OptionPane.background", new Color(53,60,66));
        UIManager.put("Panel.background", new Color(53,60,66));
        UIManager.put("Button.background", new Color(236,110,69));
        UIManager.put("Button.foreground", Color.WHITE);
        UIManager.put("Button.fonts",new Font("Dialog", Font.PLAIN,12));

        //Exit + Minimize Menu
        menuBar = new JMenuBar();
        menuBar.setPreferredSize(new Dimension(826, 25));
        menuBar.setBorder(BorderFactory.createMatteBorder(0, 0, 0, 0, new Color(40,180,99)));
        menuBar.setBackground(new Color(53,60,66));
        menuBar.add(Box.createHorizontalGlue());
        window.setJMenuBar(menuBar);
        
        miniButton = new JMenu();
        miniButton.setIcon(minIcon);
        menuBar.add(miniButton);
        
        closeButton = new JMenu();
        closeButton.setIcon(closeIcon);
        menuBar.add(closeButton);
        
        closeButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                closeButtonMouseClicked(e);
            }
            @Override
            public void mouseEntered(MouseEvent e) {
                closeButtonMouseEntered(e);
            }
            @Override
            public void mouseExited(MouseEvent e) {
                closeButtonMouseExited(e);
            }
            
        });
        miniButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                miniButtonMouseClicked(e);
            }
            @Override
            public void mouseEntered(MouseEvent e) {
                miniButtonMouseEntered(e);
            }
            @Override
            public void mouseExited(MouseEvent e) {
                miniButtonMouseExited(e);
            }
            
        });
        
        //CardLayout Root
        root = new JPanel(new CardLayout());
        window.add(root);
        
        //Login panel
        login = new JPanel(new MigLayout("center,inset 100","[]8[]","[]25[]"));
        login.setBackground(new Color(53,60,66));
        
        logo = new JLabel("LOGIN");
        logo.setFont(new Font("Mohave", Font.BOLD, 116));
        logo.setForeground(Color.WHITE);
        login.add(logo,"span,wrap");
        
        userLabel = new JLabel();
        userLabel.setIcon(userIcon);
        login.add(userLabel,"split 2,span");
        
        textlogin = new JTextField();
        textlogin.setBorder(javax.swing.BorderFactory.createEmptyBorder());
        login.add(textlogin,"wrap, grow");
        
        passLabel = new JLabel();
        passLabel.setIcon(passwordIcon);
        login.add(passLabel,"split 2,span");

        textpassword = new JPasswordField();
        textpassword.setBorder(javax.swing.BorderFactory.createEmptyBorder());
        login.add(textpassword,"wrap, grow");
        
        logon = new JButton("CADASTRAR");
        logon.setBorderPainted(false);
        logon.setForeground(Color.WHITE);
        logon.setBackground(new Color(236,110,69));
        login.add(logon,"w 112!");
        
        logon.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                cadastrarMouseClicked(e);
            }
        });
        
        newuser = new JButton("ENTRAR");
        newuser.setBorderPainted(false);
        newuser.setForeground(Color.WHITE);
        newuser.setBackground(new Color(236,110,69));
        login.add(newuser,"grow");
        
        newuser.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                entrarMouseClicked(e);
            }
        });
        
        root.add(login, "login");

        //NewUser panel
        newUser = new JPanel(new MigLayout("center,inset 100","[]10[]","[]25[]"));
        newUser.setBackground(new Color(53,60,66));
        
        cadastrar = new JLabel("CADASTRO");
        cadastrar.setFont(new Font("Mohave", Font.BOLD, 116));
        cadastrar.setForeground(Color.WHITE);
        newUser.add(cadastrar,"span,wrap");
        
        nomeLabel = new JLabel("NOME");
        nomeLabel.setForeground(Color.WHITE);
        newUser.add(nomeLabel,"");
        
        textNomeLabel = new JTextField();
        textNomeLabel.setBorder(javax.swing.BorderFactory.createEmptyBorder());
        newUser.add(textNomeLabel,"wrap,grow");
        
        newuserLabel = new JLabel("USUÁRIO");
        newuserLabel.setForeground(Color.WHITE);
        newUser.add(newuserLabel,"");
        
        textNewUserLabel = new JTextField();
        textNewUserLabel.setBorder(javax.swing.BorderFactory.createEmptyBorder());
        newUser.add(textNewUserLabel,"grow,wrap");
        
        passNewUserLabel = new JLabel("SENHA");
        passNewUserLabel.setForeground(Color.WHITE);
        newUser.add(passNewUserLabel,"");

        textpasswordNewUserLabel = new JPasswordField();
        textpasswordNewUserLabel.setBorder(javax.swing.BorderFactory.createEmptyBorder());
        newUser.add(textpasswordNewUserLabel,"grow,wrap");
        
        cancel = new JButton("CANCELAR");
        cancel.setBorderPainted(false);
        cancel.setForeground(Color.WHITE);
        cancel.setBackground(new Color(236,110,69));
        newUser.add(cancel,"split,span,grow");
        
        cancel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                cadastrarCancelarMouseClicked(e);
            }
        });
                
        register = new JButton("CADASTRAR");
        register.setBorderPainted(false);
        register.setForeground(Color.WHITE);
        register.setBackground(new Color(236,110,69));
        newUser.add(register,"gapx 10,grow");
        
        register.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                cadastrarConfirmMouseClicked(e);
            }
        });
        
        root.add(newUser, "newUser");
        
        //Main panel       
        main = new JPanel(new MigLayout("","","10[][]20"));
        main.setBackground(new Color(53,60,66));
        
        menuMain = new JMenuBar();
        
        menuMain.setLayout(new MigLayout("rtl"));
        menuMain.setPreferredSize(new Dimension(826, 40));
        menuMain.setBorder(BorderFactory.createMatteBorder(0, 0, 0, 0, new Color(40,180,99)));
        menuMain.setBackground(new Color(53,60,66));
        menuMain.add(Box.createHorizontalGlue());
        main.add(menuMain,"dock north");
        
        quit = new JMenu();
        quit.setIcon(logoutIcon);
        menuMain.add(quit,"");
        
        username = new JMenu("Bem vindo, usuário");
        username.setForeground(Color.WHITE);
        username.setFont(new Font("Dialog", Font.PLAIN,14));
        menuMain.add(username,"");
        
        //Font currentFont = username.getFont();
        //System.out.println(currentFont.getName());
        
        add = new JMenu();
        add.setIcon(addIcon);
        menuMain.add(add,"");
        
        add.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                addMouseClicked(e);
            }
            public void mouseEntered(MouseEvent e) {
                addMouseEntered(e);
            }
            public void mouseExited(MouseEvent e) {
                addMouseExited(e);
            }
            
        });
        
        quit.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                quitMouseClicked(e);
            }
            public void mouseEntered(MouseEvent e) {
                quitMouseEntered(e);
            }
            public void mouseExited(MouseEvent e) {
                quitMouseExited(e);
            }
            
        });
        
        //JTabbed
        
        moviePane = new JTabbedPane();
        moviePane.setOpaque(false);
        moviePane.setFocusable(false);
        moviePane.setBorder(BorderFactory.createMatteBorder(0, 0, 7, 0, new Color(236,110,69)));
        moviePane.setBackground(Color.white);
        
        moviePane.setUI(new BasicTabbedPaneUI() {
         @Override
        protected void installDefaults() {
            super.installDefaults();
            highlight = Color.white;
            lightHighlight = Color.white;
            shadow = Color.white;
            darkShadow = Color.white;
            focus = Color.white;
            
        }
        });
        
        //Tab assistindo
        assistindoPanelTab = new JPanel(new MigLayout("center","20[][]20","50[][]20"));
        assistindoPanelTab.setBackground(Color.WHITE);
        moviePane.addTab("Assistindo", assistindoPanelTab);

        assistindoPanel = new JPanel(new MigLayout("wrap 2","10[]25[]10","[]10[]"));
        assistindoPanel.setBackground(Color.WHITE);

        scrollAssistindo = new JScrollPane(assistindoPanel);
        scrollAssistindo.setVerticalScrollBarPolicy(scrollAssistindo.VERTICAL_SCROLLBAR_ALWAYS);
        scrollAssistindo.setBorder(BorderFactory.createEmptyBorder());
        assistindoPanelTab.add(scrollAssistindo,"height 300, width 600,span 3");
        
        //Tab Finalizados
        finalizadoPanelTab = new JPanel(new MigLayout("center","20[][]20","50[][]20"));
        finalizadoPanelTab.setBackground(Color.WHITE);
        moviePane.addTab("Finalizados",finalizadoPanelTab);
        
        finalizadoPanel = new JPanel(new MigLayout("wrap 2","10[]25[]10","[]10[]"));
        finalizadoPanel.setBackground(Color.WHITE);
        
        scrollFinal = new JScrollPane(finalizadoPanel);
        scrollFinal.setVerticalScrollBarPolicy(scrollFinal.VERTICAL_SCROLLBAR_ALWAYS);
        scrollFinal.setBorder(BorderFactory.createEmptyBorder());
        finalizadoPanelTab.add(scrollFinal,"height 300, width 600,span 3");
        
        main.add(moviePane,"height 420, width 670,center,wrap");

        
        root.add(main, "home");

        // Show card
        cl = (CardLayout)root.getLayout();
        cl.show(root,"login");
        window.setVisible(true);
    }
    
    public void quitMouseClicked(MouseEvent e){
        quit.setSelected(false);

        user = null;
        textlogin.setText("");
        textpassword.setText("");
        //aqui
        //colocar codigo para desconectar o usuario atual

        
        cl.show(root, "login");
    }
    public void quitMouseEntered(MouseEvent e){
        quit.setSelected(false);
        quit.setIcon(logoutSelectedIcon);
    }  
    public void quitMouseExited(MouseEvent e){
        quit.setSelected(false);
        quit.setIcon(logoutIcon);
    }
    
    public void addMouseClicked(MouseEvent e){
        add.setSelected(true);
        addDialog = new JPanel(new MigLayout("center,wrap 2","10[]10[]10","[]10[]"));
        addDialog.setBackground(new Color(53,60,66));
        
        labelAdd = new JLabel("ADICIONAR");
        labelAdd.setFont(new Font("Mohave", Font.BOLD, 76));
        labelAdd.setForeground(Color.WHITE);
        addDialog.add(labelAdd,"span,wrap");
        
        dialogLabelNome = new JLabel("Nome");
        dialogLabelNome.setForeground(Color.WHITE);
        addDialog.add(dialogLabelNome,"align right");
        
        dialogTextNome = new JTextField();
        dialogTextNome.setBorder(javax.swing.BorderFactory.createEmptyBorder());
        addDialog.add(dialogTextNome,"grow,wrap");
         
        dialogLabelAno = new JLabel("Ano");
        dialogLabelAno.setForeground(Color.WHITE);
        addDialog.add(dialogLabelAno,"align right");
        
        dialogTextAno = new JTextField();
        dialogTextAno.setBorder(javax.swing.BorderFactory.createEmptyBorder());
        addDialog.add(dialogTextAno,"grow,wrap");
        
        dialogLabelProdutora = new JLabel("Produtora");
        dialogLabelProdutora.setForeground(Color.WHITE);
        addDialog.add(dialogLabelProdutora,"align right");
        
        dialogTextProd = new JTextField();
        dialogTextProd.setBorder(javax.swing.BorderFactory.createEmptyBorder());
        addDialog.add(dialogTextProd ,"grow,wrap");
        
        int reply = JOptionPane.showConfirmDialog(window, addDialog,null,JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
        
        if (reply == JOptionPane.OK_OPTION){
            Short ano = Short.parseShort(dialogTextAno.getText());
            String nome = dialogTextNome.getText();
            String produtora = dialogTextProd.getText();
            Controller controller = new Controller();
            controller.saveMovie(produtora, nome, ano,user);
            updateTab();
            // aqui
            // colocar o codigo para adicionar um novo filme
            // os input dos textfield são: 
            // dialogTextNome.getText() = nome do filem
            // dialogTextAno.getText() = ano do filme
            // dialogTextProd.getText() = produtora
        }
    }
    public void addMouseEntered(MouseEvent e){
        add.setSelected(false);
        add.setIcon(addSelectIcon);
    }  
    public void addMouseExited(MouseEvent e){
        add.setSelected(false);
        add.setIcon(addIcon);
    }
    
    public void windowMousePressed(MouseEvent e) {
        point.x = e.getX();
        point.y = e.getY();
    }
    public void windowMouseDragged(MouseEvent e){
        Point p = window.getLocation();
        window.setLocation(p.x + e.getX() - point.x,p.y + e.getY() - point.y);
    }
    
    public void closeButtonMouseClicked(MouseEvent e) {
        System.exit(0);
    }
    public void closeButtonMouseEntered(MouseEvent e) {
        closeButton.setSelected(true);
    }
    public void closeButtonMouseExited(MouseEvent e) {
        closeButton.setSelected(false);
    }
    
    public void miniButtonMouseClicked(MouseEvent e) {
        window.setState(window.ICONIFIED);
    }
    public void miniButtonMouseEntered(MouseEvent e) {
        miniButton.setSelected(true);
    }
    public void miniButtonMouseExited(MouseEvent e) {
        miniButton.setSelected(false);
    }
    public void entrarMouseClicked(MouseEvent e) {


        String userName = textlogin.getText();
        char[] password = textpassword.getPassword();
        if((!(userName.equalsIgnoreCase(""))) && (!(password.toString().equalsIgnoreCase("")))){
            Controller controller = new Controller();
            if (controller.verifyPaswword(userName, password)) {
                user = controller.login(userName);
                cl.show(root,"home");
                updateTab();
                username.setText("Bem vindo, "+ user.getName());
            }else{
                JOptionPane.showMessageDialog(null, "Senha ou usuario incorreto", " Erro ao realizar login" , JOptionPane.INFORMATION_MESSAGE);
            }
        }else{
            JOptionPane.showMessageDialog(null, "Preencha os campos necessários", " Erro ao realizar login" , JOptionPane.INFORMATION_MESSAGE);
        }


        //aqui
        //colocar codigo para conectar o usuario
        
        //textlogin.getText() = username 
        //textpassword.getPassword(); = senha do usuario
        

    }
    public void cadastrarMouseClicked(MouseEvent e) {
        cl.show(root,"newUser");
    }
    public void cadastrarConfirmMouseClicked(MouseEvent e) {
        //aqui
        //colocar código para cadastrar um novo usuario
        
        //textNomeLabel.getText() = nome do novo usuario
        //textNewUserLabel.getText() = user do novo usuario
        //textpasswordNewUserLabel.getPassword() = senha do novo usuario
        Controller controller = new Controller();
        String name = textNomeLabel.getText();
        String userName = textNewUserLabel.getText();
        char[] password =textpasswordNewUserLabel.getPassword();

        if((!(userName.equalsIgnoreCase(""))) && (!(password.toString().equalsIgnoreCase("")))&& ((!(name.equalsIgnoreCase(""))) )){
            user= controller.saveUser(name,userName,password);

            JOptionPane.showMessageDialog(null,"Usuário cadastrado com sucesso");
            username.setText("Bem vindo, "+ user.getName());


            cl.show(root,"home");
            updateTab();
            textNomeLabel.setText("");
            textNewUserLabel.setText("");
            textpasswordNewUserLabel.setText("");

        }else{
            JOptionPane.showMessageDialog(null,"Preencha os campos necessários");
        }


    }

    public void cadastrarCancelarMouseClicked(MouseEvent e) {
        cl.show(root,"login");
    }


    public void updateTab(){
        //aqui
        //update
        //ok
        assistindoPanel.removeAll();
        finalizadoPanel.removeAll();

        Controller controller = new Controller();

        List<MovieList> pendentes = controller.notWatchedMovie(user.getId());
        for (int i=0; i < pendentes.size();i++){

            JLabel remover = new JLabel();
            remover.setIcon(removeIcon);
            assistindoPanel.add(remover,"");

            JLabel nome = new JLabel(pendentes.get(i).getMovie().getName());

            remover.addMouseListener(new MouseAdapter(){
                public void mouseClicked(MouseEvent e){
                    removeMouseClicked(e, nome.getText());
                }});

            assistindoPanel.add(nome,"");

            nome.addMouseListener(new MouseAdapter(){
                @Override
                public void mouseClicked(MouseEvent e){
                    rateMouseClicked(e,nome.getText());
                }});
        }

        List<MovieList> finalizados = controller.watchedMovie(user.getId());

            for (int i=0; i < finalizados.size();i++){

                JLabel nomes = new JLabel(finalizados.get(i).getMovie().getName());
                finalizadoPanel.add(nomes,"");

                nomes.addMouseListener(new MouseAdapter(){
                    @Override
                    public void mouseClicked(MouseEvent e){
                        infoMouseClicked(e,nomes.getText());
                    }});

                JLabel avaliacao = new JLabel(String.valueOf(finalizados.get(i).getRate()) + " estrela(s)");
                finalizadoPanel.add(avaliacao," ");
            }

            assistindoPanel.revalidate();
            finalizadoPanel.revalidate();
            assistindoPanel.repaint();
            finalizadoPanel.repaint();

    }



    public void removeMouseClicked(MouseEvent e, String text)
    {
        Controller controller = new Controller();
        controller.removeMovie(text, user.getId());
        updateTab();
    }  
    public void rateMouseClicked(MouseEvent e, String text)
    {  
        //aqui
        //Colocar codigo muda o jlabel dialogNome para o nome do item selecionado do JtabbedPanel
        // e guradar a avaliação escolhida no database

        Controller controller = new Controller();

        rateDialog = new JPanel(new MigLayout("center,wrap 2","10[]10[]10","[]10[]"));
        rateDialog.setBackground(new Color(53,60,66));
        
        labelAdd = new JLabel("AVALIAR");
        labelAdd.setFont(new Font("Mohave", Font.BOLD, 76));
        labelAdd.setForeground(Color.WHITE);
        rateDialog.add(labelAdd,"span,wrap");
        
        dialogLabelNome = new JLabel("Nome");
        dialogLabelNome.setForeground(Color.WHITE);
        rateDialog.add(dialogLabelNome,"align right");
        
        dialogNome = new JLabel(text); // nome do filme no database
        dialogNome.setForeground(Color.WHITE);
        dialogNome.setBorder(javax.swing.BorderFactory.createEmptyBorder());
        rateDialog.add(dialogNome,"grow,wrap");
        
        dialogLabelNota = new JLabel("Avaliação");
        dialogLabelNota.setForeground(Color.WHITE); 
        rateDialog.add(dialogLabelNota,"align right");
        
        dialogAval = new JComboBox(new String[]{"1","2","3","4","5"});
        rateDialog.add(dialogAval,"grow,wrap");
        
        int reply = JOptionPane.showConfirmDialog(window, rateDialog,null,JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
        
        if (reply == JOptionPane.OK_OPTION){

            // aqui
            // colocar o codigo para avaliar o filme
            // dialogAval.getSelectedItem() = avaliacao escolhida
            Movie filme = controller.findMovieByName(text);
            controller.rateMovie(filme, user.getId(), Long.parseLong(dialogAval.getSelectedItem().toString()));
            updateTab();
        }
    }
    public void infoMouseClicked(MouseEvent e, String text)
    {  
        //aqui
        //Colocar codigo muda os jlabel para o nome do item selecionado do JtabbedPanel
        //aqui
        //ok
        Controller controller = new Controller();
        Movie filmeInfo = controller.findMovieByName(text);
        MovieList filmeUsuarioInfo = controller.getMovieInfo(filmeInfo, user.getId());

        infoDialog = new JPanel(new MigLayout("center,wrap 2","10[]10[]10","[]10[]"));
        infoDialog.setBackground(new Color(53,60,66));

        labelAdd = new JLabel("DETALHES");
        labelAdd.setFont(new Font("Mohave", Font.BOLD, 76));
        labelAdd.setForeground(Color.WHITE);
        infoDialog.add(labelAdd,"span,wrap");

        dialogLabelNome = new JLabel("Nome");
        dialogLabelNome.setForeground(Color.WHITE);
        infoDialog.add(dialogLabelNome,"align right");

        dialogNome = new JLabel(filmeInfo.getName()); // nome do filme no database
        dialogNome.setForeground(Color.WHITE);
        dialogNome.setBorder(javax.swing.BorderFactory.createEmptyBorder());
        infoDialog.add(dialogNome,"grow,wrap");

        dialogLabelData = new JLabel("Ano");
        dialogLabelData.setForeground(Color.WHITE);
        infoDialog.add(dialogLabelData,"align right");

        dialogData = new JLabel(String.valueOf(filmeInfo.getYear())); // ano do filme no database
        dialogData.setForeground(Color.WHITE);
        dialogData.setBorder(javax.swing.BorderFactory.createEmptyBorder());
        infoDialog.add(dialogData,"grow,wrap");

        dialogLabelProdutora = new JLabel("Produtora");
        dialogLabelProdutora.setForeground(Color.WHITE);
        infoDialog.add(dialogLabelProdutora,"align right");

        dialogProdutora = new JLabel(filmeInfo.getProducer().getName()); // produtora do filme no database
        dialogProdutora.setForeground(Color.WHITE);
        dialogProdutora.setBorder(javax.swing.BorderFactory.createEmptyBorder());
        infoDialog.add(dialogProdutora,"grow,wrap");

        dialogLabelRate = new JLabel("Avaliação");
        dialogLabelRate.setForeground(Color.WHITE);
        infoDialog.add(dialogLabelRate,"align right");

        dialogAvalLabel = new JLabel(String.valueOf(filmeUsuarioInfo.getRate() )+ " estrela(s)"); // nota do filme no database
        dialogAvalLabel.setForeground(Color.WHITE);
        dialogAvalLabel.setBorder(javax.swing.BorderFactory.createEmptyBorder());
        infoDialog.add(dialogAvalLabel,"grow,wrap");

        int reply = JOptionPane.showConfirmDialog(window, infoDialog,null,JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE);

    }

    //aqui
    //As tabs só atualizam quando clicadas, mas eu mudo isso depois que o resto do código estiver pronto!
}

