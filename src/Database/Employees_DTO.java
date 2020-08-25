package Database;

public class Employees_DTO {
    private static int Emp_ID;
    private static String Emp_name;
    private static String EmpCar_number;


    // Getter
    public static int getEmp_ID() {
        return Emp_ID;
    }

    public static String getEmp_name() {
        return Emp_name;
    }

    public static String getEmpCar_number() {
        return EmpCar_number;
    }

    // Setter
    public static void setEmp_ID(int emp_ID) {
        Emp_ID = emp_ID;
    }

    public static void setEmp_name(String emp_name) {
        Emp_name = emp_name;
    }

    public static void setEmpCar_number(String empCar_number) {
        EmpCar_number = empCar_number;
    }
}
