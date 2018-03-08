package pluralsight.com.codingwithmitchstore.util;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

import pluralsight.com.codingwithmitchstore.models.Product;
import pluralsight.com.codingwithmitchstore.resources.Products;


/**
 * Created by User on 3/4/2018.
 */

public class CartManger {

    private static final String TAG = "CartManger";

    static final String SHOPPING_CART = "shopping_cart";
    static final String CART_ITEMS = "cart_items";
    Context mContext;
    SharedPreferences mSharedPreferences;
    SharedPreferences.Editor mEditor;

    public CartManger(Context context) {
        mContext = context;
        mSharedPreferences = mContext.getSharedPreferences(SHOPPING_CART, 0);
        mEditor = mSharedPreferences.edit();
    }

    public void addItemToCart(Product product){
        Set<String> cartItems = mSharedPreferences.getStringSet(CART_ITEMS, new HashSet<String>());
        cartItems.add(String.valueOf(product.getSerial_number()));

        mEditor.putStringSet(CART_ITEMS, cartItems);
        mEditor.commit();
    }

    public ArrayList<Product> getCartItems(){
        Set<String> cartItems = mSharedPreferences.getStringSet(CART_ITEMS, new HashSet<String>());

        ArrayList<Product> productsList = new ArrayList<>();
        HashMap<String, Product> productMap = Products.getProducts();
        for(String serialNumber : cartItems){
            productsList.add(productMap.get(serialNumber));
            Log.d(TAG, "getCartItem: serial number: " + serialNumber);
            Log.d(TAG, "getCartItem: item title: " + productMap.get(serialNumber).getTitle());
        }

        return productsList;
    }

    public void removeItemFromCart(Product product){
        Set<String> cartItems = mSharedPreferences.getStringSet(CART_ITEMS, new HashSet<String>());

        cartItems.remove(product);
        mEditor.putStringSet(CART_ITEMS,cartItems);
        mEditor.commit();
    }
}


















