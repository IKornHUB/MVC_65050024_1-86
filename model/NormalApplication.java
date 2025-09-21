package model;

import java.time.LocalDateTime;

public class NormalApplication extends ApplicationBase {

    public NormalApplication(String jobId, String candidateId, LocalDateTime appliedDate) {
        super(jobId, candidateId, appliedDate);
    }

    @Override
    public boolean isEligible(Candidate candidate) {
        //  เฉพาะผู้สมัครที่จบแล้ว (Graduate)
        return "Graduate".equalsIgnoreCase(candidate.getStatus());
    }
}
