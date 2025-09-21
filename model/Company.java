package model;

public class Company {
    private String id;       // รหัสบริษัท (8 หลัก ไม่ขึ้นต้นด้วย 0)
    private String name;     // ชื่อบริษัท
    private String email;    // อีเมลที่ใช้ติดต่อ
    private String location; // สถานที่ตั้งบริษัท

    public Company(String id, String name, String email, String location) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.location = location;
    }

    public String getId() { return id; }
    public String getName() { return name; }
    public String getEmail() { return email; }
    public String getLocation() { return location; }

    @Override
    public String toString() {
        return name + " (" + location + ")";
    }
}
