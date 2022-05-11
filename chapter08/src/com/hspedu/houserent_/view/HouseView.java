package com.hspedu.houserent_.view;

import com.hspedu.houserent_.domian.House;
import com.hspedu.houserent_.service.HouseService;
import com.hspedu.houserent_.utils.Utility;

/*1.显示用户界面
* 2.接受用户的输入
* 3.调用HouseService完成对房屋的各种操作
*
* */
   public class HouseView {
        private boolean loop = true; //控制显示菜单
        private char key =' ';  //接受用户选择
        //首先有houseService对象调用方法 在View界面层增加属性
        private HouseService houseService = new HouseService(20);//设置数组大小、

        //根据id修改房屋信息

        public void update(){
            System.out.println("======修改房屋信息==========");
            System.out.println("======请选择待修改的房屋编号(-1表示退出) ：");
            int updateId = Utility.readInt();
            if(updateId == -1){
                System.out.println("已放弃修改房屋信息");
                return;
            }

            //根据输入updateId 查找对象 返回对象接受
            House house = houseService.selectById(updateId);//返回的是引用类型 所以修改数据会影响到
            //数组里的house 对象
            if(house == null){
                System.out.println("要修改的房屋信息编号不存在");
                return;
            }
            //代表输入新的修改房屋信息
            System.out.println("姓名("+house.getName()+") :");
            String name = Utility.readString(8," ");
            //如果name 是不是 空的判断
            if(!"".equals(name)){//修改
                //因此这里的house.setXxx(Xxx)的修改会直接影响到service层的数组【元素】！！！！
                house.setName(name);
            }
            //电话信息
            System.out.println("电话("+house.getPhone()+") :");
            String phone = Utility.readString(12);
            if(! "".equals(phone)){
                house.setPhone(phone);
            }
            //地址信息
            System.out.println("地址(" +house.getAddress() +")：");
            String address = Utility.readString(18);
            if(!"".equals(address)){
                house.setAddress(address);
            }
            //租金
            System.out.println("租金("+house.getRent() +") :");
            int rent = Utility.readInt(-1);
            if(rent != -1){
                house.setRent(rent);
            }
            //状态
            System.out.println("状态("+house.getState()+"):");
            String state= Utility.readString(3,"");
            if(!"".equals(state)){
                house.setState(state);
            }
            System.out.println("修改成功");
        }

        //根据id查找房屋信息
        public void findHouse(){
            System.out.println("====查找房屋信息=========");
            System.out.println("请输入要查找的id: ");
            int selectId = Utility.readInt();
            //调用方法 service层
            House house = houseService.selectById(selectId);
            if(house != null){
                System.out.println(house);
            } else {
                System.out.println("没有查到相应房屋id信息");
            }
        }

        //编写完成退出确认exit();即可

        public void exit(){
            char c = Utility.readConfirmSelection();
            if( c == 'Y'){
                loop = false;
            }
        }

        //编写delHouse() 接受输入的 id,调用service的del方法
        public void delHouse(){
            System.out.println("==========删除房屋信息 ==============");
            System.out.println("==============请输入待删除房屋(-1退出)的编号：");
            int delId = Utility.readInt();
            if(delId == -1){
                System.out.println("你放弃了删除");
                //接下来代码不要再走了 ,不要用break
                // 要用return因为代表结束delHouse方法
                return;
            }
            System.out.println("请确认是否删除(Y/N)");
            //ctrl + b 跳转readConfirmSelection()方法
            //注意该方法工具类本身带有循环判断的逻辑 必须输出Y/N 否则出不来的
            char choice = Utility.readConfirmSelection();
            if(choice == 'Y'){//真的要做删除功能去service层去实现
                //调用service层的方法 接受del方法中的形参delId
                if(houseService.del(delId)){
                    System.out.println("=====删除成功========");
                } else {
                    //只有一种可能id编号不存在
                    System.out.println("=======删除失败============");
                }
            } else {
                System.out.println("==========已放弃删除房屋信息 ==============");
            }
        }

        //编写addHouse() 接受输入 创建house对象 调用add方法  (思路)
        //addHouse() 方法在主菜单调用 do - while 中的switch语句
        public void addHouse(){
            System.out.println("==========添加房屋=============");
            //接受信息输入
            System.out.print("姓名");
            String name = Utility.readString(8);
            System.out.print("电话");
            String phone = Utility.readString(12);
            System.out.println("地址");
            String address = Utility.readString(16);
            System.out.println("月租 ：");
            int rent =Utility.readInt();
            System.out.println("状态 ： ");
            String state =Utility.readString(3);
            //创建一个新的House对象  注意id是系统分配的  用户无法输入
            House newHouse = new House(1,name,phone,address,rent,state);
            //添加房屋信息 newHouse对象“houseService”调用add方法(这是service层写完add业务之后 最后一步调用方法)
            if(houseService.add(newHouse)){
                System.out.println("=============添加房屋成功===========");
            } else {
                System.out.println("=============添加房屋失败============");
            }
        }


        //编写listHouses() 显示房屋列表
        public void listHouses(){
            System.out.println("====房屋列表====");
            System.out.println("编号\t\t房屋\t\t电话\t\t地址\t\t月租\t\t状态\t\t(未出组/已出租)");
            House[] houses = houseService.list();//得到所有房屋的信息
            //遍历房屋
            for (int i = 0; i < houses.length; i++) {//大家想想，这里有什么问题  有雷区  会报null
                //如果Houses 为null 就不要再显示了
                if(houses[i] == null ){
                    break;
                }
                //因为在domain 下的House层已经实现toString方法
                System.out.println("houses[i]");
            }
            System.out.println("=======房屋列表显示完毕=========");
        }
        //显示主菜单
        public void mainMenu(){
            //菜单界面 就想到do - while 循环
            do{
                System.out.println("==========");
                System.out.println("\t\t\t\t1 新增房源");
                System.out.println("\t\t\t\t2 查找房源");
                System.out.println("\t\t\t\t3 查找房屋");
                System.out.println("\t\t\t\t4 删除房屋信息");
                System.out.println("\t\t\t\t5 修改房屋信息");
                System.out.println("\t\t\t\t6 显示房屋信息");
                System.out.println("\t\t\t\t7 退出房屋信息");

                //菜单写好后  请收入用的选择 1-7 并用key来接受
                System.out.println("请收入用的选择 1-7");
                key = Utility.readChar();
                switch (key) {
                    case '1' :
                        //addHouse要在主菜单view界面调用一次  很重要
                        addHouse();
                        break;

                    case '2' :
                        System.out.println("查找");
                        break;
                    case '3' :
                        //System.out.println("查找房屋");
                        findHouse();
                        break;
                    case '4' :
                        //System.out.println("删除");
                        delHouse();
                        break;
                    case '5' :
                        update();
                        break;

                    case '6' :
                        listHouses();
                        break;

                    case '7' :
                        exit();
                        break;
                }
            }while (loop);
        }
}
