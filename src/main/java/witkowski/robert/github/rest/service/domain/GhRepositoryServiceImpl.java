package witkowski.robert.github.rest.service.domain;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import retrofit2.Response;
import witkowski.robert.github.rest.service.domain.dto.GhRepositoryDto;
import witkowski.robert.github.rest.service.integration.github.GitHubApiClient;
import witkowski.robert.github.rest.service.integration.github.dto.IntegrationGhRepository;
import witkowski.robert.github.rest.service.validation.ArgAssert;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
class GhRepositoryServiceImpl implements GhRepositoryService {

    private final GitHubApiClient gitHubApiClient;

    @Override
    public Collection<GhRepositoryDto> findAllBy(String username) {
        ArgAssert.isNotBlank(username);

        Response<List<IntegrationGhRepository>> response = gitHubApiClient.findAllBy(username);

        return response.isSuccessful()
                ? createResponseList(response.body())
                : new ArrayList<>();
    }

    private Collection<GhRepositoryDto> createResponseList(List<IntegrationGhRepository> responseBody) {
        if (CollectionUtils.isEmpty(responseBody)) {
            return new ArrayList<>();
        }
        return responseBody.stream()
                .map(GhRepositoryDto::createFromIntegrationEntity)
                .collect(Collectors.toList());
    }

    @Override
    public GhRepositoryDto findOne(String username, String repositoryName) {
        ArgAssert.isNotBlank(username);
        ArgAssert.isNotBlank(repositoryName);

        Response<IntegrationGhRepository> response = gitHubApiClient.findOne(username, repositoryName);

        //In this place we could throw one of BusinessException instead return empty dto.
        //This behaviour is depend of business requirement.
        return response.isSuccessful()
                ? GhRepositoryDto.createFromIntegrationEntity(response.body())
                : GhRepositoryDto.empty();
    }
}
