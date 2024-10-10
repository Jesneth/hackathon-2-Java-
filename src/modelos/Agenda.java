package modelos;

import datos.IUtilAgenda;

import java.util.*;
import java.util.stream.IntStream;

public class Agenda implements IUtilAgenda {
    Scanner scGeneral = new Scanner(System.in);
    String nuevoNombre, nuevoApellido, nuevoTelefono;
    int maximo = 10;
    // creamos arrays
    Contacto[] listaContactos = new Contacto[maximo];
    List<Contacto> lista = new ArrayList<>();

    public void mostrar(){
        System.out.println(lista.toString());
    }

    @Override
    public void agregarContacto(Contacto contacto) {
            if(!existeContacto(contacto.getNombre(),contacto.getApellido())){
                if (lista.size() < maximo) {
                    lista.add(contacto);
                }else{
                    System.out.println("Haz llegado a tu máximo de contacto!");
                }
            }
    }

    @Override
    public boolean existeContacto(Contacto contacto) {
        if (lista.contains(contacto)) {
            System.out.println("El contacto existe");
            return true;
        }
        return false;
    }

    @Override
    public void listarContactos() {
        // mostrar los elementos de la lista
        if (lista.isEmpty()){
            System.out.println("La lista esta vacia.  Agrega un contacto");
            System.out.println();
            return;
        }
        lista.stream().forEach(c -> System.out.println(c));
        System.out.println();

    }

    @Override
    public void buscarContacto(String nombre, String apellido) {
        boolean existe = lista.stream().anyMatch(contact -> contact.getNombre()
                .equalsIgnoreCase(nombre) && contact.getApellido().equalsIgnoreCase(apellido));
        if(existe){
           Contacto cont = lista.stream().filter(contact -> contact.getNombre()
                    .equalsIgnoreCase(nombre) && contact.getApellido().equalsIgnoreCase(apellido)).findFirst().get();
            System.out.println(cont);
        }else{
            System.out.println("El contacto que solicita no existe!");
        }

    }

    @Override
    public void eliminarContacto(Contacto contacto) {
            lista.remove(contacto);
        System.out.println("Se ha eliminado el contacto "+
                contacto.getNombre()+" "+contacto.getApellido()+" con exito.");
    }

    @Override
    public void modificarTelefono(Contacto contacto) {
        System.out.println("Escribe el NUEVO TELÉFONO: ");
        nuevoTelefono = scGeneral.nextLine();
        contacto.setTelefono(nuevoTelefono);
        System.out.println("Su contacto se ha modficado con exito: ");
        System.out.println(contacto);
    }

    @Override
    public void agendaLlena() {
        if (lista.size() == maximo) {
            System.out.println("Tu lista de contactos esta llena!");
        } else {
            espacioLibres();
        }
    }

    @Override
    public void espacioLibres() {
        System.out.println("Espacio disponible: " + (maximo - lista.stream().count()) + " contactos" );


    }

    @Override
    public boolean existeContacto(String nombre, String apellido) {
        for (Contacto miContacto : lista){
            if(miContacto.getNombre().equalsIgnoreCase(nombre) && miContacto.getApellido().equalsIgnoreCase(apellido)){
                System.out.println("El contacto ya existe");
                return true;
            }
        }
        return false;
    }
    //---------

    String g = "\uD83D\uDCBE";
    String l = "\uD83D\uDCDA";
    String e = "❌";
    String ed = "\uD83D\uDCDD";
    String ex = "\uD83D\uDD1A";
    String bv = "\uD83D\uDC68\uD83C\uDFFD\u200D\uD83D\uDCBB";
    String love = "꒒ ০ ⌵ ୧ ♡";



