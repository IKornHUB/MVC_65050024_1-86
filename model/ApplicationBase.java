package model;

import java.time.LocalDateTime;

public abstract class ApplicationBase {
    protected String jobId;
    protected String candidateId;
    protected LocalDateTime appliedDate;

    public ApplicationBase(String jobId, String candidateId, LocalDateTime appliedDate) {
        this.jobId = jobId;
        this.candidateId = candidateId;
        this.appliedDate = appliedDate;
    }

    public String getJobId() { return jobId; }
    public String getCandidateId() { return candidateId; }
    public LocalDateTime getAppliedDate() { return appliedDate; }

    // แต่ละประเภทงานต้อง implement เงื่อนไขการสมัครเอง
    public abstract boolean isEligible(Candidate candidate);

    @Override
    public String toString() {
        return "Job: " + jobId + " | Candidate: " + candidateId + " | Date: " + appliedDate;
    }
}
