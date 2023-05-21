package com.example.project3.Controller;


import com.example.project3.Model.*;
import com.example.project3.Service.*;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/amazon")
@RequiredArgsConstructor
public class AmazonController {

    private final ProductService productService;
    private final CategoryService categoryService;
    private final MerchantService merchantService;
    private final MerchantStockService merchantStockService;
    private final MyUserService myUserService;



    //Get All products
    @GetMapping("/product/get")
    public ResponseEntity getProducts(){
        return ResponseEntity.status(200).body(productService.getProducts());
    }

    //Add product
    @PostMapping("/product/add")
    public ResponseEntity addProduct(@Valid @RequestBody Product product, Errors errors){
        if (errors.hasErrors()){
            String message = errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(message);
        }
        if (categoryService.find(product.getCategoryID())) {
            productService.addProduct(product);
            return ResponseEntity.status(200).body("Product added");
        }
        return ResponseEntity.status(400).body("Category not found");
    }

    //Update product
    @PutMapping("/product/update/{id}")
    public ResponseEntity updateProduct(@PathVariable int id, @Valid@RequestBody Product product, Errors errors){
        if (errors.hasErrors()){
            String message = errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(message);
        }
        if (productService.updateProduct(id,product))
            return ResponseEntity.status(200).body("Product updated");
        return ResponseEntity.status(400).body("Not Found");
    }

    //Delete product
    @DeleteMapping("/product/delete/{id}")
    public ResponseEntity deleteProduct(@PathVariable int id){
        if (productService.deleteProduct(id))
            return ResponseEntity.status(200).body("Product deleted");
        return ResponseEntity.status(400).body("Not Found");
    }

//_______________________________________________________________________________________________________


    //Get All categories
    @GetMapping("/category/get")
    public ResponseEntity getCategories(){
        return ResponseEntity.status(200).body(categoryService.getCategories());
    }

    //Add category
    @PostMapping("/category/add")
    public ResponseEntity addCategory(@Valid @RequestBody Category category, Errors errors){
        if (errors.hasErrors()){
            String message = errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(message);
        }
        categoryService.addCategory(category);
        return ResponseEntity.status(200).body("Category added");
    }

    //Update Category
    @PutMapping("/category/update/{id}")
    public ResponseEntity updateCategory(@PathVariable int id, @Valid@RequestBody Category category, Errors errors){
        if (errors.hasErrors()){
            String message = errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(message);
        }
        if (categoryService.updateCategory(id,category))
            return ResponseEntity.status(200).body("Category updated");
        return ResponseEntity.status(400).body("Not Found");
    }

    //Delete Category
    @DeleteMapping("/category/delete/{id}")
    public ResponseEntity deleteCategory(@PathVariable int id){
        if (categoryService.deleteCategory(id))
            return ResponseEntity.status(200).body("Category deleted");
        return ResponseEntity.status(400).body("Not Found");
    }


//_______________________________________________________________________________________________________


    //Get All Merchant
    @GetMapping("/merchant/get")
    public ResponseEntity getMerchants(){
        return ResponseEntity.status(200).body(merchantService.getMerchants());
    }

    //Add Merchant
    @PostMapping("/merchant/add")
    public ResponseEntity addMerchant(@Valid @RequestBody Merchant merchant, Errors errors){
        if (errors.hasErrors()){
            String message = errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(message);
        }
        merchantService.addMerchant(merchant);
        return ResponseEntity.status(200).body("Merchant added");
    }

    //Update Merchant
    @PutMapping("/merchant/update/{id}")
    public ResponseEntity updateMerchant(@PathVariable int id, @Valid@RequestBody Merchant merchant, Errors errors){
        if (errors.hasErrors()){
            String message = errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(message);
        }
        if (merchantService.updateMerchant(id,merchant))
            return ResponseEntity.status(200).body("Merchant updated");
        return ResponseEntity.status(400).body("Not Found");
    }

    //Delete Merchant
    @DeleteMapping("/merchant/delete/{id}")
    public ResponseEntity deleteMerchant(@PathVariable int id){
        if (merchantService.deleteMerchant(id))
            return ResponseEntity.status(200).body("Merchant deleted");
        return ResponseEntity.status(400).body("Not Found");
    }

//_______________________________________________________________________________________________________

