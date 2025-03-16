package com.app.patients_api.exceptions;

import org.springframework.web.bind.annotation.ResponseStatus;

import java.io.Serial;

import static java.lang.String.format;
import static org.springframework.http.HttpStatus.NO_CONTENT;

@ResponseStatus(NO_CONTENT)
public class NoContentException extends RuntimeException {

  @Serial
  private static final long serialVersionUID = 1398954373743289078L;

  public NoContentException(final String msg) {
    super(msg);
  }

  public NoContentException(final String msg, final Object... arguments) {
    super(format(msg, arguments));
  }
}
