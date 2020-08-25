package Admin;

public class AdminAccount {

    // field
    private static String adminID = "hyeonseok";
    private static String adminPass = "1234";

    private static String inputID;
    private static String inputPass;

    // Getter
    public static String getAdminID() {
        return adminID;
    }
    public static String getAdminPass() {
        return adminPass;
    }

    public static String getInputID() {
        return inputID;
    }
    // Setter

    public static void setInputID(String inputID) {
        AdminAccount.inputID = inputID;
    }

    public static void setInputPass(String inputPass) {
        AdminAccount.inputPass = inputPass;
    }
}
