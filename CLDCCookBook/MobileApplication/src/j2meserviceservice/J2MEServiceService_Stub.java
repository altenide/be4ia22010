package j2meserviceservice;

import javax.xml.rpc.JAXRPCException;
import javax.xml.namespace.QName;
import javax.microedition.xml.rpc.Operation;
import javax.microedition.xml.rpc.Type;
import javax.microedition.xml.rpc.ComplexType;
import javax.microedition.xml.rpc.Element;

public class J2MEServiceService_Stub implements J2MEServiceService, javax.xml.rpc.Stub {

    private String[] _propertyNames;
    private Object[] _propertyValues;

    public J2MEServiceService_Stub() {
        _propertyNames = new String[] { ENDPOINT_ADDRESS_PROPERTY };
        _propertyValues = new Object[] { "http://localhost:8122/J2MEWebServiceProvider/J2MEServiceService" };
    }

    public void _setProperty( String name, Object value ) {
        int size = _propertyNames.length;
        for (int i = 0; i < size; ++i) {
            if( _propertyNames[i].equals( name )) {
                _propertyValues[i] = value;
                return;
            }
        }
        String[] newPropNames = new String[size + 1];
        System.arraycopy(_propertyNames, 0, newPropNames, 0, size);
        _propertyNames = newPropNames;
        Object[] newPropValues = new Object[size + 1];
        System.arraycopy(_propertyValues, 0, newPropValues, 0, size);
        _propertyValues = newPropValues;

        _propertyNames[size] = name;
        _propertyValues[size] = value;
    }

    public Object _getProperty(String name) {
        for (int i = 0; i < _propertyNames.length; ++i) {
            if (_propertyNames[i].equals(name)) {
                return _propertyValues[i];
            }
        }
        if (ENDPOINT_ADDRESS_PROPERTY.equals(name) || USERNAME_PROPERTY.equals(name) || PASSWORD_PROPERTY.equals(name)) {
            return null;
        }
        if (SESSION_MAINTAIN_PROPERTY.equals(name)) {
            return new Boolean(false);
        }
        throw new JAXRPCException("Stub does not recognize property: " + name);
    }

    protected void _prepOperation(Operation op) {
        for (int i = 0; i < _propertyNames.length; ++i) {
            op.setProperty(_propertyNames[i], _propertyValues[i].toString());
        }
    }

    public boolean connection(String login, String pw) throws java.rmi.RemoteException {
        Object inputObject[] = new Object[] {
            login,
            pw
        };

        Operation op = Operation.newInstance( _qname_operation_connection, _type_connection, _type_connectionResponse );
        _prepOperation( op );
        op.setProperty( Operation.SOAPACTION_URI_PROPERTY, "" );
        Object resultObj;
        try {
            resultObj = op.invoke( inputObject );
        } catch( JAXRPCException e ) {
            Throwable cause = e.getLinkedCause();
            if( cause instanceof java.rmi.RemoteException ) {
                throw (java.rmi.RemoteException) cause;
            }
            throw e;
        }

        return ((Boolean )((Object[])resultObj)[0]).booleanValue();
    }

    protected static final QName _qname_operation_connection = new QName( "http://j2mews/", "connection" );
    protected static final QName _qname_connectionResponse = new QName( "http://j2mews/", "connectionResponse" );
    protected static final QName _qname_connection = new QName( "http://j2mews/", "connection" );
    protected static final Element _type_connection;
    protected static final Element _type_connectionResponse;

    static {
        _type_connection = new Element( _qname_connection, _complexType( new Element[] {
            new Element( new QName( "", "login" ), Type.STRING, 0, 1, false ),
            new Element( new QName( "", "pw" ), Type.STRING, 0, 1, false )}), 1, 1, false );
        _type_connectionResponse = new Element( _qname_connectionResponse, _complexType( new Element[] {
            new Element( new QName( "", "return" ), Type.BOOLEAN )}), 1, 1, false );
    }

    private static ComplexType _complexType( Element[] elements ) {
        ComplexType result = new ComplexType();
        result.elements = elements;
        return result;
    }
}
