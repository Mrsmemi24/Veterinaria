function validarFormulario() {
    let nombre = document.getElementById("nombre").value.trim();
    let especie = document.getElementById("especie").value;
    let edad = document.getElementById("edad").value;
    let peso = document.getElementById("peso").value;
    let motivo = document.getElementById("motivo").value.trim();

    if (nombre === "" || especie === "" || edad === "" || peso === "" || motivo === "") {
        alert("🚨 ¡Profesor/Maestro! Todos los campos son obligatorios.");
        return false;
    }

    if (parseInt(edad) < 0 || parseFloat(peso) <= 0) {
        alert("🚨 La edad no puede ser negativa y el peso debe ser mayor a 0.");
        return false;
    }

    return true;
}