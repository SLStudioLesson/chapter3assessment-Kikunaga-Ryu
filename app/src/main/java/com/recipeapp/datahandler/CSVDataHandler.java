package com.recipeapp.datahandler;

/*
 * インターフェースの実装
 * CSV形式に対応したクラス
 */

import java.util.ArrayList;
import com.recipeapp.model.Recipe;

public class CSVDataHandler {
    private String filePath;

    public CSVDataHandler() {
        this.filePath = "app/src/main/resources/recipes.csv";
    }

    public CSVDataHandler(String filePath) {
        this.filePath = filePath;
    }

    public String getMode() {
        return "CSV";
    }

    public ArrayList<Recipe> readData() {
        return null;
    }

    public void writeData() {
        
    }

    public ArrayList<Recipe> searchData() {
        return null;
    }

}
