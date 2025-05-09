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

    // creo una lista para guardar las consultas y los usuarios
    private List<Atencion> solicitudPersona = new ArrayList<>();

    // esta lista esta ordenada segun la persona y la solicitud - ATENCION: PERSONA Y SOLICITUD
    private List<Atencion> ordenPrioridadSolicitudPersona = new ArrayList<>();

    // metodo constructor
    public CentroAtencion(String nombre) {
        setNombre(nombre);
    }

        public String getNombre() {
            return nombre;
        }

    private void setNombre(String nombre) {
            if (nombre == null || nombre.isEmpty()) {
                throw new IllegalArgumentException("El nombre del centro no puede ser nulo ni vacío.");
            }else{
                this.nombre = nombre;
            }
    }

    // Método para registrar una persona - VALIDA SI YA EXISTE EL DNI Y SI EL NOMBRE ES CORRECTO
    public void registrarPersona(Persona persona) {
        if ((persona.getNombre() == null || persona.getNombre().isEmpty())||persona.getDni()<0){
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
        boolean encuentra=true;
        while(i<personasRegistradas.size()){
            if(personasRegistradas.get(i).getDni()==persona.getDni()){
                encuentra=false; // si encuentra un dni duplicado envia un false
            }
            i++;
        }
        // realizo un solo retorno, por buenas practicas 
        return encuentra; // si no encuentra un dni duplicado envia un true
    }

    // metodo para visualizar todas las personas registradas
    public void getPersonasRegistradas(){
        int i=0;
        System.out.println("Cantidad de personas registradas: "+personasRegistradas.size());
        System.out.println("Listado:");
        while(i<personasRegistradas.size()){
            System.out.println(personasRegistradas.get(i));
            i++;
        }
    }

    // se recibe y se guardan todas las solicitudes de cada persona
    public void cargarSolicitudPersona(Persona persona, Solicitud solicitud){
        // creo una instancia de Atencion y lo guardo en un arrayList de ese tipo
        Atencion nuevaSolicitud = new Atencion(persona, solicitud);
        // verificamos la fecha
        if(verificarFecha(solicitud.getFechaSolicitud())){
            solicitudPersona.add(nuevaSolicitud);
        }else{
            System.out.println("La fecha ingresada es incorrecta");
        }
    }

    // corregir los return , tener 1 solo
    public boolean verificarFecha(Fecha solicitud){

        if(solicitud.getAnio()<2020 || solicitud.getAnio()>2025){
            return false;
        }

        if(solicitud.getMes()<1 || solicitud.getMes()>12){
            return false;
        }

        if(solicitud.getDia()<1 || solicitud.getDia()>31){
            return false;
        }

        return true;
    }

    // ordena solicitudPersona contiene todas las solicitudes y las personas. ordenPrioridadSolicitudPersona es la lista ordenada de estas solicitudes
    public void getOrdenDePrioridadSolicitud(){
        int i=0;
        System.out.println("Cantidad de solicitudes atendidas: "+solicitudPersona.size());
        System.out.println("Listado de solicitudes atendidas: ");
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
        // una vez ordenado por orden de prioridad. muestro la solicitud y el cliente
        while(i<ordenPrioridadSolicitudPersona.size()){
            System.out.println(ordenPrioridadSolicitudPersona.get(i));
            i++;
        }
    }

    public void mostrarListaPersonaSolicitudInverso() {                
        // Recorro la lista desde el último elemento hasta el primero 
        // cargo el orden de prioridad ya ordenado, pero lo muestro invertido
        for (int i = ordenPrioridadSolicitudPersona.size() - 1; i >= 0; i--) {
            System.out.println(ordenPrioridadSolicitudPersona.get(i));
        }
    }
    
}
