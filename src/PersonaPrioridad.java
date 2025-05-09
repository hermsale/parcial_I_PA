public class PersonaPrioridad extends Persona {

    // Constructor
    public PersonaPrioridad(String nombre, int dni) {
        super(nombre, dni);
    }

    // Implementación del método setSolicitud
    @Override
    public boolean tienePrioridad() {
        return true;
    }

    public String toString() {
        return "Nombre: "+getNombre()+" dni: "+getDni();
    }

}
