CREATE TABLE Doctor(
DoctorID INT NOT NULL,
DoctorName VARCHAR(100) NOT NULL,
Degree VARCHAR(100) NOT NULL,
OtherCredentials VARCHAR(256) NOT NULL,
City VARCHAR(255) NOT NULL,
DoctorUsername VARCHAR(30) NOT NULL,
DoctorPassword VARCHAR(30) NOT NULL,
PRIMARY KEY (DoctorID));

CREATE TABLE Patient(
PatientID INT NOT NULL,
DoctorID INT NOT NULL,
PatientName VARCHAR(100) NOT NULL,
Address VARCHAR(255) NOT NULL,
City VARCHAR(255) NOT NULL,
PatientUsername VARCHAR(30) NOT NULL,
PatientPassword VARCHAR(30) NOT NULL,
PRIMARY KEY (PatientID),
FOREIGN KEY (DoctorID) REFERENCES Doctor(DoctorID));

CREATE TABLE SentMessage(
SentMessageID INT NOT NULL,
DoctorID INT,
PatientID INT,
SentDateTime DATE NOT NULL,
MessageText VARCHAR(256) NOT NULL,
RecipientName VARCHAR(100) NOT NULL,
PRIMARY KEY (SentMessageID),
FOREIGN KEY (DoctorID) REFERENCES Doctor(DoctorID),
FOREIGN KEY (PatientID) REFERENCES Patient(PatientID));
--for a SentMessage, only one of the foreign keys will be used and the other will be null

CREATE TABLE ReceivedMessage(
ReceivedMessageID INT NOT NULL,
DoctorID INT,
PatientID INT,
ReceivedDateTime DATE NOT NULL,
MessageText VARCHAR(256) NOT NULL,
SenderName VARCHAR(100) NOT NULL,
PRIMARY KEY (ReceivedMessageID),
FOREIGN KEY (DoctorID) REFERENCES Doctor(DoctorID),
FOREIGN KEY (PatientID) REFERENCES Patient(PatientID));
--for a ReceivedMessage, only one of the foreign keys will be used and the other will be null

CREATE TABLE Record(
RecordID INT NOT NULL,
PatientID INT NOT NULL,
RecordName VARCHAR(50) NOT NULL,
RecordText VARCHAR(256) NOT NULL,
PRIMARY KEY (RecordID),
FOREIGN KEY (PatientID) REFERENCES Patient(PatientID));

CREATE TABLE Appointment(
AppointmentID INT NOT NULL,
DoctorID NOT NULL,
PatientID NOT NULL,
AppointmentDateTime DATE NOT NULL,
AppointmentPlace VARCHAR(50) NOT NULL,
PRIMARY KEY (AppointmentID),
FOREIGN KEY (DoctorID) REFERENCES Doctor(DoctorID),
FOREIGN KEY (PatientID) REFERENCES Patient(PatientID));

CREATE TABLE Prescription(
PrescriptionID INT NOT NULL,
DoctorID INT NOT NULL,
PatientID INT NOT NULL,
PrescriptionName VARCHAR(50) NOT NULL,--Name
PrescriptionNotes VARCHAR(256) NOT NULL,--Description
LastRenewedDate DATE NOT NULL,--PatientAvailable
NeedsRenewal INT NOT NULL,--NeedsMore
PRIMARY KEY (PrescriptionID),
FOREIGN KEY (DoctorID) REFERENCES Doctor(DoctorID),
FOREIGN KEY (PatientID) REFERENCES Patient(PatientID));
-- treat NeedsRenewal as a boolean value where 1 = true and 0 = false

INSERT INTO Doctor VALUES(1, 'Tom', 'Doctorate of Medicine', 'Is a really cool guy!', 'Minneapolis', 'username', 'password');
INSERT INTO Patient VALUES(1, 1, 'Jim', '1320 Albrecht Blvd', 'Fargo', 'username', 'password');

COMMIT;

