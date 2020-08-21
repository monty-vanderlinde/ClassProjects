def is_float(value):
    try:
        float(value)
        return True
    except ValueError:
        return False

class Motor:
    def __init__(self, motorID, description, rpm, voltage, status):
        if len(motorID) == 5:
            self.MotorID = motorID
        else:
            self.MotorID = "BadID"

        self.Description = description

        if is_float(voltage) and voltage >= 1 and voltage <= 500:
            self.Voltage = voltage
        else:
            self.Voltage = 1

        if is_float(rpm) and rpm >= 10 and rpm <= 10000:
            self.RPM = rpm
        else:
            self.RPM = 10

        if status == "ON" or status == "OFF" or status == "MNT" or status == "NA":
            self.Status = status
        else:
            self.Status = "BAD"

    def toString(self):
        return "Motor ID: " + self.MotorID + "; Description: " + self.Description + "; Voltage: " + str(self.Voltage) + "; RPM: " + str(self.RPM) + "; Status: " + self.Status

def display_all_motors( motorArray ):
    for motor in motorArray:
        print(motor.toString())

def main():
    motors = [Motor("12345", "Big Motor", 500, 10000, "ON"), Motor("54321", "Medium Motor", 100, 1000, "OFF"), Motor("12321", "Small Motor", 5, 100, "MTN")]
    display_all_motors(motors)

main()