package ex3.command;


import ex3.device.AirConditioner;

public class ACSetTemperatureCommand implements Command {
    private AirConditioner ac;
    private int newTemp;
    private int prevTemp;

    public ACSetTemperatureCommand(AirConditioner ac, int temp) {
        this.ac = ac;
        this.newTemp = temp;
    }

    @Override
    public void execute() {
        prevTemp = ac.getTemperature();
        ac.setTemperature(newTemp);
    }

    @Override
    public void undo() {
        System.out.print("Undo: ");
        ac.setTemperature(prevTemp);
    }
}
