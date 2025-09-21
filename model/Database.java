package model;

import java.time.LocalDate;
// import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Database {
    private List<Company> companies;
    private List<Job> jobs;
    private List<Candidate> candidates;
    private List<ApplicationBase> applications;

    public Database() {
        companies = new ArrayList<>();
        jobs = new ArrayList<>();
        candidates = new ArrayList<>();
        applications = new ArrayList<>();

        seedData(); // ใส่ข้อมูลตัวอย่าง
    }

    private void seedData() {
        // --- Companies ---
        companies.add(new Company("10000001", "TechCorp", "hr@techcorp.com", "Bangkok"));
        companies.add(new Company("10000002", "EduSoft", "contact@edusoft.com", "Chiang Mai"));

        // --- Jobs ---
        jobs.add(new Job("20000001", "Software Engineer", "Develop software applications",
                "10000001", LocalDate.now().plusDays(10), true, "Normal"));
        jobs.add(new Job("20000002", "Data Analyst", "Analyze data and create reports",
                "10000001", LocalDate.now().plusDays(5), true, "Normal"));
        jobs.add(new Job("20000003", "QA Tester", "Test applications for bugs",
                "10000001", LocalDate.now().plusDays(7), true, "Normal"));
        jobs.add(new Job("20000004", "Intern Developer", "Assist development team",
                "10000001", LocalDate.now().plusDays(15), true, "Internship"));
        jobs.add(new Job("20000005", "UI/UX Designer", "Design user interfaces",
                "10000001", LocalDate.now().plusDays(3), false, "Normal"));
        jobs.add(new Job("20000006", "Java Developer", "Maintain Java applications",
                "10000002", LocalDate.now().plusDays(8), true, "Normal"));
        jobs.add(new Job("20000007", "Project Manager", "Manage software projects",
                "10000002", LocalDate.now().plusDays(12), true, "Normal"));
        jobs.add(new Job("20000008", "Intern Data Scientist", "Work with AI/ML team",
                "10000002", LocalDate.now().plusDays(20), true, "Internship"));
        jobs.add(new Job("20000009", "System Administrator", "Maintain IT systems",
                "10000002", LocalDate.now().plusDays(6), false, "Normal"));
        jobs.add(new Job("20000010", "Web Developer", "Build and maintain websites",
                "10000002", LocalDate.now().plusDays(9), true, "Normal"));

        // --- Candidates ---
        candidates.add(new Candidate("30000001", "Somchai", "Sukjai", "somchai@gmail.com", "Graduate"));
        candidates.add(new Candidate("30000002", "Suda", "Yingyai", "suda@gmail.com", "Graduate"));
        candidates.add(new Candidate("30000003", "Anan", "Meechai", "anan@gmail.com", "Student"));
        candidates.add(new Candidate("30000004", "Nok", "Narak", "nok@gmail.com", "Student"));
        candidates.add(new Candidate("30000005", "Korn", "Jaiyen", "korn@gmail.com", "Graduate"));
        candidates.add(new Candidate("30000006", "Nam", "Wong", "nam@gmail.com", "Graduate"));
        candidates.add(new Candidate("30000007", "May", "Thida", "may@gmail.com", "Student"));
        candidates.add(new Candidate("30000008", "Tee", "Rungroj", "tee@gmail.com", "Graduate"));
        candidates.add(new Candidate("30000009", "Fah", "Thong", "fah@gmail.com", "Student"));
        candidates.add(new Candidate("30000010", "Art", "Yod", "art@gmail.com", "Graduate"));

        // --- Applications (ยังว่าง, จะเพิ่มตอนสมัครงาน) ---
    }

    // --- Getter Methods ---
    public List<Company> getCompanies() { return companies; }
    public List<Job> getJobs() { return jobs; }
    public List<Candidate> getCandidates() { return candidates; }
    public List<ApplicationBase> getApplications() { return applications; }

    // --- Helper Methods ---
    public Company getCompanyById(String id) {
        return companies.stream()
                .filter(c -> c.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    public Candidate getCandidateById(String id) {
        return candidates.stream()
                .filter(c -> c.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    public List<Job> getOpenJobs() {
        List<Job> openJobs = new ArrayList<>();
        for (Job job : jobs) {
            if (job.isOpen()) openJobs.add(job);
        }
        return openJobs;
    }

    public boolean login(String userId, String userType) {
        if ("Graduate".equals(userType) && getCandidateById(userId) != null) {
                return true;
        } else if ("Student".equals(userType) && getCandidateById(userId) != null) {
                return true;
        }
     return false;
    }  

    public void addApplication(ApplicationBase app) {
        applications.add(app);
    }
}
