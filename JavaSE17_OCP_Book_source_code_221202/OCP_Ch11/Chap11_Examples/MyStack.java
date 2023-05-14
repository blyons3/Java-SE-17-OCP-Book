import java.util.Iterator;
import java.util.NoSuchElementException;

/** Simplified implementation of a generic stack */
public class MyStack<E> implements IStack<E> {                     // (1)
  // Top of stack.
  private Node<E> tos;                                             // (2)
  // Size of stack
  private int numOfElements;                                       // (3)

  @Override public boolean isEmpty() { return tos == null; }       // (4)
  @Override public int size()        { return numOfElements; }     // (5)

  @Override public void push(E element) {                          // (6)
    tos = new Node<>(element, tos);
    ++numOfElements;
  }

  @Override public E pop() {                                       // (7)
    if (!isEmpty()) {
      E data = tos.getData();
      tos = tos.getNext();
      --numOfElements;
      return data;
    }
    throw new NoSuchElementException("No elements.");
  }

  @Override public E peek()  {                                     // (8)
    if (!isEmpty()) return tos.getData();
    throw new NoSuchElementException("No elements.");
  }

  // Membership
  @Override public boolean isMember(E element) {                   // (9)
    for (E data : this)
      if (data.equals(element))
        return true;       // Found.
    return false;          // Not found.
  }

  // Get iterator.
  @Override public Iterator<E> iterator() {                        // (10)
    return new NodeIterator<>(this.tos);
  }

  // Copy to array as many elements as possible.
  @Override public E[] toArray(E[] toArray) {                      // (11)
    Node<E> thisNode = tos;
    for (int i = 0; thisNode != null && i < toArray.length; i++) {
      toArray[i] = thisNode.getData();
      thisNode = thisNode.getNext();
    }
    return toArray;
  }

  // Text representation of stack: (e1, e2, ..., en).
  @Override public String toString() {                             // (12)
    StringBuilder rep = new StringBuilder("(");
    for (E data : this) {
      rep.append(data + ", ");
    }
    if (!isEmpty()) {
      int len = rep.length();
      rep.delete(len - 2, len);                   // Delete the last ", ".
    }
    rep.append(")");
    return rep.toString();
  }
}