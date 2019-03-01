/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package designtelasfx;

import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import org.json.JSONArray;
import org.json.JSONObject;

/**
 *
 * @author victor-sued
 */
public class DesignTelasFX {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        restAPI rest = new restAPI();
        List<String> list = new ArrayList<String>();
        //JOptionPane.showMessageDialog(null, rest.get("/cards"));
        JSONObject jsonObj = new JSONObject(rest.get("/cards"));
        JSONArray array = jsonObj.getJSONArray("cards");
        for(int i = 0 ; i < array.length() ; i++){
          list.add(array.getJSONObject(i).getString("imageUrl"));
    }
        System.out.println(list.get(99));
        
    }
    
}
