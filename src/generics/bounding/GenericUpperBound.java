package generics.bounding;

public class GenericUpperBound<T extends Number> {//bounding from upper --subclass of Number

    private T[] numberArray;
    //const


    public GenericUpperBound(T[] numberArray) {
        this.numberArray = numberArray;
    }
    //method to to find average of arrar
    public double getAveraga(){
        double sum =0;
        for(T t:numberArray){
            sum += t.doubleValue();// converts elements to double  type
        }
        double avg = sum/numberArray.length;
        return avg;
    }

    public static void main(String[] args) {
        Integer[] intArr = {2, 4, 7, 8};
        GenericUpperBound<Integer> obj1 = new GenericUpperBound<>(intArr);
        System.out.println(obj1.getAveraga());

        Double [] doubleArr = {4.5, 8.3, 9.5};
        GenericUpperBound<Double> obj2 = new GenericUpperBound<>(doubleArr);
        System.out.println(obj2.getAveraga());
        //can we now use this with String?
        // will not work because String is not from the Number bound
        //so we cannot get Runtime error, and typecasting exception
//        String[] strArr = {"Java", "Generics","Are", "Fantastic"};
//        GenericUpperBound<String> obj2 = new GenericUpperBound<>(String);
//        System.out.println(obj1.getAveraga());
    }
}
