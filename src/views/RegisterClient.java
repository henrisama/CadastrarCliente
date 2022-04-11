package src.views;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.text.MaskFormatter;

import java.awt.Dimension;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.FlowLayout;
import java.awt.event.*;
import java.text.ParseException;
import java.util.regex.Pattern;

public class RegisterClient extends JFrame{
    private JLabel cpfLabel;
    private JTextField cpfTextField;

    private JLabel phoneLabel;
    private JTextField phoneTextField;

    private JLabel emailLabel;
    private JTextField emailTextField;

    private String states[] = { "MS", "SP", "AM", "RO", "SC" };

    public RegisterClient(){
        // title page
        super("Cadastrar Cliente");

        // set icon
        Image icon = Toolkit.getDefaultToolkit().getImage("public/img/russia.png");
        setIconImage(icon);

        // set layout
        this.setLayout(new FlowLayout());

        // dimension
        this.setPreferredSize(new Dimension(800, 500));

        // add components
            cpfLabel = new JLabel("CPF: ");
            this.add(cpfLabel);

            try{
                cpfTextField = new JFormattedTextField(new MaskFormatter("###.###.###-##"));
            }catch(ParseException e){
                throw new RuntimeException(e);
            }
            cpfTextField.setPreferredSize(new Dimension(150,30));;
            this.add(cpfTextField);


            JLabel nameLabel = new JLabel("Nome: ");
            this.add(nameLabel);

            JTextField nameTextField = new JTextField();
            nameTextField.setPreferredSize(new Dimension(150, 30));
            this.add(nameTextField);

            JLabel streetLabel = new JLabel("Rua: ");
            this.add(streetLabel);

            JTextField streetTextField = new JTextField();
            streetTextField.setPreferredSize(new Dimension(150, 30));
            this.add(streetTextField);

            JLabel numLabel = new JLabel("N°: ");
            this.add(numLabel);

            JTextField numTextField = new JTextField();
            numTextField.setPreferredSize(new Dimension(150, 30));
            this.add(numTextField);

            JLabel districtLabel = new JLabel("Bairro: ");
            this.add(districtLabel);

            JTextField districtTextField = new JTextField();
            districtTextField.setPreferredSize(new Dimension(150, 30));
            this.add(districtTextField);

            JLabel cityLabel = new JLabel("Cidade: ");
            this.add(cityLabel);

            JTextField cityTextField = new JTextField();
            cityTextField.setPreferredSize(new Dimension(150, 30));
            this.add(cityTextField);

            JLabel stateLabel = new JLabel("UF: ");
            this.add(stateLabel);

            // array of string containing states
            
            JComboBox stateComboBox = new JComboBox<>(states);
            this.add(stateComboBox);

            phoneLabel = new JLabel("Telefone: ");
            this.add(phoneLabel);

            try{
                phoneTextField = new JFormattedTextField(new MaskFormatter("(##)#####-####"));
            }catch(ParseException e){
                throw new RuntimeException(e);
            }
            phoneTextField.setPreferredSize(new Dimension(150, 30));
            this.add(phoneTextField);

            emailLabel = new JLabel("Email: ");
            this.add(emailLabel);

            emailTextField = new JTextField();
            emailTextField.setPreferredSize(new Dimension(150, 30));
            this.add(emailTextField);

            JButton cancelButton = new JButton("Cancelar");
            cancelButton.addActionListener(new ActionListener(){
                @Override
                public void actionPerformed(ActionEvent e) {
                    System.out.println("Close");
                }
            });

            JButton confirmButton = new JButton("Confirm");
            confirmButton.addActionListener(new ActionListener(){
                @Override
                public void actionPerformed(ActionEvent e) {
                    handleConfirmEvent();
                }
            });

            this.add(cancelButton);
            this.add(confirmButton);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        pack();
        setLocationRelativeTo(null);
    }

    private String _validate(){
        // CPF

        // Name

        // Street

        // Street Number

        // District

        // City

        // State

        // Phone

        // Email
        String email = emailTextField.getText();
        System.out.println(email);

        if(!Pattern
            .compile("^([\\w-\\.]+){1,64}@([\\w&&[^_]]+){2,255}.[a-z]{2,}$")
            .matcher(email).find()
        ){
            return "Invalid Email";
        }

        return "Brazil Hexa";
    }

    public void handleConfirmEvent(){

    }
}
