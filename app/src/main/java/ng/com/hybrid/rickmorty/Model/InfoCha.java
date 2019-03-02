package ng.com.hybrid.rickmorty.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class InfoCha {


    @SerializedName("count")
    @Expose
    private int count;

    @SerializedName("pages")
    @Expose
    private int pages;

    @SerializedName("next")
    @Expose
    private String next;

    @SerializedName("prev")
    @Expose
    private String prev;


    @SerializedName("results")
    @Expose
    private List<Characters> characters;

    public List<Characters> getCharacters() {
        return characters;
    }

    public void setCharacters(List<Characters> characters) {
        this.characters = characters;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int getPages() {
        return pages;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }

    public String getNext() {
        return next;
    }

    public void setNext(String next) {
        this.next = next;
    }

    public String getPrev() {
        return prev;
    }

    public void setPrev(String prev) {
        this.prev = prev;
    }
}
