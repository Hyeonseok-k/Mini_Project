package Database;

public class  Car_ParkDTO {

    //field
    private static int car_Park_ID; // primary key, auto increment
    private static int in_Time; // Timestamp
    private static int out_Time; // Timestamp
    private static int available_Space;
    private static int cars_ID; // Foreign Key From Cars


    // Getter Method
    public static int getCar_Park_ID() {
        return car_Park_ID;
    }

    public static int getIn_Time() {
        return in_Time;
    }

    public static int getOut_Time() {
        return out_Time;
    }

    public static int getAvailable_Space() {
        return available_Space;
    }

    public static int getCars_ID() {
        return cars_ID;
    }

    // Setter Method
    public void setAvailable_Space(int available_Space) {
        this.available_Space = available_Space;
    }

    // 외래키 설정 메소드
    public static void setCars_ID() {
        cars_ID = CarsDTO.getCars_ID();
    }
}

