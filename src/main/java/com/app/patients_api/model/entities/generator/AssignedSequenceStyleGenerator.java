package com.app.patients_api.model.entities.generator;

import com.app.patients_api.model.entities.WithId;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.enhanced.SequenceStyleGenerator;

import java.io.Serial;
import java.io.Serializable;

public class AssignedSequenceStyleGenerator extends SequenceStyleGenerator {

  @Serial
  private static final long serialVersionUID = 5598445671157729871L;

  @Override
  public Serializable generate(final SharedSessionContractImplementor session, final Object obj) {

    if (!(obj instanceof WithId withId)) {
      return null;
    }

    final var id = withId.getId();
    return id != null ? id : (Long) super.generate(session, obj);
  }
}
