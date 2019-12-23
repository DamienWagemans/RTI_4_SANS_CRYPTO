package ClassesRequeteViews;

public class Server_Information {
    private String Ip;
    private int Port;

    public String getIp(){
        return Ip;
    }

    public void setIp(String Ip){
        this.Ip = Ip;
    }

    public int getPort(){
        return Port;
    }

    public void setPOrt(int Port){
        this.Port = Port;
    }

    public Server_Information(){
        Port = 0;
        Ip = "";
    }

    public Server_Information(int Port, String Ip){
        this.Port = Port;
        this.Ip = Ip;
    }
}
