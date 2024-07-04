public class RegistroProducto {

    public String nombre;
    public int cantidad;
    public String codigo;
    private double costoPrd;

    public RegistroProducto(String nombre , int cantidad ,String codigo , double costoPrd ){

        this.nombre = nombre;
        this.cantidad = cantidad;
        this.codigo = codigo;
        this.costoPrd = costoPrd;
    }
    //SETTERS de las variables para los productos
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }
    public void setCostoPrd(double costoPrd) {
        this.costoPrd = costoPrd;
    }
   
   //GETTERS de las variables para los productos
   
    public int getCantidad() {
        return cantidad;
    }
    public String getCodigo() {
        return codigo;
    }
    public double getCostoPrd() {
        return costoPrd;
    }
    public String getNombre() {
        return nombre;
    }

    
    public void MostrarInformacionproductos(){
        
        System.out.println("el nombre de el producto es :  "+nombre);
        System.out.println("la cantidad de el producto es :  "+cantidad);
        System.out.println("el codigo  de el producto es :  "+codigo);
         System.out.println("el costo total  de el producto seria:  "+costoPrd *cantidad +" su valor unitario es de : "+costoPrd);
    }


    @Override
    public String toString() {
        return nombre + " , " + cantidad + " , " + codigo + " , " + costoPrd;
    }

    public static RegistroProducto fromString(String guardado) {
        String[] parts = guardado.split(" , ");
        String nombre = parts[0];
        int cantidad = Integer.parseInt(parts[1]);
        String codigo = parts[2];
        double costoprd = Double.parseDouble(parts[3]);
        
        return new RegistroProducto(nombre, cantidad, codigo, costoprd);
    }





}

