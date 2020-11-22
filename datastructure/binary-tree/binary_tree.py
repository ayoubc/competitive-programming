class BinaryTree:
    def __init__(self, value, left=None, right=None):
        self.key = value
        self.left = left
        self.right = right

    def insert_left(self, val):
        if self.left is None:
            self.left = BinaryTree(val)
        else:
            tmp = BinaryTree(val, self.left)
            self.left = tmp

    def insert_right(self, val):
        if self.right is None:
            self.right = BinaryTree(val)
        else:
            tmp = BinaryTree(val, None, self.right)
            self.right = tmp

    def get_right_child(self):
        return self.right

    def get_left_child(self):
        return self.left

    def set_root_val(self, obj):
        self.key = obj

    def get_root_val(self):
        return self.key

    def __str__(self):
        return self.key


def preorder(tree):
    if tree is not None:
        print(tree.get_root_val())
        preorder(tree.get_left_child())
        preorder(tree.get_right_child())


def postorder(tree):
    if tree is not None:
        postorder(tree.get_left_child())
        postorder(tree.get_right_child())
        print(tree.get_root_val())


def inorder(tree):
    if tree is not None:
        inorder(tree.get_left_child())
        print(tree.get_root_val())
        inorder(tree.get_right_child())
