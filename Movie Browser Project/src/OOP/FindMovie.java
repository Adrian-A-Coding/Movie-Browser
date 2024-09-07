package OOP;

import java.util.Scanner;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

public class FindMovie implements MovieSearching {
	private static Set<Person> creditedPeople;
	private boolean firstInstance = false; //Flag to keep duplicate titles from overriding the first find

	public  void creatingPersonCredits(String movieId) {
		if (creditedPeople == null) {
			creditedPeople = new HashSet<Person>();
		}
		BufferedReader br2 = null;
		FileReader fr2 = null;
		try {
			fr2 = new FileReader("D:\\Eclipse-Work\\Final_Assignment\\src\\OOP\\credits.csv");
			br2 = new BufferedReader(fr2);
			String line;
			//char[] targetArr = movieId.toCharArray();
			while((line = br2.readLine()) != null) {
				line.toLowerCase();
				if(line.contains(movieId)) {
					String parts[] = line.split(",");
					Person p = new Person(parts[2], parts[4], Integer.valueOf(parts[0]), parts[1]);
					creditedPeople.add(p);
				}
			}
		}
		catch(IOException ep) {
			System.out.println("There was an error reading the credits file!\nError Message: " + ep.getMessage());
		}
		finally {
			try {
				if (br2 != null)
					br2.close();
				if (fr2 != null)
					fr2.close();
			}
			catch(IOException epx) {
				epx.printStackTrace();
			}
		}
	}
	
	public  void validateMovie(Movie movie, String title, String line) {
		String[] pieces = line.split(",");
		if(title.equalsIgnoreCase(pieces[1])) {
			movie.setId(pieces[0]);
			movie.setShowType(pieces[2]);
			movie.setReleaseYear(pieces[3]);
			movie.setRuntime(Integer.valueOf(pieces[5]));
			//movie.setGenre(pieces[7]);
			if (! pieces[2].equalsIgnoreCase("movie")) {
				movie.setSeasons(Double.valueOf(pieces[8]));
			}
			//Would want more questions to make the search accurate
			firstInstance = true; //Stops the while loop from continuing
		}
	}
	
	public  void fillMovieDetails(Movie movie) {
		BufferedReader br = null;
		FileReader fr = null;
		try {
			fr = new FileReader("D:\\Eclipse-Work\\Final_Assignment\\src\\OOP\\titles_updated.csv");
			String currentLine;
			br = new BufferedReader(fr);
			while((currentLine = br.readLine()) != null && !firstInstance) {
				validateMovie(movie, movie.getTitle(), currentLine);
			}//Now we jump into fill the set of people involved with the film
			creatingPersonCredits(movie.getId());
			Person[] transferPeepsDetails = new Person[creditedPeople.size()];
			int counter = 0;
			for(Person element:creditedPeople) {
				transferPeepsDetails[counter++] = element;
			}
			movie.setArray(transferPeepsDetails); //Setting the arrays
		}
		catch(IOException e) {
			System.out.println("Apologies, but there was an error reading the film file and completing the task!\nError Message: " + e.getMessage());
		}
		finally {
			try {
				if (br != null)
					br.close();
				if (fr != null)
					fr.close();
			}
			catch(IOException ex) {
				ex.printStackTrace();
			}
		}
	}
	
	public static void main(String[] args) {
		try (Scanner input = new Scanner(System.in)) {
			System.out.println("Enter the movie you'd like to search for: ");
			String searchTitle = input.nextLine();
			searchTitle.trim().toLowerCase();
			//After getting user input for title we use the input to make a movie object
			Movie mov = new Movie(searchTitle);
			FindMovie app = new FindMovie();
			app.fillMovieDetails(mov);
			mov.toString();
		}
	}
}
