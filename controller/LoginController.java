package controller;

import model.Database;
import view.LoginView;
import javax.swing.JOptionPane;

public class LoginController {
    private Database db;
    private LoginView loginView;

    public LoginController(Database db) {
        this.db = db;
        this.loginView = new LoginView();
        
        loginView.getLoginButton().addActionListener(e -> handleLogin());
        loginView.setVisible(true);
    }

    private void handleLogin() {
        String userId = loginView.getUserIdField().getText().trim();
        String userType = (String) loginView.getUserTypeCombo().getSelectedItem();

        if (db.login(userId, userType)) {
            JOptionPane.showMessageDialog(loginView, "Login successful!");
            loginView.dispose();
            new JobController(db); // Start main application
        } else {
            JOptionPane.showMessageDialog(loginView, "Invalid credentials!");
        }
    }
}