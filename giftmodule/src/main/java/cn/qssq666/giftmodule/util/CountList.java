package cn.qssq666.giftmodule.util;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Set;

/**
 * Created by luozheng on 2016/4/28. qssq.space
 * 2017年7月3日 11:32:04  时间过得太快，我已经我不知道这东西是干什么用的，又看了一下，貌似是一个支持统计添加的次数的东西。{@link CountList @getCount} 传递一个model可以判断它的次数。
 */
public class CountList<E> extends ArrayList<E> {
    HashMap<E, Integer> countMaps = new HashMap<>();

    /**
     * 真表示 第一次创建
     *
     * @param t
     * @return
     */
    public boolean addUnique(E t) {
        if (countMaps.containsKey(t)) {
            countMaps.put(t, countMaps.get(t) + 1);
            return false;
        } else {
            countMaps.put(t, 1);
            super.add(t);
            return true;
        }
    }

    @Override
    public E remove(int index) {
        E e = super.get(index);
        super.remove(index);
        countMaps.remove(e);
        return e;
    }

    public void removeUnique(E t) {
        if (countMaps.containsKey(t)) {
            countMaps.remove(t);
        }
    }

    public ArrayList<E> getUniqueList() {
        ArrayList<E> arrayList = new ArrayList<>();
        Set<E> ts = countMaps.keySet();
        for (E t : ts) {
            arrayList.add(t);
        }
        return arrayList;
    }

    /**
     * @param object
     * @return
     * @deprecated 请使用 addUnique
     */
    @Override
    public boolean add(E object) {
        throw new RuntimeException("不支持直接添加!");
    }

    public Integer getCount(E t) {
        return countMaps.get(t);
    }

    public void setCount(E t, int value) {
        countMaps.put(t, value);
    }

    @Override
    public boolean remove(Object object) {
        countMaps.remove(object);
        return super.remove(object);
    }

    @Override
    public boolean addAll(Collection collection) {
        throw new RuntimeException("不支持此用户");
    }

    @Override
    public boolean removeAll(Collection collection) {
        throw new RuntimeException("不支持");
    }

    @Override
    public void clear() {
        countMaps.clear();
        super.clear();
    }
}
