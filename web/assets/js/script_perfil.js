/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


const $seleccionArchivosDonatario = document.querySelector("#seleccionArchivosDonatario"),
        $imagenPrevisualizacionDonatario = document.querySelector("#imagenPrevisualizacionDonatario");

// Escuchar cuando cambie
$seleccionArchivosDonatario.addEventListener("change", () => {
    // Los archivos seleccionados, pueden ser muchos o uno
    const archivos = $seleccionArchivosDonatario.files;
    // Si no hay archivos salimos de la función y quitamos la imagen
    if (!archivos || !archivos.length) {
        $imagenPrevisualizacionDonatario.src = "assets/img/user_default.png";
        document.getElementById('info-imagen-Donatario').innerHTML = "";
        return;
    }
    // Ahora tomamos el primer archivo, el cual vamos a previsualizar
    const primerArchivo = archivos[0];
    // Lo convertimos a un objeto de tipo objectURL
    const objectURL = URL.createObjectURL(primerArchivo);
    // Y a la fuente de la imagen le ponemos el objectURL
    $imagenPrevisualizacionDonatario.src = objectURL;

    var pdrs = document.getElementById('seleccionArchivosDonatario').files[0].name;
    document.getElementById('info-imagen-Donatario').innerHTML = pdrs;
});