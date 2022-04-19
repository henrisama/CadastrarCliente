package src.views;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.text.MaskFormatter;

import src.DAO.ClientDAO;
import src.utils.Address;
import src.utils.Client;

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

    private JLabel nameLabel;
    private JTextField nameTextField;

    private JLabel streetLabel;
    private JTextField streetTextField;

    private JTextField numTextField;

    private JTextField districtTextField;

    private JTextField cityTextField;

    private JComboBox stateComboBox;

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


            nameLabel = new JLabel("Nome: ");
            this.add(nameLabel);

            nameTextField = new JTextField();
            nameTextField.setPreferredSize(new Dimension(150, 30));
            this.add(nameTextField);

            streetLabel = new JLabel("Rua: ");
            this.add(streetLabel);

            streetTextField = new JTextField();
            streetTextField.setPreferredSize(new Dimension(150, 30));
            this.add(streetTextField);

            JLabel numLabel = new JLabel("N°: ");
            this.add(numLabel);

            numTextField = new JTextField();
            numTextField.setPreferredSize(new Dimension(150, 30));
            this.add(numTextField);

            JLabel districtLabel = new JLabel("Bairro: ");
            this.add(districtLabel);

            districtTextField = new JTextField();
            districtTextField.setPreferredSize(new Dimension(150, 30));
            this.add(districtTextField);

            JLabel cityLabel = new JLabel("Cidade: ");
            this.add(cityLabel);

            cityTextField = new JTextField();
            cityTextField.setPreferredSize(new Dimension(150, 30));
            this.add(cityTextField);

            JLabel stateLabel = new JLabel("UF: ");
            this.add(stateLabel);

            // array of string containing states
            
            stateComboBox = new JComboBox<>(states);
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

    public static boolean isNumeric(String strNum) {
        if (strNum == null) {
            return false;
        }
        try {
            int d = Integer.parseInt(strNum);
        } catch (NumberFormatException nfe) {
            return false;
        }
        return true;
    }

    private String _validate(){
        // CPF
        String cpf = cpfTextField.getText().replace(".", "").replace("-", "");
        if(cpf.isBlank() || cpf.length() != 11){
            return "Invalid CPF";
        }

        // Name
        String name = nameTextField.getText();
        if(name.isBlank() || name.length() > 50){
            return "Invalid name";
        }

        // Street
        String street = streetTextField.getText();
        if(street.isBlank() || street.length() > 30){
            return "Invalid street";
        }

        // Street Number
        String num = numTextField.getText();
        if(num.isBlank() || !isNumeric(num)){
            return "Invalid number";
        }

        // District
        String district = districtTextField.getText();
        if(district.isBlank() || district.length() > 30){
            return "Invalid district";
        }

        // City
        String city = cityTextField.getText();
        if(city.isBlank() || city.length() > 30){
            return "Invalid city";
        }

        // State


        // Phone
        String phone = phoneTextField.getText()
                .replace("(", "")
                .replace(")", "")
                .replace("-", "");
        if(phone.isBlank()){
            return "Invalid phone";
        }

        // Email
        String email = emailTextField.getText();

        if(!Pattern
            .compile("^([\\w-\\.]+){1,64}@([\\w&&[^_]]+){2,255}.[a-z]{2,}$")
            .matcher(email).find()
        ){
            return "Invalid Email";
        }

        return "Brazil Hexa";
    }

    public void handleConfirmEvent(){
        String validateResult = _validate();
        if(validateResult.compareTo("Brazil Hexa") == 0){
            String cpf = cpfTextField.getText()
                .replace(".", "")
                .replace("-", "");
            String name = nameTextField.getText();
            String email = emailTextField.getText();
            String phone = phoneTextField.getText()
                .replace("(", "")
                .replace(")", "")
                .replace("-", "");

            String street = streetTextField.getText();
            int num = Integer.parseInt(numTextField.getText());
            String district = districtTextField.getText();
            String city = cityTextField.getText();
            String state = stateComboBox.getSelectedItem().toString();
    
            Address address = new Address(street, num, district, city, state);
            Client client = new Client(name, cpf, phone, email, address);

            System.out.println(client.toString());

            ClientDAO clientDAO = new ClientDAO();
            
            int dbResult = clientDAO.CadastrarCliente(client);
            System.out.println(dbResult);

            switch (dbResult) {
                case 1:
                    new PopUp("Cliente cadastrado com sucesso!");
                    break;
                case 1062:
                    new PopUp("Cliente já cadastrado!");
                    break;
                default:
                    break;
            }
            
        }else{
            System.out.println(validateResult);
            new PopUp(validateResult);
        }
    }
}
