package pushWebServer;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.security.SecureRandom;
import java.security.cert.X509Certificate;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

public class Pushserver {
	
	public static void main(String[] args) throws Exception {
		String url = "https://fcm.googleapis.com/fcm/send"; 
		String parameters =  "{\"data\" : {\"title\" : \"여기다 제목 넣기 \", \"body\" : \"여기다 내용 넣기\"}, \"to\":\"/topics/noticeMsg\"}";
		
		String result = sendPost(url,parameters);
			
	}
	public static String sendPost(String url, String parameters) throws Exception { 
	    TrustManager[] trustAllCerts = new TrustManager[]{new X509TrustManager(){
	            public X509Certificate[] getAcceptedIssuers(){return new X509Certificate[0];}
	            public void checkClientTrusted(X509Certificate[] certs, String authType){}
	            public void checkServerTrusted(X509Certificate[] certs, String authType){}
	    }};
	    SSLContext sc = SSLContext.getInstance("TLS");
	    sc.init(null, trustAllCerts, new SecureRandom());
	    HttpsURLConnection.setDefaultSSLSocketFactory(sc.getSocketFactory());

	   URL obj = new URL(url);
	   HttpsURLConnection con = (HttpsURLConnection) obj.openConnection();

	   //reuqest header
	   con.setRequestMethod("POST");
	   con.setRequestProperty("Content-Type", "application/json");
	   con.setRequestProperty("Authorization", "AAAAjFXEKw8:APA91bEgYHri-Mzz9sXkeRDSY_uiO7KDkjRLuxF8M4Csv6zSSH_iNGw5rAjunEj98qKMd2HaaBwZfS8h8GMQ3l3dhF_U2rOkIRfygrXM0H84V_klVxZ3D_oSYnDIP6aIcYXl4cYzXKLk");
	   String urlParameters = parameters;

	   //post request
	   con.setDoOutput(true);
	   DataOutputStream wr = new DataOutputStream(con.getOutputStream());
	   wr.write(urlParameters.getBytes("UTF-8"));
	   wr.flush();
	   wr.close();

	   int responseCode = con.getResponseCode();     
	   System.out.println("Post parameters : " + urlParameters);
	   System.out.println("Response Code : " + responseCode);

	   StringBuffer response = new StringBuffer();

	   if(responseCode == 200){   
	          BufferedReader in = new BufferedReader( new InputStreamReader(con.getInputStream()));
	          String inputLine;
	          while ((inputLine = in.readLine()) != null) {
	                 response.append(inputLine);
	          }
	          in.close();   
	   }
	   //result
	   System.out.println(response.toString());
	   return response.toString();
	}

}
