package week13.task4;

public class DeviceAdapter implements NewDevice{
    OldDevice oldDevice;

    public DeviceAdapter(OldDevice oldDevice) {
        this.oldDevice = oldDevice;
    }

    @Override
    public void operateNewFunction(){
        oldDevice.operateOldFunction();
    }
}
