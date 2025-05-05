import java.util.ArrayList;
import java.util.List;


public class CentroAtencion {
// El centro cuenta con un nombre (no nulo ni vacío), un conjunto de personas
// registradas y dos conjuntos de espera: una para personas prioritarias y otra para
// personas comunes. Además, debe llevar un registro de todas las solicitudes
// atendidas.


    private String nombre;

    // guardo todas las personas registradas
    private List<Persona> personasRegistradas = new ArrayList<>();
    // guardo por orden de prioridad
    // private List<Persona> ordenPrioridad = new ArrayList<>();

    // creo una lista para guardar las consultas y los usuarios
    private List<Atencion> solicitudPersona = new ArrayList<>();
    // esta lista esta ordenada segun la persona y la solicitud
    private List<Atencion> ordenPrioridadSolicitudPersona = new ArrayList<>();

    // private ArrayList<Solicitud> solicitudesAtendidas;

    // lista que contendra el orden de prioridad - contiene primero los prioritarios y despues los comunes

    // metodo constructor
    public CentroAtencion(String nombre) {
        setNombre(nombre);
    }

        public String getNombre() {
            return nombre;
        }

    public void setNombre(String nombre) {
            if (nombre == null || nombre.isEmpty()) {
                throw new IllegalArgumentException("El nombre del centro no puede ser nulo ni vacío.");
            }else{
                this.nombre = nombre;
            }
    }

        // Método para registrar una persona
    public void registrarPersona(Persona persona) {
        if ((persona.nombre == null || persona.nombre.isEmpty())||persona.dni<0){
            System.out.println("Persona no registrada: datos invalidos");
        }else{
            if(verificarDNIRepetido(persona)){
                personasRegistradas.add(persona);
            }else{
                System.out.println("Su DNI ya se encuentra registrado");
            }
        }
    }

    public boolean verificarDNIRepetido(Persona persona){
        int i=0;
        while(i<personasRegistradas.size()){
            if(personasRegistradas.get(i).getDni()==persona.getDni()){
                return false; // si encuentra un dni duplicado envia un false
            }
            i++;
        }
        return true; // si no encuentra un dni duplicado envia un true
    }

    // metodo para visualizar todas las personas registradas
    public void getPersonasRegistradas(){
        int i=0;
        while(i<personasRegistradas.size()){
            System.out.println(personasRegistradas.get(i));
            i++;
        }
    }

    // public void mostrarListaPersonaOrdenPrioridad(){
    //     int i=0;
    //     // llamo al metodo para ordenar por orden de prioridad
    //     getOrdenDePrioridad();
    //     while(i<ordenPrioridad.size()){
    //         System.out.println(ordenPrioridad.get(i));
    //         i++;
    //     }
    // }

    // metodo para ordenar por orden de prioridad
    // public void getOrdenDePrioridad(){
    //     int i=0;
    //     while(i<personasRegistradas.size()){
    //         // primero agregamos a los de prioridad true
    //         // si tienePrioridad es true entonces agrega
    //         if(personasRegistradas.get(i).tienePrioridad()){
    //             ordenPrioridad.add(personasRegistradas.get(i)); // agrego a esa persona primero
    //         }
    //         i++;
    //     }
    //     i=0;
    //     while(i<personasRegistradas.size()){
    //         if(personasRegistradas.get(i).tienePrioridad()==false){
    //             ordenPrioridad.add(personasRegistradas.get(i)); // agrego a esa persona comun
    //         }
    //         i++;
    //     }
    // }

    // recibo a persona y solicitud. analizo si tiene prioridad 
    // public void atenderSolicitud(Persona persona, Solicitud solicitud){
    //     getOrdenDePrioridad(); 
    //     int i=0;
    //     while(i<ordenPrioridad.size()){
    //         if(persona.dni==ordenPrioridad.get(i).dni){
    //             System.out.println("Se atendio la consulta "+solicitud+" al cliente "+persona.nombre);
    //         }
    //         i++;
    //     }
    // }

    // se recibe y se guardan todas las solicitudes de cada persona
    public void cargarSolicitudPersona(Persona persona, Solicitud solicitud){
        // creo una instancia de Atencion y lo guardo en un arrayList de ese tipo
        Atencion nuevaSolicitud = new Atencion(persona, solicitud);
        solicitudPersona.add(nuevaSolicitud);
    }

    // ordena solicitudPersona contiene todas las solicitudes y las personas. ordenPrioridadSolicitudPersona es la lista ordenada de estas solicitudes
    public void getOrdenDePrioridadSolicitud(){
        int i=0;
        while(i<solicitudPersona.size()){
            // primero agregamos a los de prioridad true
            // si tienePrioridad es true entonces agrega
            if(solicitudPersona.get(i).persona.tienePrioridad()){
                ordenPrioridadSolicitudPersona.add(solicitudPersona.get(i)); // agrego a esa persona primero
            }
            i++;
        }
        i=0;
        while(i<solicitudPersona.size()){
            if(personasRegistradas.get(i).tienePrioridad()==false){
                ordenPrioridadSolicitudPersona.add(solicitudPersona.get(i)); // agrego a esa persona comun
            }
            i++;
        }
    }

    
    public void mostrarListaPersonaSolicitud(){
        int i=0;
        // llamo al metodo para ordenar por orden de prioridad
        getOrdenDePrioridadSolicitud();
        while(i<ordenPrioridadSolicitudPersona.size()){
            System.out.println(ordenPrioridadSolicitudPersona.get(i));
            i++;
        }
    }
}
