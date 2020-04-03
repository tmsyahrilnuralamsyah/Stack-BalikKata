import java.util.Scanner;

/**
 * Ini merupakan class yang memuat method main
 */
public class BalikKata {
    /**
     * Ini method main yang akan menjalankan 
     * @param args
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Masukkan kata     : ");
        String kata = sc.nextLine();
        sc.close();
        Stack<String> stack = new Stack<>();
        System.out.println("Panjang kata      : "+ kata.length());
        for (int i = 0; i < kata.length(); i++) {
            stack.push(new Data<String>(String.valueOf(kata.charAt(i))));
        }
        String balik = "";
        while (!stack.isEmpty()) {
            balik += stack.getHead().getData().toString();
            stack.pop();
        }
        System.out.print("Setelah dibalik   : " + balik);
        // stack.display();
    }
}

/**
 * Ini class Data dari Node nya 
 * @param <Tipe>
 */
class Data<Tipe> {
    private Tipe x;

    /**
     * Ini merupakan method constructor
     * @param x
     */
    public Data(Tipe x) {
        this.x = x;
    }

    /**
     * Ini method yang mengembalikan string dari objek
     */
    public String toString() {
        return this.x.toString();
    }
}

/**
 * Ini class Node dari linkedlist
 * @param <Tipe>
 */
class Node<Tipe> {
    private Data<Tipe> data;
    private Node<Tipe> next;

    /**
     * Ini merupakan method constructor
     * @param data
     * @param next
     */
    public Node(Data<Tipe> data, Node<Tipe> next) {
        this.setNext(next);
        this.setData(data);
    }

    /**
     * Ini method yang memberi nilai si next
     * @param next
     */
    public void setNext(Node<Tipe> next) {
        this.next = next;
    }

    /**
     * Ini method yang memberi nilai si data
     * @param data
     */
    public void setData(Data<Tipe> data) {
        this.data = data;
    }

    /**
     * Ini method yang mengembalikan nilai data 
     * @return
     */
    public Data<Tipe> getData() {
        return this.data;
    }

    /**
     * Ini method yang mengembalikan nilai next
     * @return
     */
    public Node<Tipe> getNext() {
        if (this.hasNext()) {
            return this.next;
        }
        return null;
    }

    /**
     * Ini method yang memeriksa next selanjutnya null atau tidak
     * @return
     */
    public boolean hasNext() {
        return this.next != null;
    }

    /**
     * Ini method yang memberi nilai awal next
     */
    public void setNull() {
        this.next = null;
    }
}

/**
 * Ini merupakan class Stack nya
 * @param <Tipe>
 */
class Stack<Tipe> {
    private Node<Tipe> head;
    private int size;

    /**
     * Ini merupakan method constructor
     */
    public Stack() {
        this.head = null;
        this.size = 0;
    }

    /**
     * Ini method untuk memberikan nilai kepada head
     * @param head
     */
    public void setHead(Node<Tipe> head) {
        this.head = head;
    }

    /**
     * Ini method untuk menaikkan size secara otomatis
     */
    public void incSize() {
        this.size++;
    }

    /**
     * Ini method untuk menurunkan size secara otomatis
     */
    public void decSize() {
        this.size--;
    }

    /**
     * Ini method untuk mengembalikan ukuran head
     * @return
     */
    public int Size() {
        return this.size;
    }

    /**
     * Ini method untuk mengembalikan nilai head
     * @return
     */
    public Node<Tipe> getHead() {
        return this.head;
    }

    /**
     * Ini method yang mengimput data
     * @param data
     */
    public void push(Data<Tipe> data) {
        this.setHead(new Node<Tipe>(data, this.getHead()));
        this.incSize();
    }

    /**
     * Ini method untuk menampilkan isi data
     */
    public void display() {
        Node<Tipe> current = this.getHead();
        while (current != null) {
            System.out.println(current.getData());
            if (current.getNext() == null) {
                break;
            }
            current = current.getNext();
        }
    }

    /**
     * Ini method yang memantau input ada isi atau tidak
     * @return
     */
    public boolean isEmpty() {
        if (this.Size() == 0) {
            return true;
        }
        return false;
    }

    /**
     * Ini method untuk memunculkan elemen dari stack
     * @return
     */
    public String pop() {
        Node<Tipe> current = this.getHead();
        if (this.Size() == 0) {
            return "";
        } else if (current.getNext() != null) {
            this.setHead(current.getNext());
        } else {
            current.setNull();
        }
        this.decSize();
        return this.getHead().getData().toString();
    }
}