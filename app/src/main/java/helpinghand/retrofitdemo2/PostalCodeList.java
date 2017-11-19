package helpinghand.retrofitdemo2;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Rasil10 on 2017-11-16.
 */

public class PostalCodeList {
    @SerializedName("data")
    @Expose
    private List<PostalCode> postalCodeList = new ArrayList<>();

    public List<PostalCode> getPostalCodeList() {
        return postalCodeList;
    }

    public void setPostalCodeList(List<PostalCode> postalCodeList) {
        this.postalCodeList = postalCodeList;
    }
}
