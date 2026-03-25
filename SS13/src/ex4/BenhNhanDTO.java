package ex4;


import java.util.List;

public class BenhNhanDTO {

    private int id;
    private String name;
    private List<DichVu> dsDichVu;

    // Constructor rỗng
    public BenhNhanDTO() {
    }

    // Constructor đầy đủ
    public BenhNhanDTO(int id, String name, List<DichVu> dsDichVu) {
        this.id = id;
        this.name = name;
        this.dsDichVu = dsDichVu;
    }

    // Getter & Setter
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<DichVu> getDsDichVu() {
        return dsDichVu;
    }

    public void setDsDichVu(List<DichVu> dsDichVu) {
        this.dsDichVu = dsDichVu;
    }

    @Override
    public String toString() {
        return "BenhNhanDTO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", dsDichVu=" + dsDichVu +
                '}';
    }
}

