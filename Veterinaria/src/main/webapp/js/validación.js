function validarFormulario() {
    // Capturamos los elementos del formulario
    let nombre = document.getElementById("nombre").value.trim();
    let especie = document.getElementById("especie").value;
    let edad = document.getElementById("edad").value;
    let peso = document.getElementById("peso").value;
    let motivo = document.getElementById("motivo").value.trim();

    // 🚨 Error común: Olvidar validar si los campos numéricos son negativos
    if (nombre === "" || especie === "" || edad === "" || peso === "" || motivo === "") {
        alert("🚨 ¡Profesor/Maestro! Todos los campos son obligatorios.");
        return false; // Cancela el envío al servlet
    }

    if (parseInt(edad) < 0 || parseFloat(peso) <= 0) {
        alert("🚨 La edad no puede ser negativa y el peso debe ser mayor a 0.");
        return false;
    }

    return true; // Si todo está perfecto, permite que los datos viajen al Servlet
}