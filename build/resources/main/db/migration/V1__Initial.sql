CREATE TABLE IF NOT EXISTS unit
(
    id                          BIGINT                 NOT NULL,
    name                        VARCHAR(255)           NOT NULL,
    deleted                     BOOLEAN                NOT NULL DEFAULT FALSE,

    PRIMARY KEY (id)
);

DROP SEQUENCE IF EXISTS unit_seq;

CREATE SEQUENCE unit_seq INCREMENT 1;
SELECT setval('unit_seq', coalesce((SELECT max(id) FROM unit), 1));


CREATE TABLE IF NOT EXISTS app_user
(
    username                        VARCHAR(255)              NOT NULL UNIQUE,
    first_name                      VARCHAR(255)              NOT NULL,
    last_name                       VARCHAR(255)              NOT NULL,
    password                        VARCHAR(255)              NOT NULL,
    phone_number                    VARCHAR(255),
    role                            VARCHAR                   NOT NULL,
    unit_id                         BIGINT,
    deleted                         BOOLEAN                   NOT NULL DEFAULT FALSE,


    PRIMARY KEY (username),
    CONSTRAINT fk_app_user_unit FOREIGN KEY (unit_id) REFERENCES unit(id),
    CONSTRAINT check_unit_id CHECK (
        (role IN ('ADMIN', 'MODERATOR') AND unit_id IS NOT NULL) OR
        (role = 'SUPER_ADMIN' AND unit_id IS NULL)
    )
);

INSERT INTO app_user (username, first_name, last_name, password, role, deleted)
values('superadmin', 'Super', 'Admin', '$2a$10$Z0/YwZCojgHpLy66/1xUuuoKPoAINYZAzJNsdezTYc/bm7SDhLUtu', 'SUPER_ADMIN', false);


CREATE TABLE IF NOT EXISTS patient
(
    patient_id                          VARCHAR(255)                NOT NULL,
    first_name                          VARCHAR(255)                NOT NULL,
    last_name                           VARCHAR(255)                NOT NULL,
    gender                              VARCHAR(255)                NOT NULL,
    date_of_birth                       BIGINT                      NOT NULL,
    mentions                            VARCHAR(4000),
    recommendation                      VARCHAR(4000),
    diseases                            VARCHAR(4000),
    unit_id                             BIGINT                      NOT NULL,
    contact_persons                     jsonb,
    deleted                             BOOLEAN                     NOT NULL DEFAULT FALSE,

    PRIMARY KEY (patient_id),
    CONSTRAINT fk_patient_unit_id FOREIGN KEY (unit_id) REFERENCES unit(id)
);


CREATE TABLE IF NOT EXISTS daily_status
(
    patient_id                       VARCHAR(255)              NOT NULL,
    timestamp                        BIGINT                    NOT NULL,
    activities                       VARCHAR(4000),
    mentions                         VARCHAR(4000),
    medication                       VARCHAR(4000),
    health_condition                 VARCHAR(4000),
    meals                            VARCHAR(4000),
    assigned_to                      VARCHAR,

    PRIMARY KEY (patient_id, timestamp),
    CONSTRAINT fk_daily_status_assigned_to FOREIGN KEY (assigned_to) REFERENCES app_user(username),
    CONSTRAINT fk_daily_status_patient_id FOREIGN KEY (patient_id) REFERENCES patient(patient_id)
);



