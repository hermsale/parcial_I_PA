
public class App {

    public static void main(String[] args) throws Exception {

        // CentroAtencion centro = new CentroAtencion("Centro de Salud");
        CentroAtencion centro = new CentroAtencion("Centro de salud");
        System.out.println("Nombre del centro: " + centro.getNombre());
 

        // Crear personas
        Persona persona1 = new PersonaComun("Juan Pérez", 12345678);  // Persona común
        Persona persona2 = new PersonaPrioridad("Ana Gómez", 87654321);  // Persona prioritaria
        Persona persona3 = new PersonaPrioridad("Alejandro Herms", 35664987);  // Persona prioritaria
        Persona persona4 = new PersonaPrioridad("Pepe argento", 35202020); 
        
        
        // Registrar personas en el centro de atención - se registran 4 personas
        centro.registrarPersona(persona1);  //
        centro.registrarPersona(persona2);
        centro.registrarPersona(persona3);
        centro.registrarPersona(persona4);
       

          // Crear solicitudes
          Solicitud solicitud1 = new Solicitud(Servicio.ASESORAMIENTO,new Fecha(22, 10, 2025));
          Solicitud solicitud2 = new Solicitud(Servicio.TRAMITE, new Fecha(10, 4, 2021));
          Solicitud solicitud3 = new Solicitud(Servicio.RECLAMO,new Fecha(22, 10, 2012)); //  fecha mal cargada
          Solicitud solicitud4 = new Solicitud(Servicio.RECLAMO,new Fecha(22, 10, 2024)); 

        // Recibir las solicitudes de las personas
        centro.recibirPersona(persona1, false, solicitud1);  // Persona común
        centro.recibirPersona(persona2, true, solicitud2);   // Persona prioritaria
        centro.recibirPersona(persona3, true, solicitud3);   // persona con fecha mal cargada
        centro.recibirPersona(persona3, false, solicitud4); // persona NO es prioritaria

        // Mostrar estadísticas
        System.out.println("Total de personas registradas: " + centro.getPersonasRegistradas().size());
        System.out.println("Total de solicitudes atendidas: " + centro.getSolicitudesAtendidas().size());

        // Mostrar las solicitudes en orden inverso
        System.out.println("Solicitudes atendidas en orden inverso:");
        System.out.println(centro.getSolicitudesAtendidas());

        
    }
}
