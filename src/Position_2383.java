public class Position_2383 {
    int x;
    int y;
    int length;
    int toStair;
    int[] time;

    Position_2383(int x, int y, int length) {
        this.x = x;
        this.y = y;
        this.length = length;
        time = new int[2];
    }

    int timeToPosition(Position_2383 toPosition) {
        return Math.abs(this.x - toPosition.x) + Math.abs(this.y - toPosition.y);
    }

    int compareToTime(Position_2383 one, Position_2383 two) {
        int firstTime = timeToPosition(one),
                secondTime = timeToPosition(two);
        if (firstTime > secondTime)
            toStair = 1;
        else
            toStair = 0;
        time[1] = secondTime;
        time[0] = firstTime;
        return toStair;
    }
}
