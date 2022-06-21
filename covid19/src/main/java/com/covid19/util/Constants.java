package com.covid19.util;

import org.springframework.stereotype.Component;

public class Constants {
	
	public final static String RAPID_API = "X-RapidAPI-Key";
	public final static String RAPID_API_KEY = "98ed144181msh2319db7c80ee42ap1f04e8jsn300808bfbed8";
	public final static String RAPID_API_HOST_NAME = "X-RapidAPI-Host";
	public final static String RAPID_API_HOST = "covid-19-coronavirus-statistics.p.rapidapi.com";
	
	public final static String GLOBAL_DATA_URL = "https://covid-19-coronavirus-statistics.p.rapidapi.com/v1/stats";
    public final static String DATA_FOR_USA_URL = "https://covid-19-coronavirus-statistics.p.rapidapi.com/v1/stats?country=USA";
	public final static String PAGINATED_DATA_URL = "https://covid-19-coronavirus-statistics.p.rapidapi.com/v1/stats?country=USA";
}
