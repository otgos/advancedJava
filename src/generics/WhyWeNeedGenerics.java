package generics;

import java.util.ArrayList;
import java.util.List;

public class WhyWeNeedGenerics {
    private Object obj;

    public Object getObj() {
        return obj;
    }

    public void setObj(Object obj) {
        this.obj = obj;
    }

    public static void main(String[] args) {
        //Create object list
        List<Object> objectList = new ArrayList<>();
        objectList.add("Hello Generics");
        objectList.add(123);
        String str  = (String) objectList.get(0);
        //String num = (String) objectList.get(1);
        String s = String.valueOf(objectList.get(1));
        //Integer.parseInt(objectList.get(1));


        WhyWeNeedGenerics obj = new WhyWeNeedGenerics();
        obj.setObj("Hello");
        obj.setObj(45);
        String num = (String) obj.getObj();
        System.out.println(num);

    }
}
