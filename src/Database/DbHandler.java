package Database;

import java.sql.Timestamp;

public class DbHandler {

//  --------------- 입 차 ---------------
    // 1. 사용자가 입력한 차 번호로 입차 처리
    public static void insertCar() {
        CarsDAO.addCar();
        Car_ParkDAO.updateCarPark();
    }

//  --------------- 결 제 ---------------
    // 1. 사용자가 결제요청 시 출차시간 업데이트 후 출차시간 리턴
    public static Timestamp updateOutTime() {
        Car_ParkDAO.updateOuttime();
        return  Car_ParkDAO.getOutTime();
    }

    // 2. 결제를 위한 입차시간 리턴
    public static Timestamp getInTime() {
        return Car_ParkDAO.getInTime();
    }

//  --------------- 출 차 ---------------
    // 결제완료 후 결제로그 처리, 출차한 차량 데이터삭제
    public static void OutCar() {
        PaymentDAO.addLog();
        Car_ParkDAO.deleteCar();
    }



}
