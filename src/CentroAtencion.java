import java.util.ArrayList;


public class CentroAtencion {
// El centro cuenta con un nombre (no nulo ni vacío), un conjunto de personas
// registradas y dos conjuntos de espera: una para personas prioritarias y otra para
// personas comunes. Además, debe llevar un registro de todas las solicitudes
// atendidas.


    private String nombre;
    private ArrayList<Persona> personasRegistradas;
    private ArrayList<Persona> personasComunes;
    private ArrayList<Persona> personasPrioridad;
    private ArrayList<Solicitud> solicitudesAtendidas;

    public CentroAtencion(String nombre) {
        if (nombre == null || nombre.isEmpty()) {
            throw new IllegalArgumentException("El nombre del centro no puede ser nulo ni vacío.");
        }
        this.nombre = nombre;
        this.personasRegistradas = new ArrayList<>();
        this.personasComunes = new ArrayList<>();
        this.personasPrioridad = new ArrayList<>();
        this.solicitudesAtendidas = new ArrayList<>();
    }

        // getter y setter
        public String getNombre() {
            return nombre;
        }

        public void setNombre(String nombre) {
            if (nombre == null || nombre.isEmpty()) {
                throw new IllegalArgumentException("El nombre del centro no puede ser nulo ni vacío.");
            }
            this.nombre = nombre;
        }

        public ArrayList<Persona> getPersonasRegistradas() {
            return personasRegistradas;
        }

        public void setPersonasRegistradas(ArrayList<Persona> personasRegistradas) {
            this.personasRegistradas = personasRegistradas;
        }

        public ArrayList<Persona> getPersonasComunes() {
            return personasComunes;
        }

        public void setPersonasComunes(ArrayList<Persona> personasComunes) {
            this.personasComunes = personasComunes;
        }

        public ArrayList<Persona> getPersonasPrioridad() {
            return personasPrioridad;
        }

        public void setPersonasPrioridad(ArrayList<Persona> personasPrioridad) {
            this.personasPrioridad = personasPrioridad;
        }
        
        public void setSolicitudesAtendidas(ArrayList<Solicitud> solicitudesAtendidas) {
            this.solicitudesAtendidas = solicitudesAtendidas;
        }

        // /////////////////////////////////////////////////////////////////////////
    // metodo para enviar la lista de solicitudes de manera invertida 
        public ArrayList<Solicitud> getSolicitudesAtendidas() {
            ArrayList<Solicitud> listaInvertida = new ArrayList<>();

            
            for (int i = solicitudesAtendidas.size() - 1; i >= 0; i--) {
                listaInvertida.add(solicitudesAtendidas.get(i));
            }
        
            return listaInvertida;
        }
    

    // Método para registrar una persona
    public void registrarPersona(Persona persona) {
        // Verificamos si ya existe la persona por DNI en cualquiera de las listas
        if (!personaYaRegistrada(persona)) {
            personasRegistradas.add(persona);
            if (persona instanceof PersonaPrioridad) {
                personasPrioridad.add(persona); // Si es una persona de prioridad, la agregamos a esa lista
            } else {
                personasComunes.add(persona); // Si es común, la agregamos a la lista de comunes
            }
        }else{
            System.out.println("Error: El DNI ya está registrado.");
        }
    }

    // Método para verificar si la persona ya está registrada
    private boolean personaYaRegistrada(Persona persona) {
        for (Persona p : personasRegistradas) {
            if (p.getDni() == persona.getDni()) {
                return true; // Ya está registrada
            }
        }
        return false; // No está registrada
    }

    // Definir solicitud y ubicarla en el conjunto correspondiente
    public void recibirPersona(Persona persona, boolean esPrioritaria, Solicitud solicitud) {
        if (!personaYaRegistrada(persona)) {
            System.out.println("Persona no registrada.");
            return;
        }
    
        // Validar la fecha usando el propio método de Solicitud
        if (!solicitud.esFechaValida()) {
            System.out.println("Error: La fecha de la solicitud no es válida. No se registrará la solicitud.");
            return;
        }
    
        // si la persona esta registrada agregamos su solicitud
        persona.setSolicitud(solicitud);
        solicitudesAtendidas.add(solicitud);
    
        if (esPrioritaria) {
            personasPrioridad.add(persona);
        } else {
            personasComunes.add(persona);
        }
    }

   
    
}
