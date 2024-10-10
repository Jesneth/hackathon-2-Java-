package modelos;

import datos.IUtilAgenda;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Agenda implements IUtilAgenda {

    int maximo = 10;
    // creamos arrays
    Contacto[] listaContactos = new Contacto[maximo];
    List<Contacto> lista = new ArrayList<>(Arrays.asList(listaContactos));

    @Override
    public void agregarContacto(Contacto contacto) {

        if (listaContactos.length < maximo) {
            lista.add(contacto);
        }
    }

    @Override
    public void existeContacto(Contacto contacto) {
        if (lista.contains(contacto)) {
            System.out.println("el contacto existe");
        }
    }

    @Override
    public void listarContactos() {
        // mostrar los elementos de la lista
        lista.stream().forEach(c -> System.out.println(c));
    }

    @Override
    public void buscarContacto(String nombre, String apellido) {
        lista.stream().forEach(c -> c.nombre.equalsIgnoreCase(nombre));
    }

    @Override
    public void eliminarContacto(Contacto contacto) {

    }

    @Override
    public void modificarTelefono(Contacto contacto) {
        Contacto con = lista.stream().findFirst().get();
    }

    @Override
    public void agendaLlena() {
        if (lista.length == maximo) {
            System.out.println("la lista esta llena");
        }
    }

    @Override
    public void espacioLibres() {
        int contador = 0;

        System.out.println(lista.stream().count());


    }
}
