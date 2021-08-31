//https://blog.csdn.net/qq_46105170/article/details/113578377
/**
 * 求一个子区间的乘积可以用前缀积来做。这里有个特例需要考虑，即如果添加了0 00进来，
 * 事实上此时前缀积列表可以直接清空，并重新开始计算前缀积。在询问的时候，
 * 如果发现询问的子区间长度大于了列表长度，说明query区间里有0 00，则直接返回0 00，否则返回区间乘积。
————————————————
版权声明：本文为CSDN博主「记录算法」的原创文章，遵循CC 4.0 BY-SA版权协议，转载请附上原文出处链接及本声明。
原文链接：https://blog.csdn.net/qq_46105170/article/details/113578377
 */
class ProductOfNumbers {
    List<Integer> prefixProduct;

    public ProductOfNumbers() {
        prefixProduct = new ArrayList<>();
    }
    
    public void add(int num) {
        if (num == 0) {
            prefixProduct.clear();
        } else if (prefixProduct.size() == 0){
            prefixProduct.add(num);
        } else {
            prefixProduct.add(num *  prefixProduct.get(prefixProduct.size() - 1));
        }
    }
    
    public int getProduct(int k) {
        int size = prefixProduct.size();
        if (k < size) {
            return prefixProduct.get(size - 1) / prefixProduct.get(size - 1 - k);
        } else if (k == size) {
            return prefixProduct.get(size - 1);
        }
        return 0;
    }
}

/**
 * Your ProductOfNumbers object will be instantiated and called as such:
 * ProductOfNumbers obj = new ProductOfNumbers();
 * obj.add(num);
 * int param_2 = obj.getProduct(k);
 */