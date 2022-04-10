package src.views;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import java.awt.Dimension;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.FlowLayout;

public class CadastrarCliente extends JFrame{
    public CadastrarCliente(){
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
            JLabel cpfLabel = new JLabel("CPF: ");
            this.add(cpfLabel);

            JTextField cpfTextField = new JTextField(20);
            cpfTextField.setSize(new Dimension(100, 50));
            this.add(cpfTextField);


            JLabel nameLabel = new JLabel("Nome: ");
            this.add(nameLabel);

            JTextField nameTextField = new JTextField(20);
            nameTextField.setSize(new Dimension(100, 50));
            this.add(nameTextField);

            JLabel streetLabel = new JLabel("Rua: ");
            this.add(streetLabel);

            JTextField streetTextField = new JTextField(20);
            streetTextField.setSize(new Dimension(100, 50));
            this.add(streetTextField);

            JLabel numLabel = new JLabel("N°: ");
            this.add(numLabel);

            JTextField numTextField = new JTextField(10);
            numTextField.setSize(new Dimension(100, 50));
            this.add(numTextField);

            JLabel districtLabel = new JLabel("Bairro: ");
            this.add(districtLabel);

            JTextField districtTextField = new JTextField(10);
            districtTextField.setSize(new Dimension(100, 50));
            this.add(districtTextField);

            JLabel cityLabel = new JLabel("Cidade: ");
            this.add(cityLabel);

            JTextField cityTextField = new JTextField(10);
            cityTextField.setSize(new Dimension(100, 50));
            this.add(cityTextField);

            JLabel stateLabel = new JLabel("UF: ");
            this.add(stateLabel);

            // array of string containing states
            String states[] = { "MS", "SP", "AM", "RO", "SC" };
            JComboBox stateComboBox = new JComboBox<>(states);
            this.add(stateComboBox);

            JLabel phoneLabel = new JLabel("Telefone: ");
            this.add(phoneLabel);

            JTextField phoneTextField = new JTextField(10);
            phoneTextField.setSize(new Dimension(100, 50));
            this.add(phoneTextField);

            JLabel emailLabel = new JLabel("Email: ");
            this.add(emailLabel);

            JTextField emailTextField = new JTextField(10);
            emailTextField.setSize(new Dimension(100, 50));
            this.add(emailTextField);

            JButton cancelButton = new JButton("Cancelar");
            JButton confirmButton = new JButton("Confirm");
            this.add(cancelButton);
            this.add(confirmButton);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        pack();
        setLocationRelativeTo(null);
    }
}
