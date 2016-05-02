
package temperaturas;
import java.util.Arrays;
public class tSemana {
    
    
//------------------------ATRIBUTOS---------------------------------------------
    private int tNSemana;
    private int[]tempDias;
   
    
    
//------------------------CONSTRUCTOR-------------------------------------------
   
   public tSemana()
   {
       tNSemana=0;
       
       tempDias=new int[7];
   
   }
   
//------------------------MÉTODOS----------------------------------------------- 
   
   //GETTERS
   
    public int gettNSemana() {
        return tNSemana;
    }
   

    public int[] getTempDias() {
        return tempDias; //Ojo, al ser un array, devuelve una direccion de memoria
    }

    
    @Override  //Sobreescribiendo el método toString().
    public String toString() { 
        return "\nNúmero de la semana=" + tNSemana  + "\n temperaturas=" + Arrays.toString(tempDias)+"\n temperatura media=" +tMedia()+"\n temperatura máxima="+tMax()+"\n temperatura mínima="+tMin()+"\n";
    }
    
    

    //SETTERS
    
    public void settNSemana(int tNSemana) { 
        this.tNSemana =tNSemana;
    }

    public void setTempDias(int[] tempDias) {
        this.tempDias = tempDias;
    }
    
    
    
    //OTROS
    
    public byte Comparar(tSemana sem)  //recibe objeto
    {
        byte resul=0;
        
        if(this.tMedia()<sem.tMedia()) 
        {
            resul=-1;
        }
        else if(this.tMedia()>sem.tMedia())
            {
                 resul=1;
             }
               return resul; //devuelve -1 , 0 ó 1
    }
    
    public int tMedia() //CALCULA EL VALOR MEDIO DEL ARRAY
    {
        int media=0;
        
        for(int i=0; i<tempDias.length;i++)
        {
            media+=tempDias[i];
        }
        
        media/=tempDias.length;
        
        return media;
    }
    
    public int tMax()
    {
        int mayor=tempDias[0];
        
        for(int j=0; j<tempDias.length; j++)
        {
            if(tempDias[j] > mayor)
            {
                mayor=tempDias[j];
            }
        }    
        return mayor;
    }
     
    public int tMin()
    {
        int menor=tempDias[0];
        
        for(int j=0; j<tempDias.length; j++)
        {
            if(tempDias[j] < menor)
            {
                menor=tempDias[j];
            }
        }    
        return menor;
    }
}
    