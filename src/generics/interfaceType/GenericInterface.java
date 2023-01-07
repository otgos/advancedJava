package generics.interfaceType;
//generics will allow us to create type-safe objects
public interface GenericInterface <T>{
    void setValue(T t);
    T getValue();
}
