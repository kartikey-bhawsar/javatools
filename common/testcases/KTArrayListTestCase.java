import com.kartik.bhavsar.util.*;
class psp
{
public static void main(String [] gg)
{
KTArrayList k=new KTArrayList();
k.add(10);
k.add(20);
k.add(40);	
k.add(45);
k.add(2,50);
for(int i=0;i<k.size();i++)
{
System.out.println(k.get(i));
}
System.out.println("dfsd");
k.add(0,464);
k.add(2,232);
k.removeAt(4);
for(int i=0;i<k.size();i++)
{
System.out.println(k.get(i));
}
k.update(0,45);
System.out.println("ffff");
for(int i=0;i<k.size();i++)
{
System.out.println(k.get(i));
}
System.out.println("sdf");
}
}