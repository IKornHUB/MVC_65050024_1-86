package view;

import javax.swing.*;
import java.awt.*;

public class ApplicationFormView extends JFrame {
    private JTextField candidateIdField;
    private JTextField emailField;
    private JButton submitButton;

    public ApplicationFormView(String jobId, String jobTitle) {
        setTitle("Apply Job: " + jobId);
        setSize(400, 200);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel(new GridLayout(4, 2, 10, 10));
        panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        panel.add(new JLabel("Job ID:"+ jobId));
        panel.add(new JLabel(jobTitle));

        panel.add(new JLabel("Candidate ID:"));
        candidateIdField = new JTextField();
        panel.add(candidateIdField);

        panel.add(new JLabel("Email:"));
        emailField = new JTextField();
        panel.add(emailField);

        submitButton = new JButton("Submit Application");
        panel.add(new JLabel("")); // ช่องว่าง
        panel.add(submitButton);

        add(panel);
    }

    public JTextField getCandidateIdField() { return candidateIdField; }
    public JTextField getEmailField() { return emailField; }
    public JButton getSubmitButton() { return submitButton; }
}
