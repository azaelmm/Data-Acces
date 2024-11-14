package Models;

/**
 * Clase que representa a un socio de la biblioteca.
 * Un socio tiene un NIF, nombre, apellidos, número de socio y código postal.
 */
public class Partner {

    private String NIF;
    private String name;
    private String surnames;
    private int partnerNumber;
    private int postalCode;

    /**
     * Constructor de la clase Partner.
     * Inicializa un nuevo socio con su NIF, nombre, apellidos, número de socio y código postal.
     *
     * @param NIF NIF del socio.
     * @param name Nombre del socio.
     * @param surnames Apellidos del socio.
     * @param partnerNumber Número de socio del socio.
     * @param postalCode Código postal del socio.
     */
    public Partner(String NIF, String name, String surnames, int partnerNumber, int postalCode) {
        this.NIF = NIF;
        this.name = name;
        this.surnames = surnames;
        this.partnerNumber = partnerNumber;
        this.postalCode = postalCode;
    }

    /**
     * Constructor vacío de la clase Partner.
     * Este constructor se utiliza para crear un objeto Partner sin inicializar los atributos.
     */
    public Partner() {
    }

    // GETTERS Y SETTERS

    /**
     * Obtiene el NIF del socio.
     *
     * @return NIF del socio.
     */
    public String getNIF() {
        return NIF;
    }

    /**
     * Establece el NIF del socio.
     *
     * @param NIF NIF del socio.
     */
    public void setNIF(String NIF) {
        this.NIF = NIF;
    }

    /**
     * Obtiene el nombre del socio.
     *
     * @return Nombre del socio.
     */
    public String getName() {
        return name;
    }

    /**
     * Establece el nombre del socio.
     *
     * @param name Nombre del socio.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Obtiene los apellidos del socio.
     *
     * @return Apellidos del socio.
     */
    public String getSurnames() {
        return surnames;
    }

    /**
     * Establece los apellidos del socio.
     *
     * @param surnames Apellidos del socio.
     */
    public void setSurnames(String surnames) {
        this.surnames = surnames;
    }

    /**
     * Obtiene el número de socio del socio.
     *
     * @return Número de socio del socio.
     */
    public int getPartnerNumber() {
        return partnerNumber;
    }

    /**
     * Establece el número de socio del socio.
     *
     * @param partnerNumber Número de socio del socio.
     */
    public void setPartnerNumber(int partnerNumber) {
        this.partnerNumber = partnerNumber;
    }

    /**
     * Obtiene el código postal del socio.
     *
     * @return Código postal del socio.
     */
    public int getPostalCode() {
        return postalCode;
    }

    /**
     * Establece el código postal del socio.
     *
     * @param postalCode Código postal del socio.
     */
    public void setPostalCode(int postalCode) {
        this.postalCode = postalCode;
    }

    /**
     * Representación en cadena del socio.
     * Devuelve una cadena con la información del socio, incluyendo NIF, nombre, apellidos, número de socio y código postal.
     *
     * @return Representación en formato String del socio.
     */
    @Override
    public String toString() {
        return super.toString() + " " + getClass().getSimpleName() +
                " NIF='" + NIF + '\'' +
                ", name='" + name + '\'' +
                ", surnames='" + surnames + '\'' +
                ", partnerNumber=" + partnerNumber +
                ", postalCode=" + postalCode +
                '}';
    }
}
