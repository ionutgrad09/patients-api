package com.app.patients_api.exceptions;

import org.springframework.web.bind.annotation.ResponseStatus;

import java.io.Serial;

import static java.lang.String.format;
import static org.springframework.http.HttpStatus.BAD_REQUEST;

@ResponseStatus(BAD_REQUEST)
public class IllegalDataException extends RuntimeException {

  @Serial
  private static final long serialVersionUID = 6254986314855256378L;

  public IllegalDataException(final String msg) {
    super(msg);
  }

  public IllegalDataException(final String msg, final Throwable throwable) {
    super(msg, throwable);
  }

  public IllegalDataException(final String msg, final Object... arguments) {
    super(format(msg, arguments));
  }
}
