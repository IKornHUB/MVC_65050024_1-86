package view;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class JobListView extends JFrame {
    private JTable jobTable;
    private JButton applyButton;

    public JobListView(DefaultTableModel model) {
        setTitle("Open Jobs");
        setSize(800, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        jobTable = new JTable(model);
        JScrollPane scrollPane = new JScrollPane(jobTable);
        JLabel textLabel = new JLabel("**** Select a job and click 'Apply Job' to proceed. ****");
        textLabel.setHorizontalAlignment(SwingConstants.CENTER);
        textLabel.setFocusTraversalPolicyProvider(rootPaneCheckingEnabled);
        applyButton = new JButton("Apply Job");

        JPanel panel = new JPanel(new BorderLayout());
        panel.add(scrollPane, BorderLayout.CENTER);
        panel.add(textLabel, BorderLayout.NORTH);
        panel.add(applyButton, BorderLayout.SOUTH);

        add(panel);
    }

    public JTable getJobTable() { return jobTable; }
    public JButton getApplyButton() { return applyButton; }
}
