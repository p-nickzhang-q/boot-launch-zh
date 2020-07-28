package com.zh.boot.launch.exceptions;

public class NotFoundException extends RuntimeException {

    /**
     *
     */
    private static final long serialVersionUID = -1819522025720812659L;
    private static final String Default = "Not found this entity";

    public NotFoundException(String string) {
        super(string);
    }

    public NotFoundException() {
        super(Default);
    }

}
