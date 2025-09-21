package model;

import java.time.LocalDateTime;

public class InternshipApplication extends ApplicationBase {

    public InternshipApplication(String jobId, String candidateId, LocalDateTime appliedDate) {
        super(jobId, candidateId, appliedDate);
    }

    @Override
    public boolean isEligible(Candidate candidate) {
        //  เฉพาะผู้สมัครที่กำลังศึกษา (Student)
        return "Student".equalsIgnoreCase(candidate.getStatus());
    }
}
