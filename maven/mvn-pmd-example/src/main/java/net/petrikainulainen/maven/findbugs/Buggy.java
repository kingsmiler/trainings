package net.petrikainulainen.maven.findbugs;

/**
 * @author Petri Kainulainen
 */
public class Buggy {

    public static void main(String[] arguments) {
        String foo = null;
        String boo = null;
        System.out.println(foo.length());
    }
}
