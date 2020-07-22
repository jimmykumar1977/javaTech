package app.lombok.examples;

import lombok.*;



@Getter
public class JData extends AbstractBaseClass{
    private  int dataNumber;

    private  String dataName;

    @Builder
    public JData(int dataNumber,String dataName,String id){
        super(id);
        this.dataNumber = dataNumber;
        this.dataName=dataName;
    }

}
