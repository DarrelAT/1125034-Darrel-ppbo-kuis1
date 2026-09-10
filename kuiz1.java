enum PIN {
    PASSWORD
}

interface Connectable {
    abstract public String connectable();
}

interface Switchable {
    abstract public String switchable();
}

interface Lockable {
    abstract public String lockable();
}



abstract class SmartDevice {
    private int id;
    private String nama;
    private int daya;
    private String status;
    //private String connect;
    //private String disconnect;



    public SmartDevice(int id, String nama, int daya, String status){
        this.id = id;
        this.nama = nama;
        this.daya = daya;
        this.status = status;
        //this.disconnect = disconnect;
        //this.connect = connect;
    }

    public String setPin(PIN pin){
        return "PIN: " + pin;
    }

    public String getDeviceDetails () {
        return getClass().getSimpleName() + "[" + nama + "]" + "\n" + 
               "(ID: " + id + ")" + "\n" +
               " - Daya: "+ daya + " | ";

    }

    public int getId(){
        return id;
    }

    public void setId(int id){
        this.id = id;
    }

    public String getNama(){
        return nama;
    }

    public void setNama(String nama){
        this.nama = nama;
    }

    public int geDaya(){
        return daya;
    }

    public void setDaya(int daya){
        this.daya = daya;
    }

    public String getStatus(){
        return status;
    }

    public void setStatus(String status){
        this.status = status;
    }

    /* 
    public abstract void turnOn();
    public abstract void turnOff();
    */
}

class SmartTV extends SmartDevice {
    public SmartTV(int id, String nama, int daya, String status){
        super(id, nama, daya, status);
    }

    public static void koneksi(String koneksi){
        System.out.println("Koneksi: " + koneksi);
    }

    public static void setChannel(String channel){
        System.out.println("Channel :" + channel);
    }

    public static String print(){
        return "test" ;
    }
    
    /* 
    @Override 
    public String getDeviceDetail(){
        return super.getDeviceDetails();
    }
    */

       /*
    @Override
    public String switchable(status){
        return status;
    }
     */

    /*
    @Override
    public String lockable(status){
    return status;
    }
     */

}

class SmartSpeaker extends SmartDevice {
    public SmartSpeaker (int id, String nama, int daya, String status) {
        super(id, nama, daya, status);
    }

    public static void koneksi(String koneksi){
        System.out.println("Koneksi: " + koneksi);
    }

    /* 
    @Override 
    public String getDeviceDetail(){
        return super.getDeviceDetails();
    }
    */

    /*
    @Override
    public String switchable(status){
        return status;
    }
     */

    /*
    @Override
    public String lockable(status){
    return status;
    }
     */

}

class SmartDoorLock extends SmartDevice {
    public SmartDoorLock (int id, String name, int daya, String status) {
        super(id, name, daya, status);
    }

    /* 
    @Override 
    public String setPin(String newPin) {
        setPin(newPin);
        System.out.println("PIN: " + newPin);
    }
    */


    public static void setPin(String pin){
        System.out.println("PIN: " + pin);
    }

    /* 
    @Override 
    public String getDeviceDetail(){
        return super.getDeviceDetails();
    }
    */
}

public class kuiz1 {
    public static void main(String[] args) {
        //Smart newSmart = new Smart.BLUETOOTH();

        SmartDevice[] listDevice = new SmartDevice[] {
            new SmartDoorLock(01, null, 0, null),
            new SmartSpeaker(02, null, 0, null),
            new SmartTV(03, null, 0, null)
        };

        for (SmartDevice s : listDevice){
            System.out.println(s);
        }

        SmartTV.print();
        
    }
}
