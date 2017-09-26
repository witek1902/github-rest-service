package witkowski.robert.github.rest.service.domain;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import retrofit2.Call;
import retrofit2.Response;
import witkowski.robert.github.rest.service.domain.dto.GhRepositoryDto;
import witkowski.robert.github.rest.service.integration.github.GhApiEndpointInterface;
import witkowski.robert.github.rest.service.integration.github.dto.IntegrationGhRepository;
import witkowski.robert.github.rest.service.validation.ArgAssert;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Service
class GhRepositoryServiceImpl implements GhRepositoryService {

    @Autowired
    private GhApiEndpointInterface ghApi;

    @Override
    public Collection<GhRepositoryDto> findAllBy(String username) throws IOException {
        ArgAssert.isNotBlank(username);

        Call<List<IntegrationGhRepository>> call = ghApi.findAllBy(username);
        Response<List<IntegrationGhRepository>> response = call.execute();

        return response.isSuccessful()
                ? createResponseList(response.body())
                : new ArrayList<>();

    }

    private Collection<GhRepositoryDto> createResponseList(List<IntegrationGhRepository> responseBody) {
        if(CollectionUtils.isEmpty(responseBody)) {
            return new ArrayList<>();
        }
        return responseBody.stream()
                .map(GhRepositoryDto::createFromIntegration)
                .collect(Collectors.toList());
    }

    @Override
    public GhRepositoryDto findOne(String username, String repositoryName) throws IOException {
        ArgAssert.isNotBlank(username, repositoryName);

        Call<IntegrationGhRepository> call = ghApi.findOne(username, repositoryName);
        Response<IntegrationGhRepository> response = call.execute();

        //In this place we could throw one of BusinessException instead return empty dto.
        //This behaviour is depend of business requirement.
        return response.isSuccessful()
                ? GhRepositoryDto.createFromIntegration(response.body())
                : GhRepositoryDto.empty();
    }
}
