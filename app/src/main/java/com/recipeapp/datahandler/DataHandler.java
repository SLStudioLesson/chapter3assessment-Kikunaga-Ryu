package com.recipeapp.datahandler;

/*
 * インターフェースの定義
 */

import java.util.ArrayList;
import com.recipeapp.model.Recipe;

public interface DataHandler {

    // 現在のモードを返します
    public String getMode();
    // レシピデータを読み込みます
    public ArrayList<Recipe> readData();
    // 指定されたRecipeオブジェクトに追加
    public void writeData(Recipe recipe);
    // 指定されたキーワードでレシピを検索し、一致するオブジェクトをリストで返す
    public ArrayList<Recipe> searchData(String keyword);
}
