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

    // el padre al tener el metodo privado, se tiene que obtener los datos por el metodo get  
    @Override
    public String toString() {
        return "Nombre: "+getNombre()+" dni: "+getDni();
    }
}
