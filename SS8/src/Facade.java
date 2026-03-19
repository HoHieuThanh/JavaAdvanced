public class Facade {
}
class FacadeRes{
    private Chef chef = new Chef();
    private Staff staff = new Staff();
    private Manager manager =  new Manager();
    void order(){
        staff.orfer();
        chef.cook();
    }
    void pay(){
        staff.invoice();
        manager.feedback();
    }
}
class Chef{
    public void cook(){
        System.out.println("Nhận order từ bồi bàn. Nấu ăn");
    }
}
class Staff{
    public void orfer(){
        System.out.println("Order món cho khách");
    }
    public void invoice(){
        System.out.println("Xuất hoá đơn");
    }
}
class Manager{
    public void feedback(){
        System.out.println("Thu nhận đánh giá");
    }
}
