package Employee.models;

public abstract class NhanVien {
    protected String name;
    protected double salary;

    public NhanVien(String name, double salary) {
        this.name = name;
        this.salary = salary;
    }

    abstract double salary();
    abstract void displayInfo();

    public String getName() {
        return name;
    }

    public double getBaseSalary() {
        return salary;
    }

}
