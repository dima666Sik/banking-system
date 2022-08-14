package ui.swing;

import domain.env.EnvironmentUtilities;
import domain.models.User;
import domain.models.utility.Internet;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.BigDecimal;

public class MenuChooseUtilityServiceForm extends JDialog {
    private User user;
    private JPanel panelUtilities;
    private JButton backButton;
    private JButton internetButton;
    private JButton gasButton;
    private JButton TVButton;
    private JButton waterButton;
    private final DefaultListModel<String> model = new DefaultListModel<>();

    public MenuChooseUtilityServiceForm(User user) {
        this.user = user;
        setUndecorated(true);
        setContentPane(panelUtilities);
        setMinimumSize(new Dimension(400, 200));

        setModal(true);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        backButton.addActionListener(e -> {
            dispose();
            new ActionMenuForm(user);
        });
        internetButton.addActionListener(e -> {
            dispose();
            new PayOfUtilityForm(user, new Internet("Internet",
                    new BigDecimal("275.6"),
                    EnvironmentUtilities.INTERNET));
        });
        TVButton.addActionListener(e -> {

        });
        gasButton.addActionListener(e -> {

        });
        waterButton.addActionListener(e -> {

        });
        setVisible(true);
    }
}
