function validateNoControl(field) {
    var valResult = {success: true};
    if (!characterString(field.val())) {
        valResult.success = false;
        valResult.mensaje = "Error de Validación. " + getFieldLabel(field) + ": Cadena con formato inválido, sólo se permiten letras y números, al menos 7 caracteres.";
        highlightError(field, true);
    } else {
        highlightError(field, false);
    }
    return valResult;
}

function getFieldLabel(field) {
    return $(field).parents().eq(0).prev().text();
}

function highlightError(field, on) {
    if (on) {
        $(field).parents().eq(0).addClass("has-error");
    } else {
        $(field).parents().eq(0).removeClass("has-error");
    }
}

function characterString(cadena) {
    var reg = /^[0-9a-zA-Z]{7,}$/;
    if (reg.test(cadena)) {
        return true;
    }
    return false;
}