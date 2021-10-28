package Control;

import Modelo.AGENDA;
import javax.swing.table.DefaultTableModel;

public class Arbol {
    
    private Nodo Raiz;
    public Arbol(){
        Raiz = null;
    }
    public void setRaiz(Nodo Raiz){this.Raiz = Raiz; }
    public Nodo getRaiz(){return Raiz;}
    
    public Nodo Agregar(Nodo Nodo, AGENDA Elemento)
    {
        if (Nodo == null) 
        {
            Nodo Nuevo = new Nodo(Elemento);
            return Nuevo;
        }
        else
        {
            if (Nodo.getElemento().getNomCompletos().compareTo(Elemento.getNomCompletos())<0)
            {
                Nodo.setDer(Agregar(Nodo.getDer(),Elemento));
            }
             else
            {
                Nodo.setIzq(Agregar(Nodo.getIzq(), Elemento));
            }    
        }
        return Nodo;
    }       
    
    public Nodo BuscarApeNom(String Dato)
    {
        Nodo Auxiliar = Raiz;
        while(Auxiliar != null)
        {
            if (Auxiliar.getElemento().getNomCompletos().startsWith(Dato)) 
            {
                return Auxiliar;
            }
            else
            {
                if (Dato.compareTo(Auxiliar.getElemento().getNomCompletos())>0) 
                {
                    Auxiliar = Auxiliar.getDer();
                }
                else
                {
                    Auxiliar = Auxiliar.getIzq();
                }
            }
        }
        
        return null;
    }
    
    public void Listar_inOrden(DefaultTableModel modTabla,Nodo Nodo)
    {
        if(Nodo !=null)
        {
            Listar_inOrden(modTabla, Nodo.getIzq());
            modTabla.addRow(Nodo.getElemento().getRegistro());
            Listar_inOrden(modTabla, Nodo.getDer());
        }
    }        
    public Nodo BuscarMayorIzquierda(Nodo Auxiliar)
    {
        if (Auxiliar != null)
        {
            while (Auxiliar.getDer() != null)
            {
               Auxiliar = Auxiliar.getDer();    
            }           
        }
        return Auxiliar;
    }
    public Nodo EliminarMayorIzquierda(Nodo Auxiliar)
    {
        if (Auxiliar == null) 
            return null;
        
         else if(Auxiliar.getDer() != null)         
         {
           Auxiliar.setDer(EliminarMayorIzquierda(Auxiliar.getDer()));     
           return Auxiliar;      
         }    
           return Auxiliar.getIzq();      
    }
    public Nodo Eliminar(Nodo Auxiliar, String Dato)
    {
        if(Auxiliar == null)       
            return null;
        
        if(Dato.compareTo(Auxiliar.getElemento().getNomCompletos())<0)
        {
            Auxiliar.setIzq(Eliminar(Auxiliar.getIzq(), Dato));
        }
        
        else if (Dato.compareTo(Auxiliar.getElemento().getNomCompletos())>0)
        {
            Auxiliar.setDer(Eliminar(Auxiliar.getDer(), Dato));
        }
        
        else if (Auxiliar.getIzq() != null && Auxiliar.getDer() !=null) 
        {
            Auxiliar.setElemento(BuscarMayorIzquierda(Auxiliar.getIzq()).getElemento());            
            Auxiliar.setIzq(EliminarMayorIzquierda(Auxiliar.getIzq()));
        }
        else
        {
             Auxiliar = ( Auxiliar.getIzq() != null ) ? Auxiliar.getIzq() : Auxiliar.getDer(); 
        }
        return Auxiliar;
    }
}
