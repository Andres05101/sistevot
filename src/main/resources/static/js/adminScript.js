var respuestaIndex = 0;
var temaIndex = 0;

function addTema(){
    var textoDiv = document.getElementById('tema');
    var newtextoDiv = document.createElement('div');
    newtextoDiv.innerHTML = '<label for="tema' + temaIndex + ' ">Tema:</label>'+
        '<input type="text" id="tema ' + temaIndex +'" name="temas" th:value="${tema.texto_tema}">';
    textoDiv.appendChild(newtextoDiv);
    temaIndex++;
}

function addRespuesta() {
    var respuestasDiv = document.getElementById('respuestas');
    var newRespuestaDiv = document.createElement('div');
    newRespuestaDiv.innerHTML = '<label for="respuesta' + respuestaIndex + '">Respuesta:</label>' +
        '<input type="text" id="respuesta' + respuestaIndex + '" name="respuestas" th:value="${respuesta.textoRespuesta}">';
    respuestasDiv.appendChild(newRespuestaDiv);
    respuestaIndex++;
}