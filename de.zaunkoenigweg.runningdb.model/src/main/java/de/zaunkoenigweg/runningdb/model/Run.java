package de.zaunkoenigweg.runningdb.model;

/**
 * Single run as part of a training session.
 * 
 * @author Nikolaus Winter
 */
public class Run {

    /**
     * distance [meters]
     */
    private Integer distance;
    
    /**
     * time [seconds]
     */
    private Integer time;

    // Getters/Setters
    
    public Integer getDistance() {
        return distance;
    }

    public void setDistance(Integer distance) {
        this.distance = distance;
    }

    public Integer getTime() {
        return time;
    }

    public void setTime(Integer time) {
        this.time = time;
    }
    
    // fluent API
    
    public Run withDistance(Integer distance) {
    	this.distance = distance;
    	return this;
    }

    public Run withTime(Integer time) {
    	this.time = time;
    	return this;
    }

}
