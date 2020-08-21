function Carpet(color, style, price) {
    this.color = color; //string
    this.style = style; //string
    this.price = price; //number (decimal)
}

Carpet.prototype.totalPrice = function (area) {
    return this.price * area;
}

function Rectangle(width, length) {
    this.width  = width;            //number (decimal)
    this.length = length;           //number (decimal)
    this.area   = this.getArea();   //number (decimal)
}

Rectangle.prototype.getArea = function () {
    return this.width * this.length;
}

window.onload = function () {
    var x = document.getElementById('submit');
    if (x.addEventListener)
        x.addEventListener("click", buttonClicked);
    else if (x.attachEvent)
        x.attachEvent("onclick", buttonClicked);
    
    var colorEl     = document.getElementById("color");
    var styleEl     = document.getElementById("style");
    var priceEl     = document.getElementById("price");
    var widthEl     = document.getElementById("width");
    var lengthEl    = document.getElementById("length");
    var areaEl      = document.getElementById("area");
    var totalEl     = document.getElementById("total");

    function buttonClicked() {
        if((colorEl.value == "") || (styleEl.value == "") || (priceEl.value == "") || (widthEl.value == "") || (lengthEl.value == "")){
            return;
        }

        var carpet = new Carpet(colorEl.value, styleEl.value, priceEl.value);
        var rectangle = new Rectangle(widthEl.value, lengthEl.value);

        areaEl.innerHTML    = rectangle.area;
        totalEl.innerHTML   = "$" + carpet.totalPrice(rectangle.area).toFixed(2).replace(/\d(?=(\d{3})+\.)/g, '$&,');;
    }
}