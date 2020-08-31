function quickSort(a) {
    function swap(i, j) {
        let tmp =  a[i];
        a[i] = a[j];
        a[j] = tmp;
    }

    function sortRecursive(left, right) {
        if (left >= right) return ;

        let pivot = a[Math.floor((left + right)/2)];
        let index = partition(left, right, pivot);

        sortRecursive(left, index-1);
        sortRecursive(index, right);
    }

    
    function partition(left, right, pivot) {
        while(left <= right) {
            while(a[left] < pivot) left ++;
            while(a[right] > pivot) right --;

            if(left <= right) {
                swap(left, right);
                left++;
                right--;
            }
        }

        return left;
    }

    sortRecursive(0, a.length-1);
}


let a = [5,4,3,1,2,5,6,7,8,1,10];
quickSort(a);
console.log(a);

// you can add this function to the prototype of Array;

