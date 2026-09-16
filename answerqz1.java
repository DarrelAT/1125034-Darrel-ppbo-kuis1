import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

//Enum dan Interface
enum ConnectionType {
    WIFI, BLUETOOTH, NONE
}

interface Connectable {
    void connect(ConnectionType type);
    void disconnect();
}

interface Switchable {
    void turnOn();
    void turnOff();
}

interface Lockable {
    void lock();
    void unlock();
}

//Static Input Util Class
class InputUtil {
    private static Scanner scanner = new Scanner(System.in);

    public static int readInt() {
        int value = scanner.nextInt();
        scanner.nextLine(); 
        return value;
    }

    public static double readDouble() {
        double value = scanner.nextDouble();
        scanner.nextLine(); 
        return value;
    }

    public static String readLine() {
        return scanner.nextLine();
    }
}

//Parent Class
abstract class SmartDevice {
    private String id;
    private String nama;
    private double daya;
    private String status;

    public SmartDevice(String id, String nama, double daya) {
        this.id = id;
        this.nama = nama;
        this.daya = daya;
        this.status = "Mati";
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public double getDaya() {
        return daya;
    }

    public void setDaya(double daya) {
        this.daya = daya;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public abstract String getDeviceDetails();
}

//Chlid Class
class SmartTV extends SmartDevice implements Switchable, Connectable {
    private int channel;
    private int volume;
    private ConnectionType connectionType;

    public SmartTV(String id, String nama, double daya, int channel, int volume) {
        super(id, nama, daya);
        this.channel = channel;
        this.volume = volume;
        this.connectionType = ConnectionType.NONE;
    }

    public int getChannel() {
        return channel;
    }

    public void setChannel(int channel) {
        this.channel = channel;
    }

    public int getVolume() {
        return volume;
    }

    public void setVolume(int volume) {
        this.volume = volume;
    }

    public ConnectionType getConnectionType() {
        return connectionType;
    }

    @Override
    public void turnOn() {
        setStatus("Menyala");
    }

    @Override
    public void turnOff() {
        setStatus("Mati");
    }

    @Override
    public void connect(ConnectionType type) {
        this.connectionType = type;
    }

    @Override
    public void disconnect() {
        this.connectionType = ConnectionType.NONE;
    }

    @Override
    public String getDeviceDetails() {
        return "Smart TV [" + getNama() + "] (ID: " + getId() + ") - Daya: " + getDaya() + "W | Status: " 
               + getStatus() + " | Koneksi: " + connectionType + " | Channel: " + channel + " | Volume: " + volume;
    }
}

class SmartSpeaker extends SmartDevice implements Switchable, Connectable {
    private int volume;
    private ConnectionType connectionType;

    public SmartSpeaker(String id, String nama, double daya, int volume) {
        super(id, nama, daya);
        this.volume = volume;
        this.connectionType = ConnectionType.NONE;
    }

    public int getVolume() {
        return volume;
    }

    public void setVolume(int volume) {
        this.volume = volume;
    }

    public ConnectionType getConnectionType() {
        return connectionType;
    }

    @Override
    public void turnOn() {
        setStatus("Menyala");
    }

    @Override
    public void turnOff() {
        setStatus("Mati");
    }

    @Override
    public void connect(ConnectionType type) {
        this.connectionType = type;
    }

    @Override
    public void disconnect() {
        this.connectionType = ConnectionType.NONE;
    }

    @Override
    public String getDeviceDetails() {
        return "Smart Speaker [" + getNama() + "] (ID: " + getId() + ") - Daya: " + getDaya() + "W | Stauts: " 
               + getStatus() + " | Koneksi: " + connectionType + " | Volume: " + volume;
    }
}

class SmartDoorLock extends SmartDevice implements Lockable {
    private String pin;

    public SmartDoorLock(String id, String nama, double daya, String pin) {
        super(id, nama, daya);
        this.pin = pin;
        setStatus("Terkunci");
    }

    public String getPin() {
        return pin;
    }

    public void setPin(String pin) {
        this.pin = pin;
    }

    @Override
    public void lock() {
        setStatus("Terkumci");
    }

    @Override
    public void unlock() {
        setStatus("Terbuka");
    }

    @Override
    public String getDeviceDetails() {
        return "Smart Door Lock [" + getNama() + "] (ID: " + getId() + ") - Daya: " + getDaya() + "W | Status: " 
               + getStatus() + " | PIN: ****";
    }
}

//Main Program dan Polymorphism and looping nya
public class answerqz1 {
    public static void main(String[] args) {
        List<SmartDevice> devices = new ArrayList<>();
        int menu = -1;

        while (menu != 0) {
            System.out.println("\n=== MENU SMART HOME ===");
            System.out.println("1. Tambah Perangkat");
            System.out.println("2. Print Semua Perangkat");
            System.out.println("0. Berhenti");
            System.out.print("Pilih menu: ");
            menu = InputUtil.readInt();

            if (menu == 1) {
                System.out.println("\n--- Jenis Perangkat ---");
                System.out.println("1. Smart TV");
                System.out.println("2. Smart Speaker");
                System.out.println("3. Smart Door Lock");
                System.out.print("Pilih jenis: ");
                int subMenu = InputUtil.readInt();

                System.out.print("Masukkan ID: ");
                String id = InputUtil.readLine();
                System.out.print("Masukkan Nama: ");
                String nama = InputUtil.readLine();
                System.out.print("Masukkan Daya (Watt): ");
                double daya = InputUtil.readDouble();

                if (subMenu == 1) {
                    System.out.print("Masukkan Channel: ");
                    int channel = InputUtil.readInt();
                    System.out.print("Masukkan Volume: ");
                    int volume = InputUtil.readInt();

                    SmartTV tv = new SmartTV(id, nama, daya, channel, volume);
                    tv.turnOn();
                    tv.connect(ConnectionType.WIFI);
                    devices.add(tv);

                } else if (subMenu == 2) {
                    System.out.print("Masukkan Vloume: ");
                    int volume = InputUtil.readInt();

                    SmartSpeaker speaker = new SmartSpeaker(id, nama, daya, volume);
                    speaker.turnOn();
                    speaker.connect(ConnectionType.BLUETOOTH);
                    devices.add(speaker);

                } else if (subMenu == 3) {
                    System.out.print("Masukkan PIN: ");
                    String pin = InputUtil.readLine();

                    SmartDoorLock lock = new SmartDoorLock(id, nama, daya, pin);
                    lock.lock();
                    devices.add(lock);
                }

            } else if (menu == 2) {
                System.out.println("\n=== DAFTAR PERANGKAT PINTAR ===");
                if (devices.isEmpty()) {
                    System.out.println("Belum ada perangkat.");
                } else {
                    for (SmartDevice device : devices) {
                        System.out.println(device.getDeviceDetails());
                    }
                }
            }
        }
    }
}