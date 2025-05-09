public abstract class Persona implements AsignarPrioridad{

//     Existen dos tipos de personas que pueden registrarse: aquellas con prioridad (como
// adultos mayores o personas con discapacidad) y personas comunes. Cada persona
// se identifica por su nombre completo (no nulo ni vacío) y un número de DNI positivo
// único. Al momento de registrarse en el sistema, no se asigna ninguna solicitud; esta
// será definida cuando la persona sea recibida para ser atendida.

    private String nombre;
    private int dni;
    // Atributo para almacenar la solicitud

    // Constructor
    public Persona(String nombre, int dni) {
        // this.nombre = nombre;
        // this.dni = dni;
        setNombre(nombre);
        setDni(dni);
    }

    // Métodos abstractos
    // public abstract void setSolicitud(Solicitud solicitud);

    // Otros métodos comunes para Persona
    public String getNombre() {
        return nombre;
    }

    public int getDni() {
        return dni;
    }

    private void setNombre(String nombre) {
        if (nombre == null || nombre.isEmpty()) {
            System.out.println("El nombre completo no puede ser nulo ni vacío.");
        }else{
            this.nombre = nombre;
        }
    }

    private void setDni(int dni) {
        if (dni <= 0) {
            System.out.println("El DNI debe ser positivo.");
        }else{
            this.dni = dni;
        }
    }

}
