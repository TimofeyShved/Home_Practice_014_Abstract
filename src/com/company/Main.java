package com.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) {
	    Object[] objects = new Object[]{"zzz", 1, 34, null, 2.5, null, "4"};

	    objects = Main.filterChain(objects);

        for (Object o : objects){
            System.out.println(o);
        }
    }

    public static Object[] filterChain(Object[] old){
        int offset = 0;
        List list = new ArrayList();

        for (Object o : old){
            if (!new FilterNull().apply(o)){
                list.add(o);
            }
        }

        return list.toArray(new Object[list.size()]);
    }
}


// интерфейс Filter c методом apply(Object o), то есть мы проверяем что существует объект
interface Filter {
    boolean apply(Object o);
}

class FilterNull implements  Filter{

    @Override
    public boolean apply(Object o) {
        if (o == null){
            return true;
        }
        return false;
    }
}