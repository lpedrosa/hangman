package io.github.lpedrosa.common;

public class ServiceException extends Exception {

    private static final long serialVersionUID = -3864431436384272267L;

    public ServiceException(final String msg) {
        super(msg);
    }
}
