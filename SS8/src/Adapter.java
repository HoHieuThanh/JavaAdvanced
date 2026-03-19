public class Adapter {
    public static void main(String[] args) {
        HumanAdapter humanAdapter = new HumanAdapter(new YoungHuman());
        humanAdapter.move3();
    }
}

class YoungHuman{
    void move2(){
        System.out.println("Đi bằng 2 chân");
    }
}
interface OldHuman{
    void move3();
}
class HumanAdapter implements OldHuman{
    private YoungHuman old;
    public HumanAdapter(YoungHuman old){
        this.old = old;
    }

    @Override
    public void move3() {
        old.move2();
        System.out.println("Đi bằng 3 chân");
    }
}
