package com.example.project3.Service;

import com.example.project3.Model.Category;
import com.example.project3.Model.Product;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class CategoryService {

    ArrayList<Category> categories = new ArrayList<>();

    public ArrayList<Category> getCategories(){
        return categories;
    }

    public void addCategory(Category category){
        categories.add(category);
    }

    public boolean updateCategory(int id, Category category){
        for (int i =0; i < categories.size(); i++) {
            if (categories.get(i).getId() == id) {
                categories.set(i, category);
                return true;
            }
        }
        return false;
    }

    public boolean deleteCategory(int id){
        for (int i =0; i < categories.size(); i++) {
            if (categories.get(i).getId() == id) {
                categories.remove(i);
                return true;
            }
        }
        return false;
    }

    public boolean find(int id){
        for (int i =0; i < categories.size(); i++) {
            if (categories.get(i).getId() == id) {
                return true;
            }
        }
        return false;
    }
}
