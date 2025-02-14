import com.recipeapp.datahandler.CSVDataHandler;
import com.recipeapp.datahandler.DataHandler;
import com.recipeapp.datahandler.JSONDataHandler;
import com.recipeapp.ui.RecipeUI;
import java.io.*;
import java.util.ArrayList;

public class App {

    public static void main(String[] args) {
        ArrayList<String> choices = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            System.out.println("Choose the file format:");
            System.out.println("1. CSV");
            System.out.println("2. JSON");
            System.out.print("Select (1/2): ");
            String choice = reader.readLine();
            if (choice.equals("2") ) {
                JSONDataHandler jsonDataHandler = new JSONDataHandler();
                choices.add(choice);
                //System.out.println("Current mode: " + jsonDataHandler.getMode());
                System.out.println();
            } else {
                CSVDataHandler csvDataHandler = new CSVDataHandler();
                choices.add(choice);
                //System.out.println("Current mode: " + csvDataHandler.getMode());
            }
        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
}