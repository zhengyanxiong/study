package com.Bernie.Array;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author Bernie
 * @Date 2019/1/9 11:35
 **/
public class RemoveDuplicates {

    /**
     * 普通删除方法
     * @param array
     * @return
     */
    public int removeDuplicate(int[] array){
        if(array.length == 0)
            return 0;
        int[] tem_array = new int[array.length];
        int temp = 0;
        for(int i=0;i<array.length;i++){
            boolean isTrue = true;
            for(int j = i+1;j<array.length;j++){
                if(array[i] == array[j]){
                    isTrue =false;
                    break;
                }
            }

            if(isTrue){
                tem_array[temp] = array[i];
                temp++;
            }

        }

        int[] newArry = new int[temp];
        System.arraycopy(tem_array,0,newArry,0,temp);
        for(int i=0;i<newArry.length;i++)
            System.out.print(newArry[i]+" ");
        System.out.println();
        return newArry.length;
    }

    /**
     * 改进,利用list集合实现
     * @param array
     * @return
     */
    public int removeDuplicates(int[] array){
        if(array.length == 0)
            return 0;
        List list = new ArrayList();
        for(int i=0;i<array.length;i++){
            if(!list.contains(array[i]))
                list.add(array[i]);
        }

        Object[] newArry = list.toArray();
        for(int i=0;i<newArry.length;i++)
            System.out.print(newArry[i]+" ");
        return newArry.length;
    }

    /**
     * 利用hashSet方法去重
     * @param array
     * @return
     */
    public int removeDuplicatesHashSet(int[] array){
        if(array.length == 0)
            return 0;
        Set set = new HashSet();
        for(int i=0;i<array.length;i++){
            set.add(array[i]);
        }
        Object[] newArray = set.toArray();
        for(int i=0;i<newArray.length;i++){
            System.out.print(newArray[i]+" ");
        }

        return newArray.length;
    }

    public static void main(String[] args){
        RemoveDuplicates removeDuplicates = new RemoveDuplicates();
        int[] array = {1,1,2,2,1};
        System.out.println("方法一：\narray length :"+removeDuplicates.removeDuplicate(array));
        System.out.println("方法二：\narray length :"+removeDuplicates.removeDuplicates(array));
        System.out.println("方法三：\narray length :"+removeDuplicates.removeDuplicatesHashSet(array));
    }
}
