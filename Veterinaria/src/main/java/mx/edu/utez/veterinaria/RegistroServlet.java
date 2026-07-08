package mx.edu.utez.veterinaria;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

// 🚨 Alerta de Principiante: El nombre en la anotación determina la URL de acceso
@WebServlet("/RegistroServlet")
public class RegistroServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // 1. Recibir los 5 parámetros del formulario web
        // Los nombres dentro de getParameter DEBEN coincidir con el 'name' de los inputs en el HTML
        String nombre = request.getParameter("nombre");
        String especie = request.getParameter("especie");
        int edad = Integer.parseInt(request.getParameter("edad"));
        double peso = Double.parseDouble(request.getParameter("peso"));
        String motivoConsulta = request.getParameter("motivoConsulta");

        // 2. CREACIÓN DEL 6TO PARÁMETRO (Lógica de negocio propia)
        String prioridad = "Media"; // Por defecto

        // Si el usuario escribió la palabra "urgencia" o la mascota es muy viejita/bebé, prioridad Alta
        String motivoMinusc = motivoConsulta.toLowerCase();
        if (motivoMinusc.contains("urgencia") || motivoMinusc.contains("fractura") || edad > 12 || edad == 0) {
            prioridad = "Alta";
        } else if (motivoMinusc.contains("control") || motivoMinusc.contains("vacuna")) {
            prioridad = "Baja";
        }

        // 3. Crear el objeto Mascota con los 6 datos
        Mascota nuevaMascota = new Mascota(nombre, especie, edad, peso, motivoConsulta, prioridad);

        // 4. Guardar el objeto en el "carrito de la petición" (Request Attribute)
        // para que la siguiente página pueda leerlo
        request.setAttribute("paciente", nuevaMascota);

        // 5. Redireccionar (Forward) hacia el archivo resultado.jsp
        request.getRequestDispatcher("resultado.jsp").forward(request, response);
    }
}