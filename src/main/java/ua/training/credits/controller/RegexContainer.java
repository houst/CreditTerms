package ua.training.credits.controller;

/**
 * Created by oleglitvinenko on Jul 19, 2019
 */
public interface RegexContainer {
	
	String REGEX_NAME = "^[A-Z][a-z]{1,20}$|^[А-ЩЬЮЯҐІЇЄ][а-щьюяґіїє']{1,20}$";
	String REGEX_NUMBER = "^[0-9]+$";
	
}
