package com.cn.nicole.entity;/*
 * author: Nicole
 * email : nicolechen412@163.com
 * date  : 2022/5/15 5:40 PM
 * desc  : 二叉堆：存储在数组的二叉树。将索引作为指针
            优先级队列的底层原理就是二叉堆
            插入和删除元素的时间复杂度是O(logN)
            作用：根据比较方式选出最大或者最小数据，二叉堆可以保证父节点一定大于孩子节点，但同层节点之间无需，内部不是严格有序。因此每获取一个堆顶元素，需要重新排序，选出第二个堆顶元素。
 */

public class PriorityQueue <Key extends Comparable<Key>>{

    //存储元素的数组
    private Key[] arrays;
    private boolean isMaxHeap;
    //容量
    private int capaity;
    //元素数量
    private int size;

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("PriorityQueue: " );
       for(int i = 1; i <= size; i++){
           sb.append(arrays[i].toString());
       }
        return sb.toString();
    }

    public PriorityQueue() {
        int capaity = 101;
        arrays = (Key[]) new Comparable[capaity];
        this.capaity = capaity;
    }

    public PriorityQueue(int capaity, boolean isMaxHeap) {
        //因为第一个索引不存数据，所以申请空间+1
        arrays = (Key[]) new Comparable[capaity + 1];
        this.capaity = capaity;
        this.isMaxHeap = isMaxHeap;
    }


    /**
     * 获取父节点的索引
     */
    int getParentIndex(int root){
        return root/2;
    }
    /**
     * 获取左孩子的索引
     */
    int getLeftIndex(int root){
        return root * 2;
    }
    /**
     * 获取右孩子的索引
     */
    int getRightIndex(int root){
        return root * 2 + 1;
    }

    /**
     * 获取堆顶数据
     * @return
     */
    public Key peek(){
        return arrays[1];
    }

    /**
     * 获取并删除堆顶数据
     * 方法：将堆顶元素A和堆底元素B交换，删除堆底元素，然后将B下沉到对应的位置
     * @return
     */
    public Key getAndRemove(){
        swap(1, size);
        Key tmp = arrays[size];
        arrays[size--] = null;
        sink(1);
        return tmp;
    }


    /**
     * 插入元素
     * @param key
     */
    public void insert(Key key){
        if(size < capaity){
            arrays[++size] = key;
            swim(size);
        }
    }

    public int getSize(){
        return size;
    }

    /**
     * 上浮第x个元素
     * @param x
     */
    private void swim(int x){
        if(size > 1){
            if(isMaxHeap){   //大顶堆的情况出现逆序重新交换元素
                while(getParentIndex(x) >= 1 ){
                    if(isEquals(getParentIndex(x), x) < 0){
                        swap(getParentIndex(x), x);
                        x = getParentIndex(x);
                    } else {
                        break;
                    }
                }

            } else {        //小顶堆的情况
                while(getParentIndex(x) >= 1){
                    if(isEquals(getParentIndex(x), x) > 0){
                        swap(getParentIndex(x), x);
                        x = getParentIndex(x);
                    } else {
                        break;
                    }
                }
            }
        }
    }

    /**
     * 下沉第x个元素
     * @param x
     */
    private void sink(int x){
        if(isMaxHeap){
            while(getLeftIndex(x) <= size){
                //选出两个孩子之中最大的
                int older = getLeftIndex(x);
                if(getRightIndex(x)  <= size && isEquals(older, getRightIndex(x)) < 0){
                    older = getRightIndex(x);
                }
                if(isEquals(x, older) <= 0){
                    //交换位置 并修改索引继续比较
                    swap(x, older);
                    x = older;
                } else {  //满足排序则跳出循环
                    break;
                }

            }
        } else {
            while(getLeftIndex(x) <= size){
                int younger = getLeftIndex(x);
                if(getRightIndex(x)  <= size && isEquals(younger, getRightIndex(x)) > 0){
                    younger = getRightIndex(x);
                }
                if(isEquals(x, younger) >= 0){
                    swap(x, younger);
                    x = younger;
                } else {  //跳出循环
                    break;
                }
            }
        }

    }

    /**
     * 交换x和y两个元素
     * @param x
     * @param y
     */
    private void swap(int x, int y){
        Key tmp;
        tmp = arrays[x];
        arrays[x] = arrays[y];
        arrays[y] = tmp;
    }

    /**
     * 比较两个元素大小
     * @param x
     * @param y
     * @return
     */
    private int isEquals(int x, int y){
        return arrays[x].compareTo(arrays[y]);
    }


    public static void main(String[] args) {

        PriorityQueue<ListNode> queue = new PriorityQueue<>(10, true);
        ListNode a = new ListNode(1);
        ListNode b = new ListNode(2);
        ListNode c = new ListNode(3);
        ListNode d = new ListNode(5);
        ListNode e = new ListNode(4);
        queue.insert(a);
        queue.insert(b);
        queue.insert(c);
        queue.insert(d);
        queue.insert(e);
        System.out.println(queue.toString());
        queue.getAndRemove();
        System.out.println(queue.toString());


    }

}
