package controller;

import model.*;
import view.ApplicationFormView;

import javax.swing.*;
import java.time.LocalDateTime;

public class ApplicationController {
    private Database db;
    private ApplicationFormView appView;
    private String jobId;
    private String jobTitle;

    public ApplicationController(Database db, String jobId, String jobTitle) {
        this.db = db;
        this.jobId = jobId;
        this.jobTitle = jobTitle;
        this.appView = new ApplicationFormView(jobId, jobTitle);

        // กด submit
        appView.getSubmitButton().addActionListener(e -> handleSubmit());

        appView.setVisible(true);
    }

    private void handleSubmit() {
        String candidateId = appView.getCandidateIdField().getText().trim();
        String email = appView.getEmailField().getText().trim();

        Candidate candidate = db.getCandidateById(candidateId);
        Job job = db.getJobs().stream()
                .filter(j -> j.getId().equals(jobId))
                .findFirst()
                .orElse(null);

        // --- ตรวจสอบเบื้องต้น ---
        if (candidate == null || job == null) {
            JOptionPane.showMessageDialog(appView, "Invalid Candidate ID or Job ID.");
            return;
        }
        if (!email.contains("@")) {
            JOptionPane.showMessageDialog(appView, "Invalid email format.");
            return;
        }

        // --- ตรวจสอบ Eligibility ตามประเภทงาน ---
        ApplicationBase Newapp;
        if ("Internship".equalsIgnoreCase(job.getType())) {
            Newapp = new InternshipApplication(jobId, candidateId, LocalDateTime.now());
        } else {
            Newapp = new NormalApplication(jobId, candidateId, LocalDateTime.now());
        }

        if (!Newapp.isEligible(candidate)) {
            JOptionPane.showMessageDialog(appView,
                    "You are not eligible to apply for this job (" + job.getType() + ").");
            return;
        }

        // --- ถ้าผ่าน -> บันทึก Application (Data Model) ---
        db.addApplication(Newapp);
        
        JOptionPane.showMessageDialog(appView,
                "Application submitted successfully for job: " + job.getTitle());
        appView.dispose(); // ปิดฟอร์ม
    }
}
