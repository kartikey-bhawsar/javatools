package com.kartik.bhavsar.util;
public class KTLinkedList<T> implements KTList<T>
{
class KTNode<T>
{
public T data;
public KTNode<T> next;
KTNode() //this is not necessary as by default values are same as we have assigned below but for clarity I am writing  
{
this.data=null;
this.next=null;
}
}
private KTNode<T> start,end;
private int size;

public class KTLinkedListIterator<T> implements KTIterator<T>
{
private KTNode<T> ptr;

public KTLinkedListIterator(KTNode<T> ptr)
{
this.ptr=ptr;
}

public boolean hasNext()
{
return this.ptr!=null;
}

public T next()
{
if(ptr==null) throw new InvalidIteratorException("Iterator has no more elements");
T data=this.ptr.data;
this.ptr=this.ptr.next;
return data;
}
}// KTLinkedListIterator ends here

public KTIterator<T> Iterator()
{
return new KTLinkedListIterator(this.start);
}

public void add(T data)
{
KTNode<T> temp=new KTNode<T>();
temp.data=data;
if(this.start==null)
{
this.start=temp;
this.end=temp;
}
else
{
this.end.next=temp;
this.end=temp;
}
this.size++;
}

public void add(int index, T data)
{
if(index<0) throw new IndexOutOfBoundsException("Invalid index");
if(index>=size) 
{
add(data);
return;
}
KTNode<T> temp=new KTNode<T>();
temp.data=data;
if(index==0)
{
temp.next=this.start;
this.start=temp;
}
else
{
KTNode<T> j,k;
int i=0;
j=this.start;
k=null;
while(i<index)
{
k=j;
j=j.next;
i++;
}
k.next=temp;
temp.next=j;
}
this.size++;
}

public void insert(int index, T data)
{
add(index, data);
}

public void removeAll()
{
clear();
}

public void clear()
{
this.start=null;
this.end=null;
this.size=0;
}

public int size()
{
return this.size;
}

public T get(int index)
{
if(index<0 || index>=this.size) throw new IndexOutOfBoundsException("Invalid index");
KTNode<T> temp;
temp=start;
for(int i=0;i<index;i++)
{
temp=temp.next;
}
return temp.data;
}

public void update(int index, T data)
{
if(index<0 || index>this.size) throw new IndexOutOfBoundsException("Invalid index");
if(index==this.size-1)
{
this.end.data=data;
return;
}
KTNode<T> temp=start;
for(int i=0;i<index;i++)
{
temp=temp.next;
}
temp.data=data;
}

public T removeAt(int index)
{
if(index<0 || index>this.size) throw new IndexOutOfBoundsException("Invalid index");
T data;
if(start==end)
{
data=this.start.data;
this.start=null;
this.end=null;
this.size=0;
return data;
}
if(index==0)
{
data=this.start.data;
this.start=this.start.next;
this.size--;
return data;
}
KTNode<T> j,k;
j=null;
k=this.start;
for(int e=0;e<index;e++)
{
j=k;
k=k.next;
}
j.next=k.next;
data=k.data;
if(this.end==k) this.end=j;
this.size--;
return data;
}

public void copyTo(KTList<T> other)
{
other.clear();
for(int i=0;i<this.size();i++) other.add(this.get(i));
}

public void copyFrom(KTList<T> other)
{
this.clear();
for(int i=0;i<other.size();i++) this.add(other.get(i));
}

public void appendTo(KTList<T> other)
{
for(int i=0;i<this.size();i++) other.add(this.get(i));
}

public void appendFrom(KTList<T> other)
{
for(int i=0;i<other.size();i++) this.add(other.get(i));
}

public void forEach(KTListItemAcceptor<T> a)
{
if(a==null) return;
KTNode<T> t;
for(t=start;t!=null;t=t.next)
{
a.accept(t.data);
}
}

}