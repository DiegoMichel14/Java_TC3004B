import java.util.Random;

public class Patron implements Runnable {
    private SistemaBiblioteca biblioteca;  // Referencia a nuestra biblioteca para usar sus métodos
    private String idPatron;
    private Random aleatorio = new Random();
    
    private String[] libros = {"Programación en Java", "Estructuras de Datos", "Patrones de Diseño"};  // Usamos una lista con libros disponibles

    public Patron(SistemaBiblioteca biblioteca, String idPatron) {
        this.biblioteca = biblioteca;
        this.idPatron = idPatron;
    }

    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {  // Cada usuario realiza 5 operaciones
            String tituloLibro = libros[aleatorio.nextInt(libros.length)];  // Selecciona un libro al azar

            boolean prestar = aleatorio.nextBoolean(); // Decide aleatoriamente si prestará o devolverá el libro

            if (prestar) {
                biblioteca.prestarLibro(tituloLibro);
            } else {
                biblioteca.devolverLibro(tituloLibro);
            }

            try {  // Establecemos un retraso entre operaciones con .sleep
                Thread.sleep(aleatorio.nextInt(1000));
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }
}