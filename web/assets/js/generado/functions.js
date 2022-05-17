
$(document).ready(init);

function init() {
    initComponents();

    $('#inpNoControl').on('keyup', function (event) {
        if (event.which === 13) {
            $(this).blur();
        }
    });

    $('#inpNoControl').on('blur', function () {
        var valResult = validateNoControl($(this));
        if (valResult.success) {
            var noControl = $(this).val();
            getDataAlumno(noControl);
        } else {
            bootBoxAlert('<i class=\"fa fa-info-circle fa-lg iconoInfo\"></i> ', 'Aviso', "Por favor verifica lo siguiente: <br>" + valResult.mensaje);
        }
    });


}


function getDataAlumno(id) {
    $.ajax({
        async: true,
        cache: false,
        type: "POST",
        url: "app/inicio/principal.do",
        data: {id: id},
        beforeSend: function () {
            cleanFormData();
            $('#inpNoControl').attr('disabled', true);
        },
        complete: function () {
            $('#inpNoControl').attr('disabled', false);
        },
        success: function (response) {
            if (response.status === 0) {
                fillFormData(response.responseObject);
            } else {
                bootBoxAlert('<i class=\"fa fa-info-circle fa-lg"></i> ', 'Ocurrió un error', response.mensaje);
            }
        },
        error: function (XMLHttpRequest, textStatus, errorThrown) {
            $('#inpNoControl').attr('disabled', false);
            if (errorThrown !== "") {
                bootBoxAlert('<i class=\"fa fa-info-circle fa-lg"></i> ', 'Ocurrió un error.', 'Ocurrió un error al realizar la petición:<br/>' +
                        'Estatus: ' + '<strong>' + textStatus + ' </strong><br/>' +
                        'Error: ' + '<strong>' + errorThrown + '</strong><br/>' +
                        'Por favor, notifique a su administrador de este error<br/>.');
            } else {
                bootBoxAlert('<i class=\"fa fa-info-circle fa-lg"></i> ', 'Aviso', 'Por favor verifique que su conexión a la Red sea correcta y vuelva a intentarlo.');
            }
        }
    });
}


function fillFormData(response) {
    $('#inpCurp').val(response.curp);
    $('#inpSexo').val(response.sexo);
    $('#inpNombre').val(response.nombreAlumno);
    $('#inpApPat').val(response.apPaterno);
    $('#inpApMat').val(response.apMaterno);
}


function cleanFormData() {
    $('#inpCurp').val('');
    $('#inpSexo').val('');
    $('#inpNombre').val('');
    $('#inpApPat').val('');
    $('#inpApMat').val('');
}


function initComponents(){
    $('#popoverInfo').popover({
        trigger:'hover',
        html:true,
        content:'Para consultar, utiliza alguno de los siguientes números de control<br>\n\
                    <ul><li>111111A</li><li>222222B</li><li>333333C</li></ul>'
    });
}