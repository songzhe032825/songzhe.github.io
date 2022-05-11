package com.hspedu.houserent_.service;

import com.hspedu.houserent_.domian.House;

public class HouseService {
    //定义House []数组保存House对象
    //这里只是声明House 对象 默认是null
    private House[] houses;
    //在add判断语句中需要一个变量houseNum记录当前有多少个房屋信息，为了判断是否可以添加
    private int houseNums = 1; //初始化 先为1
    private int idCounter = 1 ; //记录当前的id自增长哪个值 Counter计数器
    //1.创建构造器 存放houses数组的数据
    public HouseService(int size) {
        //new Houses
        houses = new House[size]; //当创建HouseService 指定数组大小
        //没有房屋信息 为了配合测试 初始化一个house对象
        houses[0] = new House(1, "jack", "112", "海淀区", 20000, "未出组");
    }

    //5.select 方法 返回House对象 或者null
    //selectById 为何方法名这么命名？ 不单单是id后续有可能是名字查找 多元化区分
    public House selectById(int selectId){
        //编程思想 ：怎么去查询id 肯定是根据遍历数组查找
        for (int i = 0; i < houseNums ; i++) {
            if(selectId == houses[i].getId()){
                //找到id 返回该对象
                return houses[i];
                //这里作为思考延伸：如果查找地址address 那么返回是多个地址 显示用for循环来处理
            }
         }
         return null;
    }

    //4.del方法  删除一个房屋信息 delId形参要最后传入到view层中去
    public boolean del(int delId){
        //应先找到删除房屋信息对应的下标 这里很重要 搞清楚”房屋的下标”与“房屋的编号“是两码事
        // 不要认为删除房屋的编号就是房屋的下标，这里大错特错
        int index =-1;
        for (int i = 0; i <houseNums; i++) {
            //delId 等于 当前数组house下标为i的元素 的当前对象
            //delId 表示房屋的编号 house[i].getId 表示房屋的下标号
            if(delId == houses[i].getId()){
                //表示已经找到了 ，那就用index保存记录下来i
                index = i;//核心来了:找到的i元素就是要业务逻辑正真正删除的i
            }
        }

        if(index == -1){//说明delId 再数组中不存在 那就返回错误
            return  false;
        } else {
            //如果找到 这里需要小伙伴思考 这里很困难
            //思路分析 ：就是把index等于该元素 需要这么做 ：就是把index+1 的
            //元素向前挪 最后一个位置置空即可【 相当于把index指的下标被后面覆盖了,
            //所以最后一位空出来了】
            for (int i = index; i <houseNums-1 ; i++) {//houseNums满的
                //如果houseNums-1 就会空指针异常 必须减去一就是可以把最后一个移动过去l
                //表示i下标移动  要覆盖前面的元素
                houses[i] =houses[i+1];
            }
        }   //最后元素置空
            //满足需求在数据库中把前面i删除了之后，最后一个空出来了
            houses[houseNums-1] = null;
            //自减
            -- houseNums ;
            return true;
    }

    //3.再增加业务add方法  添加新对象  返回boolean
    public boolean add(House newHouse) {
        //判断是否可以继续添加 (先不要考虑数组的扩容问题 length+1
        if (houseNums == houses.length) {//已满 不能添加
            System.out.println("数组已满 不能再添加");
            //怎么办呢  直接放回false
            return false;
        }
        //如果没有问题 可以继续添加  把newHouse 对象加入到houses数组中
        // 新增HouseNums++一个房屋信息 这里是核心
        //解析代码 ：把newHouse对象加入到数组houses中的houseNum下，然后自增
        houses[houseNums++] = newHouse;
        //程序员需要设计一个id  自增长的机制
        idCounter ++;
        //最关键的地方 相当于新更新新进来newHouse的 “id”
        newHouse.setId(idCounter);
        //这次是真的成功了  就返回一个true 完成业务逻辑
        return true;
    }
    //2.list方法  返回houses对象
    public House[] list(){
        return houses;
    }
}
