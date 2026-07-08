<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<!DOCTYPE html>
<html lang="es">
<head>
  <meta charset="UTF-8">
  <title>Veterinaria - Registro de Pacientes</title>
  <link rel="stylesheet" href="css/estilos.css">
</head>
<body>

<div class="contenedor">
  <h1>🐾 Registro de Pacientes Veterinarios</h1>

  <form action="RegistroServlet" method="post" id="formMascota" onsubmit="return validarFormulario()">

    <div class="campo">
      <label for="nombre">Nombre de la Mascota:</label>
      <input type="text" id="nombre" name="nombre">
    </div>

    <div class="campo">
      <label for="especie">Especie:</label>
      <select id="especie" name="especie">
        <option value="">-- Selecciona --</option>
        <option value="Perro">Perro</option>
        <option value="Gato">Gato</option>
        <option value="Ave">Ave</option>
        <option value="Otro">Otro (Reptil/Roedor)</option>
      </select>
    </div>

    <div class="campo">
      <label for="edad">Edad (en años):</label>
      <input type="number" id="edad" name="edad">
    </div>

    <div class="campo">
      <label for="peso">Peso (en kg):</label>
      <input type="number" step="0.1" id="peso" name="peso">
    </div>

    <div class="campo">
      <label for="motivo">Motivo de la Consulta:</label>
      <textarea id="motivo" name="motivoConsulta" rows="3" placeholder="Ej: Control, Vacuna, Urgencia..."></textarea>
    </div>

    <button type="submit">Registrar Paciente</button>
  </form>
</div>

<script src="js/validaciones.js"></script>
</body>
</html>