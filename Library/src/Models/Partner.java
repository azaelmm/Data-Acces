package Models;

import java.util.ArrayList;

public class Partner {

    private String nif;
    private ArrayList<Address> addressArrayList;

    public Partner(String nif) {
        this.nif = nif;
        this.addressArrayList = new ArrayList<>();
    }

    // Método para agregar una dirección al socio
    public void agregarDireccion(Address direccion) {
        addressArrayList.add(direccion);
    }

    public String getNif() {
        return nif;
    }

    public void setNif(String nif) {
        this.nif = nif;
    }

    public ArrayList<Address> getAddressArrayList() {
        return addressArrayList;
    }

    public void setAddressArrayList(ArrayList<Address> addressArrayList) {
        this.addressArrayList = addressArrayList;
    }


}
