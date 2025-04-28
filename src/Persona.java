public abstract class Persona {

//     Existen dos tipos de personas que pueden registrarse: aquellas con prioridad (como
// adultos mayores o personas con discapacidad) y personas comunes. Cada persona
// se identifica por su nombre completo (no nulo ni vacío) y un número de DNI positivo
// único. Al momento de registrarse en el sistema, no se asigna ninguna solicitud; esta
// será definida cuando la persona sea recibida para ser atendida.

    private String nombre;
    private int dni;
    protected Solicitud solicitud; // Atributo para almacenar la solicitud

    // Constructor
    public Persona(String nombre, int dni) {
        if (nombre == null || nombre.isEmpty()) {
            throw new IllegalArgumentException("El nombre completo no puede ser nulo ni vacío.");
        }
        if (dni <= 0) {
            throw new IllegalArgumentException("El DNI debe ser positivo.");
        }
        this.nombre = nombre;
        this.dni = dni;
        this.solicitud = null; // Inicialmente no tiene solicitud asignada
    }

    // Métodos abstractos
    public abstract void setSolicitud(Solicitud solicitud);

    // Otros métodos comunes para Persona
    public String getNombre() {
        return nombre;
    }

    public int getDni() {
        return dni;
    }

    public void setNombre(String nombre) {
        if (nombre == null || nombre.isEmpty()) {
            throw new IllegalArgumentException("El nombre completo no puede ser nulo ni vacío.");
        }
        this.nombre = nombre;
    }

    public void setDni(int dni) {
        if (dni <= 0) {
            throw new IllegalArgumentException("El DNI debe ser positivo.");
        }
        this.dni = dni;
    }

    public Solicitud getSolicitud() {
        return solicitud;
    }
}
