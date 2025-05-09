
public class App {

    public static void main(String[] args) throws Exception {

        // CentroAtencion centro = new CentroAtencion("Centro de Salud");
        CentroAtencion centro = new CentroAtencion("Centro de Atencion 3 de Febrero");
        System.out.println("Nombre del centro: " + centro.getNombre());


        // Crear personas
        Persona persona1 = new PersonaComun("Juan Pérez", 12345678);  // Persona común
        Persona persona2 = new PersonaPrioridad("Ana Gómez", 87654321);  // Persona prioritaria
        Persona persona3 = new PersonaPrioridad("Alejandro Herms", 35664987);  // Persona prioritaria
        Persona persona4 = new PersonaPrioridad("Pepe argento", 35202020); 
        Persona persona5 = new PersonaPrioridad("", -35202020); // persona mal cargada - no la carga
        Persona persona6 = new PersonaPrioridad("Jorge Ramirez", 35202020); // persona con dni duplicado
        
        
        // Registrar personas en el centro de atención - se registran 4 personas
        centro.registrarPersona(persona1);  //
        centro.registrarPersona(persona2);
        centro.registrarPersona(persona3);
        centro.registrarPersona(persona4);
        centro.registrarPersona(persona5); // trato de cargarla y tira error 
        centro.registrarPersona(persona6); // persona con dni duplicado
       

          // Crear solicitudes
          Solicitud solicitud1 = new Solicitud(Servicio.ASESORAMIENTO,new Fecha(22, 10, 2025));
          Solicitud solicitud2 = new Solicitud(Servicio.TRAMITE, new Fecha(10, 4, 2021));
          Solicitud solicitud3 = new Solicitud(Servicio.RECLAMO,new Fecha(22, 10, 2012)); //  fecha mal cargada
          Solicitud solicitud4 = new Solicitud(Servicio.RECLAMO,new Fecha(22, 10, 2024)); 

        // guardamos en un arraylist de solicitudes persona 
        centro.cargarSolicitudPersona(persona1, solicitud1);  // Persona común
        centro.cargarSolicitudPersona(persona2, solicitud2);   // Persona prioritaria
        centro.cargarSolicitudPersona(persona3, solicitud3);   // persona con fecha mal cargada
        centro.cargarSolicitudPersona(persona3, solicitud4); // persona NO es prioritaria

        // Mostrar estadísticas
        System.out.println("\n");
        centro.getPersonasRegistradas();
      
        System.out.println("\nLista ordenada segun prioridad del afiliado y consulta");
        centro.mostrarListaPersonaSolicitud();

        System.out.println("\n");
        System.out.println("Lista de persona solicitud inverso: ");
        centro.mostrarListaPersonaSolicitudInverso();
        
    }
}
