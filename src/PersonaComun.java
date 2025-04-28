public class PersonaComun extends Persona{

      // Constructor
    public PersonaComun(String nombre, int dni) {
        super(nombre, dni);
    }

    // Implementación del método setSolicitud
    @Override
    public void setSolicitud(Solicitud solicitud) {
        this.solicitud = solicitud; // Asigna la solicitud
    }
}
