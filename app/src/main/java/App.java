/*
 * ユーザーの選択に応じて出力
 * 1の場合CSVDataHandlerのインスタンスを生成
 * 2の場合JSONDataHandlerのインスタンスを生成
 * 1、2以外の場合CSVDataHandlerのインスタンスを生成
 * 選択されたデータハンドラーをRecipeUIに渡す
 * displayMenuメソッドを呼び出してメインメニュー出力
 */


import com.recipeapp.datahandler.CSVDataHandler;
import com.recipeapp.datahandler.DataHandler;
import com.recipeapp.datahandler.JSONDataHandler;
import com.recipeapp.model.Recipe;
import com.recipeapp.ui.RecipeUI;
import java.io.*;

public class App {

    public static void main(String[] args) {

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            System.out.println("Choose the file format:");
            System.out.println("1. CSV");
            System.out.println("2. JSON");
            System.out.print("Select (1/2): ");
            String choice = reader.readLine();
            if (choice.equals("1")) {
                CSVDataHandler csvDataHandler = new CSVDataHandler();
            } else if (choice.equals("2")) {
                JSONDataHandler jsonDataHandler = new JSONDataHandler();
            } else {
                CSVDataHandler csvDataHandler = new CSVDataHandler();
            }
        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
}