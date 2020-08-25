package Discount;

public class Discount {
    // field
    private static int spendMoney;
    private static double rate;
    private static double discountedFee;
    private static int FinalFee;

    // Setter
    public static void setSpendMoney(int Money) {
        spendMoney = Money;
    }

    public static void setDiscountedFee(double discountedFee) {
        Discount.discountedFee = discountedFee;
    }

    public static void setFinalFee(int finalFee) {
        FinalFee = finalFee;
    }

    // Getter
    public static int getSpendMoney() {
        return spendMoney;
    }

    public static double getRate() {
        setDiscountRate();
        return rate;
    }

    public static int getFinalFee() {
        return FinalFee;
    }

    // 구매금액에따른 할인율 설정 메소드
    public static void setDiscountRate() {
        if (spendMoney < 10000) {
            rate = 0;
        } else if (spendMoney >= 10000 && spendMoney < 30000) {
            rate = 0.1;
        } else if (spendMoney >= 30000 && spendMoney < 50000) {
            rate = 0.3;
        } else if (spendMoney >= 50000) {
            rate = 1;
        }
    }
}

