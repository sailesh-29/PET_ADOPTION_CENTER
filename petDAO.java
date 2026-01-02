package petadoption;

import java.util.*;

public class petDAO {

    private List<Pet> petList = new ArrayList<>();

    public void addPet(Pet pet) {
        petList.add(pet);
    }

    public List<Pet> getAllPets() {
        return petList;
    }

    public Pet getPetById(int id) {
        for (Pet p : petList) {
            if (p.getPetId() == id) {
                return p;
            }
        }
        return null;
    }

    public boolean deletePet(int id) {
        Pet pet = getPetById(id);
        if (pet != null) {
            petList.remove(pet);
            return true;
        }
        return false;
    }
}
