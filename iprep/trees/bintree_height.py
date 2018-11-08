def height(root):
    return recurse(root)

def recurse(node):
    if (node != None):
        height_L = recurse(node.left)
        height_R = recurse(node.right)

        return max(height_L, height_R)+1

    else:
        return -1
