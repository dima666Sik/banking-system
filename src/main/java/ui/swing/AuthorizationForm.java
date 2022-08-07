package ui.swing;

import javax.swing.*;
import java.awt.*;

public class AuthorizationForm extends JDialog {
    private JFrame jFrameOld;
    private JPanel panelSignIn;
    private JTextField loginField;
    private JButton loginButton;
    private JButton registrationButton;
    private JPasswordField passwordField;
    private JButton closeButton;

    public AuthorizationForm() {
        setUndecorated(true);
        setContentPane(panelSignIn);
        setMinimumSize(new Dimension(480, 350));

        setModal(true);
        setLocationRelativeTo(jFrameOld);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        closeButton.addActionListener(e -> dispose());
        setVisible(true);
    }

}
