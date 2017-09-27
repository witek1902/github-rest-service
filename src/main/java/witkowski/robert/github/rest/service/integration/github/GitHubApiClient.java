package witkowski.robert.github.rest.service.integration.github;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import retrofit2.Call;
import retrofit2.Response;
import witkowski.robert.github.rest.service.integration.github.dto.IntegrationGhRepository;
import witkowski.robert.github.rest.service.integration.github.exception.GithubIOException;

import java.io.IOException;
import java.util.List;

@Component
@Slf4j
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class GitHubApiClient {

    private final GhApiEndpointInterface ghApi;

    public Response<List<IntegrationGhRepository>> findAllBy(String username) {
        Call<List<IntegrationGhRepository>> call = ghApi.findAllBy(username);
        return processCall(call);
    }

    public Response<IntegrationGhRepository> findOne(String username, String repositoryName) {
        Call<IntegrationGhRepository> call = ghApi.findOne(username, repositoryName);
        return processCall(call);
    }


    private <T> Response<T> processCall(Call<T> call) {
        try {
            return call.execute();
        } catch(IOException e) {
            throw new GithubIOException("IOException when application call to GitHub API.");
        }
    }
}
