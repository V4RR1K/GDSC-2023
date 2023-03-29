package com.recycleracoon.RecycleRacoonAPI.Model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class RecycleNode {

    static final String FORMAT_STR =
            "RecycleNode[id=%d, name=%s, description=%s, photoName=%s, googleNode=%s, type=%s]";

    @JsonProperty("id")
    private int id;

    @JsonProperty("name")
    private String name;

    @JsonProperty("description")
    private String description;

    @JsonProperty("photoName")
    private String photoName;

    @JsonProperty("googleNode")
    private String googleNode;

    @JsonProperty("type")
    private RecycleType type;

    public RecycleNode(
            @JsonProperty("id") int id,
            @JsonProperty("name") String name,
            @JsonProperty("description") String description,
            @JsonProperty("photoName") String photoName,
            @JsonProperty("googleNode") String googleNode,
            @JsonProperty("type") RecycleType type) {

        this.id = id;
        this.name = name;
        this.description = description;
        this.photoName = photoName;
        this.googleNode = googleNode;
        this.type = type;

    }

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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPhotoName() {
        return photoName;
    }

    public void setPhotoName(String photoName) {
        this.photoName = photoName;
    }

    public String getGoogleNode() {
        return googleNode;
    }

    public void setGoogleNode(String googleNode) {
        this.googleNode = googleNode;
    }

    public RecycleType getType() {
        return type;
    }

    public void setType(RecycleType type) {
        this.type = type;
    }

    public Response testHttp(){
        OkHttpClient client = new OkHttpClient().newBuilder()
          .build();
        MediaType mediaType = MediaType.parse("text/plain");
        RequestBody body = RequestBody.create(mediaType, "");
        Request request = new Request.Builder()
          .url("https://maps.googleapis.com/maps/api/place/findplacefromtext/json?input=Museum%20of%20Contemporary%20Art%20Australia&inputtype=textquery&fields=formatted_address%2Cname%2Crating%2Copening_hours%2Cgeometry&key=YOUR_API_KEY")
          .method("GET", body)
          .build();
        Response response = client.newCall(request).execute();

    }



    @Override
    public String toString() {
        return String.format(FORMAT_STR, this.id, this.name, this.description,
                this.photoName, this.googleNode, this.type);
    }
}
