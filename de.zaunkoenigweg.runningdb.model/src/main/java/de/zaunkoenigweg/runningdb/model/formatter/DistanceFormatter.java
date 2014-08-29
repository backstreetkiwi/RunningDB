package de.zaunkoenigweg.runningdb.model.formatter;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.lang3.StringUtils;

/**
 * Format and parse distance
 * 
 * @author Nikolaus Winter
 *
 */
public class DistanceFormatter {

    private static final String REGEX = "^(\\d{1,2})?\\.?(\\d{3})$";

    public String format(Integer distance) {
		if (distance == null) {
			return "";
		}
		int meter = distance.intValue() % 1000;
		int kilometer = (distance.intValue() / 1000);
		if (kilometer == 0) {
			return String.format("%03d", meter);
		} else {
			return String.format("%d.%03d", kilometer, meter);
		}
	}
	
	public Integer parse(String distance) {
        if(StringUtils.isBlank(distance)) {
            return null;
        }
        Pattern pattern = Pattern.compile(REGEX);
        Matcher matcher = pattern.matcher(distance); 
        if (!matcher.matches()) {
            throw new IllegalArgumentException(String.format("'%s' is not a valid distance.", distance));
        }
        
        int strecke = 0;
        strecke += Integer.valueOf(matcher.group(2));
        if(matcher.group(1)!=null) {
            strecke += Integer.valueOf(matcher.group(1)) * 1000;
        }
        
        if(strecke==0) {
            return null;
        }
        
        return Integer.valueOf(strecke);
	}

}
