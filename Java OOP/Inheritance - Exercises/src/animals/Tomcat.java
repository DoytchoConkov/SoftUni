package animals;

public class Tomcat extends Cat{
    public Tomcat(String name,int age){
        super(name,age,"female");
    }

    @Override
    public String produceSound(){
        return "MEOW";
    }
}
