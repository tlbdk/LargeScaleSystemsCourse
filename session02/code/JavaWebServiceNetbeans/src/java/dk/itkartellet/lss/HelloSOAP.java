/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dk.itkartellet.lss;

import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;

/**
 *
 * @author TroelsLiebeBentsen
 */
@WebService(serviceName = "HelloSOAP")
public class HelloSOAP {

    /**
     * This is a sample web service operation
     */
    @WebMethod(operationName = "hello")
    public String hello(@WebParam(name = "name") String txt) {
        return "Hello " + txt + " !";
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "plus")
    public int plus(@WebParam(name = "a") int a, @WebParam(name = "b") int b) {
        return a + b;
    }
}
