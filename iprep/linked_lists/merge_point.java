// Complete the findMergeNode function below.

/*
 * For your reference:
 *
 * SinglyLinkedListNode {
 *     int data;
 *     SinglyLinkedListNode next;
 * }
 *
 */
static int findMergeNode(SinglyLinkedListNode head1, SinglyLinkedListNode head2) {

    HashMap visitedMap = new HashMap<SinglyLinkedListNode, Boolean>();

    SinglyLinkedListNode node = head1;
    while (node != null) {
        visitedMap.put(node, true);
        node = node.next;
    }

    node = head2;
    while (node != null) {
        if ( visitedMap.containsKey(node) ) {
            return node.data;
        }
        node = node.next;
    }

    return -1;
}
