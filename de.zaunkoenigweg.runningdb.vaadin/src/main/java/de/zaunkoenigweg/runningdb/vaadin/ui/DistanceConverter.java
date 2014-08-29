package de.zaunkoenigweg.runningdb.vaadin.ui;

import java.util.Locale;

import com.vaadin.data.util.converter.Converter;

import de.zaunkoenigweg.runningdb.model.formatter.DistanceFormatter;

/**
 * Converts running distance.
 *
 * @author Nikolaus Winter
 */
public class DistanceConverter implements Converter<String, Integer> {

    private static final long serialVersionUID = -5944663904981260796L;

    @Override
    public Integer convertToModel(String value, Class<? extends Integer> targetType, Locale locale) throws Converter.ConversionException {
    	try {
			return new DistanceFormatter().parse(value);
		} catch (Exception e) {
			throw new ConversionException(String.format("'%s' konnte nicht als Strecke erkannt werden.", value));
		}
    }

    @Override
    public String convertToPresentation(Integer value, Class<? extends String> targetType, Locale locale) throws Converter.ConversionException {
    	return new DistanceFormatter().format(value);
    }

    @Override
    public Class<Integer> getModelType() {
        return Integer.class;
    }

    @Override
    public Class<String> getPresentationType() {
        return String.class;
    }

}
