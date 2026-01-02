package petadoption;

import java.util.*;
import java.util.regex.Pattern;

public class petService {

    private petDAO dao = new petDAO();
    private static final Pattern AGE_PATTERN = Pattern.compile("^[0-9]{1,2}$");

    // Regex validation for age
    private int validateAge(String age) {
        if (!AGE_PATTERN.matcher(age).matches()) {
            throw new IllegalArgumentException("Invalid age! Age must be numeric.");
        }
        return Integer.parseInt(age);
    }

    public void addPet(int id, String name, String species, String age) {
        int validAge = validateAge(age);
        dao.addPet(new Pet(id, name, species, validAge));
    }

    public void viewPetsSortedById() {
        List<Pet> pets = dao.getAllPets();
        Collections.sort(pets);
        pets.forEach(System.out::println);
    }

    // Comparator → sort by species
    public void viewPetsSortedBySpecies() {
        List<Pet> pets = dao.getAllPets();
        pets.sort(Comparator.comparing(Pet::getSpecies));
        pets.forEach(System.out::println);
    }

    public void updatePet(int id, String name, String species, String age) {
        Pet pet = dao.getPetById(id);
        if (pet == null) {
            System.out.println("Pet not found");
            return;
        }
        pet.setName(name);
        pet.setSpecies(species);
        pet.setAge(validateAge(age));
    }

    public void deletePet(int id) {
        if (!dao.deletePet(id)) {
            System.out.println("Pet not found");
        }
    }
}
