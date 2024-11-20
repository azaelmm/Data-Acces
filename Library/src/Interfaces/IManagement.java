package Interfaces;

import Exceptions.AddressNotFoundException;
import Exceptions.MemberNotFoundException;
import Models.Address;
import Models.Partner;

public interface IManagement {

    public String direccionesSocio (String NIF) throws MemberNotFoundException, AddressNotFoundException;
    public Partner getEspecificoPartner (String calle, int numero, int cp) throws MemberNotFoundException;
    public Address getEspecificAddress (String calle, int numero, int cp) throws AddressNotFoundException;
}
