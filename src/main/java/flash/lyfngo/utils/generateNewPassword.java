package flash.lyfngo.utils;

import org.apache.commons.lang3.RandomStringUtils;

public class generateNewPassword {
	public static String generateRandomPassword(String oldPassword) {
		  String upperCaseLetters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
	        String lowerCaseLetters = "abcdefghijklmnopqrstuvwxyz";
	        String numbers = "0123456789";
	        String specialCharacters = "!@#$%^&*()-_=+[{]}\\|;:,<.>/";

	        String allCharacters = upperCaseLetters + lowerCaseLetters + numbers + specialCharacters;
			  String newpass = RandomStringUtils.random(9, allCharacters);
			  while (newpass.equals(oldPassword)) {
				  newpass = RandomStringUtils.random(8, allCharacters);
			  }
 return newpass;
	}
}
