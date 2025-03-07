package TestExamples;

import Utilities.File_Reader;

public class OpenFile {

	public static void main(String[] args) throws Exception{
		
		String xpathValue;
		//File_Reader.getParameters();
		//File_Reader.XMLWriterExample();
		//File_Reader.XMLReaderExample();
		//File_Reader.getAllParameters();
		//File_Reader.getAllParameters();
		//"//input[@id='inputUsername']"
		xpathValue= File_Reader.findXpathValue("txt_loginPg_userName");
	
	}
}
