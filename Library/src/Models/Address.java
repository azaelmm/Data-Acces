package Models;

public class Address implements Comparable<Address> {

    private int codigo;
    private String calle;
    private int numero;
    private String ciudad;
    private int cp;

    public Address(int codigo, String calle, int numero, String ciudad, int cp) {
        this.codigo = codigo;
        this.calle = calle;
        this.numero = numero;
        this.ciudad = ciudad;
        this.cp = cp;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getCalle() {
        return calle;
    }

    public void setCalle(String calle) {
        this.calle = calle;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public int getCp() {
        return cp;
    }

    public void setCp(int cp) {
        this.cp = cp;
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() +
                "codigo=" + codigo +
                ", calle='" + calle + '\'' +
                ", numero=" + numero +
                ", ciudad='" + ciudad + '\'' +
                ", cp=" + cp +
                '}';
    }


    @Override
    public int compareTo(Address o) {
        int resultado = o.getCalle().compareToIgnoreCase(this.calle);
        if (resultado != 0){
            return resultado;
        }

        resultado = Integer.compare(this.numero, o.getNumero()) ;
        if (resultado != 0){
            return resultado;
        }

        resultado = Integer.compare(this.cp, o.getCp());
        if (resultado != 0){
            return resultado;
        }

        return Integer.compare(this.codigo, o.getCodigo());
    }
}
