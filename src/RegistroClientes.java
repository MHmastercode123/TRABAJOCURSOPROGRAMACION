public class RegistroClientes {

    public String nombrecliente;
    public int edad;
    public String cedula;
    public String direccion;

    public RegistroClientes(String nombrecliente,  int edad ,String cedula ,String direccion){

        this.nombrecliente = nombrecliente;
        this.cedula = cedula;
        this.direccion = direccion;
        this.edad = edad;
    }


    public void setCedula(String cedula) {
        this.cedula = cedula;
    }
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
    public void setEdad(int edad) {
        this.edad = edad;
    }
    public void setNombrecliente(String nombrecliente) {
        this.nombrecliente = nombrecliente;
    }
    public String getNombrecliente() {
        return nombrecliente;
    }
    public String getCedula() {
        return cedula;
    }
    public int getEdad() {
        return edad;
    }
    
    public String getDireccion() {
        return direccion;
    }
    
    

    public void Mostrarinformacionclientes(){
       
        System.out.println("el nombre de este cliente es :   "+nombrecliente);
        System.out.println("la cedula de este cliente   es :   "+cedula);
        System.out.println("la edad de este cliente  es  :   "+edad);
        System.out.println("la direccion de este cliente  es :  "+direccion);
        

    }

    @Override
    public String toString(){
        return   nombrecliente + " , " +cedula+ " , " +edad+ " , " +direccion ;
    }

    public static RegistroClientes fromString(String guardado){

        String[] parts = guardado.split(" , ");
        String nombrecliente = parts[0];
        String cedula = parts[1];
        int  edad = Integer.parseInt(parts[2]);
        String direccion = parts[3];
    
        return new RegistroClientes(nombrecliente, edad, cedula, direccion);


    }


}

