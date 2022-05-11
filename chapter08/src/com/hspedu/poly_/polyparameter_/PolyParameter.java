package com.hspedu.poly_.polyparameter_;

//多态应用二 ：多态参数
public class PolyParameter {
    public static void main(String[] args) {
        Worker worker = new Worker("Carter",350000);
        Manager manager = new Manager("Kobe",344444,677777);
        PolyParameter polyParameter = new PolyParameter();
        //运用动态机制看出不一样的状态效果
        polyParameter.showEmpAnnual(worker);
        polyParameter.showEmpAnnual(manager);

        //运用动态机制看出不一样的状态效果
        polyParameter.testWork(worker);
        polyParameter.testWork(manager);
    }

    //实现获取任何员工的年工资  在main方法中调用 [e.getAnnual()]
    public void showEmpAnnual(Employee e){
        System.out.println(e.getAnnual());
    }

    //添加一个方法  testWork 如果是普通员工  则调用work方法 如果是经理 则调用manager方法
    public void  testWork(Employee e){
        if( e instanceof Worker){
            ((Worker)e).worker();
        }else if(e instanceof Manager){
            ((Manager)e).manager();
        }else{
            System.out.println("你的类型有误，请重新输入");
        }
    }
}
