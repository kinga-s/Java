import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Member;
import static java.lang.System.out;


public class Refl {
    private static void printMembers(Member[] m, String s) {
        out.format("%s:%n", s);
        for (Member mbr : m) {
            if (mbr instanceof Field)
                out.format("  %s%n", ((Field)mbr).toGenericString());
            else if (mbr instanceof Method)
                out.format("  %s%n", ((Method)mbr).toGenericString());
        }
        if (m.length == 0)
            out.format("  -- No %s --%n", s);
        out.format("%n");
    }


    public static void main(String[] args) {
        if(args.length < 1){
            System.out.println("Run the program with arg [Class_name]");
            System.exit(0);
        }

        try {
            Class<?> c = Class.forName(args[0]);
            System.out.println("Class: " + c.getSimpleName() + "\nModifiers: " + Modifier.toString(c.getModifiers())+"\n");

            printMembers(c.getDeclaredFields(), "Fields");
            printMembers(c.getDeclaredMethods(), "Methods");

        } catch (ClassNotFoundException x) {
            x.printStackTrace();
        }

    }
}
