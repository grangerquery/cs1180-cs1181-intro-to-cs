public class PowerBankMain {
    public static void main(String[] args) {
        PowerBank powerbank1 = new PowerBank();
        PowerBank powerbank2 = new PowerBank(1, 2);

        powerbank1.setStatus(false);
        powerbank2.setStatus(true);
        powerbank2.plugIn("usb");
        System.out.println(powerbank2.toString());
    }
}
