package com.recipeapp.datahandler;

/*
 * インタフェースの実装
 * JSONクラスに対応したクラス
 */

import java.util.ArrayList;
import com.recipeapp.model.Recipe;

public class JSONDataHandler {
    public String getMode() {
        return "JSON";
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
