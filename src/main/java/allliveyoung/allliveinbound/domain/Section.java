package allliveyoung.allliveinbound.domain;

import allliveyoung.allliveinbound.constant.ProductType;
import allliveyoung.allliveinbound.constant.StoreTemperature;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Section {
    private Long id;
    private String code;
    private Warehouse warehouse;
    private StoreTemperature storeTemperature;
    private ProductType type;
    private int capacity;
}
