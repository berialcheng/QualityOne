import java.io.File;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class ContextInitializeListener implements ServletContextListener{

	private static String WORKINGDIR = ".one";
	
	public void contextInitialized(ServletContextEvent sce) {
		String homePath = System.getProperty("user.home") + File.separator + WORKINGDIR;
		File homeDir = new File(homePath);
		if(!homeDir.exists())
		{
			homeDir.mkdir();
		}
		
	}

	public void contextDestroyed(ServletContextEvent sce) {
		// TODO Auto-generated method stub
	}
}
