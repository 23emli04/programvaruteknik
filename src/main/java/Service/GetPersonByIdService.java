package Service;

import dao.PersonDao;
import domain.Person;

public class GetPersonByIdService {
    private final int id;

    public GetPersonByIdService(int id) {
        this.id = id;
    }
    public Person execute(){
        return new PersonDao().getAll().stream().filter(p -> p.getId() == this.id).findFirst().orElse(null);
    }
}
