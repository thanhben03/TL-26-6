package Employee.models;

public class NguoiQuanLy extends NhanVien{
    double bonus;

    public NguoiQuanLy(String name, double salary, double bonus) {
        super(name, salary);
        this.bonus = bonus;
    }

    @Override
    double salary() {
        return salary + bonus;
    }

    @Override
    public void displayInfo() {
        System.out.println(
                "Manager name: " + getName() +
                "\nBase salary: " + getBaseSalary() +
                "\nBonus: " + getBonus() +
                        "\nTotal Salary: " + salary()
        );
    }

    public double getBonus() {
        return bonus;
    }
}
