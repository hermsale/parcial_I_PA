public interface Validable {
    // La fecha debe ser válida:
    // el mes debe estar entre 1 y 12, el año entre 2020 y 2025, y el día debe ser coherente
    // con el mes indicado.
    boolean esValido();
    // Pasamos el mensaje de error si lo hubiese
    String getMensajeError();
}
