public class Fecha{
    // y una fecha formada por día, mes y año.
    // la validacion se implementa por medio de una interfaz
    //  La fecha debe ser válida:
    // el mes debe estar entre 1 y 12, el año entre 2020 y 2025, y el día debe ser coherente
    // con el mes indicado.

    private int dia;
    private int mes;
    private int anio;
    // private String mensajeError="";
    // private boolean valido;
    
    public Fecha(int dia, int mes, int anio) {
        this.dia = dia;
        this.mes = mes;
        this.anio = anio;
    }

    
    
    public int getDia() {
        return dia;
    }



    public void setDia(int dia) {
        this.dia = dia;
    }



    public int getMes() {
        return mes;
    }



    public void setMes(int mes) {
        this.mes = mes;
    }



    public int getAnio() {
        return anio;
    }



    public void setAnio(int anio) {
        this.anio = anio;
    }



    public String toString() {
            return dia + "/" + mes + "/" + anio;     
    }
}
