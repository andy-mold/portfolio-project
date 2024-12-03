import java.util.Iterator;
import java.util.NoSuchElementException;

import components.sequence.Sequence;
import components.sequence.Sequence1L;

/**
 * Class.
 */
public class ShotTrackerOnSequence extends ShotTrackerSecondary {

    /*
     * Private members --------------------------------------------------------
     */

    /**
     * Representation of {@code this}.
     */
    private Sequence<ShotTracker.Shot> rep;

    /**
     * Creator of initial representation.
     */
    private void createNewRep() {

        this.rep = new Sequence1L<ShotTracker.Shot>();

    }

    /**
     * No-argument constructor.
     */
    public ShotTrackerOnSequence() {

        this.createNewRep();

    }

    //Kernel Methods

    // CHECKSTYLE: ALLOW THIS METHOD TO BE OVERRIDDEN
    @Override
    public final void addShot(int clubType, int shotType, int distance) {
        assert clubType >= 0
                && clubType <= 14 : "Violation of: 0 <= clubType <= 14";
        assert shotType >= 0
                && shotType <= 5 : "Violation of: 0 <= shotType <= 5";

        ShotTracker.Shot shot = new ShotTrackerSecondary.Shot(clubType,
                shotType, distance);
        this.rep.add(this.rep.length(), shot);

    }

    // CHECKSTYLE: ALLOW THIS METHOD TO BE OVERRIDDEN
    @Override
    public final ShotTracker.Shot removeShot(int n) {
        assert this.length() > 0 : "Violation of: this /= empty_set";
        assert n < this.length() && n >= 0 : "Violation of: 0 <= n < |this|";

        ShotTracker.Shot shot = this.rep.remove(n);
        return shot;
    }

    // CHECKSTYLE: ALLOW THIS METHOD TO BE OVERRIDDEN
    @Override
    public final int length() {

        return this.rep.length();
    }

    // CHECKSTYLE: ALLOW THIS METHOD TO BE OVERRIDDEN
    @Override
    public final ShotTracker.Shot getShot(int n) {
        assert this.length() > 0 : "Violation of: this /= empty_set";
        assert n < this.length() && n >= 0 : "Violation of: 0 <= n < |this|";

        ShotTracker.Shot entry = this.rep.entry(n);
        return entry;
    }

    //Standard Methods

    // CHECKSTYLE: ALLOW THIS METHOD TO BE OVERRIDDEN
    @Override
    public final ShotTracker newInstance() {
        try {
            return this.getClass().getConstructor().newInstance();
        } catch (ReflectiveOperationException e) {
            throw new AssertionError(
                    "Cannot construct object of type " + this.getClass());
        }
    }

    // CHECKSTYLE: ALLOW THIS METHOD TO BE OVERRIDDEN
    @Override
    public final void clear() {
        this.createNewRep();
    }

    // CHECKSTYLE: ALLOW THIS METHOD TO BE OVERRIDDEN
    @Override
    public final void transferFrom(ShotTracker source) {
        assert source != null : "Violation of: source is not null";
        assert source != this : "Violation of: source is not this";
        assert source instanceof ShotTrackerOnSequence : ""
                + "Violation of: source is of dynamic type ShotTrackerOnSequence";

        ShotTrackerOnSequence localSource = (ShotTrackerOnSequence) source;
        this.rep = localSource.rep;
        localSource.createNewRep();
    }

    //Iterator

    @Override
    public final Iterator<ShotTracker.Shot> iterator() {
        return new ShotTrackerOnSequenceIterator();
    }

    /**
     * Implementation of {@code Iterator} interface for {@code ShotTracker}.
     */
    private final class ShotTrackerOnSequenceIterator
            implements Iterator<ShotTracker.Shot> {
        /**
         * Representation iterator.
         */
        private final Iterator<ShotTracker.Shot> iterator;

        /**
         * No-argument constructor.
         */
        private ShotTrackerOnSequenceIterator() {
            this.iterator = ShotTrackerOnSequence.this.rep.iterator();
        }

        @Override
        public boolean hasNext() {
            return this.iterator.hasNext();
        }

        @Override
        public ShotTracker.Shot next() {
            assert this.hasNext() : "Violation of: ~this.unseen /= <>";
            if (!this.hasNext()) {
                /*
                 * Exception is supposed to be thrown in this case, but with
                 * assertion-checking enabled it cannot happen because of assert
                 * above.
                 */
                throw new NoSuchElementException();
            }
            ShotTracker.Shot entry = this.iterator.next();
            return new ShotTrackerSecondary.Shot(entry.getDistance(),
                    entry.getClubType(), entry.getShotType());
        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException(
                    "remove operation not supported");
        }
    }

}
