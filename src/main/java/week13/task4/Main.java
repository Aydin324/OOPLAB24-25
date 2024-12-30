package week13.task4;

public class Main {
    public static void main(String[] args) {
        NewDevice newDevice = new NewDeviceImpl();
        System.out.println("Using NewDeviceImpl directly:");
        newDevice.operateNewFunction();

        OldDevice oldDevice = new OldDeviceImpl();
        NewDevice adapter = new DeviceAdapter(oldDevice);
        System.out.println("Using OldDevice through DeviceAdapter:");
        adapter.operateNewFunction();
    }
}
