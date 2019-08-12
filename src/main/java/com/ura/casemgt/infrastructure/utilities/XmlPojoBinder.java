package com.ura.casemgt.infrastructure.utilities;

import com.ura.casemgt.core.exception.ReadXmlException;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import javax.xml.XMLConstants;
import javax.xml.bind.*;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import java.io.*;

/**
 * @author smallGod
 */
public class XmlPojoBinder {

    /**
     * @param <T>
     * @param xmlFilePath File to un-marshal (convert to Java Object)
     * @param xsdFilePath validation file
     * @param classToBind marshalling/un-marshalling class
     * @return
     * @throws ReadXmlException
     */
    public static <T> Object convertXmlToPojo(String xmlFilePath,
                                              String xsdFilePath,
                                              Class<T> classToBind)
            throws ReadXmlException {

        try {

            File xmlFile = new File(xmlFilePath);
            File xsdFile = new File(xsdFilePath);

            InputStream inputStream = new FileInputStream(xmlFile);
            Reader reader = new InputStreamReader(inputStream, "utf-8");
            InputSource is = new InputSource(reader);
            is.setEncoding("utf-8");

            SchemaFactory sf = SchemaFactory
                    .newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
            Schema schema = sf.newSchema(xsdFile);

            JAXBContext jc = JAXBContext.newInstance(classToBind);
            Unmarshaller unmarshaller = jc.createUnmarshaller();
            unmarshaller.setSchema(schema);
            unmarshaller.setEventHandler(new XMLValidationEventHandler());

            return JAXBIntrospector
                    .getValue(unmarshaller.unmarshal(is));

        } catch (NullPointerException
                | FileNotFoundException
                | UnsupportedEncodingException
                | SAXException
                | JAXBException exc) {

            throw new ReadXmlException(exc);

        }
    }
}