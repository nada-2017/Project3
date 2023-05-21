package com.example.project3.Service;


import com.example.project3.Model.MerchantStock;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.ArrayList;

@Service
public class MerchantStockService {

    ArrayList<MerchantStock> merchantStocks = new ArrayList<>();

    public ArrayList<MerchantStock> getMerchantStocks(){
        return merchantStocks;
    }

    public void addMerchantStock(MerchantStock merchantStock){
        merchantStocks.add(merchantStock);
    }

    public boolean updateMerchantStock(int id, MerchantStock merchantStock){
        for (int i =0; i < merchantStocks.size(); i++) {
            if (merchantStocks.get(i).getId() == id) {
                merchantStocks.set(i, merchantStock);
                return true;
            }
        }
        return false;
    }

    public boolean deleteMerchantStock(int id){
        for (int i =0; i < merchantStocks.size(); i++) {
            if (merchantStocks.get(i).getId() == id) {
                merchantStocks.remove(i);
                return true;
            }
        }
        return false;
    }

    public MerchantStock find(int productId, int merchantId){
        for (int i =0; i < merchantStocks.size(); i++) {
            if (merchantStocks.get(i).getMerchantId() == merchantId && merchantStocks.get(i).getProductId() == productId)
                return merchantStocks.get(i);
        }
        return null;
    }
}
