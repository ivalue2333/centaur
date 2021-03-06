package algorithm.sort;

/**
 * Created by 13722 on 2017/9/7.
 */
/**
 * 桶式排序:
 * 桶式排序不再是基于比较的了，它和基数排序同属于分配类的排序，
 * 这类排序的特点是事先要知道待排 序列的一些特征。
 * 桶式排序事先要知道待排 序列在一个范围内，而且这个范围应该不是很大的。
 * 比如知道待排序列在[0,M）内，那么可以分配M个桶，第I个桶记录I的出现情况，
 * 最后根据每个桶收到的位置信息把数据输出成有序的形式。
 * 这里我们用两个临时性数组，一个用于记录位置信息，一个用于方便输出数据成有序方式，
 * 另外我们假设数据落在0到MAX,如果所给数据不是从0开始，你可以把每个数减去最小的数。
 */
public class BucketSort {
    public void sort(int[] keys,int from,int len,int max)
    {
        int[] temp=new int[len];
        int[] count=new int[max];


        for(int i=0;i<len;i++)
        {
            count[keys[from+i]]++;
        }
        //calculate position info
        for(int i=1;i<max;i++)
        {
            count[i]=count[i]+count[i-1];//这意味着有多少数目小于或等于i，因此它也是position+ 1
        }

        System.arraycopy(keys, from, temp, 0, len);
        for(int k=len-1;k>=0;k--)//从最末到开头保持稳定性
        {
            keys[--count[temp[k]]]=temp[k];// position +1 =count
        }
    }
    /**
     * @param args
     */
    public static void main(String[] args) {

        int[] a={1,4,8,3,2,9,5,0,7,6,9,10,9,13,14,15,11,12,17,16};
        BucketSort bucketSort=new BucketSort();
        bucketSort.sort(a,0,a.length,20);//actually is 18, but 20 will also work


        for(int i=0;i<a.length;i++)
        {
            System.out.print(a[i]+",");
        }

    }


}
