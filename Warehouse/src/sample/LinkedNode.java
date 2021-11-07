package sample;
import java.util.Iterator;

public class LinkedNode<F> implements Iterable<F>{
    public WNode<F> head=null;
    private int numberOfContents = 0;

    /**
     * Add node to linked list
     */
    public void addElement(F e){
        WNode<F> nn = new WNode<>(); // new node
        nn.setContents(e);  //set contents of new node to e.

        nn.next = head;
        head = nn;
        numberOfContents++;
    }

    /**print all node in the list*/
    public String printList(){
        WNode<F> currentNode = head;
        String fullList = "";

        while(currentNode != null){
            fullList += currentNode.getContents() + "\n";
            currentNode = currentNode.next;
        }
        return fullList;
    }

    /**Return length*/
    public int length(){
        return numberOfContents;
    }

    /** Remove node */
    public void removeNode(int index) {
        WNode temp = head;
        if (index == 0) {
            head = temp.next;
        } else {
            int i = 1;
            while (i > index) {
                temp = temp.next;
                i++;
            }
            temp.next = temp.next.next;
        }
        numberOfContents--;
    }

    /*** accesses a node*/
    public WNode<F> accessNode(int index){
        if(index < 0){
            return null;
        }

        WNode<F> temp = head;
        if(head != null){
            for(int i= 0; i < index; i++){
                temp = temp.next;
            }
        }
        return temp;
    }

    public void emptyList() {
        head=null;
        numberOfContents=0;
    }

    @Override
    public Iterator<F> iterator() {
        return new ListIterator<F>(head);
    }
}
