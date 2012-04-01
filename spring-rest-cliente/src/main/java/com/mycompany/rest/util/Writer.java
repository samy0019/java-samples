package com.mycompany.rest.util;

import java.io.ByteArrayOutputStream;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import org.apache.log4j.Logger;

/**
 * Writes the report to the output stream
 * 
 * @author Krams at {@link http://krams915@blogspot.com}
 */
public class Writer {

	private static Logger logger = Logger.getLogger("service");
	/**
	 * Writes the report to the output stream
	 */
	public static void write(HttpServletResponse response, ByteArrayOutputStream bao) {
		
		logger.debug("Writing report to the stream");
		try {
			// Retrieve the output stream
			ServletOutputStream outputStream = response.getOutputStream();
			// Write to the output stream
			bao.writeTo(outputStream);
			// Flush the stream
			outputStream.flush();
			// Close the stream
			outputStream.close();

		} catch (Exception e) {
			logger.error("Unable to write report to the output stream");
		}
	}
	
	/**
	 * Writes the report to the output stream
	 */
	public static void write(HttpServletResponse response, byte[] byteArray) {
		
		logger.debug("Writing report to the stream");
		try {
			// Retrieve the output stream
			ServletOutputStream outputStream = response.getOutputStream();
			// Write to the output stream
			outputStream.write(byteArray);
			// Flush the stream
			outputStream.flush();
			// Close the stream
			outputStream.close();
			
		} catch (Exception e) {
			logger.error("Unable to write report to the output stream");
		}
	}	
}
