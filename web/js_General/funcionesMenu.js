function cargarElementoDinamicamenteMenu(url,elemento){
    var request = new XMLHttpRequest();
    request.open("GET", url, false);
    request.send(null);
    elemento.innerHTML = request.responseText;
}

function agregarIngredientes(){
    cargarElementoDinamicamenteMenu("Vista/AddMenu.jsp",document.getElementById("agregarMenu"));
}



