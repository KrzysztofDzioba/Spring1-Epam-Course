package ua.epam.spring.hometask.domain;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.LongStream;

public class Auditorium {

    private String name;

    private long numberOfSeats;

    private Set<Long> vipSeats = Collections.emptySet();

    public Auditorium() {
    }

    // TODO for course instructor - please answer me for this question: Is there a possibility not to create this 3-arg
    // constructor and inject vipSeats field directly from .properties file instead of injecting String into constructor
    // and then converting it into an array?
    public Auditorium(String name, long numberOfSeats, String vipSeats) {
        this.name = name;
        this.numberOfSeats = numberOfSeats;
        this.vipSeats = getVipSeatsSet(vipSeats);
    }

    private Set<Long> getVipSeatsSet(String vipSeats) {
        return Arrays.stream(vipSeats.split(",")).map(Long::valueOf).collect(Collectors.toSet());
    }

    /**
     * Counts how many vip seats are there in supplied <code>seats</code>
     * 
     * @param seats
     *            Seats to process
     * @return number of vip seats in request
     */
    public long countVipSeats(Collection<Long> seats) {
        return seats.stream().filter(seat -> vipSeats.contains(seat)).count();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getNumberOfSeats() {
        return numberOfSeats;
    }

    public void setNumberOfSeats(long numberOfSeats) {
        this.numberOfSeats = numberOfSeats;
    }
    
    public Set<Long> getAllSeats() {
        return LongStream.range(1, numberOfSeats+1).boxed().collect(Collectors.toSet());
    }

    public Set<Long> getVipSeats() {
        return vipSeats;
    }

    public void setVipSeats(Set<Long> vipSeats) {
        this.vipSeats = vipSeats;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        Auditorium other = (Auditorium) obj;
        if (name == null) {
            if (other.name != null) {
                return false;
            }
        } else if (!name.equals(other.name)) {
            return false;
        }
        return true;
    }

}
