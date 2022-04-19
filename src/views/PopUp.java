package src.views;

import javax.swing.JDialog;
import java.awt.Dimension;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class PopUp extends JDialog{
    public PopUp(String msg){
        setPreferredSize(new Dimension(400, 200));
        setVisible(true);

        JLabel popup = new JLabel(msg, SwingConstants.CENTER);
        add(popup);
        
        setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        setResizable(false);
        pack();
        setLocationRelativeTo(null);
    }
}
