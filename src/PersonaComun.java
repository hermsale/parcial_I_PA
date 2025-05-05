public class PersonaComun extends Persona{

      // Constructor
    public PersonaComun(String nombre, int dni) {
        super(nombre, dni);
    }

    // Implementación de la interface AsignarPrioridad
    @Override
    public boolean tienePrioridad() {
        return false;
    }

    @Override
    public String toString() {
        return "Nombre: "+nombre+" dni: "+dni;
    }

    
}
