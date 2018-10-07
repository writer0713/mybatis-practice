package com.writer0713.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

@RestController
public class AnotherController {
	
	private static final Logger logger = LoggerFactory.getLogger(AnotherController.class);
	
	@RequestMapping(value = "/rest", method = RequestMethod.GET)
	public String test(Locale locale, Model model) {
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);

		return formattedDate;
	}
	
}
