package org.vikramkumar.weather;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

public class Weather {
	
	public static void main (String[] args){
		Weather weather = new Weather();
		System.out.println(weather.getCurrentPollution());
		System.out.println(weather.getPollutionSummary());

	}
	
	public String getCurrentPollution(){
			String returnValue=null;
		try{
			StringBuffer returnHtml=new StringBuffer();
			Document doc = Jsoup.connect("http://aqicn.org/city/delhi/mandir-marg/").userAgent("Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/58.0.3029.81 Safari/537.36").referrer("http://www.google.com").get();

			 String overAllStatusTitle = doc.getElementById("aqiwgtvalue").attr("title").toString();
			 String overAllAQIValue = doc.getElementById("aqiwgtvalue").text();

			 String pmi25 = doc.getElementById("cur_pm25").text();
			 String pmi10 = doc.getElementById("cur_pm10").text();
			 returnHtml.append("<html>").append("Mandir Marg: Delhi - ").append("OverAll Status: <b>").append(overAllStatusTitle).append("</b> and overall AQI: <b>").append(overAllAQIValue).append("</b> <br>PMI-2.5: ").append(pmi25).append(",<br> PMI-10: ").append(pmi10).append("<br><br> PMI 2.5, <br>0-50 = Good,<br> 51-100 = Moderate,<br>101-150 = Moderately Unhealhty, <br> 150 - 200 = Unhealthy, <br> 201-300: Very Unhealthy<br> 300+: Hazadaorus").append("</html>");
			 returnValue=returnHtml.toString();
			 
			} catch (Exception ee){
				returnValue=ee.getMessage();
				ee.printStackTrace();
			}
		return returnValue;
		
	}
	
	public String getPollutionSummary(){
		String returnValue=null;
	try{
		StringBuffer returnHtml=new StringBuffer();
		Document doc = Jsoup.connect("http://aqicn.org/city/delhi/mandir-marg/").userAgent("Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/58.0.3029.81 Safari/537.36").referrer("http://www.google.com").get();

		 String overAllStatusTitle = doc.getElementById("aqiwgtvalue").attr("title").toString();
		 String overAllAQIValue = doc.getElementById("aqiwgtvalue").text();

		 String pmi25 = doc.getElementById("cur_pm25").text();
		 String pmi10 = doc.getElementById("cur_pm10").text();
		 returnHtml.append("").append("Mandir Marg: Delhi - ").append("OverAll Status: ").append(overAllStatusTitle).append(" and overall AQI: ").append(overAllAQIValue).append(" Visit http://pollution.vikramkumar.org for details.");
		 returnValue=returnHtml.toString();
		 
		} catch (Exception ee){
			returnValue=ee.getMessage();
			ee.printStackTrace();
		}
	return returnValue;
	
}

}
