public class Fecha{
    // y una fecha formada por día, mes y año.
    // la validacion se implementa por medio de una interfaz
    //  La fecha debe ser válida:
    // el mes debe estar entre 1 y 12, el año entre 2020 y 2025, y el día debe ser coherente
    // con el mes indicado.

    private int dia;
    private int mes;
    private int anio;
    private String mensajeError="";
    private boolean valido;
    
    public Fecha(int dia, int mes, int anio) {
        this.dia = dia;
        this.mes = mes;
        this.anio = anio;
    }
    
    // uso del metodo traido de la interfaz 
    public boolean esValido() {
        valido=true; // inicializo como valido
        mensajeError = ""; // limpio los errores 
        if (mes < 1 || mes > 12) {
            mensajeError += " Mes inválido";
            valido = false;
        }
        if (anio < 2020 || anio > 2025) {
            mensajeError += " Año inválido";
            valido= false;
        }
        if (!diaValido(dia, mes)) {
            mensajeError += " Día inválido para el mes";
            valido= false;
        }
        return valido;
    }

    // metodo para consumir por fuera de la clase y verificar la fecha valida y sus errores
    public String getMensajeError() {
        return mensajeError;
    }

    // valido el dia, segun el mes indicado
    private boolean diaValido(int dia, int mes) {
        switch (mes) {
            case 4: case 6: case 9: case 11: // Abril, Junio, Septiembre, Noviembre
                return dia >= 1 && dia <= 30;
            case 2: // Febrero
                return dia >= 1 && dia <= 28; // Sin considerar bisiestos
            default: // Enero, Marzo, Mayo, Julio, Agosto, Octubre, Diciembre
                return dia >= 1 && dia <= 31;
        }
    }

    public String toString() {
        if(mensajeError==""){
            return dia + "/" + mes + "/" + anio;
        }else{
            return mensajeError;
        }
    }
}
