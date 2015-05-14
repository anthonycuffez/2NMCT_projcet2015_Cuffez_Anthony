package be.howest.nmct.data;

import java.util.ArrayList;
import java.util.List;

public class CategoryAdmin {
    private List<Category> categories;

    private static CategoryAdmin instance = new CategoryAdmin();

    private CategoryAdmin(){
        loadPlaces();
    }

    public static CategoryAdmin getInstance() { return instance; }

    public List<Category> getCategories() { return categories; }

    private void loadPlaces(){
        categories = new ArrayList<Category>();


        Category c1 = new Category("Hotels");
        Category c2 = new Category("Vakantiewoningen");
        Category c3 = new Category("Activiteiten");
        Category c4 = new Category("Restaurants");

        categories.add(c1);
        categories.add(c2);
        categories.add(c3);
        categories.add(c4);
    }
}
