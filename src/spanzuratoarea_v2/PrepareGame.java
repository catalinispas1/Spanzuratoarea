package spanzuratoarea_v2;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class PrepareGame {
	String words[] = {"programare", "telecomanda","calculator"};
	
	String fruits[] = {"Apple","Apricot","Avocado","Aubergine","Berries","Butternut squash","Cherries","Chupa-chupa","Crab apple","Clementine","Cucumber","Courgette","Custard apple",
			"Damsons","Durian","Dates","Dragon fruit","Eggfruit","Entawak","Fig","Finger lime","Grapefruit","Grapes","Guava","Imbe","Jackfruit","Java apple","Jambolan","Jeruk limo",
			"Kiwi","Kaffir lime","Kumquat","Lemon","Lime","Lychee","Loquat","Mango","Mandarin","Mangosteen","Melon","Nectarine","Nyssa ogeche","Nashi pear","Olive","Orange",
			"Papaya","Persimmon","Prickly pear","Peach","Pomegranate","Pineapple","Passion fruit","Pluot","Pear","Pepper","Pumpkin","Pomelo","Quince","Rambutan","Raisins","Rose hips",
			"Star fruit","Tomato","Tangerine","Tamarind","Tamarillo","Ugli fruit","Voavanga","Ximenia caffra fruit","Yangmei"};
	
	String vegetables [] = {"Artichokes","Arugula","Asparagus","Beets","Bell peppers","Bok choy","Broccoli","Brussels sprouts","Cabbage","Carrots","Cauliflower","Celery","Collard greens",
			"Cucumbers","Endive","Escarole","Fennel","French beans","Garlic","Ginger","Green beans","Green onions","Green peas","Kohlrabi","Leeks","Lettuce","Lima beans","Mustard greens",
			"Okra","Onions","Oregano","Parsley","Parsnips","Peas","Potatoes","Pumpkin","Radicchio","Radishes","Rapini","Red cabbage","Red onion","Red pepper","Romaine lettuce",
			"Rutabaga","Scallions","Shallots","Spinach","Squash","Sweet potatoes","Turnips","Vanilla","Zucchini"};
	
	String movies [] = {"The Proud Family Movie (2005)","Newsies", "Chariots of Fire", "Godzilla", "Teen Beach", "Lawrence of Arabia", "Pocahontas", "Harry and the Hendersons", 
			"Read It and Weep", "The Nightmare Before Christmas", "The Bourne Ultimatum", "Ghost", "Kiki's Delivery Service","Zootopia", "The Rescuers", "Bedknobs and Broomsticks", 
			"The Return of Jafar", "Sky High", "Johnny Tsunami", "Angels in the Outfield", "The Croods","The Peanuts Movie","October Sky", "Star Wars: The Force Awakens","Indiana Jones and the Last Crusade",
			"The NeverEnding Story","Patch Adams", "Beethoven", "Airplane","Jump In","Jett Jackson: The Movie", "Pokemon: Power of One", "Return to Halloweentown","Swiss Family Robinson", 
			"The Cheetah Girls: One World", "The Jungle Book", "Now You See Me", "Journey to the Center of the Earth", "Heavyweights", "Crocodile Dundee", "Romeo and Juliet", 
			"Corpse Bride", "Into the Woods", "It's a Wonderful Life", "Teenage Mutant Ninja Turtles", "Star Trek Beyond", "The Prestige","Dennis the Menace" };

	String word = "";
	char[] wordArray;
	char[] guessWordArray;
	int countLetterFound = 0;
	ArrayList <Character> history = new ArrayList <Character>();

	void setWord() {
		Random random = new Random();
		Scanner sc = new Scanner(System.in);
		System.out.println("If you want fruits, type 'f', if you want vegetables, type 'v', if you want movies, type 'm' or if you want all, type 'a'.");
		
		char category = sc.next().charAt(0);
		if(category == 'f') {
			int index = random.nextInt(fruits.length);
			this.word = fruits[index];
		}else if(category == 'v') {
			int index = random.nextInt(vegetables.length);
			this.word = vegetables[index];
		}else if(category == 'm') {
			int index = random.nextInt(movies.length);
			this.word = movies[index];
		}else if(category == 'a') {
			int randomCategory = random.nextInt(3);
			if(randomCategory == 0) {
				int index = random.nextInt(fruits.length);
				this.word = fruits[index];
			}else if(randomCategory == 1){
				int index = random.nextInt(vegetables.length);
				this.word = vegetables[index];
			}else {
				int index = random.nextInt(movies.length);
				this.word = movies[index];
			}
		}else {
			System.exit (0);
		}
	}
	
	void setStarterWord() {
		String word1 = word.toLowerCase();
		wordArray = word1.toCharArray();
		guessWordArray = new char[wordArray.length];
		
		for(int i = 0; i < wordArray.length; i++) {
			if(wordArray[0] == wordArray[i]) {
				guessWordArray[i] = wordArray[0];
				countLetterFound++;
				history.add(wordArray[0]);
			}else if (wordArray[wordArray.length-1] == wordArray[i]) {
				guessWordArray[i] = wordArray[wordArray.length-1];
				countLetterFound++;
				history.add(wordArray[wordArray.length-1]);
			}else if(wordArray[i] == ' ') {
				guessWordArray[i] = ' ';
				countLetterFound++;
				history.add(' ');
			}else if(wordArray[i] == ':') {
				guessWordArray[i] = ' ';
				countLetterFound++;
				history.add(' ');
			}else if(wordArray[i] == "\u0027".charAt(0)) {
				guessWordArray[i] = "\u0027".charAt(0);
				countLetterFound++;
				history.add(' ');
			}
			else{
				guessWordArray[i] = '_';
			}
		}
	}
	
	void printGuessWord() {
		for(int i = 0; i < wordArray.length; i++) {
			System.out.print(guessWordArray[i] + " ");
		}
	}
}
