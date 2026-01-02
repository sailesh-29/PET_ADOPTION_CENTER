package petadoption;

public class Pet implements Comparable<Pet> {

    private int petId;
    private String name;
    private String species;
    private int age;

    public Pet(int petId, String name, String species, int age) {
        this.petId = petId;
        this.name = name;
        this.species = species;
        this.age = age;
    }

    public int getPetId() {
        return petId;
    }

    public String getName() {
        return name;
    }

    public String getSpecies() {
        return species;
    }

    public int getAge() {
        return age;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSpecies(String species) {
        this.species = species;
    }

    public void setAge(int age) {
        this.age = age;
    }

    // Comparable → sort by petId
    @Override
    public int compareTo(Pet p) {
        return this.petId - p.petId;
    }

    @Override
    public String toString() {
        return petId + " | " + name + " | " + species + " | " + age;
    }
}
