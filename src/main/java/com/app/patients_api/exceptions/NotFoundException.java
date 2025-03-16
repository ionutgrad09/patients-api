package com.app.patients_api.exceptions;

import org.springframework.web.bind.annotation.ResponseStatus;

import java.io.Serial;

import static java.lang.String.format;
import static org.springframework.http.HttpStatus.NOT_FOUND;

@ResponseStatus(NOT_FOUND)
public class NotFoundException extends RuntimeException {

  @Serial
  private static final long serialVersionUID = 1398954373743289078L;

  public NotFoundException(final String msg) {
    super(msg);
  }

  public NotFoundException(final String msg, final Object... arguments) {
    super(format(msg, arguments));
  }
}
