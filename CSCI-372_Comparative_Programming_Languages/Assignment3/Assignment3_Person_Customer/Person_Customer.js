function Person(lastName, firstName, address, city, state, zip, phone) {
    this.lastName   = lastName;     //string
    this.firstName  = firstName;    //string
    this.address    = address;      //string
    this.city       = city;         //string
    this.state      = state;        //string
    this.zip        = zip;          //string
    this.phone      = phone;        //string
}

Person.prototype.toString = function () {
    return "Name: " + this.lastName + ", " + this.firstName + "<br>Address: " + this.address + ", " + this.city + ", " + this.state + ", " + this.zip + "<br>Phone Number: " + this.phone;
}

function Customer(lastName, firstName, address, city, state, zip, phone, customerNumber, mailingList, comments) {
    Person.call(this, lastName, firstName, address, city, state, zip, phone);
    this.customerNumber = customerNumber;   //number
    this.mailingList    = mailingList;      //boolean
    this.comments = comments;               //string
}

Customer.prototype.toString = function () {
    return Person.prototype.toString.call(this) + "<br>Customer Number: " + this.customerNumber + "<br>On Mailing List: " + this.mailingList + "<br>Other Comments: " + this.comments;
}

window.onload = function () {
    var x = document.getElementById('submit');
    if (x.addEventListener)
        x.addEventListener("click", buttonClicked);
    else if (x.attachEvent)
        x.attachEvent("onclick", buttonClicked);


    var bodyEl          = document.getElementById("body");

    var lastNameEl      = document.getElementById("lastName");
    var firstNameEl     = document.getElementById("firstName");
    var addressEl       = document.getElementById("address");
    var cityEl          = document.getElementById("city");
    var stateEl         = document.getElementById("state");
    var zipEl           = document.getElementById("zip");
    var phoneEl         = document.getElementById("phone");
    var mailingListEl   = document.getElementById("mailingList");
    var commentsEl      = document.getElementById("comments");

    var nextCustomerNumber = 111111;

    function buttonClicked() {
        if((lastNameEl.value === "") || (firstNameEl.value === "") || (addressEl.value === "") || (cityEl.value === "") || (stateEl.value === "") || (zipEl.value === "") || (phoneEl.value === "")){
            return;
        }

        var customer = new Customer(lastNameEl.value, firstNameEl.value, addressEl.value, cityEl.value, stateEl.value, zipEl.value, phoneEl.value, nextCustomerNumber++, mailingListEl.checked, commentsEl.value);
        //new Customer(lastNameEl.value, firstNameEl.value, addressEl.value, cityEl.value, stateEl.value, zipEl.value, phoneEl.value, nextCustomerNumber++, mailingListEl.value, commentsEl.value);

        var p = document.createElement("P");
        p.innerHTML = customer.toString();
        bodyEl.appendChild(p);
    }
}