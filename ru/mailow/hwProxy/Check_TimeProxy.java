package ru.mailow.hwProxy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Check_TimeProxy {
    public static void main(String[] args) {
        Map<String, Integer> m = CheckTimeProxy.Checktime(new HashMap<String, Integer>());
        m.put("1",2);


        List<String> ar = CheckTimeProxy.Checktime(new ArrayList<String>());
        //ArrayList<String> ar = new ArrayList();

        ar.add("test");


    }
}
