public class EBook extends Book { //Subclase de Book que añade un atributo de tamaño de archivo para representar libros digitales.
    // Tamaño del archivo 
    private double fileSize;

    
    // Constructor completo.
    public EBook(String title, String author, int year, double fileSize) {
        // Llama al constructor de la clase padre
        super(title, author, year);
        this.fileSize = fileSize;
    }

    // Obtenemos el tamaño del archivo
    public double getFileSize() {
        return fileSize;
    }

    // Modificamos el tamaño del archivo
    public void setFileSize(double fileSize) {
        this.fileSize = fileSize;
    }


    // Representación en texto del EBook.
    @Override
    public String toString() {
        // Llama al toString() de Book y añade la información de fileSize
        return String.format("%s [%.1f MB]", super.toString(), fileSize);
    }
}