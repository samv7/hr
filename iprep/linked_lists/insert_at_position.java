// Complete the insertNodeAtPosition function below.

 /*
  * For your reference:
  *
  * SinglyLinkedListNode {
  *     int data;
  *     SinglyLinkedListNode next;
  * }
  *
  */
 static SinglyLinkedListNode insertNodeAtPosition(SinglyLinkedListNode head, int data, int position) {

     SinglyLinkedListNode added = new SinglyLinkedListNode(data);
     if (position == 0) {
         added.next = head;
         head = added;
     } else {

         int i = 1;
         SinglyLinkedListNode node = head;
         while (i < position) {
             node = node.next;
             i++;
         }
         SinglyLinkedListNode oldNextNode = node.next;
         node.next = added;
         added.next = oldNextNode;

     }
     return head;

 }
