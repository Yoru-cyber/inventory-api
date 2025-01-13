package io.github.yorucyber.inventory_api.exceptions;

public class SaleNotFoundException extends RuntimeException {
    private String message;
    private long id;

    public SaleNotFoundException() {
    }

    public SaleNotFoundException(String msg, long id) {
        super(msg);
        this.message = msg;
        this.id = id;
    }
}