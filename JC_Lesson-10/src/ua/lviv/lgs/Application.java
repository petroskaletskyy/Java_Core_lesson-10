/*
 * LOGAS IT ACADEMY
 * */

package ua.lviv.lgs;

import java.util.Arrays;
import java.util.Scanner;

public class Application {

	/*
	 * Menu to select the action
	 */

	static void menu() {
		System.out.println("Press 1 to check if the entered word is a palindrome:");
		System.out.println("Press 2 to replace all loud letter:");
		System.out.println("Press 3 to count the number of words in the sentense:");
		System.out.println("Press 4 to count the number of sentences in the text:");
		System.out.println("Press 5 to find the word most often found in the sentence:");
		System.out.println("Press 6 to find the word most often found in the sentense:");
	}

	public static void main(String[] args) throws WrongInputConsoleParametersException {
		// Input values
		Scanner sc = new Scanner(System.in);
		// Loop for data entry
		while (true) {
			menu();

			switch (sc.next()) {
			case "1": {
				System.out.println("Enter a word that consists of 5 letter:");
				Scanner scan = new Scanner(System.in);

				// Read a word
				String word1 = scan.next();

				// Make a reverse word
				StringBuilder str = new StringBuilder(word1).reverse();

				// Convert reverse word to string
				String word2 = str.toString();

				// Check that the entered word has 5 letter and work with exception
				if ((word1.length() > 5) || (word1.length() < 5)) {
					throw new WrongInputConsoleParametersException("The word not consists 5 letter!!!");
				}

				// Compare two string
				if (word1.equalsIgnoreCase(word2)) {
					System.out.println("The entered word is a palindrome");
				} else {
					System.out.println("The entered word is not a palindrome");
				}
				System.out.println();
				break;
			}
			case "2": {
				System.out.println("Enter text:");

				// Inputing values
				Scanner scan = new Scanner(System.in);
				String text = scan.nextLine();

				// Creating array of loud letter
				String[] letter = { "¸", "ó", "å", "¿", "³", "à", "î", "º", "ÿ", "è", "þ", "ü", "ú", "û", "ý", "e", "y",
						"u", "i", "o", "a" };

				// Finding loud letter and replacing it to another symbol
				for (int i = 0; i < letter.length; i++) {
					text = text.replace(letter[i], "-");
					text = text.replace(letter[i].toUpperCase(), "-");
				}
				System.out.println(text.toString());
				break;
			}
			case "3": {
				System.out.println("Enter the sentense:");

				// Inputing values
				Scanner scan = new Scanner(System.in);
				String text = scan.nextLine();
				int count = 0;

				if (text.length() != 0) {
					count++;

					// Looking for spaces and counting the number of words
					for (int i = 0; i < text.length() - 1; i++) {
						if ((text.charAt(i) == ' ') && (text.charAt(i + 1) != '-')) {
							count++;
						}
					}
				}
				System.out.println("The entered sentense has " + count + " word");
				break;
			}
			case "4": {
				System.out.println("Enter the text:");

				// Inputing values
				Scanner scan = new Scanner(System.in);
				String text = scan.nextLine();
				int count = 0;

				if (text.length() != 0) {
					count++;

					// Looking for dots and counting the number of sentences
					for (int i = 0; i < text.length() - 1; i++) {
						if ((text.charAt(i) == '.') && (text.charAt(i + 1) == ' ')) {
							count++;
						}
					}
				}
				System.out.println("The entered test has " + count + " sentense");
				break;
			}
			case "5": {
				System.out.println("Enter the sentense:");

				// Inputing values
				Scanner scan = new Scanner(System.in);
				String text = scan.nextLine();

				// Creating array of string and sort the array
				String[] arr = text.split(" ");
				Arrays.sort(arr);

				String maxWord = "", word = "";
				int maxCount = 0, count = 1;

				// Pass the array and check the repeats
				for (String str : arr) {
					if (str.equals(word)) {
						count++;
					} else {
						if (count > maxCount) {
							maxCount = count;
							maxWord = word;
						}
						word = str;
						count = 1;
					}
				}

				if (count > maxCount) {
					maxCount = count;
					maxWord = word;
				}

				System.out.println("The most repeated word: \"" + maxWord + "\" (occurs " + maxCount + " times)");
				break;
			}
			case "6": {
				System.out.println("Enter the text:");

				// Inputing values
				Scanner scan = new Scanner(System.in);
				String text = scan.nextLine();

				// Creating array of string and sort the array
				String[] arr = text.split(" ");
				Arrays.sort(arr);

				String maxWord = "", word = "";
				int maxCount = 0, count = 1;

				// Pass the array and check the repeats
				for (String str : arr) {
					if (str.equals(word)) {
						count++;
					} else {
						if (count > maxCount) {
							maxCount = count;
							maxWord = word;
						}
						word = str;
						count = 1;
					}
				}

				if (count > maxCount) {
					maxCount = count;
					maxWord = word;
				}

				System.out.println("The most repeated word: \"" + maxWord + "\" (occurs " + maxCount + " times)");
				break;
			}
			}
		}

	}

}
