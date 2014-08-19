package de.zaunkoenigweg.runningdb.model;

import org.apache.commons.lang3.StringUtils;


/**
 * Pair of running shoes.
 * 
 * @author Nikolaus Winter
 */
public class Shoe {

    /**
     * ID.
     * meaning of 0: not yet saved
     */
    private int id = 0;

    /**
     * brand (e.g. Adidas, Asics).
     */
    private String brand = "";
    
    /**
     * model.
     */
    private String model = "";
    
    /**
     * date of purchase.
     * This attribute is a string of characters to allow vague values.
     */
    private String dateOfPurchase = "";
    
    /**
     * price.
     * This attribute is a string of characters to allow vague values.
     */
    private String price = "";
    
    /**
     * comments.
     */
    private String comments = "";
    
    /**
     * Are the shoes still used?
     */
    private boolean active = true;
    
    /**
     * image of the running shoes in jpeg format.
     */
    private byte[] image;
    
    // Getters/Setters
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getDateOfPurchase() {
        return dateOfPurchase;
    }

    public void setDateOfPurchase(String dateOfPurchase) {
        this.dateOfPurchase = dateOfPurchase;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }

    /**
     * Produces a short name to display in UI (e.g. DropDownLists).
     * @return short name
     */
    public String getShortname() {
        return String.format("%s %s (%s)", this.brand, this.model, this.dateOfPurchase);
    }

    /**
     * Checks shoe for validity
     * 
     * @return Is the shoe data valid, i.e. ready to be saved.
     */
    public boolean isValid() {
        
    	// brand must not be empty
        if (StringUtils.isBlank(this.brand)) {
            return false;
        }
        
        // model must not be empty
        if (StringUtils.isBlank(this.model)) {
            return false;
        }
        
        // date of purchase must not be empty
        if (StringUtils.isBlank(this.dateOfPurchase)) {
            return false;
        }
        
        return true;
    }
}
