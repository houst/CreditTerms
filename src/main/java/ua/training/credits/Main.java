package ua.training.credits;

import ua.training.credits.controller.MainController;
import ua.training.credits.view.ConsoleView;

/**
 * Created by oleglitvinenko on Jul 25, 2019
 */
public class Main {
	
	public static void main(String... args) {
		ConsoleView consoleView = new ConsoleView();
		MainController mainController = new MainController(consoleView);
		mainController.process();
		
		// TODO implement web-realization of the project
		// Embedded Jetty server init (in conjunction with jetty-server & jetty-servlet)
//		Server server = new Server(7070);
//        ServletContextHandler handler = new ServletContextHandler(server, "/");
//        handler.addServlet(CreditServlet.class, "/");
//        try {
//			server.start();
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
		
	}
	
}
