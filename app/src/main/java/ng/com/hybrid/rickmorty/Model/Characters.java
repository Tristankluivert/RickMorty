package ng.com.hybrid.rickmorty.Model;





import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Characters {

    @SerializedName("id")
    @Expose
    private int id;

    @SerializedName("name")
    @Expose
    private String charactername;

    @SerializedName("status")
    @Expose
    private String status;

    @SerializedName("species")
    @Expose
    private String species;

    @SerializedName("gender")
    @Expose
    private String gender;

    @SerializedName("origin")
    @Expose
    private Origin origin;

    @SerializedName("location")
    @Expose
    private Location location;

    @SerializedName("image")
    @Expose
    private String image;

    @SerializedName("created")
    @Expose
    private String createdwhen;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCharactername() {
        return charactername;
    }

    public void setCharactername(String charactername) {
        this.charactername = charactername;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getSpecies() {
        return species;
    }

    public void setSpecies(String species) {
        this.species = species;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Origin getOrigin() {
        return origin;
    }

    public void setOrigin(Origin origin) {
        this.origin = origin;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getCreatedwhen() {
        return createdwhen;
    }

    public void setCreatedwhen(String createdwhen) {
        this.createdwhen = createdwhen;
    }
}
