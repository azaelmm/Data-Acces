package Models;

import Exceptions.AddressNotFoundException;
import Exceptions.MemberNotFoundException;
import Interfaces.IManagement;

import java.util.ArrayList;

/**
 * La clase Library representa una biblioteca que gestiona listas de préstamos y socios (partners).
 * Implementa la interfaz {@link IManagement} para realizar operaciones de búsqueda y gestión
 * de socios y direcciones.
 */
public class Library implements IManagement {

    private ArrayList<Prestamo> list_prestamos = new ArrayList<>();
    private ArrayList<Partner> socios = new ArrayList<>();

    /**
     * Constructor de la clase Library.
     * Inicializa las listas de préstamos y socios.
     */
    public Library() {
        this.list_prestamos = new ArrayList<>();
        this.socios = new ArrayList<>();
    }

    /**
     * Agrega un préstamo a la lista de préstamos de la biblioteca.
     *
     * @param prestamo El objeto {@link Prestamo} a agregar.
     */
    public void agregarPrestamo(Prestamo prestamo) {
        list_prestamos.add(prestamo);
    }

    /**
     * Agrega un socio (partner) a la lista de socios de la biblioteca.
     *
     * @param socio El objeto {@link Partner} a agregar.
     */
    public void agregarSocio(Partner socio) {
        socios.add(socio);
    }

    /**
     * Obtiene las direcciones de un socio dado su NIF (Número de Identificación Fiscal).
     * Lanza una excepción si el socio no es encontrado.
     *
     * @param NIF El NIF del socio.
     * @return Una cadena de texto que contiene las direcciones del socio.
     * @throws MemberNotFoundException Si no se encuentra un socio con el NIF especificado.
     */
    @Override
    public String direccionesSocio(String NIF) throws MemberNotFoundException, AddressNotFoundException {
        Partner socio = buscarSocioPorNif(NIF);

        if (socio == null) {

            throw new MemberNotFoundException("El socio con NIF " + NIF + " no fue encontrado.");

        } else {

            String direcciones = "";

            for (Address direccion : socio.getAddressArrayList()) {

                direcciones += direccion.toString() + "\n";

            }

            if (direcciones.equalsIgnoreCase("")){

                throw new AddressNotFoundException("No se encontraron direcciones");

            }

            return direcciones;
        }
    }

    /**
     * Busca un socio en la lista de socios por su NIF.
     *
     * @param nif El NIF del socio a buscar.
     * @return El objeto {@link Partner} si se encuentra, o null si no se encuentra.
     */
    private Partner buscarSocioPorNif(String nif) {

        for (Partner socio : socios) {

            if (socio.getNif().equals(nif)) {

                return socio;

            }
        }
        return null;  // Retorna null si no encuentra el socio
    }

    /**
     * Obtiene un socio (partner) específico basado en su dirección.
     * Lanza una excepción si no se encuentra un socio con los datos de dirección especificados.
     *
     * @param calle  La calle de la dirección del socio.
     * @param numero El número de la dirección del socio.
     * @param cp     El código postal de la dirección del socio.
     * @return El objeto {@link Partner} correspondiente a los datos de dirección.
     * @throws MemberNotFoundException Si no se encuentra un socio con la dirección especificada.
     */
    @Override
    public Partner getEspecificoPartner(String calle, int numero, int cp) throws MemberNotFoundException {

        Partner socio = null;

        for (Partner partner : socios) {

            for (Address address : partner.getAddressArrayList()) {

                if (address.getCalle().equalsIgnoreCase(calle) &&
                        address.getNumero() == numero && address.getCp() == cp) {

                    socio = partner;
                    break;
                }
            }
        }

        if (socio == null){
            throw new MemberNotFoundException("El socio con los datos que nos proporcionastes no existe!");
        }else {
            return socio;
        }

    }

    /**
     * Obtiene una dirección específica de un socio basado en los datos de la dirección.
     * Lanza una excepción si no se encuentra la dirección especificada.
     *
     * @param calle  La calle de la dirección.
     * @param numero El número de la dirección.
     * @param cp     El código postal de la dirección.
     * @return El objeto {@link Address} correspondiente a los datos proporcionados.
     * @throws AddressNotFoundException Si no se encuentra una dirección con los datos especificados.
     */
    @Override
    public Address getEspecificAddress(String calle, int numero, int cp) throws AddressNotFoundException {

        Address direccion = null;

        for (Partner partner : socios) {

            for (Address address : partner.getAddressArrayList()) {

                if (address.getCalle().equalsIgnoreCase(calle) &&
                        address.getNumero() == numero && address.getCp() == cp) {

                    direccion = address;

                }
            }
        }

        if (direccion == null){

            throw new AddressNotFoundException("La dirección con los datos proporcionados no existe!");

        }else {

            return direccion;
        }

    }
}
