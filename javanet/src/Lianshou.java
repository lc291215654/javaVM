import java.nio.ByteBuffer;
import java.util.BitSet;
import java.util.HashMap;

/**
 * Created by licheng on 2/1/18.
 */

class Dog {

    Dog(int num, String name) {
        this.num = num;
        this.name = name;
    }

    public int num;
    public String name;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Dog dog = (Dog) o;

        if (num != dog.num) return false;
        return name != null ? name.equals(dog.name) : dog.name == null;
    }

    @Override
    public int hashCode() {
        int result = num;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        return result;
    }
}


public class Lianshou {

    public static void main(String args[]) throws InterruptedException {
        byte bt = -107;
        BitSet bitSet = new BitSet();

        ByteBuffer buffer = ByteBuffer.allocate(10);
//        buffer.putChar('4');
        buffer.put(new Byte("4"));
        buffer.put(new Byte("7"));
        System.out.println(buffer);
        System.out.println(buffer.capacity());
        System.out.println(buffer.limit());
        System.out.println(buffer.position());





    }
}


//        Set<Dog> keyset = hashMap.keySet();
//        for (Dog dog : keyset) {
//            System.out.println("hashcode::"+dog.hashCode()+" "+dog.name + " " + dog.num + "  " +hashMap.get(dog));
//        }