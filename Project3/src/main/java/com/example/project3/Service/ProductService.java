package com.example.project3.Service;


import com.example.project3.Model.Product;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class ProductService {

    ArrayList<Product> products = new ArrayList<>();

    public ArrayList<Product> getProducts(){
        return products;
    }

    public void addProduct(Product product){
        products.add(product);
    }

    public boolean updateProduct(int id, Product product){
        for (int i =0; i < products.size(); i++) {
            if (products.get(i).getId() == id) {
                products.set(i, product);
                return true;
            }
        }
        return false;
    }

    public boolean deleteProduct(int id){
        for (int i =0; i < products.size(); i++) {
            if (products.get(i).getId() == id) {
                products.remove(i);
                return true;
            }
        }
        return false;
    }

    public boolean find(int id){
        for (int i =0; i < products.size(); i++) {
            if (products.get(i).getId() == id) {
                return true;
            }
        }
        return false;
    }

    public double getPrice(int id){
        for (int i =0; i < products.size(); i++) {
            if (products.get(i).getId() == id) {
                return products.get(i).getPrice();
            }
        }
        return 0;
    }

    public int getCategoryId(int id){
        for (int i =0; i < products.size(); i++) {
            if (products.get(i).getId() == id) {
                return products.get(i).getCategoryID();
            }
        }
        return 0;
    }
}
