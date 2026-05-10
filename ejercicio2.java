public class ejercicio2 {
    static clsGenerales cls = new clsGenerales();
    static clsVectorGral vec = new clsVectorGral();
    public static void main(String[] args) {
        procesar();
    }
    public static void procesar(){
        int cantidadVendedores = cls.leerEnteroPosMy0("Ingrese la cantidad de vendedores a procesar"), cantidadVentas=0;
        String codigoVendedor;
        float promedioGeneral=0,acomuladorPromedio=0,promedio=0,totalvendido=0;
        float[]promedios = new float[cantidadVendedores];
        String codigos[] = new String[cantidadVendedores];
        for (int i = 0; i < cantidadVendedores; i++) {
            codigoVendedor = cls.leerCadena2("Ingrese el codigo del vendedor");
            codigos[i] = codigoVendedor;
            cantidadVentas = cls.leerEnteroPos("Ingrese la cantidad de ventas realizadas por el vendedor con codigo:  " + codigoVendedor );
            if(cantidadVentas==0){
                totalvendido =0;
                promedio =0;
            }else{
            int vendido[] = new int[cantidadVentas];
            for (int j = 0; j < vendido.length; j++) {
                vendido[j] = cls.leerEnteroPos("Ingrese la venta #: " + (j + 1) + " del vendedor con codigo: " + codigoVendedor);
                totalvendido += vendido[j];
            }
            promedio = totalvendido/cantidadVentas; 
            }
            promedios[i] = promedio;
        cls.Mensaje("Estadisticas del vendedor con codigo: " + codigoVendedor + "\n" + " cantidad de ventas realizadas: " +cantidadVentas +
            "\n total vendido: " + totalvendido + "\n promedio del vendedor: " + promedio);
        totalvendido =0;
        }
        for(float n : promedios)
            acomuladorPromedio += n;
        promedioGeneral = acomuladorPromedio / promedios.length;
        cls.Mensaje("El promedio de ventas entre todos los vendedores de coquito fue de: " + promedioGeneral + "\n " + hacerTabla(codigos, promedios));
    }
    public static String hacerTabla(String codigos[], float promedios[]){
        float bandera=0;
        String acomulador= "";
        String bandera2;
        for (int i = 0; i < promedios.length; i++) {
            for (int j = i + 1; j < promedios.length; j++) {
                if(promedios[i] < promedios[j]){
                bandera = promedios[i];
                promedios[i] = promedios[j];
                promedios[j] = bandera;
                bandera2 = codigos[i];
                codigos[i] = codigos[j];
                codigos[j] = bandera2;
                }
            }      
        }
        for (int i = 0; i < promedios.length; i++) {
            acomulador += "El top " + (1+i) + " es: " + codigos[i] + " con una cantidad de ventas totales de: " + promedios[i] + "\n";
        }
        return acomulador;
        }    
    }
//2. La empresa COQUITO tiene N vendedores y cada uno de ellos realiza una cantidad de ventas 
// semanales que generalmente es diferente entre ellos. 
// Llenar y mostrar por cada vendedor el vector Vendido con el valor de c/u de las X ventas realizadas y
// , a partir de él, mostrar el código y el total de las ventas realizadas por cada uno, además;
//  mostrar el top y el promedio de ventas realizadas por los vendedores en la empresa.