package arkadii.utils.api;

import com.github.javafaker.Faker;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;

public class ApiUtil {

    public static Map<String, Object> getRequestBodyMap(){
        Faker faker = new Faker();
        Map<String,Object> newRepoMap = new LinkedHashMap<>();
 //       {
//            "name":"{{repoName}}",
//                "description":"This is your first repo!",
//                "homepage":"https://github.com",
//                "private":false,
//                "is_template":true
//        }
            newRepoMap.put("name",faker.name().firstName());
            newRepoMap.put("description",faker.chuckNorris().fact());
            newRepoMap.put("homepage","https://github.com");
            newRepoMap.put("private","false");
            newRepoMap.put("is_template","true");


            return newRepoMap;
    }
}
