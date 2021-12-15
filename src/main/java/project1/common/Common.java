/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project1.common;

import java.io.File;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.List;
import java.util.Scanner;

import javax.xml.XMLConstants;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;

import org.xml.sax.SAXException;

import generated.MovieCatalog;
import generated.ObjectFactory;

/**
 *
 * @author Miguel
 */
public class Common {
	@SuppressWarnings("CallToPrintStackTrace")
	public static MovieCatalog jaxbXMLFileToObject(String xmlName, String schemaName) {
		/**
		 * reads the XML file to Java object returns mc
		 */

		File xmlfile = new File(xmlName);

		JAXBContext jc;
		ObjectFactory of = new ObjectFactory();
		MovieCatalog mc = of.createMovieCatalog();
		try {

			jc = JAXBContext.newInstance(MovieCatalog.class);
			// Create unnarshaller
			Unmarshaller jaxbUnmarshaller = jc.createUnmarshaller();

			SchemaFactory schmFact = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
			File schemaFile = new File(schemaName);
			Schema schemaXSD;
			try {
				schemaXSD = schmFact.newSchema(schemaFile);
				jaxbUnmarshaller.setSchema(schemaXSD);
			} catch (SAXException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			mc = (MovieCatalog) jaxbUnmarshaller.unmarshal(xmlfile);

		} catch (JAXBException e) {
			e.printStackTrace();
		}

		return (mc);
	}

	@SuppressWarnings("CallToPrintStackTrace")
	public static <T> void jaxbObjectToXML(T obj, String fileName) {
		/**
		 * converts Java Object (obj) to XML file
		 */
		try {
			// Create JAXB Context
			JAXBContext jaxbContext = JAXBContext.newInstance(obj.getClass());

			// Create Marshaller
			Marshaller jaxbMarshaller = jaxbContext.createMarshaller();

			// Required formatting
			jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);

			// Store xml to File
			File file = new File(fileName);

			// Writes xml file to file-system
			jaxbMarshaller.marshal(obj, file);
		} catch (JAXBException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Receives Int as input
	 * 
	 * @param init
	 * @param fin
	 * @return int
	 **/
	public static int lerInt(int init, int fin) {
		Scanner scan = new Scanner(System.in);
		int num = 0;
		boolean aux = true;
		while (aux) {
			if (scan.hasNextInt()) {
				num = scan.nextInt();
				if (num >= init && num <= fin) {
					aux = false;
				} else {
					System.out.println("Invalid option. Try again: ");
				}
			} else {
				System.out.println("Invalid option. Try again: ");
				scan.next();
			}
		}
		return num;
	}

	/**
	 * Receives BigDecimal as input
	 * 
	 * @param init
	 * @param fin
	 * @return int
	 **/
	public static BigDecimal lerBigDecimal(BigDecimal init, BigDecimal fin) {
		Scanner scan = new Scanner(System.in);
		BigDecimal num = new BigDecimal("0.0");
		boolean aux = true;
		while (aux) {
			if (scan.hasNextBigDecimal()) {
				num = scan.nextBigDecimal();
				if ((num.compareTo(init) >= 0) && (num.compareTo(fin) <= 0)) {
					aux = false;
				} else {
					System.out.println("Invalid option. Try again: ");
				}
			} else {
				System.out.println("Invalid option. Try again: ");
				scan.next();
			}
		}
		return num;
	}

	/**
	 * Receives BigInteger as input
	 * 
	 * @param init
	 * @param fin
	 * @return int
	 **/
	public static BigInteger lerBigInt(BigInteger init) {
		Scanner scan = new Scanner(System.in);
		BigInteger num = new BigInteger("0");
		boolean aux = true;
		while (aux) {
			if (scan.hasNextBigInteger()) {
				num = scan.nextBigInteger();
				if (num.compareTo(init) >= 0) {
					aux = false;
				} else {
					System.out.println("Invalid option. Try again: ");
				}
			} else {
				System.out.println("Invalid option. Try again: ");
				scan.next();
			}
		}
		return num;
	}

	/**
	 * Checks if a contains any string from b
	 * 
	 * @param a
	 * @param b
	 * @return int
	 **/
	public static boolean containsAtLeastOne(List<String> a, List<String> b) {
		return b.stream().anyMatch(s -> (a.contains(s)));
	}

}
