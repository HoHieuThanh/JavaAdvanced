package ex3.remote;

import ex3.command.Command;

import java.util.HashMap;
import java.util.Map;

public class RemoteControl {
    private Map<Integer, Command> slots = new HashMap<>();
    private UndoManager undoManager = new UndoManager();

    public void setCommand(int slot, Command command) {
        slots.put(slot, command);
        System.out.println("Đã gán " + command.getClass().getSimpleName() + " cho nút " + slot);
    }

    public void pressButton(int slot) {
        Command cmd = slots.get(slot);
        if (cmd != null) {
            cmd.execute();
            undoManager.push(cmd);
        } else {
            System.out.println("Nút chưa được gán");
        }
    }

    public void pressUndo() {
        undoManager.undo();
    }
}
