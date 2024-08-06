public class Employee {

    private String name;
    private int idNumber;
    private String department;
    private String position;

    // Конструкторы
    public Employee() {
        this.name = "(not set)";
        this.idNumber = 0;
        this.department = "(not set)";
        this.position = "(not set)";
    }

    public Employee(String name, int idNumber) {
        this.name = name;
        this.idNumber = idNumber;
        this.department = "(not set)";
        this.position = "(not set)";
    }

    public Employee(String name, int idNumber, String department, String position) {
        this.name = name;
        this.idNumber = idNumber;
        this.department = department;
        this.position = position;
    }

    // Геттеры и сеттеры
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getIdNumber() {
        return idNumber;
    }

    public void setIdNumber(int idNumber) {
        this.idNumber = idNumber;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public void printEmployeeDetails() {
        System.out.println("Name: " + name);
        System.out.println("ID Number: " + idNumber);
        System.out.println("Department: " + department);
        System.out.println("Position: " + position);
    }
}