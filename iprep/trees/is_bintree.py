""" Node is defined as
class node:
    def __init__(self, data):
        self.data = data
        self.left = None
        self.right = None
"""

def checkBST(root):
    visited = {}
    return explore(root, visited)[2]



def explore(node, visited):

    if (node != None):

        if node.data in visited:
            return 0, 0, False
        else:
            visited[node.data] = True

        l_min, l_max, l_status = explore(node.left, visited)
        r_min, r_max, r_status = explore(node.right, visited)

        cur_min = node.data
        cur_max = node.data

        if l_status == False or r_status == False:
            return 0, 0, False


        if l_min == None: l_min = cur_min
        if r_min == None: r_min = cur_min

        if l_max == None: l_max = cur_max
        if r_max == None: r_max = cur_max


        if max(l_min, l_max) > node.data:
            return 0, 0, False

        if min(r_min, r_max) < node.data:
            return 0, 0, False


        return min(l_min, l_max, r_min, r_max, cur_min), max(l_min, l_max, r_min, r_max, cur_max), True

    else:
        return None, None, True
