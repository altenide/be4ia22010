/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package j2mews;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

/**
 *
 * @author ernestoexposito
 */
@WebService()
public class J2MEService {

    /**
     * Web service operation
     */
    @WebMethod(operationName = "connection")
    public boolean connection(@WebParam(name = "login")
    String login, @WebParam(name = "pw")
    String pw) {
        if (login.length()==pw.length())
           return true;
        else
            return false;
    }

}
