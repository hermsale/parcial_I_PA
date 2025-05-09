public class Solicitud {

    // resuelto en ENUM SERVICIO
    // Cada solicitud contiene el tipo de servicio que se requiere (como asesoramiento,
    // trámite o reclamo) 
    
    // 
    // una fecha formada por día, mes y año. La fecha debe ser válida:
    // el mes debe estar entre 1 y 12, el año entre 2020 y 2025, y el día debe ser coherente
    // con el mes indicado.
    // Cuando una persona llega al centro, se define la solicitud correspondiente y se la
    // ubica en el conjunto que le corresponda según su condición (prioritaria o común). Si la
    // persona no existe, se debe mostrar un mensaje indicando que no se encuentra
    // registrada

    private Servicio tipoServicio; // Tipo de servicio solicitado
    private Fecha fechaSolicitud; // Instancia de Fecha, ya validada
   

    public Solicitud(Servicio tipoServicio, Fecha fechaSolicitud) {
        this.tipoServicio = tipoServicio;
        this.fechaSolicitud = fechaSolicitud;
    }

    // getter y setter
    public Servicio getTipoServicio() {
        return tipoServicio;
    }

    private void setTipoServicio(Servicio tipoServicio) {
        this.tipoServicio = tipoServicio;
    }

    public Fecha getFechaSolicitud() {
        return fechaSolicitud;
    }

    private void setFechaSolicitud(Fecha fechaSolicitud) {
        
        this.fechaSolicitud = fechaSolicitud;
    }

    // metodo toString 
    public String toString() {
        return String.format(
            "Solicitud:\n" +
            "-------------------------\n" +
            "Tipo de Servicio: %-20s\n" +
            "Fecha de Solicitud: %-15s\n" +
            "-------------------------\n", 
            tipoServicio, fechaSolicitud);
    }
}
