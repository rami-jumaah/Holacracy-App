import java.util.ArrayList;
import java.util.List;
import java.io.Serializable;

// collect and filter the circles
public class CirclesCollection implements Serializable {

    public List<Circle> circles;



    public CirclesCollection() {

        this.circles = new ArrayList<>();
    }

    public List<Circle> getAll() {

        return this.circles;
    }

    public void addCircle(Circle circle) {

        this.circles.add(circle);
    }

    public void addCircles(List<Circle> circles) {
        for (Circle circle : circles) {
            this.circles.add(circle);
        }
    }

    public void removeCircle(String circleName) {
        if (findCircleByName(circleName) != null) {
            this.circles.remove(findCircleByName(circleName));
        }

    }

    public Circle findCircleByName (String circleName) {
        for (Circle circle : this.circles) {
            if (circle.getName().equals(circleName)) {
                return circle;
            }
        }
        return null;
    }

}
