/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project1.htmlviewer;

import java.io.FileOutputStream;
import java.io.OutputStream;

import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;

/**
 *
 * @author Miguel
 */
public class HTMLViewer {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {

            TransformerFactory tFactory = TransformerFactory.newInstance();
            // Source xslFile = new
            // StreamSource("/Users/User/eclipse-workspace/project1/XSLtransformation.xsl");
            Source xslFile = new StreamSource("xslTransformation.xsl");
            Source xmlFile = new StreamSource("xmlAfterProcessor.xml");
            OutputStream htmlFile = new FileOutputStream("outputHTML.html");
            Transformer transform = tFactory.newTransformer(xslFile);
            transform.transform(xmlFile, new StreamResult(htmlFile));
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
