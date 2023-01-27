package com.pos.proiectpos.entities;

import jakarta.persistence.*;

@Entity
public class Car {
    private User owner;
    private Long id;

    private String licensePlate;
    private String parkingSpot;
    private CarPhoto photo;
    @ManyToOne
    public User getOwner() {return owner;}

    public void setOwner(User owner) {this.owner = owner;}

    public void setId(Long id) {this.id = id;}

    public void setLicensePlate(String licensePlate) {this.licensePlate = licensePlate;}

    public void setParkingSpot(String parkingSpot) {this.parkingSpot = parkingSpot;}

    public String getLicensePlate() {return licensePlate;}

    public String getParkingSpot() {return parkingSpot;}

    @Id
    @GeneratedValue
    public Long getId() {return id;}

    @OneToOne(mappedBy = "car", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    public CarPhoto getPhoto() {return photo;}

    public void setPhoto(CarPhoto photo) {this.photo = photo;}
}
