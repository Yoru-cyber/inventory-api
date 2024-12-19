package io.github.yorucyber.inventory_api.exceptions;

public class MedicineNotFoundException extends RuntimeException{
    private String message;
    private long id;

    public MedicineNotFoundException() {}

    public MedicineNotFoundException(String msg, long id) {
        super(msg);
        this.message = msg;
        this.id = id;
    }
}
