public class ejercicio3 {
    static clsGenerales cls = new clsGenerales();
    static clsVectorGral vec = new clsVectorGral();
    public static String validarGenero(){
        String genero;
        do{
            genero = cls.leerCadena2("Ingrese 'F' si tu genero es femenino de lo contrario ingrese 'M' si su genero es masculino").toUpperCase();
            if(!genero.equals("F") && !genero.equals("M"))
                cls.Mensaje("Error, intente denuevo");
        }while(!genero.equals("F") && !genero.equals("M"));
        return genero;
    }
    public static void main(String[] args) {
        resolver();
    }
    public static void resolver(){
        int personasAProcesar = cls.leerEnteroPos("Ingrese la cantidad de personas a procesar"), mjrsmenores;
        String menoresDeEdad="", menorsitos="";
        if(personasAProcesar == 0){
            throw new IllegalArgumentException("Ninguna persona a procesar");
        }
        String nombres[] = new String[personasAProcesar];
        String generos[] = new String[personasAProcesar];
        String menoresEdadVec[];
        int edades[] = new int[personasAProcesar];
        for (int i = 0; i < edades.length; i++) {
            nombres[i] = cls.leerCadena2("Ingrese el nombre de la persona numero: " + (i + 1));
            generos[i] = validarGenero();
            edades[i] = cls.leerEnteroPos("Ingrese la edad de: " + nombres[i]);
        }
        mjrsmenores = cantidadMujeresMenorEdad(edades, generos);
        menoresDeEdad = (mjrsmenores == -1) ? "-1 (ninguna mujer cumple la condicion en la lista)" :  "Hay " + mjrsmenores + " que son menores al promedio de edad" ;
        menoresEdadVec = personasMenoresDeEdad(nombres, edades);
        for (int i = 0; i < menoresEdadVec.length; i++) {
        menorsitos += menoresEdadVec[i] + "\n";
        }
        cls.Mensaje("Personas registradas en total: " + nombres.length + "\n " +
            " Las mujeres que son menores al promedio de edad son: " + menoresDeEdad + "\n" + 
            " Nombre de las personas que son menores de edad: \n" + menorsitos);
    }
    public static int cantidadMujeresMenorEdad(int edades[],String[] genero){
        int totalEdades =0;
        float promedio;
        int h=0;
        for(int n : edades)
            totalEdades+= n;
        promedio = totalEdades / edades.length;
        for (int i = 0; i < genero.length; i++) {
        if(genero[i].equals("F")){
            if(edades[i] < promedio)
                h++;
        }
        }
        if(h==0){
            return -1;
        }
        return h;
    }
    public static String[] personasMenoresDeEdad(String[] nombres, int edades[]){
        int contador=0;
        int contador2=0;
        for(int n : edades){
            if(n < 18)
                contador++;
        }
         if(contador==0){
            return new String[] {"ningun menor en la lista"};
        }
        String[] nombresMenores = new String[contador];
        for (int i = 0; i < nombres.length; i++) {
            if(edades[i] < 18){
                nombresMenores[contador2] = nombres[i];
                contador2++; 
            } 
        }
        return nombresMenores;
    }
    
}
//3. Crear, llenar y mostrar 3 vectores con 
// la información de M personas: el 1ro con nombres (vNombre, no vacío o en blanco), 
// el 2do con los géneros (vGenero con valores: M o F) y el 3ro con las edades (vEdad, con valores enteros >= 0). 
// Realizar los siguiente procedimientos:
//a. Crear el método: puntoA que retorne la cantidad de mujeres que tienen una edad inferior al promedio, 
// si existen; o -1, si ninguna mujer cumple la condición en el vector.
//  Muestre al usuario el valor solicitado o el mensaje: "Ninguna mujer cumple la condición en la lista".
//b. Crear el método: puntoB que retorne un vector con los nombres de 
// todas las personas que son menores de edad; o, el valor: 
// "Ningún menor en la lista" si no existen menores de edad. Muestre los nombres solicitados o el mensaje retornado.