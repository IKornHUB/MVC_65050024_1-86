package model;

import java.time.LocalDate;

public class Job {
    private String id;            // รหัสตำแหน่งงาน (8 หลัก ไม่ขึ้นต้นด้วย 0)
    private String title;         // ชื่อตำแหน่งงาน
    private String description;   // รายละเอียดงาน
    private String companyId;     // รหัสบริษัท
    private LocalDate deadline;   // วันสุดท้ายในการรับสมัคร
    private boolean isOpen;       // สถานะการรับสมัคร (เปิด/ปิด)
    private String type;          // ประเภทตำแหน่งงาน (Normal หรือ Internship)

    public Job(String id, String title, String description,
               String companyId, LocalDate deadline,
               boolean isOpen, String type) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.companyId = companyId;
        this.deadline = deadline;
        this.isOpen = isOpen;
        this.type = type;
    }

    public String getId() { return id; }
    public String getTitle() { return title; }
    public String getDescription() { return description; }
    public String getCompanyId() { return companyId; }
    public LocalDate getDeadline() { return deadline; }
    public boolean isOpen() { return isOpen; }
    public String getType() { return type; }

    @Override
    public String toString() {
        return title + " (" + type + ")";
    }
}
