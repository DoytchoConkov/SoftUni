package OrderByAge;

public class Worker {
    private String name;
    private String iD;
    private int years;

    public Worker(String name, String iD, int years) {
        this.name = name;
        this.iD = iD;
        this.years = years;
    }

    public int getYears() {
        return years;
    }

    @Override
    public String toString(){
        return String.format("%s with ID: %s is %d years old.",this.name,this.iD,this.years);
    }
}
