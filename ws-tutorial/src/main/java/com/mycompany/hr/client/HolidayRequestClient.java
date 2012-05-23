package com.mycompany.hr.client;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.jdom.Document;
import org.jdom.Element;
import org.jdom.Namespace;
import org.jdom.transform.JDOMResult;
import org.jdom.transform.JDOMSource;
import org.springframework.ws.client.core.WebServiceTemplate;

/**
 * Example client code using Spring-WS.
 */
public class HolidayRequestClient {
	
	private Namespace hrNs;
	private SimpleDateFormat fmt;
	
	private WebServiceTemplate wsTemplate;
	
	/**
	 * Default class constructor
	 */
	public HolidayRequestClient() {
		hrNs = Namespace.getNamespace("hr", "http://mycompany.com/hr/schemas");
		fmt = new SimpleDateFormat("yyyy-MM-dd");
		wsTemplate = new WebServiceTemplate();
	}

	/**
	 * Books a holiday by invoking the HolidayRequest Web Service. The 
	 * HumanResource web service does not return any data and so this is 
	 * a void method. A successful HTTP response indicates the request
	 * was received and processed.
	 */
	public void bookHoliday(String url, Date startDate, Date endDate, 
			int employeeId, String firstName, String lastName) {
		
		Document document = 
			createHolidayRequest(startDate, endDate, employeeId, firstName, lastName);

        wsTemplate.sendSourceAndReceiveToResult(url, 
        		new JDOMSource(document.getRootElement()), 
        		new JDOMResult());
	}

	/**
	 * Creates a JDOM element representing a holiday request.
	 */
	private Document createHolidayRequest(Date startDate, Date endDate,
			int employeeId, String firstName, String lastName) {
	
		Document document= new Document(new Element("HolidayRequest", hrNs));
		
		document.getRootElement()
			.addContent(
				new Element("Holiday", hrNs)
					.addContent(
						new Element("StartDate", hrNs).setText(fmt.format(startDate))
					.addContent(
						new Element("EndDate", hrNs).setText(fmt.format(endDate)))))
			.addContent(
				new Element("Employee", hrNs)
					.addContent(
							new Element("Number", hrNs).setText(String.valueOf(employeeId)))
					.addContent(
							new Element("FirstName", hrNs).setText(firstName))
					.addContent(
							new Element("Number", hrNs).setText(lastName)));
		
		return document;
	}
	
}
