/**
 * // This is the interface that allows for creating nested lists.
 * // You should not implement it, or speculate about its implementation
 * public interface NestedInteger {
 *
 *     // @return true if this NestedInteger holds a single integer, rather than a nested list.
 *     public boolean isInteger();
 *
 *     // @return the single integer that this NestedInteger holds, if it holds a single integer
 *     // Return null if this NestedInteger holds a nested list
 *     public Integer getInteger();
 *
 *     // @return the nested list that this NestedInteger holds, if it holds a nested list
 *     // Return empty list if this NestedInteger holds a single integer
 *     public List<NestedInteger> getList();
 * }
 */
public class NestedIterator implements Iterator<Integer> {
    private List<Integer> flattened = new ArrayList();
    private int curIndex;
    public NestedIterator(List<NestedInteger> nestedList) {
        this.flattened = flatten(nestedList);
        this.curIndex = 0;
    }

    private List<Integer> flatten(List<NestedInteger> nestedList) {
        List<Integer> res = new ArrayList<>();
        for(NestedInteger ni : nestedList) {
            if (ni.isInteger()) res.add(ni.getInteger());
            else res.addAll(flatten(ni.getList()));
        }
        return res;
    }

    @Override
    public Integer next() {
        Integer res = flattened.get(curIndex);
        curIndex += 1;
        return res;
    }

    @Override
    public boolean hasNext() {
        return curIndex < flattened.size();
    }
}

/**
 * Your NestedIterator object will be instantiated and called as such:
 * NestedIterator i = new NestedIterator(nestedList);
 * while (i.hasNext()) v[f()] = i.next();
 */