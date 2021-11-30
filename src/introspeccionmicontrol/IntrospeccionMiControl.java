/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package introspeccionmicontrol;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import misControles.MiControl;

/**
 *
 * @author Luis
 */
public class IntrospeccionMiControl {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        MiControl micontrol = new MiControl();
        
        //Datos del objeto micontrol
        //paquete y clase del metodo
        System.out.println("La clase a la que pertenece mi control es : " + micontrol.getClass());
        
        /*
        for (Constructor<?> constructor : micontrol.getClass().getConstructors()) {
            System.out.println("Los contructores de la clase mi control son: " + Arrays.toString(micontrol.getClass().getConstructors()));
        }
        */
        
        muestraAtributos(micontrol.getClass());
        muestraLosConstructores(micontrol.getClass());
        muestraMetodos(micontrol.getClass());
        
    }
    
    
    //metodo para recorrer los constructores
    private static void muestraLosConstructores(Class c){
        
        Constructor[] constructores = c.getDeclaredConstructors();
        System.out.println("Los constructor de la clase son : ");
        
        for(Constructor cons: constructores){
            //Mostramos el nombre del constructor
            String nombre = cons.getName();
            
            //mostramos los modificadores del constructor
            System.out.print(" " + Modifier.toString(cons.getModifiers()));
            System.out.print(" " + nombre + " (");
            
            //recogemos los parametros del constructor
            Class[] tipoParams = cons.getParameterTypes();
            System.out.print("Los parametros del constructor son : (");
            for(int i = 0; i < tipoParams.length; i++){
                if(i > 0) System.out.print(", ");
                    System.out.print(tipoParams[i].getName());
            }
            System.out.println(") )");
            
        }
    }
    
    private static void muestraAtributos(Class c){
        
        Field[] atributos = c.getDeclaredFields();
        System.out.println("Los atributos de la clase son: ");
        
        for(Field f : atributos){
            //Mostramos el nombre d elos metodos
            String nombre = f.getName();
            Class tipo = f.getType();
            
            //Mostramos modificadores de los metodos
            System.out.print(" " + Modifier.toString(f.getModifiers()));
            System.out.print(" " + tipo.getName());
            System.out.println(" " + nombre);     
            
        }   
    }
    
    
    private static void muestraMetodos(Class c){
        
        
    }
    
}
