/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package j2meserver;

import java.io.ByteArrayOutputStream;
import java.io.FileWriter;
import java.io.PrintWriter;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.*;

/**
 *
 * @author ernestoexposito
 */
public class DOMGenerator {

    private Document document = null;
    private static DocumentBuilder builder = null;
    private Element root;

    private DOMGenerator(Document document) {
        this.document = document;
    }

    /** Creates a new instance of DOMGenerator from an empty document  */
    public static DOMGenerator createDocument() throws ParserConfigurationException {
        if (builder == null) {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            factory.setNamespaceAware(true);
            //factory.setValidating(true);
            //factory.setAttribute(JAXP_SCHEMA_LANGUAGE, W3C_XML_SCHEMA);
            builder = factory.newDocumentBuilder();
        }
        return new DOMGenerator(builder.newDocument());
    }


    // set the element root of this document
    public void setRoot(Element e) {
        this.root = e;
        document.appendChild(this.root);
    }

    public void setRoot(String s)
    {
        Element e = createElement(s);
        setRoot(e);
    }

    // returns the current document
    public Document getDocument() {
        return document;
    }

    // creates an empty element
    public Element createElement(String element) {
        return document.createElement(element);
    }

    // creates an element with the specified attributes { {name,value} ..}
    public Element createElement(String element, String[][] attributes) {
        Element e = createElement(element);
        for (int i = 0; i < attributes.length; i++) {
            e.setAttribute(attributes[i][0], attributes[i][1]);
        }
        return e;
    }

    // creates an element with the specifed childs or sub-elements
    public Element createElement(String element, Element[] elements) {
        Element e = createElement(element);
        for (int i = 0; i < elements.length; i++) {
            e.appendChild(elements[i]);
        }
        return e;
    }

    // add a new attribute (name,value) to the specified element
    public Element addAttribute(Element e, String name, String value) {
        e.setAttribute(name, value);
        return e;
    }

    // add an element to the document root element
    public void addElement(Element e) throws Exception {
        if (root == null) {
            throw new Exception("Error : root not defined");
        }
        root.appendChild(e);
    }


    // add the second element as a child of the first element
    public void addElement(Element e, Element child) throws Exception {
        if (e == null) {
            throw new Exception("Error : root not defined");
        }
        e.appendChild(child);
    }

    //Add a complete document under an Element (passed in parameters)
    //of the current Document
    public void addElement(Element e, Document d) {
        try {
            Element r = d.getDocumentElement();
            Element importedRoot = (Element) (this.getDocument()).importNode(r, true);
            this.addElement(e, importedRoot);
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }

    //Find an element with its name in a document passed in parameter
    //and import it in the current Document
    public void addElement(Element e, Document d, String elementName) {
        try {
            NodeList nl = d.getElementsByTagName(elementName);
            Element importedElem = (Element) (this.getDocument()).importNode(nl.item(0), false);
            this.addElement(e, importedElem);
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }

    //Find an element in the current document with its name passed in parameter
    public Element getElement(String elementName) {
        Element el = (Element) this.getDocument().getElementsByTagName(elementName).item(0);
        return (el);
    }

    //Return the value of an attribute specified in parameter. The element name
    //where the attribute is located is passed as the first parameter
    public String getAttributeValue(String elementName, String attributeName) {
        Element el = this.getElement(elementName);
        String attribute = el.getAttribute(attributeName);
        return (attribute);
    }


    //add a text Node to the element passed in parameter
    public void addTextNode(Element e, String s) throws Exception {
        Text t = document.createTextNode(s);
        e.appendChild(t);
    }

    // uses XSL transform to create a new document from the current document (i.e. file .xml document)
    public void transformDocument(String out) throws Exception {
        transformDocument(new StreamResult(new PrintWriter(new FileWriter(out))));
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
    @Override
    public String toString() {
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        StreamResult result = new StreamResult(out);
        try {
            transformDocument(result);
        } catch (Exception e) {
            return e.toString();
        }
        return out.toString();
    }

    public byte[] getBytes()
    {
       return getBytes(document);
    }

    public static byte[] getBytes(Document document) {
        ByteArrayOutputStream out = null;
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
        if (out != null) {
            return out.toByteArray();
        } else {
            return null;
        }
    }
}
