package de.zaunkoenigweg.runningdb.xml;

import de.zaunkoenigweg.runningdb.xml.xjc.ObjectFactory;
import de.zaunkoenigweg.runningdb.xml.xjc.Training;

public class TrainingUtil {

	public static void foo() {
		
		ObjectFactory factory = new ObjectFactory();
		
		Training training = factory.createTraining();
		
		training.setLocation("Bla");
		training.setComment("Blubb");
		
	}
	
}
