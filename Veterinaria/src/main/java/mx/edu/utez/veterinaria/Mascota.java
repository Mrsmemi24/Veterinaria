package mx.edu.utez.veterinaria;

public class Mascota {
    // 1. Atributos privados (nadie los puede modificar de golpe desde fuera)
    private String nombre;
    private String especie;
    private int edad;
    private double peso;
    private String motivoConsulta;
    private String prioridad; // El 6to atributo calculado

    // 2. Constructor (el molde para crear la mascota con sus datos)
    public Mascota(String nombre, String especie, int edad, double peso, String motivoConsulta, String prioridad) {
        this.nombre = nombre;
        this.especie = especie;
        this.edad = edad;
        this.peso = peso;
        this.motivoConsulta = motivoConsulta;
        this.prioridad = prioridad;
    }

    // 3. Getters y Setters (los métodos públicos para leer y escribir los datos)
    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public String getEspecie() { return especie; }
    public void setEspecie(String especie) { this.especie = especie; }

    public int getEdad() { return edad; }
    public void setEdad(int edad) { this.edad = edad; }

    public double getPeso() { return peso; }
    public void setPeso(double peso) { this.peso = peso; }

    public String getMotivoConsulta() { return motivoConsulta; }
    public void setMotivoConsulta(String motivoConsulta) { this.motivoConsulta = motivoConsulta; }

    public String getPrioridad() { return prioridad; }
    public void setPrioridad(String prioridad) { this.prioridad = prioridad; }
}