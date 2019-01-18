package com.battery.common.web.formater;

import java.text.ParseException;
import java.util.Date;
import java.util.Locale;

import org.springframework.format.Formatter;
import org.springframework.stereotype.Component;

import com.battery.common.utils.MyDateUtils;

@Component
public class WebDateFormatter implements Formatter<Date>{
	
	@Override
	public String print(Date object, Locale locale) {
		return MyDateUtils.getDateString(object);
	}

	@Override
	public Date parse(String text, Locale locale) throws ParseException {
		return MyDateUtils.parseDate(text);
	}

}
