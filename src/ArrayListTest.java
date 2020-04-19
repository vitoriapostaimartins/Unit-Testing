import org.junit.Test;

import static org.junit.Assert.*;

public class ArrayListTest {
    private ArrayList a = new ArrayList();
    private Object b = new Object();

    //very large size test
    @Test(expected = OutOfMemoryError.class)
    public void bigArrayList(){
        a = new ArrayList(Integer.MAX_VALUE);

    }

    //-ve size test
    @Test (expected = NegativeArraySizeException.class)
    public void negativeArrayList(){
        a = new ArrayList(-1);
    }

    // default size is correct
    @Test
    public void defaultSize() {
        assertEquals(a.size(), 10);
    }

    //after add size check
    @Test
    public void addCheckSize(){
        a.add(new Object());
        assertEquals(a.size(), 10);
    }



    //after adding more than current size check
    @Test
    public void moreThanCurrentSize(){
        for(int i = 0; i < 11; i++){
            a.add(new Object());
        }
        assertEquals(a.size(), 20);
    }

    //adding a single object
    @Test
    public void singleAdd() {
        assertTrue(a.add(new Object()));
    }

    //adding more than current size
    @Test
    public void moreThanCurrentAdd(){
        a=new ArrayList(0);
        assertTrue(a.add(new Object()));
    }

    //-ve location
    @Test (expected = ArrayIndexOutOfBoundsException.class)
    public void negativeGetAt() {
        a.getAt(-1);
    }

    //beyond size location
    //this test fails because the code returns null, when it should return an exception. it would have to be fixed.
    @Test (expected = ArrayIndexOutOfBoundsException.class)
    public void beyondSizeLocation(){
        b = a.getAt(1000);
    }

    //valid location
    @Test
    public void validGetAt() {
        a.add(b);
        assertEquals(a.getAt(0), b);
    }


    //end of list
    @Test
    public void endGetAt(){
        a = new ArrayList(2);
        a.add(null);
        a.add(b);
        assertEquals(a.getAt(a.size() - 1), b);

    }

    //start of list
    @Test
    public void startGetAt(){
        a.add(b);
        assertEquals(a.getAt(0), b);
    }

    //-ve location
    @Test (expected = ArrayIndexOutOfBoundsException.class)
    public void negativeDeleteAt() {
        a.deleteAt(-1);
    }

    //beyond size location
    //this test fails because the code returns null, when it should return an exception. it would have to be fixed.
    @Test (expected = ArrayIndexOutOfBoundsException.class)
    public void beyondSizeDeleteAt(){
        a = new ArrayList(10);
        a.deleteAt(11);
    }

    //valid location - test to check if the object is still there or not (it shouldnt be)
    @Test
    public void objectChangedValidDeleteAt(){
        a.add(b);
        assertNotEquals(a.deleteAt(0), a.getAt(0));
    }
    //valid location - test to check if the list got smaller in size
    @Test
    public void sizeChangedValidDeleteAt(){
        a = new ArrayList(10);
        a.add(b);
        a.deleteAt(0);
        assertEquals(a.size(), 9);
    }

    //end of list
    @Test
    public void EndDeleteAt(){
        a = new ArrayList(2);
        a.add(b);
        a.add(b);
        a.deleteAt(a.size()-1);
        assertEquals(a.size(), 1);
    }

    //start of list
    @Test
    public void StartDeleteAt(){
        a = new ArrayList(10);
        a.add(b);
        a.deleteAt(0);
        assertEquals(a.size(), 9);
    }

    //null list
    @Test (expected = NullPointerException.class)
    public void NullDeleteAt(){
        a = null;
        a.deleteAt(0);
    }

    //empty list
    @Test (expected = Test.None.class)
    public void emptyPrint() {
        a = new ArrayList(0);
        a.print();
    }

    //full list
    @Test (expected = Test.None.class)
    public void fullPrint() {
        a = new ArrayList(10);
        for(int i = 0; i < a.size(); i++){
            a.add(new Object());
        }
        a.print();

    }


}