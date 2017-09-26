package witkowski.robert.github.rest.service.integration.github.dto;

import com.google.gson.annotations.SerializedName;
import lombok.Getter;

import java.io.Serializable;

@Getter
public class IntegrationGhRepository implements Serializable {

    @SerializedName("id")
    private Long id;
    @SerializedName("full_name")
    private String fullName;
    @SerializedName("description")
    private String description;
    @SerializedName("clone_url")
    private String cloneUrl;
    @SerializedName("stargazers_count")
    private int stars;
    @SerializedName("created_at")
    private String createdAt;

    //In this place could some additional values from integration JSON response
}
