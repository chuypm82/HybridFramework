package Utilities;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;

import com.aventstack.extentreports.Status;

import org.w3c.dom.Node;
import org.w3c.dom.Element;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import Automation.HybridFramework.BaseClass;

public class File_Reader extends BaseClass {

	
	public static String findInputValue(String input) throws Exception{

		 String line;
		 String csvSplitBy = ",";
		 
		 try (BufferedReader br = new BufferedReader(new FileReader (TestDataFileName))) {
			while ((line = br.readLine()) != null) {
				 String[] data = line.split(csvSplitBy);
				 if(data.length>=2) {
					 String inputCol = data[0].trim();
					 String inputContent = data[1].trim();
					 
					 if(inputCol.equalsIgnoreCase(input)) {
						 System.out.println("Input: " + inputCol + "  Value: " + inputContent);
						 br.close();
						 return inputContent;
					 }
				 }
			}
			//System.out.println("Xpath Name: " + input + "was not found");
			br.close();
			return input;
		} catch (IOException e) {
			System.out.println(codeLine + "ERROR -> TestData DataSet file not provided or corrupted");
			if (reportFlag > 0)
				extentTest.log(Status.FAIL, codeLine + "ERROR -> TestData DataSet file not provided or corrupted");
			throw e;
		}
	}

	public static String findXpathValue(String xpathName) throws Exception{

		 String line;
		 String csvSplitBy = ",";
		 //String POFileName2= "PO_DataSets\\PO_App_DS.csv";
		 
		 try (BufferedReader br = new BufferedReader(new FileReader (POFileName))) {
			while ((line = br.readLine()) != null) {
				 String[] data = line.split(csvSplitBy);
				 if(data.length>=2) {
					 String xpathNameCol = data[0].trim();
					 String xpathContent = data[1].trim();
					 
					 if(xpathNameCol.equalsIgnoreCase(xpathName)) {
						 System.out.println("xpathName: " + xpathNameCol + "  Value: " + xpathContent);
						 br.close();
						 return xpathContent;
					 }
				 }
			}
			//System.out.println("Xpath Name: " + xpathName + "was not found");
			br.close();
			return xpathName;
		} catch (IOException e) {
			//e.printStackTrace();
			System.out.println(codeLine + "ERROR -> PO DataSet file not provided or corrupted");
			if (reportFlag > 0)
				extentTest.log(Status.FAIL, codeLine + "ERROR -> PO DataSet file not provided or corrupted");
			//fail();
			throw e;
		}
	}

