package com.app.patients_api.exceptions;

import org.springframework.web.bind.annotation.ResponseStatus;

import java.io.Serial;

import static java.lang.String.format;
import static org.springframework.http.HttpStatus.FORBIDDEN;

@ResponseStatus(FORBIDDEN)
public class ForbiddenException extends RuntimeException {

  @Serial
  private static final long serialVersionUID = 1818281829951788521L;

  public ForbiddenException(final String msg) {
    super(msg);
  }

  public ForbiddenException(final String msg, final Object... arguments) {
    super(format(msg, arguments));
  }
}
