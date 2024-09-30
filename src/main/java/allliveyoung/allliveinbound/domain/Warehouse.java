package allliveyoung.allliveinbound.domain;

import lombok.*;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Warehouse {
    private Long id;
    private String name;
    private String code;
    private String roadAddress;
    private String jibunAddress;
    private String zipcode;
    private String detailsAddress;
}
