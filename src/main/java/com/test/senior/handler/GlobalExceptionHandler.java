package com.test.senior.handler;

import com.test.senior.exception.RecordNotFoundException;
import com.test.senior.helper.i18n.Translator;
import com.test.senior.helper.web.dto.ErrorResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RequiredArgsConstructor
@ControllerAdvice
@Order(Ordered.LOWEST_PRECEDENCE)
@RestController
public class GlobalExceptionHandler {

  private final Translator translator;

  /**
   * Handler for RecordNotFoundException.
   *
   * @param ex RecordNotFoundException
   * @return ErrorResponse
   */
  @ResponseStatus(HttpStatus.NOT_FOUND)
  @ExceptionHandler(value = RecordNotFoundException.class)
  public ErrorResponse handlerRecordNotFoundException(RecordNotFoundException ex) {
    log.error(ex.getMessage());
    ErrorResponse response = new ErrorResponse();
    response.setError(translator.get("error.record_not_found"));
    response.setErrorDescription(ex.getMessage());
    return response;
  }
}
