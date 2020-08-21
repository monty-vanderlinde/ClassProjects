window.onload = function () {
    var x = document.getElementById('submit');
    if (x.addEventListener)
        x.addEventListener("click", buttonClicked);
    else if (x.attachEvent)
        x.attachEvent("onclick", buttonClicked);

    document.getElementById("submit").addEventListener("click", killEvent);

    var inputForm = document.getElementById('inputForm');
    var outputForm = document.getElementById('outputForm');

    //global variables
    var fName = document.getElementById("fName");
    var lName = document.getElementById("lName");
    var phNumber = document.getElementById("phNumber");
    var paNumber = document.getElementById("paNumber");
    var deposit = document.getElementById("deposit");
    var express = document.getElementById("checkbox");
    var name = document.getElementById("name");
    var phone = document.getElementById("phone");
    var base = document.getElementById("base");
    var additional = document.getElementById("additional");
    var total = document.getElementById("total");
    var depositOutput = document.getElementById("depositOutput");
    var balance = document.getElementById("balance");
    var firstString;
    var lastString;
    var phoneString;
    var panelNumber;
    var depositNumber;
    var expressBool;
    var baseCost;
    var additionalCost;
    var totalCost;
    var balanceDue;
    
    function buttonClicked() {
        getValues();
        calculateResults();
        setResults();

        if (firstString != "" && lastString != "" && phoneString != "" && panelNumber != 0 && depositNumber != "" && (expressBool == true || expressBool == false))
            outputForm.removeAttribute("hidden");

        outputForm.dispatchEvent.preventDefault();
    }

    function getValues() {
        firstString = fName.value;
        lastString = lName.value;
        phoneString = phNumber.value;
        panelNumber = paNumber.value;
        depositNumber = deposit.value;
        expressBool = express.checked;
    }

    function calculateResults() {
        baseCost = 2000.00;
        additionalCost = (panelNumber - 2) * 300;
        totalCost = baseCost + additionalCost;
        if (expressBool)
            totalCost *= 1.05;
        balanceDue = totalCost - depositNumber;
    }

    function setResults() {
        var s = firstString + " " + lastString + ", thank you for your order";
        if (expressBool)
            s += " with express installation";
        s += "!";

        name.innerHTML = s;
        phone.innerHTML = "If we have any issues, we will contact you at your phone number (" + phoneString + ")";
        base.innerHTML = "Base Cost: $" + baseCost;

        if (panelNumber == 3)
            s = "1 Additional Panel Cost: $300";
        else
            s = (panelNumber - 2) + "Additional Panels Cost: $" + (300 * (panelNumber - 2));

        additional.innerHTML = s;
        total.innerHTML = "Total Cost: $" + totalCost;
        depositOutput.innerHTML = "Deposit: $" + depositNumber;

        if (balanceDue < 0)
            s = "Refund: $" + (-1 * balanceDue);
        else
            s = "Balance Due: $" + (balanceDue);

        balance.innerHTML = s;
    }

    function killEvent(event) {
        event.preventDefault()
    }
}
