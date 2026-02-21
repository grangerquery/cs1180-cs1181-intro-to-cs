public class PowerBank {
    private int plugs_available;
    private int plugs_used;
    private int usb_available;
    private int usb_used;
    private boolean bank_on;
    private boolean light_on;

    public PowerBank() {
        this.plugs_available = 12;
        this.plugs_used = 0;
        this.usb_available = 6;
        this.usb_used = 0;
        this.bank_on = false;
        this.light_on = false;
    }

    public PowerBank(int plugs_used, int usb_used) {
        this.plugs_available = 12 - plugs_used;
        this.plugs_used = plugs_used;
        this.usb_available = 6 - usb_used;
        this.usb_used = usb_used;
    }

    public void setPlugsAvailable(int plugs_available) {
        this.plugs_available = plugs_available;
    }

    public int getPlugsAvailable() {
        return this.plugs_available;
    }

    public void setPlugsUsed(int plugs_used) {
        this.plugs_used = plugs_used;
    }

    public int getPlugsUsed() {
        return this.plugs_used;
    }

    public void setUsbAvailable(int usb_available) {
        this.usb_available = usb_available;
    }

    public int getUsbAvailable() {
        return this.usb_available;
    }

    public void setUsbUsed(int usb_used) {
        this.usb_used = usb_used;
    }

    public int getUsbUsed() {
        return this.usb_used;
    }

    public void setStatus(boolean bank_on) {
        this.bank_on = bank_on;
    }

    public boolean getStatus() {
        return this.bank_on;
    }

    public void setLight(boolean light_on) {
        this.light_on = light_on;
    }

    public boolean getLight() {
        return this.light_on;
    }

    @Override
    public String toString() {
        return "Plugs available: " + this.plugs_available + "\nPlugs used: " + this.plugs_used + "\nUSB available: "
                + this.usb_available + "\nUSB used: " + this.usb_used + "\nPowerbank on?: " + this.bank_on
                + "\nLight on?: " + this.light_on;
    }

    public void plugIn(String type) {
        if (type.equalsIgnoreCase("plug")) {
            this.plugs_used = getPlugsUsed() + 1;
            this.plugs_available = getPlugsAvailable() - 1;
        } else if (type.equalsIgnoreCase("usb")) {
            this.usb_used = getUsbUsed() + 1;
            this.usb_available = getUsbAvailable() - 1;
        } else {
            System.out.println("Invalid.");
        }
    }
}
