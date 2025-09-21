package view;

import javax.swing.*;
import java.awt.*;

public class LoginView extends JFrame {
    private JTextField userIdField;
    private JComboBox<String> userTypeCombo;
    private JButton loginButton;

    public LoginView() {
        setTitle("Login - Job Fair System");
        setSize(350, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel(new GridLayout(4, 2, 10, 10));
        panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        panel.add(new JLabel("User ID:"));
        userIdField = new JTextField();
        panel.add(userIdField);

        panel.add(new JLabel("User Type:"));
        userTypeCombo = new JComboBox<>(new String[]{"Student", "Graduate"});
        panel.add(userTypeCombo);

        loginButton = new JButton("Login");
        panel.add(new JLabel(""));
        panel.add(loginButton);

        add(panel);
    }

    public JTextField getUserIdField() { return userIdField; }
    public JComboBox<String> getUserTypeCombo() { return userTypeCombo; }
    public JButton getLoginButton() { return loginButton; }
}