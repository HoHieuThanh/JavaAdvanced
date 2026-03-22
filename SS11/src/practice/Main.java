package practice;

import practice.model.Appointment;
import practice.repository.AppointmentRepository;

import java.sql.Date;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        AppointmentRepository repo = new AppointmentRepository();

        // Thêm
        repo.addAppointment(new Appointment(
                "Nguyen Van A",
                Date.valueOf("2026-03-25"),
                "Dr. B",
                "Pending"
        ));

        // Hiển thị
        List<Appointment> list = repo.getAllAppointments();
        for (Appointment a : list) {
            System.out.println(a.getId() + " - " + a.getPatientName()
                    + " - " + a.getAppointmentDate()
                    + " - " + a.getDoctorName()
                    + " - " + a.getStatus());
        }
    }
}

