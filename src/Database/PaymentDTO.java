package Database;

public class PaymentDTO {

    // field
    private int payment_ID; // primary key, auto increment
    private int payment_Log; // timestamp
    private int cars_ID; // Foreign Key from Cars


    // Getter Method
    public int getPayment_ID() {
        return payment_ID;
    }

    public int getPayment_Log() {
        return payment_Log;
    }

    public int getCars_ID() {
        return cars_ID;
    }

    // 외래키 설정
    public void setCars_ID() {
        this.cars_ID = CarsDTO.getCars_ID();
    }
}
