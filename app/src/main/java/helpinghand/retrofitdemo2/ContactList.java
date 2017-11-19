package helpinghand.retrofitdemo2;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Rasil10 on 2017-11-16.
 */

public class ContactList {
    @SerializedName("contacts")
    @Expose
    private List<Contact> contacts = new ArrayList<>();

    /**
     * @return The contacts
     */
    public List<Contact> getContacts() {
        return contacts;
    }

    /**
     * @param contacts The contacts
     */
    public void setContacts(List<Contact> contacts) {
        this.contacts = contacts;
    }
}
