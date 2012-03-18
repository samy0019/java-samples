package com.mycompany.clima_ws;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.XPath;
import org.dom4j.xpath.DefaultXPath;
import org.springframework.ws.server.endpoint.AbstractDom4jPayloadEndpoint;




public class TemperatureDom4jEndpoint extends AbstractDom4jPayloadEndpoint {
	
	
	private static final String namespaceUri = 
			"http://joedayz.pe/weather/schemas";
	
	private XPath cityPath;
	private XPath datePath;
	private DateFormat dateFormat;
	private WeatherService weatherService;
	

	public TemperatureDom4jEndpoint() {
		//Crear los objetos XPath, incluyendo el namespace
        Map<String, String> namespaceUris = new HashMap<String, String>();
        namespaceUris.put("weather", namespaceUri);
        cityPath = new DefaultXPath("/weather:GetTemperaturesRequest/weather:city");
        cityPath.setNamespaceURIs(namespaceUris);
        datePath = new DefaultXPath("/weather:GetTemperaturesRequest/weather:date");
        datePath.setNamespaceURIs(namespaceUris);

        dateFormat = new SimpleDateFormat("yyyy-MM-dd");
	}
	
	
    public void setWeatherService(WeatherService weatherService) {
        this.weatherService = weatherService;
    }	

	@Override
	protected Element invokeInternal(Element requestElement, Document responseDocument)
			throws Exception {
		
	    // Extraer los parametros del servicio desde el mensaje request
        String city = cityPath.valueOf(requestElement);
        List<Date> dates = new ArrayList<Date>();

        for (Object node : datePath.selectNodes(requestElement)) {
            Element element = (Element) node;
            dates.add(dateFormat.parse(element.getText()));
        }
		
        // Invocar al servicio backend para manejar el request
        List<TemperatureInfo> temperatures = weatherService.getTemperatures(city, dates);

        // Construir el mensaje response desde el resultado del servicio backend 
        Element responseElement = responseDocument.addElement("GetTemperaturesResponse", namespaceUri);

        for (TemperatureInfo temperature : temperatures) {
            Element temperatureElement = responseElement.addElement("TemperatureInfo");
            temperatureElement.addAttribute("city", temperature.getCity());
            temperatureElement.addAttribute("date", dateFormat.format(temperature.getDate()));
            temperatureElement.addElement("min").setText(Double.toString(temperature.getMin()));
            temperatureElement.addElement("max").setText(Double.toString(temperature.getMax()));
            temperatureElement.addElement("average").setText(Double.toString(temperature.getAverage()));
        }

        return responseElement;

	}

}
