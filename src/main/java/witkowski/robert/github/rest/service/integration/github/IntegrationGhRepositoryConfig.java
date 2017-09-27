package witkowski.robert.github.rest.service.integration.github;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import okhttp3.OkHttpClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import witkowski.robert.github.rest.service.integration.common.PropertyKeys;
import witkowski.robert.github.rest.service.integration.common.PropertyProvider;

import java.util.concurrent.TimeUnit;

/**
 * Integration with GitHub configuration. Create required beans (GSON, PropertyProvider, Retrofit).
 */
@Configuration
class IntegrationGhRepositoryConfig {

    @Bean
    PropertyProvider gitHubPropertyProvider() {
        return new GitHubPropertyProvider();
    }

    @Bean
    public GhApiEndpointInterface ghApiEndpointInterface(PropertyProvider propertyProvider) {
        String host = propertyProvider.getAsString(PropertyKeys.API_HOST);

        Gson gson = new GsonBuilder()
                .create();

        OkHttpClient client = new OkHttpClient.Builder()
                .readTimeout(15, TimeUnit.SECONDS)
                .connectTimeout(15, TimeUnit.SECONDS)
                .build();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(host)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .client(client)
                .build();

        return retrofit.create(GhApiEndpointInterface.class);
    }

}
