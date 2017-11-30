package banhang.smartbill.DAL;

import com.google.gson.reflect.TypeToken;

import java.net.HttpURLConnection;
import java.net.ProtocolException;
import java.util.ArrayList;
import java.util.List;

import banhang.smartbill.Entity.Product;

/**
 * Created by KARATA on 28/11/2017.
 */

public class ProductAPI {
    public List<Product> getProducts(){
        BaseAPI tool = new BaseAPI("http://quanlibanhang.azurewebsites.net/api/products");
        HttpURLConnection conn = tool.getConnection();
        try{
            conn.setRequestMethod("GET");
            conn.setRequestProperty("Content-Type","application/json");
            conn.setRequestProperty("Accept","application/json");
            if(TokenAPI.TOKEN != null)
                conn.setRequestProperty("Authorization","Bearer " + TokenAPI.TOKEN);

            ArrayList<Product> products = tool.getResult(conn,new TypeToken<ArrayList<Product>>(){}.getType());
            System.out.println(products);
            return products;
        }catch(ProtocolException ex){
            return null;
        }
    }
    public Product getProduct(String id){
        BaseAPI tool = new BaseAPI("http://quanlibanhang.azurewebsites.net/api/products/"+id);
        HttpURLConnection conn = tool.getConnection();
        try{
            conn.setRequestMethod("GET");
            conn.setRequestProperty("Content-Type","application/json");
            conn.setRequestProperty("Accept","application/json");
            if(TokenAPI.TOKEN != null)
                conn.setRequestProperty("Authorization","Bearer " + TokenAPI.TOKEN);

            Product product = tool.getResult(conn,Product.class);
            System.out.println(product);
            return product;
        }catch(ProtocolException ex){
            return null;
        }
    }
}