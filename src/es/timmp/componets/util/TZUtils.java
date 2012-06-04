
package es.timmp.componets.util;

/**
 *
 * Clase de utilidades de TIZU SWING E HIBERNATE FACIL
 * Metodos estaticos para agilizar la escritura del codigo.
 *
 * @author aperalta
 * @version 1.0
 */
public class TZUtils {

    /**
     * Pasado por parametro el nombre de un atributo nos devuelve el resultante nombre
     * del metodo get
     *
     * nombre >> getName
     *
     * @param name String
     * @return String nombre del metodo get de la propiedad pasada
     */
    public static String getName(String name) {

        String prop = name;
        prop = "get" + prop.substring(0, 1).toUpperCase() + prop.substring(1);
        return prop;
    }


     /**
     * Pasado por parametro el nombre de un atributo nos devuelve el resultante nombre
     * del metodo set
     *
     * nombre >> setName
     *
     * @param name String
     * @return String nombre del metodo get de la propiedad pasada
     */
    public static String setName(String name) {

        String prop = name;
        prop = "set" + prop.substring(0, 1).toUpperCase() + prop.substring(1);
        return prop;
    }
}
