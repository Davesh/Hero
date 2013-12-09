package com.patel;

import java.io.IOException;
import java.io.InputStream;

import net.sf.json.JSON;
import net.sf.json.JSONSerializer;
import net.sf.json.xml.XMLSerializer;

import org.apache.commons.io.IOUtils;

public class ConvertJSONtoXML {

        public static void main(String[] args) {
                InputStream is = ConvertJSONtoXML.class.getResourceAsStream("/sample-json.txt");
                String jsonData = null;
				try {
					jsonData = IOUtils.toString(is);
				} catch (IOException | RuntimeException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
                
                XMLSerializer serializer = new XMLSerializer(); 
                JSON json = JSONSerializer.toJSON( jsonData ); 
                String xml = serializer.write( json );  
                System.out.println(xml);                
                
        }
}
