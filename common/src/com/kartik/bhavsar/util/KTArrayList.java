package com.kartik.bhavsar.util;
public class KTArrayList<T> implements KTList<T>
{
private Object collection[];
private int size;

public class KTArrayListIterator<T> implements KTIterator<T>
{
private int index;

public KTArrayListIterator()
{
this.index=0;
}
 
public boolean hasNext()
{
return KTArrayList.this.size!=this.index;
}

public T next()
{
if(index==size) throw new InvalidIteratorException("Iterator has no more elements");
T data=(T)get(this.index);
this.index++;
return data;
}
}// class KTArrayListIterator ends here

public KTArrayList()
{
this.collection=new Object[10];
this.size=0;
}

public int size()
{
return this.size;	
}

public void add(T data)
{
if(this.size==collection.length)
{
Object temp[]=new Object[this.size+10];
for(int i=0;i<this.size;i++) temp[i]=this.collection[i];
this.collection=temp;
}
this.collection[this.size]=data;
this.size++;
}

public void add(int index, T data)
{
if(index<0 || index>this.size) throw new IndexOutOfBoundsException("Invalid index "+index);
if(this.size==collection.length)
{
Object temp[]=new Object[this.size+10];
for(int i=0;i<this.size;i++) temp[i]=this.collection[i];
this.collection=temp;
}
for(int i=this.size;i>index;i--) 
{
this.collection[i]=this.collection[i-1];
}
this.collection[index]=data;
this.size++;
}

public void insert(int index, T data)
{
add(index,data);
}

public void clear()
{
this.size=0;
}

public void removeAll()
{
this.size=0;
}

public T get(int index)
{
if(index<0 || index>=this.size) throw new IndexOutOfBoundsException("Invalid index "+index);
return (T)this.collection[index];
}

public T removeAt(int index)
{
if(index<0 || index>=this.size) throw new IndexOutOfBoundsException("Invalid index "+index);
T data=(T)this.collection[index];
for(int i=index;i<this.size-1;i++)
{
collection[i]=collection[i+1];
}
this.size--;
return data;
}

public void update(int index, T data)
{
if(index<0 || index>=this.size) throw new IndexOutOfBoundsException("Invalid index "+index);
this.collection[index]=data;
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

public KTIterator<T> Iterator()
{
return new KTArrayListIterator();
}

public void forEach(KTListItemAcceptor<T> a)
{
if(a==null) return;
for(int i=0;i<this.size;i++)
{
a.accept((T)collection[i]);
}
}

}// class KTArrayList ends here