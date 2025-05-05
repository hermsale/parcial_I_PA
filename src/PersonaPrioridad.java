public class PersonaPrioridad extends Persona {

    // Constructor
    public PersonaPrioridad(String nombre, int dni) {
        super(nombre, dni);
    }

    // Implementación del método setSolicitud en la clase concreta
    @Override
    public boolean tienePrioridad() {
        return true;
    }

    public String toString() {
        return "Nombre: "+nombre+" dni: "+dni;
    }

}
