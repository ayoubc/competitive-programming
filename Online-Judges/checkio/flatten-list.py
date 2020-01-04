"""
 Given a list containing integers or other nested lists
 need to return it as one flatten list containing all the integers
"""
def flat_list(array: list) -> int:
    arr = []
    for item in array:
        if type(item) == int:
            arr.append(item)
        else:
            arr.extend(flat_list(item))
    return arr

if __name__ == '__main__':

    assert flat_list([1, 2, 3]) == [1, 2, 3], "First"
    assert flat_list([1, [2, 2, 2], 4]) == [1, 2, 2, 2, 4], "Second"
    assert flat_list([[[2]], [4, [5, 6, [6], 6, 6, 6], 7]]) == [2, 4, 5, 6, 6, 6, 6, 6, 7], "Third"
    assert flat_list([-1, [1, [-2], 1], -1]) == [-1, 1, -2, 1, -1], "Four"
    print('Done! Check it')
