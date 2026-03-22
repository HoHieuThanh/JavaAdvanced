package ex5.business;


import ex5.dao.DoctorDAO;
import ex5.model.Doctor;

import java.util.List;

public class DoctorService {
    private DoctorDAO dao = new DoctorDAO();

    public void showAll() {
        List<Doctor> list = dao.getAllDoctors();
        for (Doctor d : list) {
            System.out.println(d.getId() + " - " + d.getName() + " - " + d.getSpecialty());
        }
    }

    public void add(Doctor d) {
        if (d.getId().isEmpty() || d.getName().isEmpty()) {
            System.out.println("Dữ liệu không hợp lệ");
            return;
        }

        dao.addDoctor(d);
    }

    public void statistic() {
        dao.countBySpecialty();
    }
}

