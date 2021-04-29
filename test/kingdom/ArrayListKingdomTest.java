package kingdom;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ArrayListKingdomTest
{
  private ListADT<String> listKingdom;

  @BeforeEach
  void setup()
  {
    listKingdom = new ArrayListKingdom<>();
  }

  @Test
  public void testIsEmptyReturnsTrueWhenEmpty()
  {
    //No elements are added in the list currently
    assertTrue(listKingdom.isEmpty());
  }

  @Test
  public void testIsEmptyReturnsFalseWhenListIsNotEmpty()
  {
    listKingdom.add("TEST");
    assertFalse(listKingdom.isEmpty());
  }

  @Test
  public void testAddElementAtNegativeIndex()
  {
    assertThrows(IndexOutOfBoundsException.class, ()->listKingdom.add(-1,"Test"));
  }

  @Test
  public void testAddElementAtIndex0()
  {
    //List size =0 and legal values are 0 to list size
    assertDoesNotThrow(()-> listKingdom.add(0, "TEST"));
  }

  @Test
  public void testAddElementAtIndex1()
  {

    assertThrows(IndexOutOfBoundsException.class,()-> listKingdom.add(1, "TEST"));
  }

  @Test
  public void testAddElement()
  {
    listKingdom.add("TEST1");
    assertEquals(1, listKingdom.size());
  }

  @Test
  public void testAddElementsAddsToRear()
  {
    listKingdom.add("TEST1");
    listKingdom.add("TEST2");

    assertEquals(1, listKingdom.indexOf("TEST2"));
  }

  @Test
  public void testSetElementSet()
  {
    //Adds an element such that list size = 1
    //legal values = 0 to list size -1
    listKingdom.add("TEST1");
    listKingdom.set(0,"TEST2");
    assertEquals("TEST2",listKingdom.get(0));
  }

  @Test
  public void testSetElementInAnEmptyListThrowsIndexOutOfBound()
  {
    assertThrows(IndexOutOfBoundsException.class,() -> listKingdom.set(0, "Test1"));
  }

  @Test
  public void testSetElementAtIndex1ThrowsIndexOutOfBound()
  {
    //Adds one element such that list size = 1
    //Legal values for index are 0 to 0
    listKingdom.add("Test1");
  assertThrows(IndexOutOfBoundsException.class, ()-> listKingdom.set(1,"Test2"));
  }

  @Test
  public void testSetElementAtIndexMinus1ThrowsIndexOutOfBound()
  {
    //Adds one element such that list size = 1
    //Legal values for index are 0 to 0
    listKingdom.add("Test1");
    assertThrows(IndexOutOfBoundsException.class, ()-> listKingdom.set(-1,"Test2"));
  }

  @Test
  public void testGetElement()
  {
    listKingdom.add("Test1");
  listKingdom.add("Test2");
    assertEquals("Test2", listKingdom.get(1));
  }

  @Test
  public void testGetElementAtIndex2ThrowsOutOfBoundException()
  {
    //Legal index are 0 and 1
    listKingdom.add("Test1");
    listKingdom.add("Test2");
    assertThrows(IndexOutOfBoundsException.class, ()-> listKingdom.get(2));
    //Fails because it throws an undocumented exception

  }

  @Test
  public void testGetElementAtIndexMinus1ThrowsOutOfBoundException()
  {
    //Test right under boundary value
    listKingdom.add("Test1");
    listKingdom.add("Test2");
    assertThrows(IndexOutOfBoundsException.class, ()-> listKingdom.get(-1));
    //Fails because it throws an undocumented exception
  }

  @Test
  public void testRemoveElementRemove()
  {
    //Adds an element such that list size = 1
    //legal values = 0 to list size -1
    listKingdom.add("TEST1");
    assertEquals("TEST1", listKingdom.remove(0));
    assertEquals(0, listKingdom.size());
  }

  @Test
  public void testRemoveElementInAnEmptyListThrowsIndexOutOfBound()
  {
    assertThrows(IndexOutOfBoundsException.class,() -> listKingdom.remove(0));
  }

  @Test
  public void testRemoveElementAtIndex1ThrowsIndexOutOfBound()
  {
    //Adds one element such that list size = 1
    //Legal values for index are 0 to 0
    listKingdom.add("Test1");
    assertThrows(IndexOutOfBoundsException.class, ()-> listKingdom.remove(1));
  }

  @Test
  public void testRemoveElementAtIndexMinus1ThrowsIndexOutOfBound()
  {
    //Adds one element such that list size = 1
    //Legal values for index are 0 to 0, boundary values = 0
    listKingdom.add("Test1");
    assertThrows(IndexOutOfBoundsException.class, ()-> listKingdom.remove(-1));
  }


  @Test
  public void removeElement()
  {
    listKingdom.add("TEST1");
    assertEquals("TEST1", listKingdom.remove("TEST1"));
  }

  @Test
  public void testRemoveAnElementIsNotInTheList()
  {
    listKingdom.add("Test1");
    listKingdom.add("Test2");
    assertThrows(IllegalStateException.class, ()-> listKingdom.remove("Test3"));
  }

  @Test
  public void testIndexOf()
  {
    //We could also test indexOf of element of an element that does not exist in list
    //But it is not specified in the documentation what behaviour should occur.
    listKingdom.add("Test1");
    assertEquals(0, listKingdom.indexOf("Test1"));
  }

  @Test
  public void testContainsTrue()
  {
   listKingdom.add("Test1");
   assertTrue(listKingdom.contains("Test1"));
  }

  @Test
  public void testContainsFalse()
  {
   listKingdom.add("Test1");
   assertFalse(listKingdom.contains("Test2"));
  }

  @Test
  public void testIsFull()
  {
    //List is unbounded and will always return true
    for (int i = 0; i < 10000; i++)
    {
      listKingdom.add( "Test" + i);
    }
    // the ListADT in the kingdom project has the isFull set to be true
    //thus the tested class does not follow the documentation.
    assertFalse(listKingdom.isFull());
  }

  @Test
  public void testListSize()
  {
    listKingdom.add("Test1");
    listKingdom.add("Test2");
    listKingdom.add("Test3");

    assertEquals(3, listKingdom.size());
  }

  @Test
  public void testToString()
  {
    listKingdom.add("Test1");
    listKingdom.add("Test2");
    listKingdom.add("Test3");

    assertEquals("{Test1, Test2, Test3}", listKingdom.toString());
  }
}