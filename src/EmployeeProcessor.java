import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class EmployeeProcessor {

    private List<Employee> employees;

    public EmployeeProcessor() {
        this.employees = new ArrayList<>();
    }

    // Метод для чтения данных из файла
    public void readDataFromFile(String filePath) {
        try {
            List<String> lines = Files.readAllLines(Paths.get(filePath));
            for (String line : lines) {
                String[] parts = line.split(",");
                if (parts.length == 4) {
                    Employee employee = new Employee(parts[0], Integer.parseInt(parts[1]), parts[2], parts[3]);
                    employees.add(employee);
                } else if (parts.length == 2) {
                    Employee employee = new Employee(parts[0], Integer.parseInt(parts[1]));
                    employees.add(employee);
                } else {
                    Employee employee = new Employee();
                    employees.add(employee);
                }
            }
        } catch (IOException e) {
            System.out.println("Ошибка чтения файла: " + e.getMessage());
        }
    }

    // Метод для сортировки данных
    public void sortData() {
        employees.sort((e1, e2) -> e1.getName().compareTo(e2.getName()));
    }

    // Метод для фильтрации данных
    public void filterData(String filter) {
        employees.removeIf(employee -> !employee.getName().contains(filter));
    }

    // Метод для вывода данных на консоль
    public void printData() {
        for (Employee employee : employees) {
            employee.printEmployeeDetails();
            System.out.println();
        }
    }

    // Метод для сохранения данных в файл
    public void saveDataToFile(String filePath) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            for (Employee employee : employees) {
                writer.write(employee.getName() + "," + employee.getIdNumber() + "," + employee.getDepartment() + "," + employee.getPosition());
                writer.newLine();
            }
        } catch (IOException e) {
            System.out.println("Ошибка записи в файл: " + e.getMessage());
        }
    }

    // Метод для ввода данных пользователем
    public void inputDataFromUser() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите данные (введите 'exit' для завершения):");
        while (true) {
            System.out.println("Введите имя сотрудника:");
            String name = scanner.nextLine();
            if (name.equalsIgnoreCase("exit")) {
                break;
            }
            System.out.println("Введите ID сотрудника:");
            int idNumber = scanner.nextInt();
            scanner.nextLine(); // Сбросить Enter
            System.out.println("Введите отдел сотрудника:");
            String department = scanner.nextLine();
            System.out.println("Введите должность сотрудника:");
            String position = scanner.nextLine();
            Employee employee = new Employee(name, idNumber, department, position);
            employees.add(employee);
        }
    }

    public static void main(String[] args) {
        EmployeeProcessor processor = new EmployeeProcessor();

        // Чтение данных из файла
        processor.readDataFromFile("input.txt");

        // Сортировка данных
        processor.sortData();

        // Фильтрация данных
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите данные (введите 'exit' для завершения):");
        System.out.println("Введите имя сотрудника:");
        String name = scanner.nextLine();
        processor.filterData(name);

        // Вывод данных на консоль
        processor.printData();

        // Ввод данных пользователем
        processor.inputDataFromUser();

        // Сохранение данных в файл
        processor.saveDataToFile("output.txt");
    }
}