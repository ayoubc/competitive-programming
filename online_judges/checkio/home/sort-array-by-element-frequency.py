"""
 Given a list of items (integers of strings) sort it in decreasing order
 of frequency of items, in case of tie use the order of appearence
"""
def frequency_sort(items):
    d = dict()
    for i in range(len(items)):
        if items[i] in d:
            d[items[i]][0] -= 1
        else:
            d[items[i]] = [-1, i]

    
    items.sort(key = lambda item: d[item])
    return items


if __name__ == '__main__':
    print("Example:")
    print(frequency_sort([4, 6, 2, 2, 6, 4, 4, 4]))

    # These "asserts" are used for self-checking and not for an auto-testing
    assert list(frequency_sort([4, 6, 2, 2, 6, 4, 4, 4])) == [4, 4, 4, 4, 6, 6, 2, 2]
    assert list(frequency_sort(['bob', 'bob', 'carl', 'alex', 'bob'])) == ['bob', 'bob', 'bob', 'carl', 'alex']
    assert list(frequency_sort([17, 99, 42])) == [17, 99, 42]
    assert list(frequency_sort([])) == []
    assert list(frequency_sort([1])) == [1]
    print("Coding complete? Click 'Check' to earn cool rewards!")
