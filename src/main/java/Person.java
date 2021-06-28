public class Person {
    private int num;
    private String vit_Date;
    private String name;
    private String region;
    private String phone_num;
    private double temperature;
    private String agreement;

    public Person() {

    }

    public Person(int num, String vit_Date, String name, String region, String phone_num, double temperature, String agreement){
        this.num=num;
        this.vit_Date=vit_Date;
        this.name=name;
        this.region=region;
        this.phone_num=phone_num;
        this.temperature=temperature;
        this.agreement=agreement;
    }

    @Override
    public String toString(){
        return this.num + ". " + this.vit_Date + " "  + this.name + " " + this.region + " "
                + this.phone_num + " "  + this.temperature + "       "  +this.agreement ;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public String getVit_Date() {
        return vit_Date;
    }

    public void setVit_Date(String vit_Date) {
        this.vit_Date = vit_Date;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getPhone_num() {
        return phone_num;
    }

    public void setPhone_num(String phone_num) {
        this.phone_num = phone_num;
    }

    public double getTemperature() {
        return temperature;
    }

    public void setTemperature(double temperature) {
        this.temperature = temperature;
    }

    public String getAgreement() {
        return agreement;
    }

    public void setAgreement(String agreement) {
        this.agreement = agreement;
    }

}
