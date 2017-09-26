package witkowski.robert.github.rest.service.integration.github;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import witkowski.robert.github.rest.service.integration.github.dto.IntegrationGhRepository;

import java.util.List;

public interface GhApiEndpointInterface {

    /**
     * Get repository list from selected user
     * @param username - owner
     * @return
     */
    @GET("users/{owner}/repos")
    Call<List<IntegrationGhRepository>> findAllBy(@Path("owner") String username);

    /**
     * Find information about repository name in selected user repository list
     * @param username - owner
     * @param repositoryName - repository name
     * @return
     */
    @GET("repos/{owner}/{repo}")
    Call<IntegrationGhRepository> findOne(@Path("owner") String username, @Path("repo") String repositoryName);
}
