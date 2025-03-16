package com.app.patients_api.exceptions;

import org.springframework.web.bind.annotation.ResponseStatus;

import java.io.Serial;

import static java.lang.String.format;
import static org.springframework.http.HttpStatus.INTERNAL_SERVER_ERROR;

@ResponseStatus(INTERNAL_SERVER_ERROR)
public class InternalServerErrorException extends RuntimeException {

  @Serial
  private static final long serialVersionUID = 1016649985162776348L;

  public InternalServerErrorException(final String msg) {
    super(msg);
  }

  public InternalServerErrorException(final String msg, final Object... arguments) {
    super(format(msg, arguments));
  }
}
