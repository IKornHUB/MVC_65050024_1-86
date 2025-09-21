package model;

public class Candidate {
    private String id;        // รหัสผู้สมัคร (8 หลัก ไม่ขึ้นต้นด้วย 0)
    private String firstName; // ชื่อ
    private String lastName;  // นามสกุล
    private String email;     // อีเมล
    private String status;    // สถานะ (Student หรือ Graduate)

    public Candidate(String id, String firstName, String lastName, String email, String status) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.status = status;
    }

    public String getId() { return id; }
    public String getFirstName() { return firstName; }
    public String getLastName() { return lastName; }
    public String getEmail() { return email; }
    public String getStatus() { return status; }

    public String getFullName() {
        return firstName + " " + lastName;
    }

    @Override
    public String toString() {
        return getFullName() + " (" + status + ")";
    }
}
