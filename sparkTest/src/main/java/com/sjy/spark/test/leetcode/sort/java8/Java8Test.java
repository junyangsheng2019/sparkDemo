package com.sjy.spark.test.leetcode.sort.java8;


import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * @author shengjunyang created on 2021/8/3
 * @version v1.0
 */
public class Java8Test {
    public static void main(String[] args) {
        Person p1 = new Person("麻子", 31);
        Person p2 = new Person("李四", 20);
        Person p3 = new Person("王五", 26);

        List<Person> personList = new ArrayList<Person>();
        personList.add(p1);
        personList.add(p2);
        personList.add(p3);
        List<Integer> list = new ArrayList<Integer>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(1);
        list.stream().sorted().limit(10);
//        Collectors.groupingBy(Function.identity(), Collectors.counting())
//        Object map = personList.stream().collect(Collectors.groupingBy(Function.identity()), Collectors.counting());
        Map<Integer, Long> uidmap = list.stream()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        List<Long> valueList = uidmap.values().stream().sorted().limit(10).collect(Collectors.toList());
        for (Map.Entry entry: uidmap.entrySet()) {
            entry.getKey();


        }
//        Lists.partition(list,100);
        //java8遍历
        personList.forEach(p -> System.out.println(p.getAge()));
        //按照person的 age进行排序
        //方法一
//        personList.sort((o1, o2) -> o1.getAge().compareTo(o2.getAge())); //正序
//        personList.sort((o1, o2) -> o2.getAge().compareTo(o1.getAge())); //倒序
        //方法二
        personList.sort(Comparator.comparing(Person::getAge)); // 正序
        personList.sort(Comparator.comparing(Person::getAge).reversed()); // 倒序
        //遍历
        personList.forEach(p -> System.out.println(p.getAge()));

        System.out.println("========================================");

        //获取年龄最大的Person
        Person maxAgePerson = personList.stream().max(Comparator.comparing(Person::getAge)).get();
        System.out.println(maxAgePerson.getAge());

        System.out.println("========================================");

        //获取年龄最小的Person
        Person minAgePerson = personList.stream().min(Comparator.comparing(Person::getAge)).get();
        System.out.println(minAgePerson.getAge());

        //过滤出年龄是20的person，想过滤出什么条件的都可以
        List<Person> personList1 = personList.stream().filter(person -> person.getAge() == 20).collect(Collectors.toList());

        //统计出年龄等于20的个数
        long count = personList.stream().filter(person -> person.getAge() == 20).count();

        //获得年龄的平均值
        double asDouble = personList.stream().mapToInt(person -> person.getAge()).average().getAsDouble();

        //获得年龄的求和
        int sum = personList.stream().mapToInt(person -> person.getAge()).sum();

        //转成一个map
//        Map<Long, DriveCmd>   mapIdEquipmentCommand = driveCmdList.stream().collect(Collectors.toMap(DriveCmd::getId, o -> o))

    }
}
