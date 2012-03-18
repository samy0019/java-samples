package com.mycompany.clima_ws;

import java.util.Date;
import java.util.List;


public interface WeatherService {
	
    public List<TemperatureInfo> getTemperatures(String city, List<Date> dates);
    
}
