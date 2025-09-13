package flash.lyfngo.utils;

import java.util.Random;

import org.apache.commons.lang3.RandomStringUtils;

public class generateNewPassword {
	public static String generateRandomPassword(String oldPassword) {
		  String upperCaseLetters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
	        String lowerCaseLetters = "abcdefghijklmnopqrstuvwxyz";
	        String numbers = "0123456789";
	        String specialCharacters = "!@#$%^&*";
	        Random rnd = new Random();
	        String newPass;

	        do {
	            StringBuilder sb = new StringBuilder();
	            // Ensure at least one character from each category
	            sb.append(upperCaseLetters.charAt(rnd.nextInt(upperCaseLetters.length())));
	            sb.append(lowerCaseLetters.charAt(rnd.nextInt(lowerCaseLetters.length())));
	            sb.append(numbers.charAt(rnd.nextInt(numbers.length())));
	            sb.append(specialCharacters.charAt(rnd.nextInt(specialCharacters.length())));
	            String all = upperCaseLetters + lowerCaseLetters + numbers + specialCharacters;
	            for (int i = 0; i < 5; i++) {
	                sb.append(all.charAt(rnd.nextInt(all.length())));
	            }

	            newPass = sb.toString();
	        } while (newPass.equals(oldPassword));

	        return newPass;
	    }
	        
	        /** String allCharacters = upperCaseLetters + lowerCaseLetters + numbers + specialCharacters;
			  String newpass = RandomStringUtils.random(9, allCharacters);
			  while (newpass.equals(oldPassword)) {
				  newpass = RandomStringUtils.random(9, allCharacters);
			  }
 return newpass;
	} **/
}
