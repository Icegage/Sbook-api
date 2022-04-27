package com.highgag.sbook.error;

public class DuplicatedUserException extends CustomException {

    private static final long serialVersionUID = -2116671122895194101L;

    public DuplicatedUserException() {
        super(ErrorCode.CONFLICT);
    }
}