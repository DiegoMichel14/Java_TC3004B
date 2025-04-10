public class SimulacionBiblioteca {
    public static void main(String[] args) {
        SistemaBiblioteca biblioteca = new SistemaBiblioteca();  // Creación de la instancia de nuestra biblioteca

        // Registramos 3 libros usando solo su título y cantidad como se recomendó en clase
        biblioteca.registrarLibro("Programación en Java", 3);
        biblioteca.registrarLibro("Estructuras de Datos", 2);
        biblioteca.registrarLibro("Patrones de Diseño", 1);

        int numeroDePatrones = 5;  // Número de usuarios que utilizarán la biblioteca

        Thread[] hilosPatron = new Thread[numeroDePatrones]; // Creamos y arrancamos los hilos de los usuarios
        for (int i = 0; i < numeroDePatrones; i++) {
            Patron patron = new Patron(biblioteca, "Patrón " + (i + 1));
            hilosPatron[i] = new Thread(patron, "Patrón " + (i + 1));
            hilosPatron[i].start();
        }

        // Esperamos a que todos los hilos terminen con un for
        for (int i = 0; i < numeroDePatrones; i++) {
            try {
                hilosPatron[i].join();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
        
        System.out.println("Operaciones en la biblioteca completadas.");
    }
}