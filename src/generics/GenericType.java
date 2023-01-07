package generics;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GenericType <T>{

    private T type; //field, varialbe
    public T getType() {
        return type;
    }

    public void setType(T type) {
        this.type = type;
    }

    public static void main(String[] args) {
        // using generics 2 different data oject created
        GenericType<String> obj = new GenericType<>();
        obj.setType("Hello Generics");

//        GenericType<String> obj2 = new GenericType<>();
//        obj2.setType(54); we have to set only string vlue

        //Note : how avoid data cast
        GenericType<Integer> obj3 = new GenericType<>();
        obj3.setType(54);
        int num = obj3.getType(); // we donot need to cast

        //No ClassCastException

        List<String> list = new ArrayList<>();
        list.add("Hello");

        Map<Integer, String> map = new HashMap<>();
        map.put(2, "Hello");
    }
}
