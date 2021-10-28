package Modelo;

public class AGENDA {

    String Nombres;
    String Apellidos;
    int Telefono;

    public AGENDA() {
    }

    public AGENDA(String Nombres, String Apellidos, int Telefono) {
        this.Nombres = Nombres;
        this.Apellidos = Apellidos;
        this.Telefono = Telefono;
    }
    
    public AGENDA(Object[] Registro) {
        Nombres = Registro[0].toString();
        Apellidos = Registro[1].toString();
        Telefono = Integer.parseInt(Registro[2].toString());
    }
    
    public Object[] getRegistro()
    {
        Object[] Registro = {Nombres,Apellidos, Telefono};
        return Registro;
    }
    public String getNomCompletos(){ return Apellidos+" "+Nombres;}
    
    public String getNombres() {
        return Nombres;
    }

    public void setNombres(String Nombres) {
        this.Nombres = Nombres;
    }

    public String getApellidos() {
        return Apellidos;
    }

    public void setApellidos(String Apellidos) {
        this.Apellidos = Apellidos;
    }

    public int getTelefono() {
        return Telefono;
    }

    public void setTelefono(int Telefono) {
        this.Telefono = Telefono;
    }      
}
