package allliveyoung.allliveinbound.domain;

import org.springframework.http.converter.json.GsonBuilderUtils;

public class enumTest {
    public static void main(String[] args) {
        System.out.println(status.나.equals("나"));
    }
}

enum status {
    가, 나, 다, 라, 마

}
