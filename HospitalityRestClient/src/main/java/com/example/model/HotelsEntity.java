package com.example.model;


import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by dkazakov on 25.04.2014.
 */
@Entity
@Table(name = "hotels", schema = "", catalog = "mydb")
@NamedQueries({
        @NamedQuery(name = "HotelsEntity.findAll",
                query = "select h from HotelsEntity h " +
                        "left join fetch h.property " +
                        "left join fetch h.rooms"),
        @NamedQuery(name = "HotelsEntity.findAllWithFilter",
                query = "select h from HotelsEntity h " +
                        "left join fetch h.property hProperty " +
                        "left join fetch h.rooms hRooms " +
                        "left join fetch hRooms.inventory inventory " +
                        "left join fetch inventory.reservation reservation " +
                        "where " +
                        "hProperty.hasPool = :pool " +
                            "AND hProperty.hasTennisCourt = :tennis " +
                            "AND hProperty.hasWaterslides = :waterslides " +
                            "AND hRooms.peopleCapacity >= :capacity " +
                            "AND hRooms.locked = false " +
                            "AND (" +
                                "(reservation.checkIn <= :checkin AND reservation.checkOut >= :checkin) " +
                                "OR " +
                                "(reservation.checkIn >= :checkin AND reservation.checkOut <= :checkout) " +
                                "OR " +
                                "(reservation.checkIn >= :checkin AND reservation.checkOut >= :checkout) )")
})
public class HotelsEntity implements HospitalityEntity {
    private int idHotel;
    private String name;
    private String region;
    private String description;
    private String photo;

    private HotelPropertyEntity property;
    private List<RoomEntity> rooms;
    private List<ReservationDatesEntity> reservationDates;

    public HotelsEntity() {
        if (reservationDates == null)
            reservationDates = new ArrayList<ReservationDatesEntity>();

        ReservationDatesEntity first = new ReservationDatesEntity();
        first.setId(0);
        first.setCheckIn(123l);
        first.setCheckOut(321l);

        ReservationDatesEntity second = new ReservationDatesEntity();
        second.setId(1);
        second.setCheckIn(123123l);
        second.setCheckOut(312321l);

        reservationDates.add(first);
        reservationDates.add(second);
    }

    @OneToMany(mappedBy = "hotel")
    public List<ReservationDatesEntity> getReservationDates() {
        return reservationDates;
    }

    public void setReservationDates(List<ReservationDatesEntity> reservationDates) {
        this.reservationDates = reservationDates;
    }

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_hotel_property")
    public HotelPropertyEntity getProperty() {
        return property;
    }

    public void setProperty(HotelPropertyEntity property) {
        this.property = property;
    }

    @OneToMany(mappedBy = "hotel")
    public List<RoomEntity> getRooms() {
        return rooms;
    }

    public void setRooms(List<RoomEntity> rooms) {
        this.rooms = rooms;
    }

    @Id
    @Column(name = "id_hotel", unique = true)
    @GeneratedValue(strategy= GenerationType.AUTO)
    public int getIdHotel() {
        return idHotel;
    }

    public void setIdHotel(int idHotel) {
        this.idHotel = idHotel;
    }

    @Basic
    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "region")
    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    @Basic
    @Column(name = "description")
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Basic
    @Column(name = "photo")
    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        HotelsEntity that = (HotelsEntity) o;

        if (idHotel != that.idHotel) return false;
        if (description != null ? !description.equals(that.description) : that.description != null) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
//        if (!Arrays.equals(photo, that.photo)) return false;
        if (region != null ? !region.equals(that.region) : that.region != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idHotel;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (region != null ? region.hashCode() : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
//        result = 31 * result + (photo != null ? Arrays.hashCode(photo) : 0);
        return result;
    }
}