    //Get All MerchantStock
    @GetMapping("/merchantstock/get")
    public ResponseEntity getMerchantsStock(){
        return ResponseEntity.status(200).body(merchantStockService.getMerchantStocks());
    }

    //Add MerchantStock
    @PostMapping("/merchantstock/add")
    public ResponseEntity addMerchantStock(@Valid @RequestBody MerchantStock merchantStock, Errors errors){
        if (errors.hasErrors()){
            String message = errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(message);
        }
        if (merchantService.find(merchantStock.getMerchantId()) && productService.find(merchantStock.getProductId())) {
            merchantStockService.addMerchantStock(merchantStock);
            return ResponseEntity.status(200).body("MerchantStock added");
        }
        return ResponseEntity.status(400).body("Merchant or Product not found");
    }

    //Update MerchantStock
    @PutMapping("/merchantstock/update/{id}")
    public ResponseEntity updateMerchantStock(@PathVariable int id, @Valid@RequestBody MerchantStock merchantStock, Errors errors){
        if (errors.hasErrors()){
            String message = errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(message);
        }
        if (merchantStockService.updateMerchantStock(id,merchantStock))
            return ResponseEntity.status(200).body("MerchantStock updated");
        return ResponseEntity.status(400).body("Not Found");
    }

    //Delete MerchantStock
    @DeleteMapping("/merchantstock/delete/{id}")
    public ResponseEntity deleteMerchantStock(@PathVariable int id){
        if (merchantStockService.deleteMerchantStock(id))
            return ResponseEntity.status(200).body("MerchantStock deleted");
        return ResponseEntity.status(400).body("Not Found");
    }

//_______________________________________________________________________________________________________


    //Get All users
    @GetMapping("/user/get")
    public ResponseEntity getUsers(){
        return ResponseEntity.status(200).body(myUserService.getMyUsers());
    }

    //Add user
    @PostMapping("/user/add")
    public ResponseEntity addUser(@Valid@RequestBody MyUser user, Errors errors){
        if (errors.hasErrors()){
            String message = errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(message);
        }
        myUserService.addUser(user);
        return ResponseEntity.status(200).body("User added");
    }

    //Update user
    @PutMapping("/user/update/{id}")
    public ResponseEntity updateUser(@PathVariable int id, @Valid@RequestBody MyUser user, Errors errors){
        if (errors.hasErrors()){
            String message = errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(message);
        }
        if (myUserService.updateUser(id,user))
            return ResponseEntity.status(200).body("User updated");
        return ResponseEntity.status(400).body("Not Found");
    }

    //Delete user
    @DeleteMapping("/user/delete/{id}")
    public ResponseEntity deleteUser(@PathVariable int id){
        if (myUserService.deleteUser(id))
            return ResponseEntity.status(200).body("User deleted");
        return ResponseEntity.status(400).body("Not Found");
    }


//_______________________________________________________________________________________________________


    //Add product to merchant stock
    @PutMapping("/addproduct/{productId}/{merchantId}/{stock}")
    public ResponseEntity addProductToStock(@PathVariable int productId, @PathVariable int merchantId, @PathVariable int stock){
        MerchantStock m = merchantStockService.find(productId, merchantId);
        if (stock > 0) {
            m.setStock(m.getStock() + stock);
            return ResponseEntity.status(200).body("Product added");
        }
        return ResponseEntity.status(400).body("Not Found");
    }


    //User buy a product
    @PutMapping("/buy/{productId}/{merchantId}/{userId}")
    public ResponseEntity buy(@PathVariable int productId, @PathVariable int merchantId, @PathVariable int userId){
        if (productService.find(productId) && merchantService.find(merchantId) && myUserService.find(userId)) {
            MerchantStock m = merchantStockService.find(productId, merchantId);
            if (m.getStock() > 0) {
                if(myUserService.deductBalance(userId,productService.getPrice(productId)) < 0)
                    return ResponseEntity.status(400).body("balance not enough");
                m.setStock(m.getStock() - 1);
                return ResponseEntity.status(200).body("Purchased succeeded");
            }
            return ResponseEntity.status(400).body("Stock not enough");
        }
        return ResponseEntity.status(400).body("Not Found");
    }
}
