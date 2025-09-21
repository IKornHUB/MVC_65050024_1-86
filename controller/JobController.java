package controller;

import model.Database;
import model.Job;
import model.Company;
import view.JobListView;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import java.util.List;

public class JobController {
    private Database db;
    private JobListView jobListView;

    public JobController(Database db) {
        this.db = db;
        this.jobListView = new JobListView(getOpenJobsTableModel());
        this.jobListView.setVisible(true);

        jobListView.getApplyButton().addActionListener(e -> {
            int selectedRow = jobListView.getJobTable().getSelectedRow();
            if (selectedRow >= 0) {
                String jobId = (String) jobListView.getJobTable().getValueAt(selectedRow, 0);
                String jobTitle = (String) jobListView.getJobTable().getValueAt(selectedRow, 1);
                new ApplicationController(db, jobId, jobTitle); // เปิดฟอร์มสมัคร
            } else {
                JOptionPane.showMessageDialog(jobListView, "Please select a job first!");
            }
        });
    }

    private DefaultTableModel getOpenJobsTableModel() {
        String[] columns = {"Job ID", "Title", "Company", "Deadline", "Type"};
        DefaultTableModel model = new DefaultTableModel(columns, 0);

        List<Job> jobs = db.getOpenJobs();
        for (Job job : jobs) {
            Company c = db.getCompanyById(job.getCompanyId());
            model.addRow(new Object[]{
                    job.getId(),
                    job.getTitle(),
                    c != null ? c.getName() : "Unknown",
                    job.getDeadline(),
                    job.getType()
            });
        }
        return model;
    }

    public JobListView getJobListView() {
        return jobListView;
    }
}
