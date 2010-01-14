/*
 * ExampleDom.java
 *
 * Created on 13 juin 2007, 15:39
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package j2meserver;

/**
 *
 * @author ernesto
 */
/*
 * Document.java
 *
 * Created on october 2003, 16:37
 */
 import javax.xml.parsers.*;
 import javax.xml.transform.*;
 import javax.xml.transform.dom.*;
 import javax.xml.transform.stream.*;
 import org.w3c.dom.*;
 import java.io.*;


 public class DOMLibrary {

    protected Document document = null;
    protected DocumentBuilder builder=null;
    protected Element root = null;


    // constant for SCHEMA validation
    public static final String JAXP_SCHEMA_LANGUAGE = "http://java.sun.com/xml/jaxp/properties/schemaLanguage";
    public static final String W3C_XML_SCHEMA =  "http://www.w3.org/2001/XMLSchema";

    // types of validation to be performed
    public static final int NO_VALIDATION=0;
    public static final int SCHEMA_VALIDATION=1;
    public static final int DTD_VALIDATION=1;


    /** Creates a new instance of Document */
    public DOMLibrary(Document doc) {
        try {
            document = doc;
        } catch (Exception pce) {
            System.out.println("Warning : You should use another JAXP implementation ("+pce+")");
            pce.printStackTrace();
        }
    }


    /** Creates a new instance of Document */
    // parse an existing document
    public DOMLibrary(String file, int valid) {
        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            if (valid!=NO_VALIDATION) {
                factory.setNamespaceAware(true);
                factory.setValidating(true);
                if (valid==SCHEMA_VALIDATION)
                    factory.setAttribute(JAXP_SCHEMA_LANGUAGE, W3C_XML_SCHEMA);
            }
            builder = factory.newDocumentBuilder();
            document = builder.parse(new File(file));
        } catch (Exception pce) {
            System.out.println("Warning : You should use another JAXP implementation ("+pce+")");
            pce.printStackTrace();
        }
    }

    /** Creates a new instance of Document */
    // creates a empty document
    public DOMLibrary(int valid) {
        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            if (valid!=NO_VALIDATION) {
                factory.setNamespaceAware(true);
                factory.setValidating(true);
                if (valid==SCHEMA_VALIDATION)
                    factory.setAttribute(JAXP_SCHEMA_LANGUAGE, W3C_XML_SCHEMA);
            }
            builder = factory.newDocumentBuilder();
            document = builder.newDocument();
        } catch (Exception pce) {
            System.out.println("Warning : You should use another JAXP implementation ("+pce+")");
            pce.printStackTrace();
        }
    }

    /** Creates a new instance of Document */
    // creates a document from a byte array
    public DOMLibrary(byte[] in, int valid) {
        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            if (valid!=NO_VALIDATION) {
                factory.setNamespaceAware(true);
                factory.setValidating(true);
                if (valid==SCHEMA_VALIDATION)
                    factory.setAttribute(JAXP_SCHEMA_LANGUAGE, W3C_XML_SCHEMA);
            }
            builder = factory.newDocumentBuilder();
            document = builder.parse(new ByteArrayInputStream(in));
        } catch (Exception pce) {
            System.out.println("Warning : You should use another JAXP implementation ("+pce+")");
            pce.printStackTrace();
        }
    }


    // check for if current document is valid
    public boolean isValid() {
        try {
            ByteArrayOutputStream out = new ByteArrayOutputStream();
            StreamResult result = new StreamResult(out);
            transformDocument(result);
            Document d = builder.parse(new ByteArrayInputStream(out.toByteArray()));
        } catch (Exception e) {
            System.out.println("Warning : "+e);
            return false;
        }
        return true;
    }

    // set the element root of this document
    public void setRoot(Element e) {
        this.root = e;
        document.appendChild(this.root);
    }

    // returns the current document
    public Document getDocument() {
        return document;
    }

    // creates an empty element
    public Element createElement(String element) {
        return  document.createElement(element);
    }

    // creates an element with the specified attributes { {name,value} ..}
    public Element createElement(String element,String[][] attributes) {
        Element e = createElement(element);
        for (int i=0;i<attributes.length;i++)
            e.setAttribute(attributes[i][0],attributes[i][1]);
        return e;
    }

    // creates an element with the specifed childs or sub-elements
    public Element createElement(String element,Element[] elements) {
        Element e = createElement(element);
        for (int i=0;i<elements.length;i++)
            e.appendChild(elements[i]);
        return e;
    }

    // add a new attribute (name,value) to the specified element
    public Element addAttribute(Element e, String name, String value) {
        e.setAttribute(name,value);
        return e;
    }

    // add an element to the document root element
    public void addElement(Element e) throws Exception {
        if (root==null)
            throw new Exception("Error : root not defined");
        root.appendChild(e);
    }

    // add the second element as a child of the first element
    public void addElement(Element e, Element child) throws Exception {
        if (e==null)
            throw new Exception("Error : root not defined");
        e.appendChild(child);
    }

    //Add a complete document under an Element (passed in parameters) 
    //of the current Document
    public void addElement(Element e, Document d){
        try{
	    Element root = d.getDocumentElement();
            Element importedRoot = (Element) (this.getDocument()).importNode(root,true); 
            this.addElement(e,importedRoot);
	} catch (Exception exception) {exception.printStackTrace();}
    }

    //Find an element with its name in a document passed in parameter 
    //and import it in the current Document
    public void addElement(Element e, Document d, String elementName){
        try{
	    NodeList nl = d.getElementsByTagName(elementName);
            Element importedElem = (Element) (this.getDocument()).importNode(nl.item(0),false); 
            this.addElement(e,importedElem);
	} catch (Exception exception) {exception.printStackTrace();}
    }

    //Find an element in the current document with its name passed in parameter 
    public Element getElement(String elementName){
        Element el = (Element) this.getDocument().getElementsByTagName(elementName).item(0);
	return (el);
    }

    //Return the value of an attribute specified in parameter. The element name
    //where the attribute is located is passed as the first parameter
    public String getAttributeValue(String elementName, String attributeName){
	Element el=this.getElement(elementName);
	String attribute=el.getAttribute(attributeName);
	return(attribute);
    }


    //add a text Node to the element passed in parameter	
    public void addTextNode(Element e, String s) throws Exception {
 	Text t = document.createTextNode(s); 
	e.appendChild(t);
    }




    // uses XSL transform to create a new document from the current document (i.e. file .xml document)
    public void transformDocument(String out) throws Exception {
        transformDocument(new StreamResult(new  PrintWriter(new FileWriter(out))));
    }

    // uses XSL transform to create a new document to the specified StreamResult object
    public void transformDocument(StreamResult result) throws Exception {
        // Use a Transformer for output
        TransformerFactory tFactory = TransformerFactory.newInstance();
        Transformer transformer = tFactory.newTransformer();
        DOMSource source = new DOMSource(document);
        transformer.transform(source, result);
    }

    // returns the current document as a String
    public String toString() {
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        StreamResult result = new StreamResult(out);
        try {
            transformDocument(result);
        } catch (Exception e) { return e.toString(); }
        return out.toString();
    }
    
     public static byte[] getBytes(Document document)
    {
          ByteArrayOutputStream out =null;
        // create a Document Transformer
        TransformerFactory tFactory = TransformerFactory.newInstance();
        Transformer transformer;
        try {
            transformer = tFactory.newTransformer();
 
        DOMSource source = new DOMSource(document);

        // create the output for the Document as a byte[] 
        out = new ByteArrayOutputStream();
        StreamResult result = new StreamResult(out);

        // transformation of the Document into a byte[]
        transformer.transform(source, result);
         } catch (Exception ex) {
            ex.printStackTrace();
        }
        if (out!=null) return out.toByteArray();
        else return null;
    }
 

    // test of the document
    public static void main(String args[]) throws Exception {
        if (args.length==3) {
            // example : java DOMLibrary session1.xml 1 result.xml
            //    parses the session1.xml document
            //    performs SCHEMA validation
            //    stores the document in a new document called result.xml
            String file = args[0];
            int valid = Integer.parseInt(args[1]);
            DOMLibrary d = new DOMLibrary(file,valid);
            System.out.println(d);
            if (valid>0)
                System.out.println("Result of validation : " +d.isValid());
            d.transformDocument(args[2]);
        }
        else if (args.length==1) {
            // example : java DOMLibrary  result.xml
            //    creates a new empty document
            //    specifying that SCHEMA validation will be performed
            //    add specific elements and attributes to the document (including SCHEMA attributes)
            //    stores the document in a new document called result.xml
            DOMLibrary d = new DOMLibrary(DOMLibrary.NO_VALIDATION);
            Element e = d.createElement("resource",
            new String[][] {{ "xmlns:xsi","http://www.w3.org/2001/XMLSchema-instance"},
            { "xsi:noNamespaceSchemaLocation","http://homepage.ensica.fr/~ernesto/xml/tp2/resource.xsd"},
            { "description","PDA end system"}});
            d.setRoot(e);
	    Element el = d.createElement("memory",new String[][] {{"max","8MB"},{"current","3MB"}});
	    d.addTextNode(el,"test");
            d.addElement(el);
            d.addElement(d.createElement("bandwidth",new String[][] {{"max","30kbps"}}));
            d.addElement(d.createElement("display",new String[][] {{"max","160,160"}}));
            d.addElement(d.createElement("service",new String[][] {{"name","mp3_codec"}}));
            System.out.println(d);
            d.transformDocument(args[0]);
        } 
        else
        if (args.length==2) {
            // example : java DOMLibrary session1.xml result.xml
            //    parses the session1.xml document
            //    print elements and attributes
            //    stores the document in a new document called result.xml
            String file = args[0];
            DOMLibrary d = new DOMLibrary(file,DOMLibrary.NO_VALIDATION);
            Document doc = d.getDocument();
            Element e = (Element) doc.getFirstChild();
            while (e!=null)
            {
                System.out.println("Tag name: "+e.getTagName());
                NamedNodeMap nm = e.getAttributes();
                for (int i=0;i<nm.getLength();i++)
                     System.out.println("Attribute "+i+" : "+nm.item(i));
                NodeList nl = e.getChildNodes();
                for (int i=0;i<nl.getLength();i++)
                {
                    System.out.println("Element "+i+" :\t"+nl.item(i).getNodeName());
                    System.out.println("\t nb attr \t"+nl.item(i).getAttributes().getLength());
                }
                System.out.println(nl);
                e = (Element) e.getNextSibling();
            }
            d.transformDocument(args[1]);
        }
    }
 }