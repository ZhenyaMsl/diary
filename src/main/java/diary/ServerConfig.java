package diary;

import diary.server.CmdServer;
import diary.server.Server;
import diary.server.storage.FileStorage;
import diary.server.storage.Storage;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("classpath:diary.properties")
public class ServerConfig {
    @Bean
    public Storage storage(@Value("${file.user}") String userFile,
                           @Value("${file.diary}") String diaryFile) {
        return new FileStorage(userFile, diaryFile);
    }

    @Bean
    public Server server(Storage storage) {
        return new CmdServer(storage);
    }
}
