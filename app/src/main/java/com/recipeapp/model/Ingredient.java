package com.recipeapp.model;

/*
 * レシピ管理アプリのデータモデルとしてingredientクラスの作成
 * 材料の名前「name」
 */

public class Ingredient {
    private String name;

    public Ingredient(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }
}