	public static void getAllParameters() {

		try {
			// Specify the file path as a File object
			File xmlFile = new File("Config_File.xml");

			// Create a DocumentBuilder
			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
			DocumentBuilder builder = factory.newDocumentBuilder();

			// Parse the XML file
			Document document = builder.parse(xmlFile);

			System.out.println("Config file location: --> " + xmlFile.getAbsolutePath());
			// Access elements by tag name
			NodeList nodeList = document.getElementsByTagName("parameters");
			for (int i = 0; i < nodeList.getLength(); i++) {
				Node mynode = nodeList.item(i);
				if (mynode.getNodeType() == Node.ELEMENT_NODE) {
					Element myelement = (Element) mynode;
					URL = myelement.getElementsByTagName("URL").item(i).getTextContent();
					Browser = myelement.getElementsByTagName("Browser").item(i).getTextContent();
					myProfilePath = myelement.getElementsByTagName("ME_addArguments").item(i).getTextContent();
					HeadlessExecution = myelement.getElementsByTagName("HeadlessExecution").item(i).getTextContent();

					System.out.println(
							"Project: --> " + myelement.getElementsByTagName("Project").item(i).getTextContent());
					System.out.println(
							"Enviroment: --> " + myelement.getElementsByTagName("Enviroment").item(i).getTextContent());
					System.out.println("URL: --> " + myelement.getElementsByTagName("URL").item(i).getTextContent());
					System.out.println(
							"Browser: --> " + myelement.getElementsByTagName("Browser").item(i).getTextContent());
					System.out.println("HeadlessExecution: --> "
							+ myelement.getElementsByTagName("HeadlessExecution").item(i).getTextContent());
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void getAllParameters2() {

		try {

			File xmlFile = new File("Config_File3.xml");
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.parse(xmlFile);
			doc.getDocumentElement().normalize();

			System.out.println("Config file location: --> " + xmlFile.getAbsolutePath());
			NodeList nodes = doc.getElementsByTagName("library");
			for (int i = 0; i > nodes.getLength(); i++) {
				Node mynode = nodes.item(i);
				if (mynode.getNodeType() == Node.ELEMENT_NODE) {
					Element myelement = (Element) mynode;
					URL = myelement.getElementsByTagName("URL").item(i).getTextContent();
					Browser = myelement.getElementsByTagName("Browser").item(i).getTextContent();
					myProfilePath = myelement.getElementsByTagName("ME_addArguments").item(i).getTextContent();
					HeadlessExecution = myelement.getElementsByTagName("HeadlessExecution").item(i).getTextContent();

					System.out.println(
							"Project: --> " + myelement.getElementsByTagName("Project").item(i).getTextContent());
					System.out.println(
							"Enviroment: --> " + myelement.getElementsByTagName("Enviroment").item(i).getTextContent());
					System.out.println("URL: --> " + myelement.getElementsByTagName("URL").item(i).getTextContent());
					System.out.println(
							"Browser: --> " + myelement.getElementsByTagName("Browser").item(i).getTextContent());
					System.out.println("HeadlessExecution: --> "
							+ myelement.getElementsByTagName("HeadlessExecution").item(i).getTextContent());
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	
	public static void getParameters() {

		try {
			File fXmlFile = new File("Config_File.xml");
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.parse(fXmlFile);
			doc.getDocumentElement().normalize();

			System.out.println("Root element :" + doc.getDocumentElement().getNodeName());
			NodeList nList = doc.getElementsByTagName("staff");
			System.out.println("----------------------------");

			for (int temp = 0; temp < nList.getLength(); temp++) {
				Node nNode = nList.item(temp);
				System.out.println("\nCurrent Element :" + nNode.getNodeName());
				if (nNode.getNodeType() == Node.ELEMENT_NODE) {
					Element eElement = (Element) nNode;
					System.out.println("Staff id : " + eElement.getAttribute("id"));
					System.out.println(
							"First Name : " + eElement.getElementsByTagName("firstname").item(0).getTextContent());
					System.out.println(
							"Last Name : " + eElement.getElementsByTagName("lastname").item(0).getTextContent());
					System.out.println(
							"Nick Name : " + eElement.getElementsByTagName("nickname").item(0).getTextContent());
					System.out.println("Salary : " + eElement.getElementsByTagName("salary").item(0).getTextContent());
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public static void XMLReaderExample() throws Exception {

		// Specify the file path as a File object
		File xmlFile = new File("output.xml");

		// Create a DocumentBuilder
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = factory.newDocumentBuilder();

		// Parse the XML file
		Document document = builder.parse(xmlFile);

		// Access elements by tag name
		NodeList nodeList = document.getElementsByTagName("library");
		for (int i = 0; i < nodeList.getLength(); i++) {
			Node node = nodeList.item(i);
			System.out.println("Element Content: " + node.getTextContent());
		}

	}

	public static void XMLWriterExample() throws Exception {

		// Create a DocumentBuilder
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = factory.newDocumentBuilder();

		// Create a new Document
		Document document = builder.newDocument();

		// Create root element
		Element root = document.createElement("library");
		document.appendChild(root);

		// Create book elements and add text content
		Element book1 = document.createElement("Program1");
		book1.appendChild(document.createTextNode("Java Programming"));
		Element book2 = document.createElement("Program2");
		book2.appendChild(document.createTextNode("Python Programming"));
		Element book3 = document.createElement("Program3");
		book3.appendChild(document.createTextNode("JavaScript"));
		Element book4 = document.createElement("Program4");
		book4.appendChild(document.createTextNode("C Programming"));
		root.appendChild(book1);
		root.appendChild(book2);
		root.appendChild(book3);
		root.appendChild(book4);

		// Write to XML file
		TransformerFactory transformerFactory = TransformerFactory.newInstance();
		Transformer transformer = transformerFactory.newTransformer();
		DOMSource source = new DOMSource(document);

		// Specify your local file path
		StreamResult result = new StreamResult("output.xml");
		transformer.transform(source, result);

		System.out.println("XML file created successfully!");

	}
}
