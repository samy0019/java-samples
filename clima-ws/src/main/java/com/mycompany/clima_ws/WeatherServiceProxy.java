package com.mycompany.clima_ws;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.io.DocumentResult;
import org.dom4j.io.DocumentSource;
import org.springframework.ws.client.core.WebServiceTemplate;
import org.springframework.ws.client.core.support.WebServiceGatewaySupport;

public class WeatherServiceProxy extends WebServiceGatewaySupport  implements WeatherService {

	private static final String namespaceUri = "http://joedayz.pe/weather/schemas";
	private DateFormat dateFormat;
	private WebServiceTemplate webServiceTemplate;
	
	public WeatherServiceProxy() throws Exception {
		dateFormat = new SimpleDateFormat("yyyy-MM-dd");
	}
	

	public List<TemperatureInfo> getTemperatures(String city, List<Date> dates) {
		//Build el documento request desde los argumentos
		Document requestDocument = DocumentHelper.createDocument();
		Element requestElement = requestDocument.addElement("GetTemperaturesRequest", namespaceUri);
		requestElement.addElement("city").setText(city);
		for(Date date: dates){
			requestElement.addElement("date").setText(dateFormat.format(date));
		}
		//invocar al servicio web remoto
		DocumentSource source = new DocumentSource(requestDocument);
		DocumentResult result = new DocumentResult();
		getWebServiceTemplate().sendSourceAndReceiveToResult(source, result);
		
		//Extraer el resultado del response document
		Document responseDocument = result.getDocument();
		Element responseElement = responseDocument.getRootElement();
		List<TemperatureInfo> temperatures = new ArrayList<TemperatureInfo>();
		for(Object node: responseElement.elements("TemperatureInfo")){
			Element element = (Element) node;
			try{
				Date date = dateFormat.parse(element.attributeValue("date"));
				double min = Double.parseDouble(element.elementText("min"));
				double max = Double.parseDouble(element.elementText("max"));
				double average = Double.parseDouble(element.elementText("average"));
				temperatures.add(new TemperatureInfo(city, date, min, max, average));
			}catch(ParseException ex){
				throw new RuntimeException(ex);
			}
		}
		
		
		
		return temperatures;
	}

}
