import java.util.HashMap;
import java.util.Map;

public class SistemaBiblioteca {
    private Map<String, Integer> inventario = new HashMap<>(); // Definimos un mapa con el título del libro y la cantidad disponible (no usamos un objeto completo)

    public synchronized void registrarLibro(String tituloLibro, int cantidad) { // Método para registrar un libro. Si ya existe incrementa la cantidad
        inventario.put(tituloLibro, inventario.getOrDefault(tituloLibro, 0) + cantidad);  // getOrDefault devuelve la cantidad actual del libro o 0 si no existe
        System.out.println("Registrado: " + tituloLibro + " (Cantidad: " + inventario.get(tituloLibro) + ")");
    }

    public synchronized boolean prestarLibro(String tituloLibro) { // Método para prestar un libro. Regresa true si es posible o false si no
        Integer disponibles = inventario.get(tituloLibro);  // Variable para libros disponibles
        if (disponibles != null && disponibles > 0) {
            inventario.put(tituloLibro, disponibles - 1);
            System.out.println(Thread.currentThread().getName() + " prestó " + tituloLibro + ". Quedan: " + (disponibles - 1));
            return true;
        } else {
            System.out.println(Thread.currentThread().getName() + " intentó prestar " + tituloLibro + " pero no hay ejemplares disponibles.");
            return false;
        }
    }

    public synchronized void devolverLibro(String tituloLibro) {  // Método para devolver un libro
        Integer disponibles = inventario.get(tituloLibro);
        if (disponibles != null) {
            inventario.put(tituloLibro, disponibles + 1);
        } else {
            inventario.put(tituloLibro, 1);  // Si el libro no estaba registrado, se registra con 1 unidad
        }
        System.out.println(Thread.currentThread().getName() + " devolvió " + tituloLibro + ". Ahora hay: " + inventario.get(tituloLibro));
    }
}