package components.shottracker;

import components.standard.Standard;

/**
 * ShotTracker kernel component with primary methods.
 */
public interface ShotTrackerKernel
        extends Standard<ShotTracker>, Iterable<ShotTracker.Shot> {
    /**
     * Adds the shot ({@code distance}, {@code clubType}, {@code shotType}) to
     * this.
     *
     * @param distance
     *            the distance of the shot (yards).
     * @param clubType
     *            the club type used for the shot 0 <= clubType <= 14
     * @param shotType
     *            the shot type used for the shot 0 <= shotType <= 5
     * @updates this
     * @requires 0 <= clubType <= 14 && 0 <= shotType <= 5
     * @ensures this = #this union {(distance, clubType, shotType)}
     */
    void addShot(int distance, int clubType, int shotType);

    /**
     * Removes the shot at index {@code n} and returns it.
     *
     * @param n
     *            the index of the shot to be removed.
     * @return the shot removed
     * @updates this
     * @requires 0 <= n < |this|
     * @ensures <pre>
     * remove is in #this and
     * this = #this \ {remove}
     * </pre>
     */
    ShotTracker.Shot removeShot(int n);

    /**
     * Reports the length of {@code this}.
     *
     * @return the number of shots in {@code this}
     * @ensures length = |this|
     */
    int length();

    /**
     * Reports the shot at index {@code n} in {@code this}.
     *
     * @param n
     *            the index of the shot to be reported.
     * @return the shot at index {@code n}
     * @requires 0 <= n < |this|
     * @ensures getShot is in this
     */
    ShotTracker.Shot getShot(int n);
}
