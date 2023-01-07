package generics.bounding;

import java.util.ArrayList;
import java.util.List;

public class GenericLowerBoundWildCard {
    public static void main(String[] args) {
        List <Object> obj = new ArrayList<>();
        addElelements(obj);
        List <Number> nl = new ArrayList<>();
        addElelements(nl);

        List<Double> dl = new ArrayList<>();
       // addElelements(dl); //if we do not use generics, we would get run time error
        //**********PrintElements++++++++++
        //we can do this
//        List<String> st = new ArrayList<>();
//        printElement(st);
        //or
        printElement(new ArrayList<String>());
        //**********PrintObjects++++++++++
        List<String>strings = new ArrayList<>();
        //printObject(strings);//CTE
        List<Object> objectList = new ArrayList<>();
        printObject(objectList);
    }
    //super Integer-->Brings parent classes of Integer
    public static void addElelements(List<? super Integer> list){
        //?--> WildCard(unknown data type)
        for(int i =1; i<=10; i++){
            list.add(i);
        }
    }
    //wildcard limitations
    public static void printElement(List<?> listOfUnknown){
        //listOfUnknown.add("Java"); because of ? if the data type is unknown, add method will not work
        // first we need to declare data type
        //we can add null
        listOfUnknown.add(null);

        for (Object o: listOfUnknown){
            System.out.println(o);
        }
    }
    public static void printObject(List<Object> listOfObjects){
        listOfObjects.add("Java");
        for(Object o: listOfObjects){
            System.out.println(o);
        }
    }
}
