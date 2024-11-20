package Models;

import java.util.Date;

public class Prestamo {

    private String isbn;
    private Date fechaPrestamo;
    private String nifSocio;
    private String fechaDevolucion;

    public Prestamo(String isbn, Date fechaPrestamo, String nifSocio, String fechaDevolucion) {
        this.isbn = isbn;
        this.fechaPrestamo = fechaPrestamo;
        this.nifSocio = nifSocio;
        this.fechaDevolucion = fechaDevolucion;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public Date getFechaPrestamo() {
        return fechaPrestamo;
    }

    public void setFechaPrestamo(Date fechaPrestamo) {
        this.fechaPrestamo = fechaPrestamo;
    }

    public String getNifSocio() {
        return nifSocio;
    }

    public void setNifSocio(String nifSocio) {
        this.nifSocio = nifSocio;
    }

    public String getFechaDevolucion() {
        return fechaDevolucion;
    }

    public void setFechaDevolucion(String fechaDevolucion) {
        this.fechaDevolucion = fechaDevolucion;
    }
}
