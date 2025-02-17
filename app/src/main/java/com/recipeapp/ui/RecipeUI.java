package com.recipeapp.ui;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import com.recipeapp.datahandler.DataHandler;
import com.recipeapp.model.Ingredient;
import com.recipeapp.model.Recipe;

public class RecipeUI {
    private BufferedReader reader;
    private DataHandler dataHandler;

    public RecipeUI(DataHandler dataHandler) {
        reader = new BufferedReader(new InputStreamReader(System.in));
        this.dataHandler = dataHandler;
    }

    public void displayMenu() {

        System.out.println("Current mode: " + dataHandler.getMode());

        while (true) {
            try {
                System.out.println();
                System.out.println("Main Menu:");
                System.out.println("1: Display Recipes");
                System.out.println("2: Add New Recipe");
                System.out.println("3: Search Recipe");
                System.out.println("4: Exit Application");
                System.out.print("Please choose an option: ");

                String choice = reader.readLine();

                switch (choice) {
                    case "1":
                        displayRecipes();
                        break;
                    case "2":
                        addNewRecipe();
                        break;
                    case "3":
                        break;
                    case "4":
                        System.out.println("Exiting the application.");
                        return;
                    default:
                        System.out.println("Invalid choice. Please select again.");
                        break;
                }
            } catch (IOException e) {
                System.out.println("Error reading input from user: " + e.getMessage());
            }
        }
    }

    /*
     * DataHandlerから読み込んだレシピデータを整形してコンソールに表示
     * ファイルの中身があるかの確認
     * 出力例に沿って出力できるようにする
     * IOExceptionエラーを受け取った場合エラーメッセージ出力
     */

    private void displayRecipes() throws IOException {
        ArrayList<Recipe> recipes = dataHandler.readData();

        if (recipes.isEmpty()) {
            System.out.println("No recipes available.");
        } else {
            System.out.println("Recipes: ");
            System.out.println("-----------------------------------");

            for (Recipe recipe : recipes) {
                System.out.println("Recipes Name: " + recipe.getName());
                System.out.print("Main Ingredients: ");

                for (int i = 0; i < recipe.getIngredient().size(); i++) {
                    Ingredient ingredient = recipe.getIngredient().get(i);
                    System.out.println(ingredient.getName());
                    if (i < recipe.getIngredient().size() - 1) {
                        System.out.println(",");
                    }
                }
                System.out.println("-----------------------------------");
            }
        }
    }

    /*
     * ユーザーからレシピ名と主な材料を入力させ、DataHandlerを使用してrecipes.csvに追加します。
     * 材料の受付はdoneと打たれるまで入力を受け付ける
     * 表示形式に合して出力できるようにする
     */
    private void addNewRecipe() {
        try {
            System.out.println("adding a new recipe.");

            System.out.print("Enter recipe name: ");
            String recipeName = reader.readLine();

            ArrayList<Ingredient> ingredient = new ArrayList<>();
            System.out.println("Enter ingredients (type 'done' when finished):");
            while (true) {
                System.out.print("Ingredient: ");
                String ingredientName = reader.readLine();
                if (ingredientName.equals("done")) {
                    break;
                }
                ingredient.add(new Ingredient(ingredientName));
            }

            Recipe newRecipe = new Recipe(recipeName, ingredient);

            dataHandler.writeData(newRecipe);

            System.out.println("Recipe added successfully");
        } catch (IOException e) {
            System.out.println("Failed to add new recipe: " + e.getMessage());
        }
    }
}