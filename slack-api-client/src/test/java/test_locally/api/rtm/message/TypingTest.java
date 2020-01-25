package test_locally.api.rtm.message;

import com.slack.api.rtm.message.Typing;
import com.slack.api.util.json.GsonFactory;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class TypingTest {

    @Test
    public void deserialize() {
        String json = "{\n" +
                "    \"type\": \"typing\",\n" +
                "    \"channel\": \"c\",\n" +
                "    \"id\": \"123\"\n" +
                "}";
        Typing msg = GsonFactory.createSnakeCase().fromJson(json, Typing.class);
        assertThat(msg.getType(), is("typing"));
        assertThat(msg.getChannel(), is("c"));
        assertThat(msg.getId(), is(123L));
    }

    @Test
    public void serialize() {
        String generatedJson = Typing.builder().build().toJSONString();
        String expectedJson = "{\"type\":\"typing\"}";
        assertThat(generatedJson, is(expectedJson));
    }

}