    public Boolean verifyContact(String nameContact){
        return lista.stream().anyMatch(c -> c.getNombre().equalsIgnoreCase(nameContact));
    }
    public void editContacts(){
        Scanner sc = new Scanner(System.in);

        System.out.println("- -- -- -- -- -- -- -- -- -- EDICIÓN DE CONTACTOS -- -- -- -- -- -- -- -- -- -");
        System.out.println("|                                                                            |");
        System.out.println("|                              1. Editar nombre                              |");
        System.out.println("|                              2. Editar apellido                            |");
        System.out.println("|                              3. Editar teléfono                            |");
        System.out.println("|                                                                            |");
        System.out.println("- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -");
        System.out.printf("Opción: _");
        int optEdit = sc.nextInt();
        Map<Integer, Contacto> listaPersons = new HashMap<>();
        IntStream.range(0,lista.size()).forEach(n -> listaPersons.put(n+1, lista.get(n)));
        String titulo = "-----------------------------=LISTA DE CONTACTOS=-----------------------------";
        switch (optEdit){
            case 1:
                System.out.println(titulo);
                if(!listaPersons.isEmpty()){
                    listaPersons.entrySet().forEach(s -> System.out.printf("%d. %s%n", s.getKey(), s.getValue()));
                    System.out.println("Elija el contacto de la lista que quiere editar (el numero de lista): ");
                    System.out.printf("\tOpción: _");
                    int optEdit2 = sc.nextInt();
                    sc.nextLine();
                    Contacto cont = listaPersons.get(optEdit2);
                    System.out.println("Escribe el NUEVO NOMBRE: ");
                    nuevoNombre = sc.nextLine();
                    cont.setNombre(nuevoNombre);
                    System.out.println("Su contacto se ha modficado con éxito: ");
                    System.out.println(cont);
                    break;
                }
                System.out.println("La lista está vacía! Debes agregar un nuevo contacto!");
                break;
            case 2:
                System.out.println(titulo);
                if(!listaPersons.isEmpty()){
                    listaPersons.entrySet().forEach(s -> System.out.printf("%d. %s%n", s.getKey(), s.getValue()));
                    System.out.println("Elija el contacto de la lista que quiere editar (el numero de lista): ");
                    System.out.printf("\tOpción: _");
                    int optEdit2 = sc.nextInt();
                    sc.nextLine();
                    Contacto cont = listaPersons.get(optEdit2);
                    System.out.println("Escribe el NUEVO APELLIDO: ");
                    nuevoApellido = sc.nextLine();
                    cont.setNombre(nuevoApellido);
                    System.out.println("Su contacto se ha modficado con exito: ");
                    System.out.println(cont);
                    break;
                }
                System.out.println("La lista está vacía! Debes agregar un nuevo contacto!");
                System.out.println();
                break;
            case 3:
                System.out.println(titulo);
                if(!listaPersons.isEmpty()){
                    listaPersons.entrySet().forEach(s -> System.out.printf("%d. %s%n", s.getKey(), s.getValue()));
                    System.out.println("Elija el contacto de la lista que quiere editar (el numero de lista): ");
                    System.out.printf("\tOpción: _");
                    int optEdit2 = sc.nextInt();
                    sc.nextLine();
                    Contacto cont = listaPersons.get(optEdit2);
                    modificarTelefono(cont);
                    break;
                }
                System.out.println("La lista está vacía! Debes agregar un nuevo contacto!");
                System.out.println();
                break;
            default:
                System.out.println("Haz ingresado una opción incorrecta! No se puede editar.");
                System.out.println();
                break;
        }
    }

    public void agendaSystem(){
        boolean systemOn = true;
        do {
            Scanner scMenu = new Scanner(System.in);
            System.out.println("==============================================================================");
            System.out.println("||                                                                            ||");
            System.out.println("||                      "+bv+"  BIENVENIDO A TU AGENDA GENX                      ||");
            System.out.println("||                                                                            ||");
            System.out.println("||                         1. "+g+" Añadir un nuevo contacto.                   ||");
            System.out.println("||                         2. "+l+" Ver lista de contactos.                     ||");
            System.out.println("||                         3. "+e+" Eliminar un contacto.                       ||");
            System.out.println("||                         4. "+ed+" Editar un contacto.                         ||");
            System.out.println("||                         5. "+ed+" Verificar espacio.                         ||");
            System.out.println("||                         6. "+ex+" Salir.                                      ||");
            System.out.println("||                                                                            ||");
            System.out.println("==============================================================================");
            System.out.printf("\t\t\tOpción: _");
            int optMenu = scMenu.nextInt();
            System.out.println();
            scMenu.nextLine();
            String nombre;
            String telefono;
            String apellido;
            switch (optMenu){
                case 1:
                    System.out.println("\nEscribe el NOMBRE del contacto a agregar:");
                    nombre = scMenu.nextLine();
                    System.out.println("\nEscribe el APELLIDO del contacto a agregar:");
                    apellido = scMenu.nextLine();
                    System.out.println("Escribe el TELÉFONO del contacto a agregar:");
                    telefono = scMenu.nextLine();
                    Contacto contacto = new Contacto(nombre, apellido, telefono);
                    agregarContacto(contacto);
                    break;
                case 2:
                    listarContactos();

                    break;
                case 3:
                    System.out.println("\nEscribe el NOMBRE del contacto a eliminar:");
                    nombre = scMenu.nextLine();
                    System.out.println("\nEscribe el APELLIDO del contacto a eliminar:");
                    apellido = scMenu.nextLine();
                    boolean existe = lista.stream().anyMatch(c -> c.getNombre()
                            .equalsIgnoreCase(nombre) && c.getApellido().equalsIgnoreCase(apellido));
                    if(existe){
                        Contacto cont = lista.stream().filter(contact -> contact.getNombre()
                                .equalsIgnoreCase(nombre) && contact.getApellido().equalsIgnoreCase(apellido)).findFirst().get();
                        eliminarContacto(cont);
                    }else{
                        System.out.println("El contacto que quieres eliminar no está en la lista!");
                    }
                    break;
                case 4:
                    editContacts();
                    break;

                case 5:
                       agendaLlena();
                    break;


                case 6:
                    System.out.println("\nHaz salido de la Agenda!");
                    System.out.println("Un sistema hecho con mucho "+love);
                    systemOn = false;
                    break;
                default:
                    System.out.println("\nOpción incorrecta! Por favor, elige una opción correcta.");
            }

        }while(systemOn);
    }










}
