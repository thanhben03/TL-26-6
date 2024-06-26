package Employee.models;

public class LapTrinhVien extends NhanVien{
    private int overTime;
    private int hourlyRate;

    public LapTrinhVien(String name, double salary, int overTime, int hourlyRate) {
        super(name, salary);
        this.overTime = overTime;
        this.hourlyRate = hourlyRate;
    }


    @Override
    double salary() {
        return overTime * hourlyRate + salary;
    }

    @Override
    public void displayInfo() {
        System.out.println(
                "Programmer name: " + getName() +
                "\nBase salary: $" + getBaseSalary() +
                "\nOvertime Hours: " + getOverTime() +
                "\nHourly Rate: $" + getHourlyRate() +
                "\nTotal Salary: $" + salary()
        );
    }

    public int getOverTime() {
        return overTime;
    }

    public int getHourlyRate() {
        return hourlyRate;
    }
}
