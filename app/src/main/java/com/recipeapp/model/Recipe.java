package com.recipeapp.model;

import java.util.ArrayList;

public class Recipe {
    private String name;
    private ArrayList<Ingredient> ingredient = new ArrayList<>();

    public Recipe(String name, ArrayList<Ingredient> ingredient) {
        this.name = name;
        this.ingredient = ingredient;
    }

    public String getName() {
        return this.name;
    }

    public ArrayList<Ingredient> getIngredient() {
        return this.ingredient;
    }
}
