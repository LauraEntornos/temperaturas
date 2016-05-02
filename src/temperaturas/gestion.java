
package temperaturas;
import java.util.Scanner;

public class gestion {
    
        private tSemana miSemana;
        private tSemana otraSemana;
        
        Scanner teclado=new Scanner(System.in);
        
        public gestion()
        {
            miSemana=new tSemana();
            otraSemana=new tSemana();
        }
        
       
        
        public void menu()
        {
            System.out.println("***********************************¿Qué desea hacer?**************************");
            System.out.println("*                                                                            *");            
            System.out.println("*   1.Iniciar e instanciar dos objetos de la clase Semana                    *");
            System.out.println("*   2.Llenar datos de los dos objetos Semana                                 *");
            System.out.println("*   3.Mostrar datos de las dos semanas                                       *");
            System.out.println("*   4.Comparar la temperatura media de los dos objetos de la clase Semana    *");
            System.out.println("*   5.Mostrar la semana que obtuvo la temperatura máxima más alta            *");
            System.out.println("*   6.Mostrar la semana que obtuvo la temperatura mínima más baja            *");
            System.out.println("*   0.Salir                                                                  *");
            System.out.println("*                                                                            *");
            System.out.println("******************************************************************************");
            
            
            ejecucion();
            
        }
            
        
        private void ejecucion()
        {
            byte opcion;
            
            System.out.println("Elige una opción: ");
            opcion=teclado.nextByte();
            
            switch(opcion)
            {
                case 1:
                    iniciar();
                    break;
                case 2:
                    llenarDatos();
                    break;
                case 3:
                    mostrarDatos();
                    break;
                case 4:
                    comparacion();
                    break;
                case 5:
                    tMaxMasAlta();
                    break;
                case 6:
                    tMinMasBaja();
                    break;
                default:
                    break;
            }
        }
        
        
//-----------------------MÉTODOS DEL MENÚ--------------------
        
        private void iniciar() //por qué hay que hacer esto?
        {
            System.out.println("Iniciando datos.......");
            miSemana=new tSemana();
            otraSemana=new tSemana();
            System.out.println("Datos iniciados");
            menu();
        }
        
        private  void llenarDatos() //Ojo con repetir código
        {
            
             System.out.println("Rellena datos de esta semana: ");
             insertarDatos(miSemana);
            
        
             System.out.println("Rellena datos de otra semana: ");
             insertarDatos(otraSemana);
            
        }
        
        private  void mostrarDatos()//Ojo con repetir código
        {
                datosSemana(miSemana);
                datosSemana(otraSemana);
        }
        
        private  void comparacion() 
        {
            byte comparacion;
             comparacion=miSemana.Comparar(otraSemana); //¿es mejor ejecutar el metodo varias veces o guardar su resultado en la variable?

             if(comparacion<0)
             {
                 System.out.println("La temperatura media de la semana: "+miSemana.gettNSemana()+" es mas baja que la de la otra semana.");
             }
             else if(comparacion >0)
                 {
                    System.out.println("La temperatura media de la semana: "+miSemana.gettNSemana()+" es mayor que la de otra semana.");
                 }
                 else
                 {
                    System.out.println("La temperatura media de la semana: "+miSemana.gettNSemana()+" es igual que la de otra semana.");
                  }  
            
        }
  
        private void tMaxMasAlta()
        {
            if(miSemana.tMax()>otraSemana.tMax())
            {
                System.out.println("La temperatura máxima de la semana: "+miSemana.gettNSemana()+" es mayor que la de la semana: "+otraSemana.gettNSemana());
            }
            else if(otraSemana.tMax()>miSemana.tMax())
                {
                     System.out.println("La temperatura máxima de la semana: "+otraSemana.gettNSemana()+" es mayor que la de la semana: "+miSemana.gettNSemana());
                }
                else
                {
                    System.out.println("La temperaturas máximas son iguales.");
                }
        }
        
        private  void tMinMasBaja()
        {
            if(miSemana.tMin()<otraSemana.tMin())
            {
                System.out.println("La temperatura mínima de la semana: "+miSemana.gettNSemana()+" es menor que la de la semana: "+otraSemana.gettNSemana());
            }
            else if(otraSemana.tMin()<miSemana.tMin())
                {
                     System.out.println("La temperatura mínima de la semana: "+otraSemana.gettNSemana()+" es menor que la de la semana: "+miSemana.gettNSemana());
                }
                else
                {
                    System.out.println("La temperaturas mínimas son iguales.");
                }
        }
        
        
        
        
 //---------------MÉTODOS AUXILIARES ------------

  private  int leerNum(int min, int max, String texto) 
    {
        int num;
        
        System.out.println(texto+" : ");
        
        do
        {
             num=teclado.nextInt();
        
             if(num<min || num>max) //este if no se realiza cuando num es mayor que max, por qué?
             {
                 System.err.println("Error."+texto+" : ");
             }
             
        }while(num<min || num>max);
       
        return num;
    }
    
    
  private  int[] pedirTemperaturas(int array[]) //ESTE MÉTODO RELLENA EL ARRAY
    {
          for(int i=0; i<array.length; i++) //Insertar numeros en el array
        {
            array[i]=leerNum(-10,40,"¿Temperatura del "+diaSemana(i)+"?  Inserte un número entre -10 y 40");
        }
        return array;
    }
    
    
    
  private  String diaSemana(int num) //recibe de 0 a 6
    {
        String diaSemana[]={"Lunes","Martes","Miercoles","Jueves","Viernes","Sabado","Domingo"};
        String dia=diaSemana[num];
        
       return dia;
    }
    
  private  void insertarDatos(tSemana objeto)
    {
        objeto.settNSemana(leerNum(1,52,"Indique el número de semana (1-52)")); //inserta el numero de la semana
        objeto.setTempDias( pedirTemperaturas(  objeto.getTempDias() )    );
    }
    
  private  void datosSemana(tSemana objeto)
   {
       System.out.println("Datos de la semana: "+objeto.gettNSemana());
       System.out.println(objeto.toString());
   }
}
    
    
    
    
    
    
    

