/**
 * {@code ShotTrackerKernel} enhanced with secondary methods.
 */
public interface ShotTracker extends ShotTrackerKernel {

    /**
     * A ShotTracker entry containing distance, clubType, and shotType. The only
     * ways to obtain a reference to a shot are from the iterator and
     * {@code ShotTracker}'s {@code removeShot} method.
     */
    interface Shot {

        /**
         * Returns this {@code Shot}'s distance.
         *
         * @return the distance
         */
        int getDistance();

        /**
         * Returns this {@code Shot}'s clubType.
         *
         * @return the clubType
         */
        int getClubType();

        /**
         * Returns this {@code Shot}'s shotType.
         *
         * @return the shotType
         */
        int getShotType();
    }

    /**
     * Appends {@code shots} onto the end of {@code this}.
     *
     * @param shots
     *            The ShotTracker to be appended onto this
     * @updates this
     * @clears shots
     * @ensures this = #this * #s
     */
    void append(ShotTracker shots);

    /**
     * Calculates and returns the average distance of all shots in {@code this}
     * whose second component is {@code clubType}. Returns -1 if no shots have a
     * second component equal to {@code clubType}.
     *
     * @param clubType
     *            The clubType of all shots to be averaged
     * @return average distance of all shots whose second component is
     *         {@code clubType}
     * @ensures averageDistance = sum(distances) / shots
     */
    int averageDistance(int clubType);

    /**
     * Returns a new ShotTracker containing the previous {@code n} shots in
     * {@code this}. Can be used to score a hole if {@code n} is the number of
     * shots taken on the previous hole.
     *
     * @param n
     *            The number of shots to save.
     * @return new ShotTracker containing the previous n shots.
     * @requires |this| >= n
     * @ensures saveHole = final n shots of this
     */
    ShotTracker saveHole(int n);
}
