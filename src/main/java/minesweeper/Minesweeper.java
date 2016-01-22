package minesweeper;

import java.util.List;

/*import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;*/
import org.w3c.dom.Document;

import minesweeper.consoleui.ConsoleUIMines;
import minesweeper.core.FieldMines;
import score.HallOfFame;
import score.HallOfFameDatabase;
import score.HallOfFameHibernate;
import score.UserScore;

public class Minesweeper {

	public static void play() {

		/*
		 * ApplicationContext context = new
		 * ClassPathXmlApplicationContext("minesweeper/mines.xml"); ((ConsoleUI)
		 * context.getBean("ui")).play();
		 */

		// BeanFactory factory = new XmlBeanFactory(new
		// ClassPathResource("MineSweeper.xml"));
		// Document doc = context.getBean(Document.class);

		FieldMines field = new FieldMines(9, 9, 1);
		ConsoleUIMines ui = new ConsoleUIMines(field);
		ui.setHallOfFame(new HallOfFameHibernate());
		ui.play();
	}
}
