/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/* global bootbox */

//Función que genera un alert personalizado con bootbox.
//Recibe como parámetros el título y cuerpo del mensaje.

function bootBoxAlert(icono,titulo, mensaje) {
    bootbox.dialog({
        title: icono+ titulo,
        message: '<div class="row" style="text-align: justify">' +
                '<div class=col-md-12>' +
                '<h3 class=panel-title>' + mensaje + '</h3>' +
                '</div>' +
                '</div>',
        buttons: {
            main: {
                label: '<i class="fa fa-check-circle"></i> Aceptar',
                className: "btn-primary"
            }
        }
    });
}
