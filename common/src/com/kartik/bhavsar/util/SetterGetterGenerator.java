
package com.kartik.bhavsar.util;

import java.lang.reflect.*;
import java.lang.Class;
import java.io.*;
import java.util.*;

public class SetterGetterGenerator {
    public static void main(String[] args) {
        if (args.length == 0) {
            System.out.println("Error: Not given class name");
            System.out.println(
                    "Usage: java -classpath path_to_jar_file;. com.kartik.bhavsar.util.SetterGetterGenerator <class_name>");
            return;
        }
        String className = args[0];
        try {
            Class c = Class.forName(className);
            Field field[] = c.getDeclaredFields();
            // System.out.println(field.length);
            // for(int i=0;i<field.length;i++) System.out.println(field[i]);
            String cls = c.getName();
            String constructor = "public " + cls + "()\n{\n";
            for (int i = 0; i < field.length; i++)
            {
                String tmp = field[i].getName();
                constructor += tmp + " = \"\";\n";
            }
            constructor += "}\n";
            ArrayList<String> al = new ArrayList<>();
            al.add(constructor);
            String setLine = "", getLine = "";
            for (int i = 0; i < field.length; i++) {
                String name = "";
                // System.out.println(field[i].getName());
                // System.out.println(field[i].getType());
                String tmp = field[i].getName();
                String type = field[i].getType().getName();
                name = tmp.substring(0, 1).toUpperCase() + tmp.substring(1);
                setLine = "public void set" + name + "(" + type + " " + tmp + ")\n{\nthis." + tmp + "=" + tmp
                        + ";\n}\n";
                getLine = "public " + type + " get" + name + "()\n{\nreturn this." + tmp + ";\n}\n";
                // System.out.println(setLine);
                // System.out.println(getLine);
                al.add(setLine);
                al.add(getLine);
            }
            File f = new File("setterGetter.txt");
            RandomAccessFile raf = new RandomAccessFile(f, "rw");
            raf.setLength(0);
            Iterator<String> it = al.iterator();
            while (it.hasNext()) {
                raf.writeBytes(it.next());
            }
            raf.close();
            System.out.println("Setter Getter methods are successfully generated for class: " + className
                    + " in file SetterGetter.txt");
        } catch (ClassNotFoundException cnfe) {
            System.out.println("Class Not Found: " + cnfe.getMessage());
        } catch (NoClassDefFoundError ncdfe) {
            System.out.println("Class Not Found: " + ncdfe.getMessage());
        } catch (IOException ioe) {
            System.out.println(ioe.getMessage());
        }

    }
}