import re

def retrieve_values():
    #get first name
    f_name = input("Please enter your first name: ")
    while f_name == "":
        print("No name entered.")
        f_name = input("Please enter your first name: ")

    #get last name
    l_name = input("Please enter your last name: ")
    while l_name == "":
        print("No name entered.")
        l_name = input("Please enter your last name: ")

    #get phone number
    def check_phone_number(number):
        return re.search("[^0-9-]",number)

    phone_number = input("Please enter your phone number with only digits (0-9) and dashes (-): ")
    while check_phone_number(phone_number) or phone_number == "":
        if phone_number == "":
            print("No phone number entered.")
        elif check_phone_number(phone_number):
            print("Characters other than digits (0-9) and dashes (-) were entered.")
        phone_number = input("Please enter your phone number with only digits (0-9) and dashes (-): ")

    #get number of panels
    def is_int(value):
        try:
            int(value)
            return True
        except ValueError:
            return False

    panels_flag = True
    while panels_flag:
        panels_number = input("Please enter the number of panels would you like to purchase (minimum 2, maximum 1000): ")
        if panels_number == "":
            print("Nothing entered.")
            continue
        elif not is_int(panels_number):
            print("Was not a whole number from 2 to 1000 (no comma like this: 1,000).")
            continue
        elif int(panels_number) < 2:
            print("The number of panels was less than 2.")
            continue
        elif int(panels_number) > 1000:
            print("The number of panels was greater than 1000.")
            continue
        panels_flag = False
        panels_number = int(panels_number)

    #get deposit amount
    def is_float(value):
        try:
            float(value)
            return True
        except ValueError:
            return False

    deposit_flag = True
    while deposit_flag:
        deposit_number = input("Please enter the deposit you would like to put down, excluding the dollar sign (0.00 if not desired): ")
        if deposit_number == "":
            print("Nothing entered.")
            continue
        elif not is_float(deposit_number):
            print("Was not a decimal number (no dollar signs like this $200.00).")
            continue
        elif float(deposit_number) < 0.0:
            print("The deposit cannot be a negative number.")
            continue
        deposit_flag = False
        deposit_number = float(deposit_number)

    #get express shipping
    express_flag = True
    while express_flag:
        express_bool = input("Let us know if you would like express installation for an extra 5 percent to total cost (T or F): ").lower()
        if express_bool == "":
            print("Nothing entered.")
            continue
        elif express_bool == "t" or express_bool == "true":
            express_bool = True
            express_flag = False
            continue
        elif express_bool == "f" or express_bool == "false":
            express_bool = False
            express_flag = False
            continue
        else:
            print("Value entered was not \"T\", \"True\", \"F\", or \"False\".")

    #return all the values in a list
    return [f_name, l_name, phone_number, panels_number, deposit_number, express_bool]

#end retrieveValues() method


def calculate_results(values):
    base_cost = 2000

    additional_panels_cost = 300 * (values[3] - 2)

    total_cost = base_cost + additional_panels_cost
    if values[5]:
        total_cost *= 1.05;

    balance_due = total_cost - values[4]

    values.append(base_cost)
    values.append(additional_panels_cost)
    values.append(total_cost)
    values.append(balance_due)

    return values

#end calculateValues() method


def print_out_results(results):
    print("")

    s = results[0] + " " + results[1] + ", thank you for your order"
    if results[5]:
        s += " with express installation"
    s += "!"
    print(s)

    print("If we have any issues, we will contact you at your phone number (" + results[2] + ").")

    print("Base Cost: $" + str(results[6]))

    if results[3] == 3:
        print("1 Additional Panel Cost: $" + str(results[7]))
    else:
        print(str((results[3] - 2)) + " Additional Panels Cost: $" + str(results[7]))

    print("Total Cost: $" + str(results[8]))

    print("Deposit: $" + str(results[4]))

    if results[9] > 0:
        print("Balance Due: $" + str(results[9]))
    else:
        print("Refund: $" + str((-1 * results[9])))


#end of printOutResults() method


def main():
    values = retrieve_values()
    results = calculate_results(values)
    print_out_results(results)

main()