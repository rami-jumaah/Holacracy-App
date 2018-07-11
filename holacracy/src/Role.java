
import java.io.Serializable;

public class Role implements Serializable {

    public String name;
    public String purpose;
    public String accountability;


    public Role(String name, String purpose, String accountability) {
        this.name = name;
        this.purpose = purpose;
        this.accountability = accountability;

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAccountability() {
        return accountability;
    }

    public void setAccountability(String accountability) {
        this.accountability = accountability;
    }

    public String getPurpose() {
        return purpose;
    }

    public void setPurpose(String purpose) {
        this.purpose = purpose;
    }
}
