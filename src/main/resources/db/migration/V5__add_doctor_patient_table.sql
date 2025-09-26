CREATE TABLE doctor_patients
(
    doctor_id BIGINT NOT NULL,
    patient_id BIGINT NOT NULL,
    PRIMARY KEY (doctor_id, patient_id),
    CONSTRAINT fk_doctor FOREIGN KEY (doctor_id) REFERENCES doctors (id) ON DELETE CASCADE,
    CONSTRAINT fk_patient FOREIGN KEY (patient_id) REFERENCES patients (id) ON DELETE CASCADE
);
