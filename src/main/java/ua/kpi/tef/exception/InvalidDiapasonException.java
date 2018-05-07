package ua.kpi.tef.exception;

public class InvalidDiapasonException extends Exception {
    private static String INVALID_DIAPASON = "Invalid diapason: ";
    private static String DIAPASON_DELIMITER = " - ";
    private String message;
    public InvalidDiapasonException(int lower, int upper) {
        super(INVALID_DIAPASON + lower + DIAPASON_DELIMITER + upper);
    }
}
