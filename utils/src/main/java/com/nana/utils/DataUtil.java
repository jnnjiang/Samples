package com.nana.utils;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class DataUtil {
    public static List mapToList(Map map){
        List listKey = new ArrayList();
        List listValue = new ArrayList();
        Iterator it = map.keySet().iterator();
        while (it.hasNext()) {
            String key = it.next().toString();
            listKey.add(key);
            listValue.add(map.get(key));
        }
        System.out.println("Convert Finished !");

        for(int i =0 ;i<listKey.size();i++){
            System.out.print("Key :"+listKey.get(i));
            System.out.println("     Value :"+listValue.get(i));
        }
        return listValue;
    }
}
