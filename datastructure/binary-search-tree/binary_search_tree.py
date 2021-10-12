

class BinarySearchTree:
    def __init__(self, data, left=None, right=None):
        self.data = data
        self.left = left
        self.right = right


    def insert(self, val) -> None:
        if val < self.data:
            if self.left:
                self.left.insert(val)
            else:
                self.left = BinarySearchTree(val)

        else:
            if self.right:
                self.right.insert(val)
            else:
                self.right = BinarySearchTree(val)
                

    def contains(self, val) -> bool:
        if self.data == val:
            return True

        if val < self.data and self.left:
            return self.left.contains(val)

        if val > self.data and self.right:
            return self.right.contains(val)

        return False

    def min_value_node(self, root):
        current = root
        while current.left:
            current = current.left
        return current

    def delete(self, root, key):
        if root is None:
            return root

        if key < root.data:
            root.left = self.delete(root.left, key)

        elif key > root.data:
            root.right = self.delete(root.right, key)

        else:

            if root.left is None:
                return root.right

            elif root.right is None:
                return root.left

            temp = self.min_value_node(root.right)

            root.data = temp.data

            root.right = self.delete(root.right, temp.data)

        return root


def get_height(root):
    if root:
        l = get_height(root.left)
        r = get_height(root.right)
        return max(l, r) + 1
    
    return 0


def get_diameter(root):
    if root:
        l = get_diameter(root.left)
        r = get_diameter(root.right)

        lh = get_height(root.left)
        rh = get_height(root.right)
        return max(l, r, lh+rh+1)
        
    return 0


def inorder(root):
    if root:
        inorder(root.left)
        print(root.data, end=' ')
        inorder(root.right)


def preorder(root):
    if root:
        print(root.data, end=' ')
        preorder(root.left)
        preorder(root.right)

        
def postorder(root):
    if root:
        postorder(root.left)
        postorder(root.right)
        print(root.data, end=' ')

        
if __name__ == '__main__':
    root = BinarySearchTree(10)
    root.insert(11)
    root.insert(4)
    root.insert(8)
    root.insert(6)
    root.insert(13)
    root.delete(root, 4)
    inorder(root)
    print()

    
