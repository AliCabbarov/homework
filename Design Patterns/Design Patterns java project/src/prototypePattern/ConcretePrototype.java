package prototypePattern;

public class ConcretePrototype implements Prototype {
    private String property;
    public ConcretePrototype(String property){
        this.property = property;
    }

    @Override
    public Prototype clone() {
        return new ConcretePrototype(this.property);
    }

    public String getProperty() {
        return property;
    }

    public void setProperty(String property) {
        this.property = property;
    }
}
