// Complete the sortedInsert function below.

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
static DoublyLinkedListNode sortedInsert(DoublyLinkedListNode head, int data) {
    DoublyLinkedListNode added = new DoublyLinkedListNode(data);
    if (data <= head.data) {
        added.next = head;
        head.prev = added;
        head = added;
    } else {

        DoublyLinkedListNode node = head;
        while (node.next != null) {
            if (node.next.data > data) {
                    break;
            }
            node = node.next;
        }

        DoublyLinkedListNode oldNextNode = node.next;
        node.next = added;
        added.prev = node;
        added.next = oldNextNode;

    }

    return head;


}
