/*
Detect a cycle in a linked list. Note that the head pointer may be 'null' if the list is empty.

A Node is defined as:
    class Node {
        int data;
        Node next;
    }
*/


boolean hasCycle(Node head) {

    if (head == null) {
        return false;
    }

    HashMap visitedMap = new HashMap<Node, Boolean>();

    Node node = head;
    while (node != null) {
        if ( visitedMap.containsKey(node) ) {
            return true;
        } else {
            visitedMap.put(node, true);
        }

        node = node.next;
    }

    return false;
}
