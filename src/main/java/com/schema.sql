CREATE TABLE patients (
    patient_id int GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    fname varchar(255) NOT NULL,
    lname varchar(255) NOT NULL,
    dob date,
    sex varchar(1),
    height_cm int,
    weight_kg int,
    blood_type varchar(3)
);

CREATE TABLE doctors (
    doctor_id int GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    fname varchar(255) NOT NULL,
    lname varchar(255) NOT NULL,
    specialty varchar(255)
);

CREATE TABLE appointments (
    app_id int GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    patient_id int NOT NULL,
    doctor_id int,
    appointment_date timestamp NOT NULL,
    reason varchar(255),
    CONSTRAINT fk_appointments_patient FOREIGN KEY (patient_id) REFERENCES patients(patient_id) ON DELETE CASCADE,
    CONSTRAINT fk_appointments_doctor FOREIGN KEY (doctor_id) REFERENCES doctors(doctor_id) ON DELETE SET NULL
);