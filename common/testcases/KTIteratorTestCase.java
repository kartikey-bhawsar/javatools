import com.kartik.bhavsar.util.*;
class KTIteratorTestCase
{
public static void main(String [] gg)
{
KTArrayList a=new KTArrayList();
for(int i=1;i<=10;i++) a.add(i);
KTLinkedList l=new KTLinkedList();
for(int i=100;i<=109;i++) l.add(i);
System.out.println("Iterating on array list: ");
KTIterator it=a.Iterator();
while(it.hasNext())
{
System.out.println(it.next());
}
System.out.println("Iterating on linked list: ");
KTIterator it2=l.Iterator();
while(it2.hasNext())
{
System.out.println(it2.next());
}
}
}