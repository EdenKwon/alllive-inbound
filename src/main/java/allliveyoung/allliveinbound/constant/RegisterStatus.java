package allliveyoung.allliveinbound.constant;

public enum RegisterStatus {
    WAITING("처리대기중") , APPROVAL("승인") , REFUSAL("반려");

    private final String description;

    RegisterStatus(String description){
        this.description=description;
    }

    public String getDescription(){
        return description;
    }
}
