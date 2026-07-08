package mx.edu.utez.veterinaria;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;
import java.io.File;
import java.io.IOException;

@WebServlet("/RegistroServlet")
@MultipartConfig
public class RegistroServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String nombre = request.getParameter("nombre");
        String especie = request.getParameter("especie");
        int edad = Integer.parseInt(request.getParameter("edad"));
        double peso = Double.parseDouble(request.getParameter("peso"));
        String motivoConsulta = request.getParameter("motivoConsulta");

        String prioridad = "Media";

        String motivoMinusc = motivoConsulta.toLowerCase();
        if (motivoMinusc.contains("urgencia") || motivoMinusc.contains("fractura") || edad > 12 || edad == 0) {
            prioridad = "Alta";
        } else if (motivoMinusc.contains("control") || motivoMinusc.contains("vacuna")) {
            prioridad = "Baja";
        }

        Part archivoFoto = request.getPart("fotoMascota");
        String nombreFoto = archivoFoto.getSubmittedFileName();

        String rutaCarpeta = getServletContext().getRealPath("/imagenes");
        File carpeta = new File(rutaCarpeta);
        if (!carpeta.exists()) {
            carpeta.mkdirs();
        }

        if (nombreFoto != null && !nombreFoto.isEmpty()) {
            String rutaFinal = rutaCarpeta + File.separator + nombreFoto;
            archivoFoto.write(rutaFinal);
        } else {
            nombreFoto = "sin-foto.png";
        }

        Mascota nuevaMascota = new Mascota(nombre, especie, edad, peso, motivoConsulta, prioridad, nombreFoto);

        request.setAttribute("paciente", nuevaMascota);
        request.getRequestDispatcher("resultado.jsp").forward(request, response);
    }
}