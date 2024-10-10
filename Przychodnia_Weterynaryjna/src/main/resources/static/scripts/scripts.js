function showDiv(divId) {
    var divs = document.getElementsByClassName('content-div');
    for (var i = 0; i < divs.length; i++) {
        divs[i].style.display = 'none';
    }

    document.getElementById(divId).style.display = 'block';
}