package witkowski.robert.github.rest.service;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;
import witkowski.robert.github.rest.service.domain.dto.GhRepositoryDto;

@RunWith(SpringRunner.class)
@SpringBootTest
public class GithubRestServiceApplicationTests {

    private static final String ONE_REPOSITORY_URL = "http://localhost:8080/repositories/allegro/akubra";

    private RestTemplate restTemplate = new RestTemplate();

    @Test
    public void callForOneRepository() {
        GhRepositoryDto dto = restTemplate.getForObject(ONE_REPOSITORY_URL, GhRepositoryDto.class);
        Assert.assertNotNull(dto);
    }

}
