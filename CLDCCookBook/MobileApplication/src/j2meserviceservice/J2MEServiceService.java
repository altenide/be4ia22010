package j2meserviceservice;
import javax.xml.namespace.QName;

public interface J2MEServiceService extends java.rmi.Remote {

    /**
     *
     */
    public boolean connection(String login, String pw) throws java.rmi.RemoteException;

}
