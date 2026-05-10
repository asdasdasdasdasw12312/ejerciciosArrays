public class ejercicio1{
    static clsGenerales cls = new clsGenerales();
    static clsVectorGral vec = new clsVectorGral();

    public static void main(String[] args){
    procesar(); 
    }
    public static int[] calcularMenorYMayor(int[] vect){
        int mayor, menor, pos1=0,pos2=0;
        int vex[] = new int[4];
        mayor = vect[0];
        menor = vect[0];
        for (int i = 1; i < vect.length; i++) {
            if(vect[i] >= mayor){
                mayor = vect[i];
                pos1 = i;
            }
            if(vect[i] < menor){
                menor = vect[i];
                pos2=i;
            } 
        }
        vex[0] = pos1;
        vex[1] = mayor;
        vex[2] = pos2;
        vex[3] = menor;
        return vex;
    }
    public static int calcularCuadrado(int pos, int[] vect){
        return (int)Math.pow(vect[pos], 2);
    }
    public static int validarNumero(int[]vect){
        int numero;
        do{
            numero = cls.leerEnteroPos("Ingrese un numero mayor o igual a 0 y que sea menor a " + vect.length + " para calcularle el cuadrado");
            if(numero >= vect.length)
                cls.Mensaje("Error, tiene el numero que seleccionaste no esta dentro del tamaño del array");
        }while(numero >= vect.length);
        return numero;
    }
    public static void procesar(){
        int cantidadNumeros = cls.leerEnteroPosMy0("Ingrese la cantidad de numeros a procesar");
        int[] vect = new int[cantidadNumeros];
        int[] m = new int[4];
        int mayor, menor, pos1, po2, pos, cuadrado, total;
        float promedio = 0f;
        vect = vec.llenarEnterosNeg(vect, "Ingrese Un numero negativo");
        m = calcularMenorYMayor(vect);
        mayor = m[1];
        pos1 = m[0];
        menor = m[3];
        po2 = m[2];
        pos = validarNumero(vect);
        cuadrado = calcularCuadrado(pos, vect);
        total = vec.sumarEnteros(vect);
        promedio = total / cantidadNumeros;
        cls.Mensaje("La suma de los numero es: " + total + "\n El promedio de los numeroes es: " + promedio + 
            "\n el numero mayor es: " + mayor + " y esta en la posicion: " + pos1 
            + "\n el numero menor es: " + menor + " y se encontro en al posicion: " + po2
            + "\n el cuadrado del numero : " + vect[pos] + " es: " + cuadrado
        );
    }
}