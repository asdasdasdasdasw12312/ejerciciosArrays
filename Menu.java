public class Menu{
    static clsGenerales cls = new clsGenerales();
    public static void main(String[] args) {
        int numero = validarNumero("Ingrese 1 para probar el programa X, Ingrese 2 para probar el programa Y");
        switch(numero){
            case 1:

                break;
            case 2:
                
                break;
        }

        
    }
    public static int validarNumero(String txt){
        int numero;
        do{
            numero = cls.leerEnteroPosMy0(txt);
            if(numero > 2){
                cls.Mensaje("Numero invalido, porfavor digite un numero que sea el 1 o el 2");
            }

        }while(numero > 2);
            return numero;
    }

}