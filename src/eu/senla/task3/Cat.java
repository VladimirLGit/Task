package eu.senla.task3;

public class Cat {
    private String name;
    private String breed;
    private int age;

    public Cat(){}
    public Cat(String name, String breed, int age) {
        this.name = name;
        this.breed = breed;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBreed() {
        return breed;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
    @Override
    public int hashCode() {
        final int prime = 15;
        int result = 1;
        result = prime * result + name.hashCode();
        result = prime * result + breed.hashCode();
        result = prime * result + age;
        return result;
    }
    @Override
    public String toString(){
        return " name " + name + " age " + age;
    }

    @Override
    public boolean equals(Object obj){
        if(obj instanceof Cat){
            return this.name.equals(((Cat) obj).name) &&
                   this.breed.equals(((Cat) obj).breed) &&
                   this.age == ((Cat) obj).age;
        }
        return false;
    }
}
