package Employee.Application;

import Employee.models.LapTrinhVien;
import Employee.models.NguoiQuanLy;

public class Main {
    public static void main(String[] args) {
        LapTrinhVien lapTrinhVien = new LapTrinhVien("Antal Nuka", 5000, 20, 25);
        NguoiQuanLy nguoiQuanLy = new NguoiQuanLy("Corona Cadogan", 6000, 1000);

        nguoiQuanLy.displayInfo();
        System.out.println("-------------------------------");
        lapTrinhVien.displayInfo();
    }
}
