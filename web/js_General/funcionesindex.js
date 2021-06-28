function cargarElementoDinamicamente(url,elemento){
    var request = new XMLHttpRequest();
    request.open("GET", url, false);
    request.send(null);
    elemento.innerHTML = request.responseText;
}

function cargarRestaurante(){
    cargarElementoDinamicamente("Vista/altaUsuario.jsp",document.getElementById("contenidoDinamico"));
}

function cargarMenu(){
    cargarElementoDinamicamente("Vista/Menu.jsp",document.getElementById("contenidoDinamico"));
}

