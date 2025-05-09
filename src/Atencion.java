public class Atencion {
    protected Persona persona;
    private Solicitud solicitud;

    public Atencion(Persona persona, Solicitud solicitud){
        this.persona = persona;
        this.solicitud = solicitud;
    }

    public Persona getPersona() {
        return persona;
    }

    private void setPersona(Persona persona) {
        this.persona = persona;
    }

    public Solicitud getSolicitud() {
        return solicitud;
    }

    private void setSolicitud(Solicitud solicitud) {
        this.solicitud = solicitud;
    }

    @Override
    public String toString() {
        return "Consulta: " + solicitud.getTipoServicio() + ", Nombre Afiliado: " + persona.getNombre();
    }

    
}
