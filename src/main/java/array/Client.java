package array;

public class Client {

    public static void main(String[] args) {
        Array<Integer> myArr = new Array<>();

        myArr.add(1);
        myArr.add(2);
        myArr.add(3);
        myArr.add(4);
        myArr.add(5);

        for (int i =0; i< myArr.getSize(); i++){
            System.out.println("myArr " + i + " = " + myArr.get(i));
            System.out.println("myArr capacity = " + myArr.getArrayCapacity());
        }

        myArr.remove(3);

        for (int i =0; i< myArr.getSize(); i++){
            System.out.println("myArr " + i + " = " + myArr.get(i));
            System.out.println("myArr capacity = " + myArr.getArrayCapacity());
        }

        myArr.add(4, 3);
        for (int i =0; i< myArr.getSize(); i++){
            System.out.println("myArr " + i + " = " + myArr.get(i));
            System.out.println("myArr capacity = " + myArr.getArrayCapacity());
        }
    }
}
