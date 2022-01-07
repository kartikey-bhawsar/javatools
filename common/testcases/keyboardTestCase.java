import com.thinking.machines.util.*;
class KeyboardTestCase
{
public static void main(String gg[])
{
Keyboard k=new Keyboard();
String a;
a=k.getString();
String b;
b=k.getString("Enter something ");
char c;
c=k.getCharacter();
long d;
d=k.getLong("ENter long value");
int e;
e=k.getInt();
System.out.println(a);
System.out.println(b);
System.out.println(c);
System.out.println(d);
System.out.println(e);
}
}