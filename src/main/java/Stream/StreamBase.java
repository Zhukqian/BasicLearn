package Stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @ClassName StreamForeach
 * @Description Stream的简单foreach
 * forEach使用后，我如果想再对stream流进行操作是不可行的，这是因为forEach是一种消费性接口，
 * 也就是返回值是void，也就是没有返回值的接口，而我们看其他的stream流提供的接口，大部分都是有返回值的，返回的也是一个Stream流对象。
 * @Author zhukq
 * @Date 2020/4/20 9:54
 * @Version 1.0
 */
public class StreamBase {

    public static void main(String[] args) {
        List<String> strList = new ArrayList<>();
        strList.add("shaochen");
        strList.add("shaohen");
        strList.add("cool");
        strList.add("bean");
        strList.add("java");
        strList.add("java");

        //获取我们的Stream流对象,我们的操作都是根据这个流进行的
        Stream<String> stream = strList.stream();

        //首先做一个简单的for循环
        //stream.forEach(System.out::println);

        //统计次数
        //System.out.println("count::::==="+stream.count());

        //对数据进行去重并循环遍历结果
        //stream.distinct().forEach(System.out::println);


        //去重后形成一个集合
        /*List<String> collect = stream.distinct().collect(Collectors.toList());
        System.out.println(collect.toString());*/

        // 将集合中的数据循环变为大写字母，然后过滤，找到包含A的数据，循环打印出来
        //stream.map(s -> s.toUpperCase() ).filter(s -> s.contains("A")).forEach(System.out::println);

        // stream流对数据进行分页查询
        //个skip和一个limit，skip代表着要跳过结果集中的前几个数据，limit也就是取结果集中的几个数据，也就是一个是page字段，一个是size字段，可以做到简单的分页。
        //stream.skip(5).limit(2).forEach(s -> System.out.println(s));

        //map()：接收一个方法作为参数，该函数会被应用到每个元素上，并将其映射成一个新的元素
       /* List<String> stringList = stream.map(s -> s.toUpperCase()).collect(Collectors.toList());
        stringList.forEach(System.out::println);*/

       //flatMap()：对每个元素执行mapper指定的操作，并用所有mapper返回的Stream中的元素组成一个新的Stream作为最终返回结果，通俗易懂就是将原来的stream中的所有元素都展开组成一个新的stream
        //创建一个 装有两个泛型为integer的集合
        Stream<List<Integer>> streamMap = Stream.of(Arrays.asList(1, 2, 3), Arrays.asList(4, 5));
        // 将两个合为一个
        Stream<Integer> integerStream = streamMap.flatMap(
                (Function<List<Integer>, Stream<Integer>>) integers -> integers.stream());
        // 为新的集合
        List<Integer> collect = integerStream.collect(Collectors.toList());
        System.out.println("新stream大小:"+collect.size());
        System.out.println("-----合并后-----");
        collect.forEach(o ->System.out.println(o));

    }
}
