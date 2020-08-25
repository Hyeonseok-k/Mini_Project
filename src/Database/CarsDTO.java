package Database;

public class CarsDTO {

    // field (Columns)
    private static int cars_ID; // primary Key, Auto increment
    private static String car_Number;
    private static boolean is_Employees_car;

    // Getter Method
    public static int getCars_ID() {
        return cars_ID;
    }

    public static String getCar_Number() {
        return car_Number;
    }

    public static boolean is_Employees_car() {
        return is_Employees_car;
    }

    // Setter Method
    public static void setCars_ID(int cars_ID) {
        CarsDTO.cars_ID = cars_ID;
    }

    public static void setCar_Number(String number) {
        car_Number = number;
    }

    public static void setIs_Employees_car(boolean isemp) {
        is_Employees_car = isemp;
    }
}


