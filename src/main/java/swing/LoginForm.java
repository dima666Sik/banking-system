package swing;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginForm extends JDialog {
    private JPanel panelSignIn;
    private JTextField loginField;
    private JButton loginButton;
    private JButton registrationButton;
    private JPasswordField passwordField;
    private JButton closeButton;

    public LoginForm(JFrame jFrameOld) {
        super(jFrameOld);
        setContentPane(panelSignIn);
        setMinimumSize(new Dimension(480, 350));
        setModal(true);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        closeButton.addActionListener(e -> dispose());
        setVisible(true);
    }

}
