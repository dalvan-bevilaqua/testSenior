package com.test.senior.handler;

public class BusinessException extends RuntimeException {

  private static final long serialVersionUID = 8248299523085267312L;

  public BusinessException() {
    super();
  }

  public BusinessException(String message) {
    super(message);
  }

}