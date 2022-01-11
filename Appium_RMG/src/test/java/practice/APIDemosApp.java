package practice;

import java.io.IOException;
import java.net.ServerSocket;

public class APIDemosApp {
	
	public void beforeSuite() throws Exception, Exception {
		  ThreadContext.put("ROUTINGKEY", "ServerLogs");
		  server = getAppiumService();
		  if(!checkIfAppiumServerIsRunnning(4723)) {
		   server.start();
		   server.clearOutPutStreams();
		   utils.log().info("Appium server started");
		  } else {
		   utils.log().info("Appium server already running");
		  } 
		 }
		 
		 public boolean checkIfAppiumServerIsRunnning(int port) throws Exception {
		     boolean isAppiumServerRunning = false;
		     ServerSocket socket;
		     try {
		         socket = new ServerSocket(port);
		         socket.close();
		     } catch (IOException e) {
		      System.out.println("1");
		         isAppiumServerRunning = true;
		     } finally {
		         socket = null;
		     }
		     return isAppiumServerRunning;
		 }


}
