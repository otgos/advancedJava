package generics.interfaceType;
//if we implelement generic interface Class shoul be also generic
//data type is not clrear
public class GenericClassImpl01<T> implements GenericInterface<T>{
    @Override
    public void setValue(T t) {
    }

    @Override
    public T getValue() {
        return null;
    }
}
