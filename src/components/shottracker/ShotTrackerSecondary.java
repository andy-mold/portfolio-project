package components.shottracker;

/**
 *  * Layered implementations of secondary methods for {@code ShotTracker}.  
 */
public abstract class ShotTrackerSecondary implements ShotTracker {

    /**
     * * Layered implementations of secondary methods for {@code Shot}.
     */
    protected static final class Shot implements ShotTracker.Shot {

        /**
         * The distance of the shot in yards.
         */
        private int distance;

        /**
         * The type of club used for the shot (0-14).
         */
        private int clubType;

        /**
         * The type of shot taken (0-5).
         */
        private int shotType;

        /**
         * Constructor.
         *
         * @param distance
         * @param clubType
         * @param shotType
         */
        public Shot(int distance, int clubType, int shotType) {
            this.distance = distance;
            this.clubType = clubType;
            this.shotType = shotType;
        }

        // CHECKSTYLE: ALLOW THIS METHOD TO BE OVERRIDDEN
        @Override
        public int getDistance() {
            return this.distance;
        }

        // CHECKSTYLE: ALLOW THIS METHOD TO BE OVERRIDDEN
        @Override
        public int getClubType() {
            return this.clubType;
        }

        // CHECKSTYLE: ALLOW THIS METHOD TO BE OVERRIDDEN
        @Override
        public int getShotType() {
            return this.shotType;
        }
    }
    /*
     * Public members ---------------------------------------------------------
     */

    /*
     * Common methods (from Object) -------------------------------------------
     */

    // CHECKSTYLE: ALLOW THIS METHOD TO BE OVERRIDDEN
    @Override
    public String toString() {
        String s = "{";
        for (int i = 0; i < this.length(); i++) {
            s += "(";
            s += this.getShot(i).getDistance() + ", ";
            s += this.getShot(i).getClubType() + ", ";
            s += this.getShot(i).getShotType() + "), ";
        }
        s += "}";
        return s;
    }

    // CHECKSTYLE: ALLOW THIS METHOD TO BE OVERRIDDEN
    @Override
    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other == null) {
            return false;
        }
        if (!(other instanceof ShotTracker)) {
            return false;
        }
        ShotTracker s = (ShotTracker) other;
        if (this.length() != s.length()) {
            return false;
        }
        for (int i = 0; i < this.length(); i++) {
            ShotTracker.Shot thisShot = this.getShot(i);
            ShotTracker.Shot otherShot = s.getShot(i);

            if (thisShot.getDistance() != otherShot.getDistance()
                    || thisShot.getClubType() != otherShot.getClubType()
                    || thisShot.getShotType() != otherShot.getShotType()) {
                return false;
            }
        }
        return true;
    }

    /*
     * Other non-kernel methods -----------------------------------------------
     */

    // CHECKSTYLE: ALLOW THIS METHOD TO BE OVERRIDDEN
    @Override
    public void append(ShotTracker shots) {
        while (shots.length() > 0) {
            ShotTracker.Shot removed = shots.removeShot(0);
            this.addShot(removed.getDistance(), removed.getClubType(),
                    removed.getShotType());
        }
    }

    // CHECKSTYLE: ALLOW THIS METHOD TO BE OVERRIDDEN
    @Override
    public int averageDistance(int clubType) {
        int average = 0;
        int numberOfShots = 0;
        for (int i = 0; i < this.length(); i++) {
            if (this.getShot(i).getClubType() == clubType) {
                average += this.getShot(i).getDistance();
                numberOfShots++;
            }
        }
        if (average > 0) {
            average = average / numberOfShots;
        } else {
            average = -1;
        }
        return average;
    }

    // CHECKSTYLE: ALLOW THIS METHOD TO BE OVERRIDDEN
    @Override
    public ShotTracker saveHole(int n) {
        assert n <= this.length() : "Violation of: |this| >= n";

        ShotTracker hole = this.newInstance();
        for (int i = this.length() - n; i < this.length(); i++) {
            ShotTracker.Shot current = this.getShot(i);
            hole.addShot(current.getDistance(), current.getClubType(),
                    current.getShotType());
        }
        return hole;
    }
}
