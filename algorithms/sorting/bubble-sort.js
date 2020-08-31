function bubbleSort(a) {
    function swap(i, j) {
        let tmp =  a[i];
        a[i] = a[j];
        a[j] = tmp;
    }

    let isSorted = false;
    while(!isSorted) {
        isSorted = true;
        for(let i = 0; i < a.length - 1; i++) {
            if( a[i] > a[i+1]) {
                swap(i, i+1);
                isSorted = false;
            }
        }
    }
    return a;
}

let a = [5,4,3,1,2,5,6,7,8,1,10];
bubbleSort(a);
console.log(a);