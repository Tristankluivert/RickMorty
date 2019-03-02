package ng.com.hybrid.rickmorty.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class EpisodeResults {

    @SerializedName("id")
    @Expose
    private  int id;


    @SerializedName("name")
    @Expose
    private String name;

    @SerializedName("air_date")
    @Expose
    private String air_date;

    @SerializedName("episode")
    @Expose
    private String episode;


   /* @SerializedName("name")
    @Expose
    private String name;*/


    @SerializedName("created")
    @Expose
    private String created;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAir_date() {
        return air_date;
    }

    public void setAir_date(String air_date) {
        this.air_date = air_date;
    }

    public String getEpisode() {
        return episode;
    }

    public void setEpisode(String episode) {
        this.episode = episode;
    }



    public String getCreated() {
        return created;
    }

    public void setCreated(String created) {
        this.created = created;
    }
}
