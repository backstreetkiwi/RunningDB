package de.zaunkoenigweg.runningdb.model;

/**
 * Bean containing shoe bean plus statistics.
 * 
 * @author Nikolaus Winter
 */
public class ShoeStatistics {

    private Shoe shoe;
    private Integer distance;
    
    public ShoeStatistics(Shoe shoe, Integer distance) {
        super();
        this.shoe = shoe;
        this.distance = distance;
    }
    
    public Shoe getShoe() {
        return shoe;
    }
    
    public Integer getDistance() {
        return distance;
    }

}
