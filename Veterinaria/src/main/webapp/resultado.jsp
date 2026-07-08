<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <title>Paciente Registrado con Éxito</title>
    <link rel="stylesheet" href="css/estilos.css">
</head>
<body>

<div class="contenedor">
    <h1>✅ Registro Exitoso</h1>
    <p>El paciente ha sido ingresado al sistema de la veterinaria:</p>

    <div class="tarjeta-resultado">
        <p><strong>Nombre:</strong> ${paciente.nombre}</p>
        <p><strong>Especie:</strong> ${paciente.especie}</p>
        <p><strong>Edad:</strong> ${paciente.edad} años</p>
        <p><strong>Peso:</strong> ${paciente.peso} kg</p>
        <p><strong>Motivo:</strong> ${paciente.motivoConsulta}</p>

        <hr style="border: 0; border-top: 1px solid #cbd5e0; margin: 15px 0;">

        <p><strong>Prioridad de Atención:</strong>
            <span class="prioridad-${paciente.prioridad}">${paciente.prioridad}</span>
        </p>
    </div>

    <p style="text-align: center; margin-top: 20px;">
        <a href="index.jsp" style="color: #38a169; text-decoration: none; font-weight: bold;">← Registrar otra mascota</a>
    </p>
</div>

</body>
</html>