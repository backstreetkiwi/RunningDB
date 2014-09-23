package de.zaunkoenigweg.runningdb.util;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import de.zaunkoenigweg.runningdb.model.Run;
import de.zaunkoenigweg.runningdb.model.Training;

public class StatisticsUtilTest {
	
	List<Training> listOfTrainings;

	@Before
	public void setUp() throws Exception {
		this.listOfTrainings = new ArrayList<Training>();
		Training training;
		training = new Training();
		training.getRuns().add(new Run().withDistance(42195).withTime(12678));
		this.listOfTrainings.add(training);
		training = new Training();
		training.getRuns().add(new Run().withDistance(10000).withTime(2354));
		this.listOfTrainings.add(training);
	}

	@Test
	public void testGetPace() {
		assertEquals(Integer.valueOf(0), StatisticsUtil.getPace(null, null));
		assertEquals(Integer.valueOf(0), StatisticsUtil.getPace(null, -12));
		assertEquals(Integer.valueOf(300), StatisticsUtil.getPace(10000, 3000));
		assertEquals(Integer.valueOf(235), StatisticsUtil.getPace(10000, 2354));
	}

	@Test
	public void testSumDistance() {
		assertEquals(Integer.valueOf(52195), StatisticsUtil.sumDistance(this.listOfTrainings));
	}

	@Test
	public void testSumTime() {
		assertEquals(Integer.valueOf(15032), StatisticsUtil.sumTime(this.listOfTrainings));
	}

}
