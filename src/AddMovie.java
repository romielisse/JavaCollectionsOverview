import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Collections;

public class AddMovie {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<String> Movies = new ArrayList<String>();
        String movie_title = "";

        do {
            System.out.println("Enter movie title or Q to quit: ");
            movie_title = sc.nextLine();

            movie_title = movie_title.toLowerCase();

            // Check if movie title is a duplicate
            while(isDuplicate(Movies, movie_title)){
                System.out.println("Movie title already exists, enter new movie title or Q to quit: ");
                movie_title = sc.nextLine();
            }

            // Add movie title if not a duplicate
            if (movie_title.equals("q") == false) {
                Movies.add(movie_title);
            }
            else{
                break;
            }
        }while(movie_title.equals("q") == false);

        printMovies(Movies);
    }

    protected static void printMovies(List<String> movies){
        // Sort list of movies entered
        Collections.sort(movies);

        for(String movie:movies){
            System.out.println(movie);
        }
    }

    protected static Boolean isDuplicate(List<String> movies, String title) {
        for(String movie:movies){
            if(movie.equals(title)){
                return true;
            }
        }

        return false;
    }
}