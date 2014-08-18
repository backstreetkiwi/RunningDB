package de.zaunkoenigweg.runningdb.model;

import static org.junit.Assert.*;

import org.junit.Test;

public class TrainingTest {

	@Test
	public void testGetDistance() {
		Training training;
		
		// no runs => distance is 0
		training = new Training();
		assertEquals(Integer.valueOf(0), training.getDistance());
		
		// one run => distance(training) is distance(run)
		training = new Training();
		training.getRuns().add(new Run().withDistance(10000).withTime(3000));
		assertEquals(Integer.valueOf(10000), training.getDistance());

		// more runs => distance(training) is sum(distance(runs))
		training = new Training();
		training.getRuns().add(new Run().withDistance(2000).withTime(720));
		training.getRuns().add(new Run().withDistance(10000).withTime(3000));
		training.getRuns().add(new Run().withDistance(2000).withTime(780));
		assertEquals(Integer.valueOf(14000), training.getDistance());
	}

	@Test
	public void testGetTime() {
		Training training;
		
		// no runs => time is 0
		training = new Training();
		assertEquals(Integer.valueOf(0), training.getTime());

		// one run => time(training) is time(run)
		training = new Training();
		training.getRuns().add(new Run().withDistance(10000).withTime(3000));
		assertEquals(Integer.valueOf(3000), training.getTime());

		// more runs => time(training) is sum(time(runs))
		training = new Training();
		training.getRuns().add(new Run().withDistance(2000).withTime(720));
		training.getRuns().add(new Run().withDistance(10000).withTime(3000));
		training.getRuns().add(new Run().withDistance(2000).withTime(780));
		assertEquals(Integer.valueOf(4500), training.getTime());
}

	@Test
	public void testIsValid() {
		Training training;
		
		// empty object => not valid
		training = new Training();
		assertFalse(training.isValid());
	}

}
