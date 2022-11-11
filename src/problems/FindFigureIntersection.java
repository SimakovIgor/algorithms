package problems;

public class FindFigureIntersection {

    public boolean find(double squareX, double squareY, double squareA, double circleX, double circleY, double radius) {
        boolean isInXLine = (circleX >= squareX - squareA / 2) && (circleX <= squareX + squareA / 2);
        boolean isInYLine = (circleY >= squareY - squareA / 2) && (circleY <= squareY + squareA / 2);

        double nearX = 0;
        double nearY = 0;

        if (isInXLine && isInYLine) {
            return true;
        }

        if (isInXLine) {
            if (circleY < squareY - squareA / 2) {
                nearX = circleX;
                nearY = squareY - squareA / 2;
            } else if (circleY > squareY + squareA / 2) {
                nearX = circleX;
                nearY = squareY + squareA / 2;
            }
        }

        if (isInYLine) {
            if (circleX < squareX - squareA / 2) {
                nearX = squareX - squareA;
                nearY = squareY;
            } else if (circleX > squareX + squareA / 2) {
                nearX = squareX + squareA / 2;
                nearY = squareY;
            }
        } else {
            //Тогда в углах
            if (circleX > squareX + squareA / 2 && circleY > squareY + squareA / 2) {
                //правый верхний
                nearX = squareX + squareA / 2;
                nearY = squareY + squareA / 2;
            } else if (circleX < squareX - squareA / 2 && circleY > squareY - squareA / 2) {
                //левый верхний
                nearX = squareX - squareA / 2;
                nearY = squareY + squareA / 2;
            } else if (circleX > squareX - squareA / 2 && circleY < squareY - squareA / 2) {
                //нижний правый
                nearX = squareX + squareA / 2;
                nearY = squareY - squareA / 2;
            } else if (circleX < squareX - squareA / 2 && circleY < squareY - squareA / 2) {
                //нижний левый
                nearX = squareX - squareA / 2;
                nearY = squareY - squareA / 2;
            }
        }

        double d = Math.sqrt(Math.pow(nearX - circleX, 2) + Math.pow(nearY - circleY, 2));

        return d <= radius;
    }
}
