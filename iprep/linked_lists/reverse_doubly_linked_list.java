// Complete the reverse function below.

/*
 * For your reference:
 *
 * DoublyLinkedListNode {
 *     int data;
 *     DoublyLinkedListNode next;
 *     DoublyLinkedListNode prev;
 * }
 *
 */
static DoublyLinkedListNode reverse(DoublyLinkedListNode head) {

    if (head == null) {
        return head;
    }

    DoublyLinkedListNode node = head;
    while (node != null) {
        DoublyLinkedListNode oldPrev = node.prev;

        node.prev = node.next;
        node.next = oldPrev;


        if (node.prev == null) {
            break;
        } else {
            node = node.prev;
        }
    }

    return node;


}
