package datos;

import modelos.Contacto;

public interface IUtilAgenda {
    public abstract void agregarContacto(Contacto contacto);
    public abstract void existeContacto(Contacto contacto);
    public abstract void listarContactos();
    public abstract void buscarContacto(String nombre, String apellido);
    public abstract void eliminarContacto(Contacto contacto);
    public abstract void modificarTelefono(Contacto contacto);
    public abstract void agendaLlena();
    public abstract void espacioLibres();
}
