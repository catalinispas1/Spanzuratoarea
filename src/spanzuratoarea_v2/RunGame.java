package spanzuratoarea_v2;

import java.util.Scanner;

public class RunGame extends PrepareGame {
	
	//PrepareGame prepareGame = new PrepareGame();
	
	void prepareGame() {
		setWord();
		setStarterWord();
		printGuessWord();
		System.out.println();
	}
	
	boolean isDublicate(char userChar) {
		for(int i = 0; i < history.size(); i++) {
			if(userChar == history.get(i)) {
				return true;
			}
		}
		return false;
	}
	
	boolean isLetterGuessed(char userChar) {
		for(int i = 1; i < wordArray.length - 1; i++) {
			if(userChar == wordArray[i]) {
				guessWordArray[i] = wordArray[i];
				countLetterFound++;
				return true;
			}
		}
		return false;
	}
	
	void printWord(char[] word) {
		for(int i = 0; i < word.length; i++) {
			System.out.print(word[i]+" ");
		}
	}
	
	void checkWinOrLose(int attempts) {
		
		if(attempts == 0) {
			System.out.println("You lost, the word was:  ");
			printWord(wordArray);
		} else {
			printWord(guessWordArray);
		}
	}
	
	void getTheGameRunning() {
		int attempts = 8;
		//Citesti input
		prepareGame();
		Scanner sc = new Scanner(System.in);

	
		while(countLetterFound < wordArray.length) {
			System.out.println();
			System.out.println("Type a letter:");
			char userChar = sc.next().charAt(0);
			
			
			//Caz eroare: 1. Nu a ghicit o litera corecta 2. A ramas fara attempts 3. A bagat o litera pe care a mai bagat-o
			
			if(isDublicate(userChar)) {
				System.out.print("You already typed this letter, try another");
				continue;
			}
			
			
			// Tratez cazul in care litera nu este corecta + verific daca mai are sanse de incercare
			if(!isLetterGuessed(userChar)) {
				attempts--;
				if(attempts > 0) {
					System.out.println("The letter doesn't match, try again(" + attempts +  " left)");
				} else {
					System.out.println("This was your last attempt.");
				}
			}
			
			
			// Daca a pierdut, afiseaza rezultatul corect
			checkWinOrLose(attempts);
			if(attempts == 0) {
				break;
			}
			
			history.add(userChar);
		}
		sc.close();
		
		
		// Daca a castigat, afiseaza mesaj
		if(attempts > 0) {
			System.out.println("You guessed the word!");
		}
	}
}
