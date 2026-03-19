import java.util.ArrayList;
import java.util.List;

public class Observer {
    public static void main(String[] args) {
        ReceiverObserver receiverObserver1 = new ConcreteReceiver("NVA");
        ReceiverObserver receiverObserver2 = new ConcreteReceiver("LVB");
        SourceNews news = new SourceNews();
        news.addReceiver(receiverObserver1);
        news.addReceiver(receiverObserver2);
        news.sendNews();
    }
}
interface ReceiverObserver{
    void update(String news);
}
class SourceNews{
    private List<ReceiverObserver> receiverObservers = new ArrayList<>();
    public void addReceiver(ReceiverObserver receiver){
        receiverObservers.add(receiver);
    }
    public  void sendNews(){
        String content = "Tin tức mới";
        receiverObservers.forEach(receiverObserver -> {
            receiverObserver.update(content);
        });
    }
}
class ConcreteReceiver implements ReceiverObserver{
    private String name;

    public ConcreteReceiver(String name) {
        this.name = name;
    }

    @Override
    public void update(String news) {
        System.out.println(name + ": " + news);
    }
}

