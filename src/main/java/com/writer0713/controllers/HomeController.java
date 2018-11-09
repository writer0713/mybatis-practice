package com.writer0713.controllers;

import com.writer0713.domains.User;
import com.writer0713.exception.CustomException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Map;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);

		model.addAttribute("serverTime", formattedDate);


		return "home";
	}

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String loginGET() {

		return "login";
	}


	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String loginPOST(
					@ModelAttribute User user
	) {

		return "home";
	}

	@RequestMapping(value = "/customException", method = RequestMethod.GET)
	public void occurCustomException() throws CustomException {

		logger.error("occur CustomException");

		throw new CustomException("occur Custom Exception");
	}

	@RequestMapping(value = "/exception", method = RequestMethod.GET)
	public void occurException() throws Exception {

		logger.error("occur Exception");

		throw new Exception("occur Exception");
	}


}
