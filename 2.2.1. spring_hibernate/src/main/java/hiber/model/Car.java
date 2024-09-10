package hiber.model;

import jakarta.persistence.*;

@Entity
@Table(name = "cars")
public class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long carId;

    @Column(name = "model")
    String model;

    @Column(name = "series")
    int series;

    @OneToOne(mappedBy = "userCar", cascade = CascadeType.ALL)
    private User carUser;


    public Car() { }

    public Car(String model, int series) {
        this.model = model;
        this.series = series;
    }


    public Long getCarId() { return carId; }
    public void setCarId(Long carId) { this.carId = carId;}

    public String getModel() { return model; }
    public void setModel(String model) { this.model = model; }

    public int getSeries() { return series; }
    public void setSeries(int series) { this.series = series; }

    public User getCarUser() { return carUser; }
    public void setCarUser(User carUser) { this.carUser = carUser; }


    @Override
    public String toString() {
        return model + ", " + series;
    }

}
