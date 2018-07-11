package site.facade;

import org.springframework.stereotype.Service;
import site.model.Speaker;

@Service(VideosService.NAME)
public class VideosService {
    public static final String NAME = "VideosService";

    public static String replace(Speaker speaker) {
        String newData = speaker.getVideos().replaceAll(","," ");
        speaker.setVideos(newData);
        return newData;
    }

}
