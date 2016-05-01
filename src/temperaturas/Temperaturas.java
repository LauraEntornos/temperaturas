
package temperaturas;
import java.util.Scanner;
public class Temperaturas {

    public static void main(String[] args) {
        
        gestion ejercicio=new gestion();
        Scanner teclado=new Scanner(System.in);
        char resp;
        
        do
        {
            ejercicio.menu();
            
            System.out.println("¿Desea salir?");
            resp=teclado.next().charAt(0);
            
        }while(resp=='N'|| resp=='n');
        
        
    }
}
