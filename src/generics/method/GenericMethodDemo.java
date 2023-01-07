package generics.method;
//Why we need generic Methods?m
public class GenericMethodDemo {
    public static void main(String[] args) {
        GenericMethodDemo obj1 = new GenericMethodDemo();//2. create class
        Integer [] intArr = {1, 2, 56, 76};//3. create Integer arr
        obj1.print(intArr); //this will work without issue

        Double [] doubleArr = {22.3, 5.34}; //4. create double arr and ask will method work now?
        obj1.print(doubleArr);


    }
//    public void print (Integer[] arr){ //1. create method
//        // does sth
//    }
//    public void print (Double[] arr){ //5. create method ? is ok yes but then if i want string arr need to overload one more
//
//    }


    //6. so we need generic method
    public <T> void print(T[] array){
        for(T t: array){
            System.out.println(t);
        }
    }
}
