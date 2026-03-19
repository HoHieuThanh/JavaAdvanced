public class Command {
    public static void main(String[] args) {
        Light light = new Light();
        LightCommand on = new TurnOn(light);
        LightCommand off = new TurnOff(light);
        Remote remote =  new Remote();
        remote.setLightCommand(on);
        remote.pressPowerButton();
        remote.pressUndoButton();
    }
}
class Light{
    void turnOn(){
        System.out.println("Bật");
    }
    void turnOff(){
        System.out.println("Tắt");
    }
}
interface LightCommand{
    void execute();
    void undo();
}
class TurnOn implements LightCommand{
    private Light light;
    public TurnOn(Light light){
        this.light = light;
    }

    @Override
    public void execute() {
        light.turnOn();
    }

    @Override
    public void undo() {
        light.turnOff();
    }
}
class TurnOff implements LightCommand{
    private Light light;
    public TurnOff(Light light){
        this.light = light;
    }

    @Override
    public void execute() {
        light.turnOff();
    }

    @Override
    public void undo() {
        light.turnOn();
    }
}

class Remote{
    private LightCommand lightCommand;
    public void setLightCommand(LightCommand lightCommand){
        this.lightCommand = lightCommand;
    }
    public void pressPowerButton(){
        lightCommand.execute();
    }
    public void pressUndoButton(){
        lightCommand.undo();
    }
}