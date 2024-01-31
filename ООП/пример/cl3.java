package пример;

/**
 * 3
 */
public class cl3 extends cl2 {

    public static void main(String[] args) {
        cl3 cl = new cl3();
        cl.foo();
    }

    public void foo() {
        System.out.println(super.super.cl);
    }
}