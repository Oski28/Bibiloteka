package Library.Model.Model;

import Library.Model.Exception.PublicationAlreadyExistsException;
import Library.Model.Exception.UserAlreadyExistsException;

import java.io.Serializable;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Library implements Serializable {
    private Map<String,Publication> publications=new HashMap<>();
    private Map<String,LibraryUser> users=new HashMap<>();

    public Map<String, Publication> getPublications() {
        return publications;
    }

    public Map<String, LibraryUser> getUsers() {
        return users;
    }

    public void addUser(LibraryUser user){
        if (users.containsKey(user.getPesel())){
            throw new UserAlreadyExistsException("Użytkownik z tym peselem już istnieje.");
        } else {
            users.put(user.getPesel(),user);
        }
    }

    public void addPublication(Publication publication){
        if(publications.containsKey(publication.getTitle())){
            throw new PublicationAlreadyExistsException("Publikacja o takim tytule już istnieje.");
        } else {
            publications.put(publication.getTitle(),publication);
        }
    }

    public boolean removePublication(Publication publication){
        if(publications.containsValue(publication)){
            publications.remove(publication.getTitle());
            return true;
        } else {
            return  false;
        }
    }
}
