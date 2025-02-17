package com.recipeapp.datahandler;

/*
 * インタフェースの実装
 * JSONは「JavaScriptオブジェクト記法」の略で、データをテキスト形式で記述する
 * getMode()メソッドにJSONの文字列を返す
 */

import java.util.ArrayList;
import com.recipeapp.model.Recipe;
import java.io.IOException;

public class JSONDataHandler implements DataHandler{
    private String filePath;

    public JSONDataHandler() {
        this.filePath = "app/src/main/resources/recipes.json";
    }

    public JSONDataHandler(String filePath) {
        this.filePath = filePath;
    }

    @Override
    public String getMode() {
        return "JSON";
    }

    @Override
    public ArrayList<Recipe> readData() throws IOException{
        return null;
    }

    @Override
    public void writeData(Recipe recipe) throws IOException{
        
    }

    @Override
    public ArrayList<Recipe> searchData(String keyword) throws IOException{
        return null;
    }
}
