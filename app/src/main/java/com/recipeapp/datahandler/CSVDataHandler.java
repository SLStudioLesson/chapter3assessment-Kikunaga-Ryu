package com.recipeapp.datahandler;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/*
 * インターフェースの実装
 * CSVは「カンマ区切り値」の略。データをカンマで区切って保存
 */

import java.util.ArrayList;

import com.recipeapp.model.Ingredient;
import com.recipeapp.model.Recipe;

public class CSVDataHandler implements DataHandler {
    // レシピデータを格納するCSVファイルパス
    private String filePath;

    public CSVDataHandler() {
        this.filePath = "app/src/main/resources/recipes.csv";
    }

    public CSVDataHandler(String filePath) {
        this.filePath = filePath;
    }

    // getModeメソッドには「CSV」という文字列を返す
    @Override
    public String getMode() {
        return "CSV";
    }

    /*
     * recipe.csvからレシピデータを読み込み、リスト形式で返す
     * 読み込んだものを料理名と材料名の2つにわける
     * 分けたデータをrecipesにいれて返す
     */
    @Override
    public ArrayList<Recipe> readData() throws IOException {
        ArrayList<Recipe> recipes = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] data = line.split(",", 2);
                String recipeName = data[0];
                String ingredientName = data[1];
                ArrayList<Ingredient> ingredients = new ArrayList<>();

                for (int i = 1; i < data.length; i++) {
                    ingredients.add(new Ingredient(ingredientName));
                }

                recipes.add(new Recipe(recipeName, ingredients));
            }
        }
        return recipes;
    }

    /*
     * 新しいレシピをrecipes.csvに追加します。
     * レシピ名と材料はカンマ区切りで1行としてファイルに書き込まれます。
     */
    @Override
    public void writeData(Recipe recipe) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath, true))) {
            writer.write(recipe.getName());
            for (Ingredient ingredient : recipe.getIngredient()) {
                writer.write(" ," + ingredient.getName());
            }
            writer.newLine();
        }
    }

    @Override
    public ArrayList<Recipe> searchData(String keyword) throws IOException {
        return null;
    }

}
